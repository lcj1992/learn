package java8;

import com.google.common.base.Strings;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 16/8/18
 * Time: 下午12:50
 */

@FunctionalInterface
interface Converter<F, T> {
    // T = f(F);
    T convert(F from);

    default int hehe(F from) {
        System.out.println("jianzhiheheda");
        return 0;
    }

    //         静态方法中不能有范型,你能在编译期就确定类型么？
//         static String haha(F f){
//           return "";
//         }
    static int haha(int from, int to) {
        return (from + to);
    }
}

@FunctionalInterface
interface Converter2<F, T, R> {
    // r = f(f,t); 有没有很像
    R convert(F from1, T from2);
}


public class Java8Test {

    @Test
    // 函数式接口的声明方式
    public void functional() {
        Converter<String, Integer> converter;

        // 1. 函数式接口的正常实现是这样的
        converter = (String from) -> {
            return Integer.valueOf(from);
        };
        Assert.assertEquals(Integer.valueOf(1), converter.convert("1"));

        // 2.可以不指定类型,会自行推断
        converter = (from) -> {
            return Integer.valueOf(from);
        };
        Assert.assertEquals(Integer.valueOf("2"), converter.convert("2"));

        // 3.如果方法体只有一行,可以不要大括号
        converter = (String from) -> Integer.valueOf(from);
        Assert.assertEquals(Integer.valueOf("3"), converter.convert("3"));

        // 4.如果是某个类的某个方法和接口 与函数式接口的入参,返回值一样,可以使用::来指定
        // y = f(x)
        // m = g(x)
        // f(x) = g(x)
        converter = Integer::valueOf;
        Assert.assertEquals(Integer.valueOf("4"), converter.convert("4"));

        // 5.多入参
        // f(a,b) = g(a,b)
        Converter2<String, String, Integer> converter2 = String::compareTo;
        Assert.assertEquals(Integer.valueOf(-25), converter2.convert("a", "z"));
    }

    // 断言
    @Test
    public void predicateTest() {
        Predicate<String> strEmpty = Strings::isNullOrEmpty;

        Assert.assertEquals(false, strEmpty.test("haha"));
        Assert.assertEquals(true, strEmpty.negate().test("haha"));

        Predicate<String> lengthGtTen = (s) -> s != null && s.length() > 10;
        Predicate<String> lengthLtFifteen = (s) -> s != null && s.length() < 15;

        Assert.assertEquals(false, lengthGtTen.and(lengthLtFifteen).test("haha"));
        Assert.assertEquals(true, lengthGtTen.and(lengthLtFifteen).test("hahahahahah"));

        String str1 = "ab";
        String str2 = "a" + "b";
        String str3 = "abc";

        Assert.assertEquals(true, Predicate.isEqual(str1).test(str2));
        Assert.assertEquals(false, Predicate.isEqual(str1).test(str3));
    }


    // 函数式接口
    @Test
    public void functionTest() {
        Assert.assertEquals("abc", Function.identity().apply("abc"));

        String prefix = "prefix-";
        String suffix = "-suffix";
        Function<String, String> addPrefix = (s) -> prefix + s;
        Function<String, String> addSuffix = (s) -> s + suffix;

        // compose 类似装饰器
        // 先加后缀,再在加了后缀的字符串上,增加前缀。
        Assert.assertEquals(prefix + "hehe" + suffix, addPrefix.compose(addSuffix).apply("hehe"));

        // 先加前缀,后加后缀。
        Assert.assertEquals(prefix + "hehe" + suffix, addPrefix.andThen(addSuffix).apply("hehe"));
    }

    // 生产消费模型,生产者
    @Test
    public void supplierTest() {
        Supplier<String> stringSupplier = String::new;
        String str = stringSupplier.get();
        Assert.assertEquals(String.class, str.getClass());
    }


    // 生产消费模型,消费者,不同的消费者,不同的消费方式
    @Test
    public void consumerTest() {
        Consumer<String> logConsumer = s -> {
            System.out.println("打印" + s);
        };

        Consumer<String> dbConsumer = (s) -> {
            System.out.println(s + "入库");
        };

        logConsumer.andThen(dbConsumer).accept("foolchild");
    }


    // 比较器
    @Test
    public void comparatorTest() {
        Comparator<String> reserveComparator = (o1, o2) -> {
            return o1.compareTo(o2);
        };
    }

    // http://www.importnew.com/6675.html
    @Test
    public void optionalTest() {
        Optional<String> name = Optional.of("Sanaulla");
        try {
            Optional<String> someNull = Optional.of(null);
        } catch (Exception e) {
            Assert.assertEquals(true, e instanceof NullPointerException);
        }

        Optional empty = Optional.ofNullable(null);
        if (name.isPresent()) {
            System.out.println(name.get());
        }
        try {
            System.out.println(empty.get());
        } catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        }

        name.ifPresent((value) -> System.out.println("The length of the value is:" + value.length()));

        System.out.println(empty.orElse("there is no value present"));

        System.out.println(name.orElse("there is some value!"));

        try {
            empty.orElseThrow(ValueAbsentException::new);
        } catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }

        Optional<String> upperName = name.map(value -> value.toUpperCase());
        System.out.println(upperName.orElse("no value found"));

        upperName = name.flatMap(value -> Optional.of(value.toUpperCase()));
        System.out.println(upperName.orElse("no value found"));

        Optional<String> longName = name.filter(value -> value.length() > 6);
        System.out.println(longName.orElse("the name is less than 6 characters"));

        Optional<String> anotherName = Optional.of("sana");
        Optional<String> shortName = anotherName.filter(value -> value.length() > 6);
        System.out.println(shortName.orElse("the name is less than 6 characters"));

    }
}

class ValueAbsentException extends Throwable {
    public ValueAbsentException() {
        super();
    }

    public ValueAbsentException(String msg) {
        super(msg);
    }

    @Override
    public String getMessage() {
        return "no value present in the Optional instance";
    }
}