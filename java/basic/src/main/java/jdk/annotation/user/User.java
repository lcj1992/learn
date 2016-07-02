package jdk.annotation.user;


/**
 * Created by lcj on 15-4-19.
 */
public class User {
    @Name(value = "lcj")
    private String name;

    @Hometown(value = "henan")
    private String hometown;

    @Age(value = 22)
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
