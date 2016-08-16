package behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lcj on 15-10-31.
 */

interface Command {
    void execute();
}

/**
 * The Invoker class
 */
class Switch {
    private List<Command> history = new ArrayList<Command>();

    public void storeAndExecute(Command cmd) {
        this.history.add(cmd); // optional
        cmd.execute();
    }
}

/**
 * The Receiver class
 */
class Light {

    void turnOn() {
        System.out.println("The light is on");
    }

    void turnOff() {
        System.out.println("The light is off");
    }
}

/**
 * The Command for turning on the light - ConcreteCommand #1
 */
class FlipUpCommand implements Command {
    private Light theLight;

    FlipUpCommand(Light light) {
        this.theLight = light;
    }

    @Override    // Command
    public void execute() {
        theLight.turnOn();
    }
}

/**
 * The Command for turning off the light - ConcreteCommand #2
 */
class FlipDownCommand implements Command {
    private Light theLight;

    FlipDownCommand(Light light) {
        this.theLight = light;
    }

    @Override    // Command
    public void execute() {
        theLight.turnOff();
    }
}

// invoker  command  receiver
public class CommandTest {

    public static void main(String[] args) {

        // receiver 这里其实也可以抽象一层,不同的receiver 除了灯,还可以有电扇,空调等都能接受开和关的命令。
        Light lamp = new Light();
        // Command 抽象的command
        Command switchUp = new FlipUpCommand(lamp);

        // FlipUpCommand 具体的command ,持有receiver的引用
        Command switchDown = new FlipDownCommand(lamp);

        /// switch invoker
        Switch mySwitch = new Switch();

        // invoker invoke时实际调用的是command的执行方法,command的执行方法又调用了receiver的执行方法
        mySwitch.storeAndExecute(switchUp);
        mySwitch.storeAndExecute(switchDown);
    }
}
