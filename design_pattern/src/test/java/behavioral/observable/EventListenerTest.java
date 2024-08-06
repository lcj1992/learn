package behavioral.observable;

import lombok.Getter;
import org.junit.Test;

import java.util.Collection;
import java.util.EventListener;
import java.util.EventObject;
import java.util.HashSet;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 2016/11/13
 * Time: 下午11:58
 */

public class EventListenerTest {

    @Test
    public void test() {
        EventManager eventManager = new EventManager();
        eventManager.attach(new FullStateListener());
        eventManager.attach(new EmptyStateListener());
        eventManager.fireEmptyEvent();
        eventManager.fireFullEvent();
    }

    public enum Status {
        FULL, EMPTY
    }

    public interface StateListener extends EventListener {
        void onEvent(Event event);
    }

    @Getter
    public static class Event extends EventObject {

        private final Status status;

        Event(Object source, Status status) {
            super(source);
            this.status = status;
        }
    }

    public static class FullStateListener implements StateListener {

        @Override
        public void onEvent(Event event) {
            if (event.getStatus() == Status.FULL) {
                System.out.println("don't produce");
            }
        }
    }

    public static class EmptyStateListener implements StateListener {

        @Override
        public void onEvent(Event event) {
            if (event.getStatus() == Status.EMPTY) {
                System.out.println("don't consume");
            }
        }
    }


    public static class EventManager {
        private final Collection<StateListener> listeners = new HashSet<>();

        void attach(StateListener listener) {
            listeners.add(listener);
        }

        public void detach(StateListener listener) {
            listeners.remove(listener);
        }

        void fireFullEvent() {
            Event event = new Event(this, Status.FULL);
            onEvent(event);
        }

        void fireEmptyEvent() {
            Event event = new Event(this, Status.EMPTY);
            onEvent(event);
        }

        private void onEvent(Event event) {
            for (StateListener listener : listeners) {
                listener.onEvent(event);
            }
        }

    }
}
