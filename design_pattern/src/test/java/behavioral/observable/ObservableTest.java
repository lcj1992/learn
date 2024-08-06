package behavioral.observable;

/**
 * Created by lcj on 15-11-2.
 */

// Observer pattern -- Structural example
// @since JDK 5.0

import org.junit.Test;

import java.util.ArrayList;

public class ObservableTest {
    @Test
    public void test() {
        // Configure Observer structure
        ConcreteSubject s = new ConcreteSubject();
        s.attach(new ConcreteObserver(s, "A"));
        s.attach(new ConcreteObserver(s, "B"));
        s.attach(new ConcreteObserver(s, "C"));

        // Change subject and notify observers
        s.setSubjectState("NEW");
        s.notifyObservers();
    }

    public static abstract class Subject {
        // Fields
        private ArrayList<Observer> observers = new ArrayList<Observer>();
        // Methods

        void attach(Observer observer) {
            observers.add(observer);
        }

        public void detach(Observer observer) {
            observers.remove(observer);
        }

        void notifyObservers() {
            for (Observer o : observers)
                o.update();
        }
    }

    // "Observer"
    public static abstract class Observer {
        // Methods

        abstract public void update();
    }

// "ConcreteSubject"

    public static class ConcreteSubject extends Subject {
        // Fields
        private String subjectState;
        // Properties

        String getSubjectState() {
            return subjectState;
        }

        void setSubjectState(String value) {
            subjectState = value;
        }
    }

    // "ConcreteObserver"
    public static class ConcreteObserver extends Observer {
        // Fields
        private final String name;
        private String observerState;
        private final ConcreteSubject subject;

        // Constructors
        public ConcreteObserver(ConcreteSubject subject, String name) {
            this.subject = subject;
            this.name = name;
            //subject.attach(this);
        }
        // Methods

        public void update() {
            observerState = subject.getSubjectState();
            System.out.printf("Observer %s's new state is %s\n", name, observerState);
        }
    }
}
