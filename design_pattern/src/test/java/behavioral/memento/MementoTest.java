package behavioral.memento;

/**
 * Created by lcj on 15-10-31.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MementoTest {
    @Test
    public void test() {
        List<Originator.Memento> savedStates = new ArrayList<>();
        Originator originator = new Originator();
        originator.set("State1");
        originator.set("State2");
        savedStates.add(originator.saveToMemento());
        originator.set("State3");
        // We can request multiple mementos, and choose which one to roll back to.
        savedStates.add(originator.saveToMemento());
        originator.set("State4");

        originator.restoreFromMemento(savedStates.get(0));
    }

    public static class Originator {
        private String state;
        // The class could also contain additional data that is not part of the
        // state saved in the memento..

        void set(String state) {
            System.out.println("Originator: Setting state to " + state);
            this.state = state;
        }

        Memento saveToMemento() {
            System.out.println("Originator: Saving to Memento.");
            return new Memento(this.state);
        }

        void restoreFromMemento(Memento memento) {
            this.state = memento.getSavedState();
            System.out.println("Originator: State after restoring from Memento: " + state);
        }

        public static class Memento {
            private final String state;

            Memento(String stateToSave) {
                state = stateToSave;
            }

            String getSavedState() {
                return state;
            }
        }
    }
}
