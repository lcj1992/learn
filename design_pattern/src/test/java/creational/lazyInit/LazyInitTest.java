package creational.lazyInit;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lcj on 15-10-31.
 */
public class LazyInitTest {
    @Test
    public void test() {
        Fruit res = Fruit.getFruitByTypeNameHighConcurrentVersion(FruitType.BANANA);
        System.out.println(res);
        Fruit.showAll();
        Fruit.getFruitByTypeName(FruitType.APPLE);
        Fruit.showAll();
        Fruit.getFruitByTypeName(FruitType.BANANA);
        Fruit.showAll();
    }

    /**
     * Created by lcj on 15-10-31.
     */
    public static class Fruit {
        private static Map<FruitType, Fruit> types = new HashMap();

        /**
         * Using a private constructor to force the use of the staticfactory method.
         *
         * @param type
         */
        private Fruit(FruitType type) {
        }

        /**
         * Lazy Factory method, gets the Fruit instance associated with a certain
         * type. Instantiates new ones as needed.
         *
         * @param type Any allowed fruit type, e.g. APPLE
         * @return The Fruit instance associated with that type.
         */
        public static Fruit getFruitByTypeName(FruitType type) {
            Fruit fruit;
            // This has concurrency issues.  Here the read to types is not synchronized,
            // so types.put and types.containsKey might be called at the same time.
            // Don't be surprised if the data is corrupted.
            if (!types.containsKey(type)) {
                // Lazy initialisation
                fruit = new Fruit(type);
                types.put(type, fruit);
            } else {
                // OK, it's available currently
                fruit = types.get(type);
            }

            return fruit;
        }

        /**
         * Lazy Factory method, gets the Fruit instance associated with a certain
         * type. Instantiates new ones as needed. Uses double-checked locking
         * pattern for using in highly concurrent environments.
         *
         * @param type Any allowed fruit type, e.g. APPLE
         * @return The Fruit instance associated with that type.
         */
        public static Fruit getFruitByTypeNameHighConcurrentVersion(FruitType type) {
            if (!types.containsKey(type)) {
                synchronized (types) {
                    // Check again, after having acquired the lock to make sure
                    // the instance was not created meanwhile by another thread
                    if (!types.containsKey(type)) {
                        // Lazy initialisation
                        types.put(type, new Fruit(type));
                    }
                }
            }

            return types.get(type);
        }

        /**
         * Displays all entered fruits.
         */
        public static void showAll() {
            if (!types.isEmpty()) {
                System.out.println("Number of instances made = " + types.size());

                for (Map.Entry<FruitType, Fruit> entry : types.entrySet()) {
                    System.out.println(entry.getKey().toString());
                }

                System.out.println();
            }
        }
    }

    /**
     * Created by lcj on 15-10-31.
     */
    public enum FruitType {
        NONE,
        APPLE,
        BANANA;
    }
}
