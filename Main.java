import java.util.List;

public class Main {
    public static void main(String[] args) {

        Generator generator = new Generator(4);

        try {

            generator.addNumber(1, 0, 3);
            generator.addNumber(2, 1, 3);
            generator.addNumber(3, 2, 3);
            generator.addAgent(3, 3);

        } catch (Exception e) {
            System.err.println("Failed to add number!");
            e.printStackTrace();
        }

        State test = generator.generate(true);
        ArrayTools.print(test.internalState);

        try {

            generator.addNumber(1, 1, 1);
            generator.addNumber(2, 1, 2);
            generator.addNumber(3, 1, 3);

        } catch (Exception e) {
            System.err.println("Failed to add number!");
            e.printStackTrace();
        }

        State goal = generator.generate(true);
        ArrayTools.print(goal.internalState);

        List<Move> mvs = IDS(test, goal);

        if(mvs != null){
            Displayer.display(test, mvs);
        } else {
            System.out.println("Failed");
        }
    }

    private void AStar(State test, State goal){
        List<Move> ds = AStar.search(test, goal, 10000);
    }

    private void BFS(State test, State goal){
        BFS.search(test, goal, 10000);
    }

    private static List<Move> IDS(State test, State goal){
        
        boolean found = false;
        int limit = 3;
        int maxDepth = 1000;

        while(!found && limit <= maxDepth){           
            found = DFS.search(test, goal, 0, limit);
            limit++;
        }

        if(!found){
            System.out.println("IDS Search Failed");
            return null;
        }

        return DFS.finalMoves;
    }
}