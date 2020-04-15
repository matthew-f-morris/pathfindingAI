public class Main {
    public static void main(String[] args) {

        Generator generator = new Generator(3);

        try {

            generator.addNumber(1, 0, 0);
            generator.addNumber(2, 1, 0);
            generator.addNumber(3, 2, 0);
            generator.addAgent(2, 2);

        } catch (Exception e) {
            System.err.println("Failed to add number!");
            e.printStackTrace();
        }

        State test = generator.generate(true);
        ArrayTools.print(test.internalState);

        try {

            generator.addNumber(1, 1, 0);
            generator.addNumber(2, 1, 1);
            generator.addNumber(3, 1, 2);

        } catch (Exception e) {
            System.err.println("Failed to add number!");
            e.printStackTrace();
        }

        State goal = generator.generate(true);
        ArrayTools.print(goal.internalState);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // AStar.search(test, goal, 10000);
        // BFS.search(test, goal, 10000);
        
        boolean found = false;
        int limit = 3;
        int maxDepth = 1000;

        while(!found && limit <= maxDepth){           
            found = DFS.search(test, goal, 0, limit);
            limit++;
        }

        if(!found)
            System.out.println("IDS Search Failed");
    }
}