package structural.composite;

/**
 * Created by lcj on 15-10-31.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * "Component"
 */
interface Component {

    //Prints the graphic.
    void print();
}

/**
 * "Composite"
 */
class CompositeComponent implements Component {

    //Collection of child graphics.
    private List<Component> childComponents = new ArrayList<>();

    //Prints the graphic.
    public void print() {
        childComponents.forEach(Component::print);
    }

    //Adds the graphic to the composition.
    public void add(Component component) {
        childComponents.add(component);
    }

    //Removes the graphic from the composition.
    public void remove(Component component) {
        childComponents.remove(component);
    }
}

/**
 * "Leaf"
 */
class LeafComponent implements Component {

    //Prints the graphic.
    public void print() {
        System.out.println("LeafComponent");
    }
}

/**
 * Client
 */
public class CompositeTest {

    public static void main(String[] args) {
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
}