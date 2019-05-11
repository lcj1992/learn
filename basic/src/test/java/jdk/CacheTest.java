package jdk;

import com.mysql.jdbc.util.LRUCache;
import org.junit.Test;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 2017/5/31
 * Time: 上午9:09
 */
public class CacheTest {
    @Test
    public void testLinkedList() {
        LRUCache cache = new LRUCache(5);
        cache.put("lichuangian", 1);
        cache.put("sunhao", 1);
        cache.put("hehe", 1);
        cache.put("hoho", 1);
        cache.put("haha", 1);
        System.out.println(cache.get("lichuangjian"));
        cache.put("hihi", 1);
        cache.put("aa", 1);
        System.out.println(cache.get("lichuangjian"));
        System.out.println(cache.get("sunhao"));
    }
}
