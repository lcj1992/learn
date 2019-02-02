package concurrent.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2017/5/31
 * Time: 上午8:44
 */
public class CacheTest {
    @Test
    public void testCache() throws ExecutionException {
        LoadingCache<String, Integer> cache = CacheBuilder
                .newBuilder()
                .maximumSize(5)
                .expireAfterWrite(2, TimeUnit.SECONDS)
                .initialCapacity(20)
                .build(new CacheLoader<String, Integer>() {

                           @Override
                           public Integer load(String key) throws Exception {
                               return null;
                           }
                       }
                );

        cache.put("lichuangjian", 1);
        cache.put("sunhao", 2);
        cache.put("liunenzhen", 3);
        cache.put("lizhijun", 4);
        cache.put("haha",5);
        System.out.println(cache.get("lichuangjian"));
        cache.put("hh",6);
        System.out.println(cache.get("lichuangjian"));

    }

}
