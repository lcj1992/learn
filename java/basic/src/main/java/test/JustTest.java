package test;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chuangjian.li
 * 16/3/23
 */
public class JustTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("语文", 1);
        map.put("数学", 2);
        map.put("英语", 3);
        map.put("历史", 4);
        map.put("政治", 5);
        map.put("地理", 6);
        map.put("生物", 7);
        map.put("aa", 8);
        map.put("bb", 8);
        map.put("cc", 8);
        map.put("dd", 8);
        map.put("ee", 8);
        map.put("ff", 8);
        map.put("gg", 8);
        map.put("hh", 8);
        map.put("ii", 8);
        map.put("jj", 8);
        map.put("oo", 8);
        map.put("zz", 8);
        map.put("kk", 8);
        System.out.println(map.size());
        System.out.println(map.entrySet().size());
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }
}
