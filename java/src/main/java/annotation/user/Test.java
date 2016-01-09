package annotation.user;

import java.lang.reflect.Field;

/**
 * Created by lcj on 15-4-19.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("我们");
        System.out.println(getUserAnnotation());
    }

    public static User getUserAnnotation() {
        User user = new User();
        Field[] fields = User.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if ("name".equals(field.getName())) {
                Name name = field.getAnnotation(Name.class);
                user.setName(name.value());
            }
            if ("hometown".equals(field.getName())) {
                Hometown hometown = field.getAnnotation(Hometown.class);
                user.setHometown(hometown.value());
            }
            if ("age".equals(field.getName())) {
                Age age = field.getAnnotation(Age.class);
                user.setAge(age.value());
            }
        }
        return user;
    }
}
