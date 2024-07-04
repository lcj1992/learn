package lang.xxable;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SerializableTest {
    @Test
    public void test() {
        // 创建一个Student对象
        Student student = new Student("John Doe", 20);

        // 序列化Student对象
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get("student.ser")))) {
            oos.writeObject(student);
            System.out.println("Serialization complete.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 反序列化Student对象
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ser"))) {
            Student deserializedStudent = (Student) ois.readObject();
            System.out.println("Deserialized Student: " + deserializedStudent);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Data
    @AllArgsConstructor
    public static class Student implements Serializable {
        private static final long serialVersionUID = 1L;

        private String name;
        private int age;

    }
}
