package annotation.fruit;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.Collection;

/**
 * Created by lcj on 15-4-18.
 */
public class Test {
    public static void main(String[] args) {
        Apple apple = new Apple();
        FruitInfoUtil.getFruitInfo(apple.getClass());

        String[] strings = {"aa", "zz", "cc", "yy", "ee", "xx"};
        Multimap<Integer, String> multimap = ArrayListMultimap.create();
        for (String a : strings) {
            multimap.put(1, a);

        }
        for (String a : strings) {
            multimap.put(2, a);

        }
        Collection<String> result = multimap.get(1);
        for (String s : result) {
            System.out.println(s);
        }

        System.out.println("###############");
        result = multimap.get(1);
        for (String s : result) {
            System.out.println(s);
        }

    }
}
