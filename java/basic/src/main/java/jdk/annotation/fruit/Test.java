package jdk.annotation.fruit;

/**
 * Created by lcj on 15-4-18.
 *
 */
public class Test {
    public static void main(String[] args) {
        Apple apple = new Apple();
        FruitInfoUtil.getFruitInfo(apple.getClass());
    }
}
