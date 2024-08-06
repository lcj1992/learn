package structural.composite;

/**
 * Created by lcj on 15-10-31.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class CompositeTest {

    @Test
    public void test() {
        //Initialize four LearComponents
        LeafComponent leafComponent1 = new LeafComponent();
        LeafComponent leafComponent2 = new LeafComponent();
        LeafComponent leafComponent3 = new LeafComponent();
        LeafComponent leafComponent4 = new LeafComponent();

        //Initialize three composite graphics
        CompositeComponent compositeComponent = new CompositeComponent();
        CompositeComponent compositeComponent1 = new CompositeComponent();
        CompositeComponent compositeComponent2 = new CompositeComponent();

        //Composes the graphics
        compositeComponent1.add(leafComponent1);
        compositeComponent1.add(leafComponent2);
        compositeComponent1.add(leafComponent3);

        compositeComponent2.add(leafComponent4);

        compositeComponent.add(compositeComponent1);
        compositeComponent.add(compositeComponent2);

        //Prints the complete graphic (four times the string "LeafComponent").
        compositeComponent.print();
    }

    interface Component {
        void print();
    }


    static class CompositeComponent implements Component {

        private final List<Component> childComponents = new ArrayList<>();

        public void print() {
            childComponents.forEach(Component::print);
        }

        public void add(Component component) {
            childComponents.add(component);
        }

        public void remove(Component component) {
            childComponents.remove(component);
        }
    }


    static class LeafComponent implements Component {

        public void print() {
            System.out.println("LeafComponent");
        }
    }
}