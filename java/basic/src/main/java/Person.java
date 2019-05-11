import lombok.Data;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/1
 * Time: 上午9:30
 */
@Data
public class Person {
    private int age;

    private String name;

    private String city;

    private String email;

    {
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        Person person =new Person();
    }
}
