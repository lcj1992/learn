package behavioral.observable;

import org.junit.Test;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

/**
 * Created by lcj on 15-10-31.
 */


public class JdkObservableTest {
    @Test
    public void test() {
        System.out.println("Enter Text >");
        EventSource eventSource = new EventSource();
        eventSource.addObserver(new Watcher());
        new Thread(eventSource).start();
    }

    static class EventSource extends Observable implements Runnable {
        public void run() {
            while (true) {
                String response = new Scanner(System.in).next();
                setChanged();
                notifyObservers(response);
            }
        }
    }

    static class Watcher implements Observer {

        @Override
        public void update(Observable o, Object arg) {
            System.out.println("\nReceived response: " + arg);
        }
    }
}
