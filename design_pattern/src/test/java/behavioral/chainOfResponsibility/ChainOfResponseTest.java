package behavioral.chainOfResponsibility;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by lcj on 15-10-31.
 */
abstract class PurchasePower {
    static final double BASE = 500;
    PurchasePower successor;

    void setSuccessor(PurchasePower successor) {
        this.successor = successor;
    }

    abstract public void processRequest(PurchaseRequest request);
}

class ManagerPPower extends PurchasePower {

    public void processRequest(PurchaseRequest request) {
        double ALLOWABLE = 10 * BASE;
        if (request.getAmount() < ALLOWABLE) {
            System.out.println("Manager will approve $" + request.getAmount());
        } else if (successor != null) {
            successor.processRequest(request);
        }
    }
}

class DirectorPPower extends PurchasePower {

    public void processRequest(PurchaseRequest request) {
        double ALLOWABLE = 20 * BASE;
        if (request.getAmount() < ALLOWABLE) {
            System.out.println("Director will approve $" + request.getAmount());
        } else if (successor != null) {
            successor.processRequest(request);
        }
    }
}

class VicePresidentPPower extends PurchasePower {

    public void processRequest(PurchaseRequest request) {
        double ALLOWABLE = 40 * BASE;
        if (request.getAmount() < ALLOWABLE) {
            System.out.println("Vice President will approve $" + request.getAmount());
        } else if (successor != null) {
            successor.processRequest(request);
        }
    }
}

class PresidentPPower extends PurchasePower {

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
class PurchaseRequest {
    private double amount;
    private String purpose;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}

public class ChainOfResponseTest {

    public static void main(String[] args) {
        ManagerPPower manager = new ManagerPPower();
        DirectorPPower director = new DirectorPPower();
        VicePresidentPPower vp = new VicePresidentPPower();
        PresidentPPower president = new PresidentPPower();

        manager.setSuccessor(director);
        director.setSuccessor(vp);
        vp.setSuccessor(president);

        // Press Ctrl+C to end.
        try {
            while (true) {
                System.out.println("Enter the amount to check who should approve your expenditure.");
                System.out.print(">");
                double d = Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine());
                manager.processRequest(new PurchaseRequest(d, "General"));
            }
        } catch (Exception e) {
            System.exit(1);
        }
    }
}
