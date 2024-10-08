package behavioral.templateMethod;

/**
 * Created by lcj on 15-10-31.
 */

abstract class Game {
    /* Hook methods. Concrete implementation may differ in each subclass*/
    protected int playersCount;

    abstract void initializeGame();

    abstract void makePlay(int player);

    abstract boolean endOfGame();

    abstract void printWinner();

    /* A template method : */
    public final void playOneGame(int playersCount) {
        this.playersCount = playersCount;
        initializeGame();
        int j = 0;
        while (!endOfGame()) {
            makePlay(j);
            j = (j + 1) % playersCount;
        }
        printWinner();
    }
}

//Now we can extend this class in order
//to implement actual games:

class Monopoly extends Game {

    /* Implementation of necessary concrete methods */
    void initializeGame() {
        // Initialize players
        // Initialize money
    }

    void makePlay(int player) {
        // Process one turn of player
    }

    boolean endOfGame() {
        // Return true if game is over
        // according to Monopoly rules
        return true;
    }

    void printWinner() {
        // Display who won
    }
    /* Specific declarations for the Monopoly game. */

    // ...
}

class Chess extends Game {

    /* Implementation of necessary concrete methods */
    void initializeGame() {
        // Initialize players
        // Put the pieces on the board
    }

    void makePlay(int player) {
        // Process a turn for the player
    }

    boolean endOfGame() {
        // Return true if in Checkmate or
        // Stalemate has been reached
        return true;
    }

    void printWinner() {
        // Display the winning player
    }
    /* Specific declarations for the chess game. */

    // ...
}

public class TemplateMethodTest {
}
