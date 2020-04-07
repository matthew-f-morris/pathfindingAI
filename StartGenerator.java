import java.util.Arrays;

public class StartGenerator {

    int[][] startState;
    int[] included;

    public StartGenerator(final int size) {
        this.startState = new int[size][];
        System.out.println(Arrays.deepToString(startState));
    }

    public void add(final int number, final int x, final int y){
        if(number >= 1 || !this.isIncluded(number))
            System.err.println("Invalid number");
        else if(x > startState.length -1 || y > startState.length - 1)
            System.err.println("Invalid number");
        else
            this.startState[x][y] = number;
        System.out.println(Arrays.deepToString(startState));
    }

    private boolean isIncluded(final int number) {
        for (final int i : included) {
            if(i == number);
            return true;
        }
        return false;
    }

    public int[][] genStart(){
        return this.startState;
    }
}