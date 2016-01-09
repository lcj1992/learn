package creational.lazyInit;

/**
 * Created by lcj on 15-10-31.
 */
public class LazyInitTest {
    public static void main(String[] args) {
        Fruit.getFruitByTypeNameHighConcurrentVersion(FruitType.BANANA);
        Fruit.showAll();
        Fruit.getFruitByTypeName(FruitType.APPLE);
        Fruit.showAll();
        Fruit.getFruitByTypeName(FruitType.BANANA);
        Fruit.showAll();
    }
}
