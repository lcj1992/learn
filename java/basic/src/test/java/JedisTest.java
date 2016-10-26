
import junit.framework.Assert;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2016/10/17
 * Time: 上午12:17
 */
public class JedisTest {

    private static final Jedis jedis = new Jedis("127.0.0.1", 6379);


    @Test
    public void stringTransformTest() {

        String key = "name";
        jedis.del(key);
        jedis.set(key, "123");
        Assert.assertEquals("int", jedis.objectEncoding(key));
        jedis.incr(key);
        Assert.assertEquals("int", jedis.objectEncoding(key));


        jedis.append(key, "123");
        Assert.assertEquals("raw", jedis.objectEncoding(key));

        jedis.del(key);
        jedis.set(key, "123");
        jedis.incrByFloat(key, 1);
        Assert.assertEquals("embstr", jedis.objectEncoding(key));

    }


    @Test
    public void htTransformTest() {

        String key = "student";
        String keyPrefix = "name";

        String length64 = "hehedahehehehedahehehehedahehehehedahehehehedahehehehedahehe1234";
        jedis.del(key);
        jedis.hset(key, keyPrefix + 1, length64);
        Assert.assertEquals("ziplist", jedis.objectEncoding(key));
        jedis.del(key);

        String length65 = "hehedahehehehedahehehehedahehehehedahehehehedahehehehedahehe12345";
        jedis.hset(key, keyPrefix + 2, length65);
        Assert.assertEquals("hashtable", jedis.objectEncoding(key));


        jedis.del(key);
        for (int i = 0; i < 512; i++) {
            jedis.hset(key, keyPrefix + i, String.valueOf(i));
        }
        Assert.assertEquals("ziplist", jedis.objectEncoding(key));

        jedis.del(key);
        for (int i = 0; i < 513; i++) {
            jedis.hset(key, keyPrefix + i, String.valueOf(i));
        }
        Assert.assertEquals("hashtable", jedis.objectEncoding(key));
    }

    @Test
    public void setTransformTest() {
        String intset = "intset";
        jedis.del(intset);
        jedis.sadd(intset, "1", "2", "3");
        Assert.assertEquals("intset", jedis.objectEncoding(intset));
        jedis.sadd(intset, "hehe");
        Assert.assertEquals("hashtable", jedis.objectEncoding(intset));

        String key = "set";
        jedis.del(key);
        for (int i = 0; i < 512; i++) {
            jedis.sadd(key, String.valueOf(i));
        }
        Assert.assertEquals("intset", jedis.objectEncoding(key));

        jedis.del(key);
        for (int i = 0; i < 513; i++) {
            jedis.sadd(key, String.valueOf(i));
        }
        Assert.assertEquals("hashtable", jedis.objectEncoding(key));

    }

    @Test
    public void zSetTransformTest() {
        String key = "zset";
        String length64 = "hehedahehehehedahehehehedahehehehedahehehehedahehehehedahehe1234";
        jedis.del(key);
        jedis.zadd(key, 1, length64);
        Assert.assertEquals("ziplist", jedis.objectEncoding(key));
        jedis.del(key);

        String length65 = "hehedahehehehedahehehehedahehehehedahehehehedahehehehedahehe12345";
        jedis.zadd(key, 2, length65);
        Assert.assertEquals("skiplist", jedis.objectEncoding(key));
    }
}
