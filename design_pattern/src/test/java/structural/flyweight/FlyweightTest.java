package structural.flyweight;

/**
 * Created by lcj on 15-10-31.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class FlyweightTest {
    @Test
    public void test() {
        CoffeeShop shop = new CoffeeShop();

        shop.takeOrder("Cappuccino", 2);
        shop.takeOrder("Frappe", 1);
        shop.takeOrder("Espresso", 1);
        shop.takeOrder("Frappe", 897);
        //热奶
        shop.takeOrder("Cappuccino", 97);
        //冰沙
        shop.takeOrder("Frappe", 3);
        shop.takeOrder("Espresso", 3);
        shop.takeOrder("Cappuccino", 3);
        shop.takeOrder("Espresso", 96);
        shop.takeOrder("Frappe", 552);
        shop.takeOrder("Cappuccino", 121);
        shop.takeOrder("Espresso", 121);

        shop.service();
        System.out.println(shop.report());
    }

    static class CoffeeFlavour {
        private final String name;

        CoffeeFlavour(String newFlavor) {
            this.name = newFlavor;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static class Menu {
        private final Map<String, CoffeeFlavour> flavours = new ConcurrentHashMap<>();

        CoffeeFlavour lookup(String flavorName) {
            if (!flavours.containsKey(flavorName)) flavours.put(flavorName, new CoffeeFlavour(flavorName));
            return flavours.get(flavorName);
        }

        int totalCoffeeFlavoursMade() {
            return flavours.size();
        }
    }

    static class Order {
        private final int tableNumber;
        private final CoffeeFlavour flavour;

        Order(int tableNumber, CoffeeFlavour flavor) {
            this.tableNumber = tableNumber;
            this.flavour = flavor;
        }

        void serve() {
            System.out.println("Serving " + flavour + " to table " + tableNumber);
        }
    }

    static class CoffeeShop {
        private final List<Order> orders = new ArrayList<>();
        private final Menu menu = new Menu();

        void takeOrder(String flavourName, int table) {
            CoffeeFlavour flavour = menu.lookup(flavourName);
            Order order = new Order(table, flavour);
            orders.add(order);
        }

        void service() {
            Iterator<Order> it = orders.iterator();
            while (it.hasNext()) {
                Order order = it.next();
                order.serve();
                it.remove();
            }
        }

        String report() {
            return "\ntotal CoffeeFlavour objects made: " + menu.totalCoffeeFlavoursMade();
        }

    }
}