import java.util.List;

public class Displayer {

    public static void display(State start, List<Move> moves) {

        State[] states = ChildMaker.getStatesFromMoves(start, moves);
        int acc = states.length - 1;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (State state : states) {

            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("\nDepth: " + state.depth + " out of " + acc);
            System.out.println("Move:  " + state.move + "\n");
            ArrayTools.print(state.internalState);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}