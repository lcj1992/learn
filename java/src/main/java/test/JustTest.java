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
//        HashMap<String, Integer> map = new HashMap<String, Integer>();
//        map.put("语文", 1);
//        map.put("数学", 2);
//        map.put("英语", 3);
//        map.put("历史", 4);
//        map.put("政治", 5);
//        map.put("地理", 6);
//        map.put("生物", 7);
//        map.put("aa", 8);
//        map.put("bb", 8);
//        map.put("cc", 8);
//        map.put("dd", 8);
//        map.put("ee", 8);
//        map.put("ff", 8);
//        map.put("gg", 8);
//        map.put("hh", 8);
//        map.put("ii", 8);
//        map.put("jj", 8);
//        map.put("oo", 8);
//        map.put("zz", 8);
//        map.put("kk", 8);
//        System.out.println(map.size());
//        System.out.println(map.entrySet().size());
//        for(Map.Entry<String, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }

        List<Integer> list = Lists.newArrayList();
        testUnBounded(list);
        testBounded(list);
        add1(list,1);
        add2(list,1);
        add3(list,1);
    }


    private static List<?> testUnBounded(List<?> aa){
        return aa;
    }

    private static <E> List<E> testBounded(List<E> bb){
        return bb;
    }

    private static void add1(List list,Object o)
    {
        list.add(o);
    }
    private static void add2(List<Integer> list, Object o)
    {
        list.add((Integer) o);
    }
    private static void add3(List<?> list,Object o)
    {
        list.add(null);//正确，可以添加null

    }
}
