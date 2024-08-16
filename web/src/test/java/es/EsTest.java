package es;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import co.elastic.clients.elasticsearch._types.query_dsl.TermQuery;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.junit.Test;

import java.io.IOException;

public class EsTest {
    private static ElasticsearchClient client = null;

    @Test
    public void test() throws IOException {
        // 建立链接
        makeConnection();
        // 添加索引
        testAddDoc();
        // 搜索
        testSearch();
        // 聚合查询
        testAggregations();
    }

    private static void testAggregations() throws IOException {
        SearchResponse<Void> search3 = client.search(b -> b.index("products").size(0).aggregations("price-histo", a -> a.histogram(h -> h.field("price").interval(20.0))), Void.class);
        long firstBucketCount = search3.aggregations().get("price-histo").histogram().buckets().array().get(0).docCount();
        System.out.println("doc count: " + firstBucketCount);
    }

    private synchronized void makeConnection() {
        HttpHost host = new HttpHost("localhost", 9200);
        RestClient restClient = RestClient.builder(host).build();
        // Create the transport with a Jackson mapper
        ElasticsearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());
        // And create the API client
        client = new ElasticsearchClient(transport);
    }


    private void testAddDoc() throws IOException {
        // 添加索引，方式一
        Product product = new Product("abc", "Bag", 42);
        IndexRequest<Object> indexRequest = new IndexRequest.Builder<>().index("products").id("abc").document(product).build();
        client.index(indexRequest);

        // 添加索引，方式二
        Product product1 = new Product("efg", "Bag", 42);
        client.index(builder -> builder.index("products").id(product1.getId()).document(product1));
    }

    private void testSearch() throws IOException {
        // 搜索方式一
        TermQuery query = QueryBuilders.term().field("name").value("bag").build();
        SearchRequest request = new SearchRequest.Builder().index("products").query(query._toQuery()).build();
        SearchResponse<Product> search = client.search(request, Product.class);
        printRes(search);

        // 搜索方式二
        SearchResponse<Product> search1 = client.search(s -> s.index("products").query(q -> q.term(t -> t.field("name").value(v -> v.stringValue("bag")))), Product.class);
        printRes(search1);

        // 搜索方式三
        TermQuery termQuery = TermQuery.of(t -> t.field("name").value("bag"));
        SearchResponse<Product> search2 = client.search(s -> s.index("products").query(termQuery._toQuery()), Product.class);
        printRes(search2);
    }

    private static void printRes(SearchResponse<Product> search1) {
        for (Hit<Product> hit : search1.hits().hits()) {
            Product pd = hit.source();
            System.out.println(pd);
        }
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Product {
        private String id;
        private String name;
        private int price;
    }
}