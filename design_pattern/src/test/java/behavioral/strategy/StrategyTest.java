package behavioral.strategy;

import lombok.Setter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lcj on 15-10-31.
 */

public class StrategyTest {

    @Test
    public void test() {

        Customer b = new Customer(new HappyHourStrategy());
        b.add(0.8, 1);
        b.printBill();

        b.setStrategy(new NormalStrategy());
        b.add(1.3, 2);
        b.printBill();

    }

    static class Customer {
        private final List<Double> drinks;
        // Set Strategy
        @Setter
        private BillingStrategy strategy;

        Customer(BillingStrategy strategy) {
            this.drinks = new ArrayList<>();
            this.strategy = strategy;
        }

        public void add(double price, int quantity) {
            drinks.add(strategy.getActPrice(price * quantity));
        }

        // Payment of bill
        public void printBill() {
            double sum = 0;
            for (Double i : drinks) {
                sum += i;
            }
            System.out.println("Total due: " + sum);
            drinks.clear();
        }

    }

    interface BillingStrategy {
        double getActPrice(double rawPrice);
    }

    // Normal billing strategy (unchanged price)
    static class NormalStrategy implements BillingStrategy {
        @Override
        public double getActPrice(double rawPrice) {
            return rawPrice;
        }
    }

    // Strategy for Happy hour (50% discount)
    static class HappyHourStrategy implements BillingStrategy {

        @Override
        public double getActPrice(double rawPrice) {
            return rawPrice * 0.5;
        }

    }
}

