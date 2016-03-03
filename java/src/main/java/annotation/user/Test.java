package annotation.user;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lcj on 15-4-19.
 */
public class Test {
    public static void main(String[] args) {
        String s = new String();
    }

    public static void changeStr(String people) {
        people = "sunhao";
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

class People {
    private String name;

    public People(){}

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}