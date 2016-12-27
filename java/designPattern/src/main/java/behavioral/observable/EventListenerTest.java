package behavioral.observable;

import java.util.Collection;
import java.util.EventListener;
import java.util.EventObject;
import java.util.HashSet;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2016/11/13
 * Time: 下午11:58
 */
enum Status {
    FULL, EMPTY
}

interface StateListener extends EventListener {
    void onEvent(Event event);
}

class Event extends EventObject {

    private Status status;

    public Event(Object source, Status status) {
        super(source);
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

class FullStateListener implements StateListener {

    @Override
    public void onEvent(Event event) {
        if (event.getStatus() == Status.FULL) {
            System.out.println("don't produce");
        }
    }
}

class EmptyStateListener implements StateListener {

    @Override
    public void onEvent(Event event) {
        if (event.getStatus() == Status.EMPTY) {
            System.out.println("don't consume");
        }
    }
}


class EventManager {
    private Collection<StateListener> listeners = new HashSet();

    public void attach(StateListener listener) {
        listeners.add(listener);
    }

    public void dettach(StateListener listener) {
        listeners.remove(listener);
    }

    public void fireFullEvent() {
        Event event = new Event(this, Status.FULL);
        onEvent(event);
    }

    public void fireEmptyEvent() {
        Event event = new Event(this, Status.EMPTY);
        onEvent(event);
    }

    public void onEvent(Event event) {
        for (StateListener listener : listeners) {
            listener.onEvent(event);
        }
    }

}

public class EventListenerTest {

    public static void main(String[] args) {
        EventManager eventManager = new EventManager();
        eventManager.attach(new FullStateListener());
        eventManager.attach(new EmptyStateListener());
        eventManager.fireEmptyEvent();
        eventManager.fireFullEvent();
    }
}
