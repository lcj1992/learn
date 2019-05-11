package download;

import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 2019/2/2
 * Time: 下午2:53
 */
public class DownLoadPPT {
    private static final String TITLE = "title";
    private static final String DIV = "div";

    private static final HttpClient HTTP_CLIENT;
    private static final String DOWNLOAD_URL = "https://ppt.geekbang.org/serv/ppt/download";
    private static final String COOKIE = "_ga=GA1.2.171405524.1548841297; GCID=c6ab44b-4a032bb-d04fed9-9c61732; _gid=GA1.2.543246760.1549002675; GCESS=BAIE6uhTXAcE71pdWAkBAQwBAQUEAAAAAAYE9i.AVQsCBAAEBAAvDQABBFy.DwADBOroU1wKBAAAAAAIAQM-; _gat=1; SERVERID=1fa1f330efedec1559b3abbcb6e30f50|1549013853|1549013853";
    private static final String REFERER = "https://ppt.geekbang.org/slide/download";
    private static final int CACHE = 10 * 1024;
    private static final String SLIDE_PATH = "/Users/lichuangjian/Desktop/archSummit/";

    @Test
    public void test() throws IOException {
        String filePath = "/Users/lichuangjian/Desktop/test.htm";
        download(filePath);
    }

    static {
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(100000)
                .setConnectTimeout(100000).setConnectionRequestTimeout(100000).build();
        HTTP_CLIENT = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();
    }

    private void download(String filePath) throws IOException {
        File file = new File(filePath);
        Document doc = Jsoup.parse(file, "UTF-8");
        List<Element> allSlideElements = doc.getElementsByClass(TITLE).stream().filter(each -> each.tag().getName().equals(DIV)).collect(Collectors.toList());
        List<Slide> slides = allSlideElements.stream().map(this::transfer).collect(Collectors.toList());
        slides.forEach(each -> {
            HttpPost post = new HttpPost(DOWNLOAD_URL);
            post.addHeader("cookie", COOKIE);
            post.addHeader("Referer", REFERER);
            post.addHeader("Content-Type", "application/json");
            Gson gson = new Gson();
            String json = gson.toJson(each.getSlideId());
            StringEntity entity = new StringEntity(json, Charset.forName("UTF-8"));
            entity.setContentType("application/json");
            entity.setContentEncoding("UTF-8");
            post.setEntity(entity);
            try {
                HttpResponse response = HTTP_CLIENT.execute(post);
                String responseEntity = EntityUtils.toString(response.getEntity());
                Result result = gson.fromJson(responseEntity, Result.class);
                String pptUrl = result.getData().getPpt_url();
                download(pptUrl, SLIDE_PATH + each.getTitle() + ".pdf");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private Slide transfer(Element each) {
        String url = each.child(0).attr("href");
        String title = each.child(0).childNode(0).toString().replaceAll("\n", "").trim();
        Map<String, String> ids = Splitter.on("&").withKeyValueSeparator("=").split(url.substring(12));
        Integer conId = Integer.valueOf(ids.get("cid"));
        Integer pptId = Integer.valueOf(ids.get("pid"));
        return new Slide(title, new SlideId(conId, pptId));
    }

    private static void download(String url, String filepath) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(filepath));
        try {

            HttpGet httpget = new HttpGet(url);
            HttpResponse response = HTTP_CLIENT.execute(httpget);

            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent();
            File file = new File(filepath);
            FileOutputStream fileout = new FileOutputStream(file);
            byte[] buffer = new byte[CACHE];
            int ch;
            while ((ch = is.read(buffer)) != -1) {
                fileout.write(buffer, 0, ch);
            }
            is.close();
            fileout.flush();
            fileout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    private class Slide {
        private String title;

        private SlideId slideId;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    private class SlideId {
        private Integer conid;

        private Integer pptid;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    private class Result {
        private Integer code;

        private SlideUrl data;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    private class SlideUrl {
        private String ppt_url;
    }
}
