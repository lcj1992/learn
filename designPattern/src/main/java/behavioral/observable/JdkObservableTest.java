package behavioral.observable;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

/**
 * Created by lcj on 15-10-31.
 */

class EventSource extends Observable implements Runnable {
    public void run() {
        while (true) {
            String response = new Scanner(System.in).next();
            setChanged();
            notifyObservers(response);
        }
    }
}

class Watcher implements Observer{

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("\nReceived response: " + arg);
    }
}

public class JdkObservableTest {
    public static void main(String[] args) {
        System.out.println("Enter Text >");
        EventSource eventSource = new EventSource();
        eventSource.addObserver(new Watcher());
        new Thread(eventSource).start();
    }
}
