import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class SimpleSpringTest {

    /**
     * 设计一个简单的IOC容器，容器中bean是单例，bean数量不超过100，并验证；
     * 问题
     * 1. 容器管理：读取配置、实例化
     * 2. 限制：容器中bean数量不超过100、单例
     * <p>
     * 解决方案
     * 1. 整体流程
     * 1.1 读取配置
     * 1.2 解析配置
     * 1.3 实例化bean
     * 2. 限制条件
     */
    @Test
    public void test() {
        // 解析配置
        AppContext appContext = new AppContext(100, "configPath");
        TestObj1 testObj1 = (TestObj1) appContext.getBean("testObj1");
        System.out.println(testObj1.getName());
        testObj1 = (TestObj1) appContext.getBean(TestObj1.class);
        System.out.println(testObj1.getName());
    }


    @Getter
    public static class AppContext {
        private volatile boolean start = false;
        private final int capacity;
        // 容器
        private final Map<String, Object> beanNameMap;
        private final Map<String, Object> beanClassMap;
        private final String config;

        public AppContext(int capacity, String configPath) {
            this.capacity = capacity;
            this.beanNameMap = new ConcurrentHashMap<>();
            this.beanClassMap = new ConcurrentHashMap<>();
            this.config = configPath;
            start(configPath);
        }

        public synchronized void start(String configPath) {
            if (start) {
                return;
            }
            init(configPath);
            this.start = true;
        }

        private void init(String configPath) {
            Set<BeanConfig> beanConfigs = parse(configPath);
            if (beanConfigs.isEmpty()) {
                return;
            }
            if (beanConfigs.size() > 100) {
                log.error("spring container init error, bean size over 100");
                System.exit(-1);
            }
            try {
                for (BeanConfig config : beanConfigs) {
                    createBean(config);
                }
            } catch (Exception e) {
                log.error("spring container init error, beanConfig:{}", beanConfigs, e);
                System.exit(-1);
            }
        }

        private void createBean(BeanConfig config) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
            if (beanNameMap.containsKey(config.getBeanName()) || beanClassMap.containsKey(config.getClassName())) {
                return;
            }
            String className = config.getClassName();
            Class<?> clazz = Class.forName(className);
            Class<?>[] constructorParamTypes = config.getConstructorParamTypes();
            Constructor<?> constructor;
            if (constructorParamTypes != null && constructorParamTypes.length != 0) {
                constructor = clazz.getConstructor(constructorParamTypes);
            } else {
                constructor = clazz.getConstructor();
            }
            Object[] constructorParams = config.getConstructorParams();
            Object o = constructor.newInstance(constructorParams);
            beanNameMap.put(config.getBeanName(), o);
            beanClassMap.put(config.getClassName(), o);
        }

        private Set<BeanConfig> parse(String configPath) {
            // 读取配置文件、并解析bean配置
            Set<BeanConfig> beanConfigs = new HashSet<>();
            BeanConfig beanConfig = new BeanConfig();
            beanConfig.setClassName(TestObj1.class.getName());
            beanConfig.setBeanName("testObj1");
            beanConfig.setConstructorParamTypes(new Class<?>[]{Integer.class, String.class});
            beanConfig.setConstructorParams(new Object[]{20, "xiaocheng"});
            beanConfigs.add(beanConfig);
            return beanConfigs;
        }

        public Object getBean(String beanName) {
            if (beanNameMap.containsKey(beanName)) {
                return beanNameMap.get(beanName);
            }
            return null;
        }

        public Object getBean(Class<?> clazz) {
            if (beanClassMap.containsKey(clazz.getName())) {
                return beanClassMap.get(clazz.getName());
            }
            return null;
        }
    }

    @Data
    public static class BeanConfig {
        private String className;
        private String beanName;
        private Class<?>[] constructorParamTypes;
        private Object[] constructorParams;
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TestObj1 {
        private Integer age;

        private String name;
    }

    @Data
    public static class TestObj2 {

        private String schoolName;

        private String degree;
    }

}
