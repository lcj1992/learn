package reflect;


/**
 * Created by lichuangjian on 16/7/16.
 */


import java.lang.reflect.*;

/**
 * 通过一个对象获得完整的包名和类名
 */

interface FuckAble {

    int fuck();
}

class Hello {

}

class Chinese {

}

class Person extends Chinese implements FuckAble {
    private String name;
    private int age;

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "[" + this.name + " " + this.age + "]";
    }

    public void selfIntroduce() {
        System.out.println("I'm" + name + ",and I'm" + age);
    }

    public void sayHello(String name) {
        System.out.println("hello " + name);
    }

    private static final int HIGH = 10;
    private static final int JUST_SO_SO = 5;
    private static final int LOW = 0;

    public int fuck() {
        return HIGH;
    }
}

public class demo {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, NoSuchFieldException {
        // 获取类名,包名
        Hello hello = new Hello();
        System.out.println(hello.getClass());
        System.out.println(hello.getClass().getName());

        // 获取Class
        Class<?> cls1 = null;
        Class<?> cls2 = null;
        Class<?> cls3 = null;

        String clsName = "reflect.Hello";
        try {
            cls1 = Class.forName(clsName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        cls2 = hello.getClass();
        cls3 = Hello.class;

        // 通过Class实例化其类的对象
        Class<?> cls4NewInstance = null;
        Person person = null;
        try {
            cls4NewInstance = Class.forName("reflect.Person");
            person = (Person) cls4NewInstance.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        person.setAge(10);
        person.setName("fool");
        System.out.println(person);


        // 取得所有构造函数
        Constructor<?> constructors[] = cls4NewInstance.getConstructors();
        Person person1 = (Person) constructors[3].newInstance();
        Person person2 = (Person) constructors[2].newInstance("fool");
        Person person3 = (Person) constructors[1].newInstance(10);
        Person person4 = (Person) constructors[0].newInstance("fool", 10);


        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
        System.out.println(person4);


        // 实现的接口
        Class<?> cls4GetInterface = Person.class;
        Class<?> interfaces[] = cls4GetInterface.getInterfaces();
        int i = 0;
        for (Class<?> anInterface : interfaces) {
            System.out.println("实现的接口" + ++i + " :" + anInterface);
        }

        // 继承的父类
        Class<?> cls4SuperCls = Person.class;
        Class<?> superCls = cls4SuperCls.getSuperclass();
        System.out.println(superCls);

        // 方法: 修饰符,返回值,参数,方法名等
        Class<?> cls4Methods = Person.class;
        Method[] methods = cls4Methods.getMethods();
        for (Method method : methods) {
            Class<?> returnCls = method.getReturnType();
            Class<?>[] params = method.getParameterTypes();
            int modifiers = method.getModifiers();
            System.out.print(Modifier.toString(modifiers) + " ");
            System.out.print(returnCls.getName() + "  ");
            System.out.print(method.getName() + " ");

            // 打印下
            System.out.print("(");
            for (int j = 0; j < params.length; ++j) {
                System.out.print(params[j].getName() + " " + "arg" + j);
                if (j < params.length - 1) {
                    System.out.print(",");
                }
            }
            Class<?> exce[] = method.getExceptionTypes();
            if (exce.length > 0) {
                System.out.print(") throws ");
                for (int k = 0; k < exce.length; ++k) {
                    System.out.print(exce[k].getName() + " ");
                    if (k < exce.length - 1) {
                        System.out.print(",");
                    }
                }
            } else {
                System.out.print(")");
            }
            System.out.println();
        }

        // 属性
        Class<?> cls4Fields = Person.class;
        Field[] fields = cls4Fields.getDeclaredFields();
        for (Field field : fields) {
            // 权限修饰符
            int mo = field.getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = field.getType();
            System.out.println(priv + " " + type.getName() + " "
                    + field.getName() + ";");
        }

        Field[] superFields = cls4Fields.getFields();
        for (Field superField : superFields) {
            // 权限修饰符
            int mo = superField.getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = superField.getType();
            System.out.println(priv + " " + type.getName() + " "
                    + superField.getName() + ";");
        }

        // 调用方法
        Class<?> cls4Invoke = Person.class;
        Method method = cls4Invoke.getMethod("sayHello", String.class);
        method.invoke(cls4Invoke.newInstance(), "fool");
        method = cls4Invoke.getMethod("selfIntroduce");
        person = (Person) cls4Invoke.newInstance();
        person.setAge(20);
        person.setName("fool");
        method.invoke(person);

        // 调用get set
        Class<?> cls4GSet = Person.class;
        Method getter = cls4GSet.getMethod("get" + "Name");
        System.out.println(getter.invoke(person));

        // 操作属性
        Field field = cls4GSet.getDeclaredField("name");
        field.setAccessible(true);
        field.set(person, "shit");
        field = cls4GSet.getDeclaredField("age");
        field.setAccessible(true);
        field.set(person, 1);
        System.out.println(person);

        // 获取数组属性
        int[] tmp = {1, 2, 3, 4, 5};
        Class<?> cls4Array = tmp.getClass().getComponentType();
        System.out.println(cls4Array.getName());
        System.out.println(Array.getLength(tmp));
        System.out.println(Array.get(tmp, 0));
        Array.set(tmp, 0, 100);
        Object array = Array.newInstance(cls4Array, 100);
        int length = tmp.length;
        System.arraycopy(tmp, 0, array, 0, length);

        // 获取类加载器
        System.out.println(cls4GSet.getClassLoader().getClass().getName());

        // 动态代理

    }

}
