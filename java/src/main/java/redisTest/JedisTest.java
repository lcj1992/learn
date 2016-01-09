package redisTest;

import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.Set;

/**
 * Created by lcj on 15-7-12.
 */
public class JedisTest {

    public static void main(String[] args) throws IOException {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.connect();
        String key = "9c_order";
        // site + monitorType 为key
        // orderId 为score
        // 成功或失败为 member
        jedis.zadd(key, -1, "001|1");
        jedis.zadd(key, -2, "002|0");
        jedis.zadd(key, -9, "009|0");
        jedis.zadd(key, -3, "003|1");
        jedis.zadd(key, -5, "005|0");
        jedis.zadd(key, -6, "006|2");

        jedis.zrange(key, Integer.MIN_VALUE, Integer.MAX_VALUE);
        long a = jedis.zremrangeByScore(key, Integer.MIN_VALUE, Integer.MAX_VALUE);
        Set set = jedis.zrange(key, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(set);
        jedis.del("CA");
        boolean aa = jedis.exists("CA") && Long.valueOf(jedis.get("CA")) > 0;
        System.out.println( aa);
    }
}
