package linear.array;

import org.junit.Test;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 2019/3/19
 * Time: 下午11:06
 */
public class MyArrayListTest {

    @Test
    public void test() throws Exception {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);

        list.add(1, 7);
        System.out.println(list);

        list.set(2, 5);
        System.out.println(list);

        list.remove(2);
        System.out.println(list);
    }
}
