package behavioral.chainOfResponsibility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

/**
 * Created by lcj on 15-10-31.
 */
public class ChainOfResponsibilityTest {

    @Test
    public void test() {
        ManagerPPower manager = new ManagerPPower();
        DirectorPPower director = new DirectorPPower();
        VicePresidentPPower vp = new VicePresidentPPower();
        PresidentPPower president = new PresidentPPower();

        manager.setSuccessor(director);
        director.setSuccessor(vp);
        vp.setSuccessor(president);

        // Press Ctrl+C to end.
        try {
            double d = Double.parseDouble("2000000.0");
            manager.processRequest(new PurchaseRequest(d, "General"));
        } catch (Exception e) {
            System.exit(1);
        }
    }

    public static abstract class PurchasePower {
        static final double BASE = 500;
        PurchasePower successor;

        void setSuccessor(PurchasePower successor) {
            this.successor = successor;
        }

        abstract public void processRequest(PurchaseRequest request);
    }

    public static class ManagerPPower extends PurchasePower {

        public void processRequest(PurchaseRequest request) {
            double ALLOWABLE = 10 * BASE;
            if (request.getAmount() < ALLOWABLE) {
                System.out.println("Manager will approve $" + request.getAmount());
            } else if (successor != null) {
                successor.processRequest(request);
            }
        }
    }

    public static class DirectorPPower extends PurchasePower {

        public void processRequest(PurchaseRequest request) {
            double ALLOWABLE = 20 * BASE;
            if (request.getAmount() < ALLOWABLE) {
                System.out.println("Director will approve $" + request.getAmount());
            } else if (successor != null) {
                successor.processRequest(request);
            }
        }
    }

    public static class VicePresidentPPower extends PurchasePower {

        public void processRequest(PurchaseRequest request) {
            double ALLOWABLE = 40 * BASE;
            if (request.getAmount() < ALLOWABLE) {
                System.out.println("Vice President will approve $" + request.getAmount());
            } else if (successor != null) {
                successor.processRequest(request);
            }
        }
    }

    public static class PresidentPPower extends PurchasePower {

        public void processRequest(PurchaseRequest request) {
            double ALLOWABLE = 60 * BASE;
            if (request.getAmount() < ALLOWABLE) {
                System.out.println("President will approve $" + request.getAmount());
            } else {
                System.out.println("Your request for $" + request.getAmount() + " needs a board meeting!");
            }
        }
    }

    @AllArgsConstructor
    @Getter
    @Setter
    public static class PurchaseRequest {
        private double amount;

        private String purpose;
    }
}
