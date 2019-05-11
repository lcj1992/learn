package linear;

import linear.linked_list.MyLinkedListBaseOnDoublyList;
import org.junit.Test;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 2019/3/20
 * Time: 上午9:34
 */
public class MyPreLinkedListTest {

    @Test
    public void test() throws Exception {
        MyLinkedListBaseOnDoublyList<Integer> list = new MyLinkedListBaseOnDoublyList<>();
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
