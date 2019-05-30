import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/29
 * Time: 下午11:22
 */
public class Person implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean,ApplicationContextAware {
    private String name;
    private String address;
    private String phone;

    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;
    private String beanName;

    public Person() {
        System.out.println("Person constructor");

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Person setName");

        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        System.out.println("Person setAddress");

        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        System.out.println("Person setPhone");

        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person [address=" + address + ", name=" + name + ", phone="
                + phone + "]";
    }

    // 这是BeanFactoryAware接口方法
    @Override
    public void setBeanFactory(BeanFactory arg0) throws BeansException {
        System.out.println("BeanFactoryAware setBeanFactory");
        this.beanFactory = arg0;
    }

    // 这是BeanNameAware接口方法
    @Override
    public void setBeanName(String arg0) {
        System.out.println("BeanNameAware setBeanName");
        this.beanName = arg0;
    }

    // 这是InitializingBean接口方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean afterPropertiesSet");
    }

    // 这是DisposableBean接口方法
    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean destroy");
    }

    // 通过<bean>的init-method属性指定的初始化方法
    public void myInit() {
        System.out.println("init-method");
    }

    // 通过<bean>的destroy-method属性指定的初始化方法
    public void myDestroy() {
        System.out.println("destroy-method");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware setApplicationContext");
        this.applicationContext = applicationContext;
    }
}
