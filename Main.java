import java.util.List;

public class Main {
    public static void main(String[] args) {

        State initial = new State(new int[][]{
            {3, 2, 1},
            {0, 0, 0},
            {-1, 0, 0},
        });

        ArrayTools.print(initial.internalState);

        State goal = new State(new int[][]{
            {0, 0, 0},
            {0, 0, 0},
            {1, 2, 3}
        });

        ArrayTools.print(goal.internalState);
        List<Move> mvs = astar(initial, goal);

        if(mvs != null){
            Displayer.display(initial, mvs);
        } else {
            System.out.println("Failed");
        }
    }

    private static List<Move> astar(State test, State goal){
        return AStar.search(test, goal, 1000);
    }

    private static void BFS(State test, State goal){
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