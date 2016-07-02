package jdk.classLoader;

import java.io.IOException;

/**
 * Created by lcj on 15-5-16. 只需要重写findClass方法
 */
public abstract class AbstractUserDefinedClassLoader extends ClassLoader {
    // class的路径
    private String classPath;

    public AbstractUserDefinedClassLoader(String classPath) {
        this.classPath = classPath;
    }

    public abstract byte[] getClassData(String name) throws IOException;

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = null;// this.findLoadedClass(name); // 父类已加载
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
