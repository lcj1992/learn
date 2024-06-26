package creational.singleton;

import lombok.Getter;

/**
 * Created by lcj on 15-10-31.
 */
public class EagerSingleton {
    @Getter
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
    }

    public void sayHello() {
        System.out.println("hello world");
    }
}


