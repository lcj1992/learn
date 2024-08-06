package behavioral.command;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lcj on 15-10-31.
 */


// invoker  command  receiver
public class CommandTest {

    @Test
    public void test() {

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

    public interface Command {
        void execute();
    }

    /**
     * The Invoker class
     */
    public static class Switch {
        private final List<Command> histories = new ArrayList<>();

        void storeAndExecute(Command cmd) {
            this.histories.add(cmd); // optional
            cmd.execute();
        }
    }

    /**
     * The Receiver class
     */
    public static class Light {

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
    public static class FlipUpCommand implements Command {
        private final Light theLight;

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
    public static class FlipDownCommand implements Command {
        private final Light theLight;

        FlipDownCommand(Light light) {
            this.theLight = light;
        }

        @Override    // Command
        public void execute() {
            theLight.turnOff();
        }
    }
}
