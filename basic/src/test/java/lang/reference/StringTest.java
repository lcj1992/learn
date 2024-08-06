package lang.reference;

import lombok.Data;
import org.junit.Test;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 2017/5/12
 * Time: 下午7:38
 */
@Data
public class StringTest {

    private static void m1() {
        String a = "a1";
        String b = "a" + 1;
        System.out.println(a == b);
    }

    private static void m2() {
        String a = "ab";
        String bb = "b";
        String b = "a" + bb;
        System.out.println(a == b);
    }

    private static void m3() {
        String a = "ab";
        final String bb = "b";
        String b = "a" + bb;
        System.out.println(a == b);
    }


    private static void m4() {
        String a = "ab";
        final String bb = getBB();
        String b = "a" + bb;
        System.out.println(a == b);
    }

    private String name;

    private static StringTest m5() {
        try {
            StringTest result1 = new StringTest();
            result1.setName("lcj");
            return result1;
        } finally {
            StringTest result2 = new StringTest();
            return result2;
        }
    }

    @Test
    public void test() {
        m1();
        m2();
        m3();
        m4();
        System.out.println(m5().getName());

    }

    private static String getBB() {
        return "b";
    }
}
