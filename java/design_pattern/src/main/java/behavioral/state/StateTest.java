package behavioral.state;

/**
 * Created by lcj on 15-10-31.
 */

interface StateLike {
    void writeName(StateContext context, String name);
}

class StateLowerCase implements StateLike {
    @Override
    public void writeName(final StateContext context, final String name) {
        System.out.println(name.toLowerCase());
        context.setState(new StateMultipleUpperCase());
    }
}

class StateMultipleUpperCase implements StateLike {

    private int count = 0;

    @Override
    public void writeName(final StateContext context, final String name) {
        System.out.println(name.toUpperCase());
        if (++count > 1) {
            context.setState(new StateLowerCase());
        }
    }


}

class StateContext {
    private StateLike myState;

    StateContext() {
        setState(new StateLowerCase());
    }


    void setState(final StateLike newState) {
        myState = newState;
    }

    void writeName(final String name) {
        myState.writeName(this, name);
    }
}

public class StateTest {
    public static void main(String[] args) {
        final StateContext sc = new StateContext();

        sc.writeName("Monday");
        sc.writeName("Tuesday");
        sc.writeName("Wednesday");
        sc.writeName("Thursday");
        sc.writeName("Friday");
        sc.writeName("Saturday");
        sc.writeName("Sunday");
    }
}
