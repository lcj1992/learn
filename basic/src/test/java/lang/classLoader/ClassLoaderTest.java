package lang.classLoader;

import com.google.common.io.Files;
import com.google.common.io.Resources;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by lcj on 15-5-16.
 */
public class ClassLoaderTest {

    @Test
    public void test() throws ClassNotFoundException, InterruptedException, InstantiationException, IllegalAccessException {
        FileClassLoader fileClassLoader = new FileClassLoader("/Users/foolchild/work/learn/basic/target/classes/");
        String className = "Hello";
        Class<?> clazz = fileClassLoader.loadClass(className);
        System.out.println(clazz.getClassLoader());
        System.out.println(clazz.getName());
    }

    @Test
    public void testLoad() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        try {
            Class<?> aClass = classLoader.loadClass("java.lang.String");
            Object s = aClass.newInstance();
            System.out.println(s);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract static class AbstractUserDefinedClassLoader extends ClassLoader {
        // class的路径
        private final String classPath;

        public AbstractUserDefinedClassLoader(String classPath) {
            this.classPath = classPath;
        }

        public abstract byte[] getClassData(String name) throws IOException;

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            Class<?> clazz;
            byte[] classData = new byte[0]; // 根据类的二进制名称,获得该class文件的字节码数组
            try {
                classData = getClassData(name);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (classData == null) {
                throw new ClassNotFoundException();
            }
            clazz = defineClass(name, classData, 0, classData.length); // 将class的字节码数组转换成Class类的实例
            return clazz;
        }

        public String getPathAndName(String name) {
            String classPath = this.classPath;
            if (!classPath.endsWith("/")) {
                classPath = classPath.concat("/");
            }
            return classPath + name.replace(".", "/") + ".class";
        }

    }

    public static class FileClassLoader extends AbstractUserDefinedClassLoader {

        public FileClassLoader(String classPath) {
            super(classPath);
        }

        @SuppressWarnings("UnstableApiUsage")
        @Override
        public byte[] getClassData(String name) throws IOException {
            String pathAndName = getPathAndName(name);
            System.out.println(pathAndName);
            return Files.toByteArray(new File(pathAndName));
        }
    }

    public static class NetWorkClassLoader extends AbstractUserDefinedClassLoader {
        public NetWorkClassLoader(String classPath) {
            super(classPath);
        }

        @SuppressWarnings("UnstableApiUsage")
        @Override
        public byte[] getClassData(String name) throws IOException {
            String pathAndName = getPathAndName(name);
            return Resources.toByteArray(new URL(pathAndName));
        }
    }
}
