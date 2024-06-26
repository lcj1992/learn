package creational.singleton;

import lombok.Getter;

/**
 * Created by lcj on 15-10-31.
 *
 */
public class StaticBlockSingleton {
    @Getter
    private static final StaticBlockSingleton instance;

    private StaticBlockSingleton() {
    }

    static {
        instance = new StaticBlockSingleton();
    }

    public void sayHello() {
        System.out.println("hello world");
    }
}
