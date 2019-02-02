package jdk;

import org.junit.Test;

import java.lang.ref.SoftReference;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2017/5/31
 * Time: 上午8:30
 */
public class SoftReferenceTest {

    @Test
    public void testSoftReference() {
        System.out.println("开始");

        A a = new A();

        SoftReference<A> sr = new SoftReference<>(a);
        a = sr.get();

        System.out.println(a.a);
        System.out.println("结束");

    }

    class A {
        int[] a;

        public A() {
            a = new int[100000000];
        }
    }
}
