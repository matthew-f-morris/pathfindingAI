public class Main {
    public static void main(String[] args) {

        Generator generator = new Generator(4);

        try {

            generator.addNumber(1, 0, 3);
            generator.addNumber(2, 1, 3);
            generator.addNumber(3, 2, 3);
            generator.addNumber(4, 2, 2);
            // generator.addNumber(5, 3, 2);
            // generator.addNumber(6, 3, 3);
            generator.addAgent(0, 0);

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
            generator.addNumber(4, 3, 3);
            // generator.addNumber(5, 3, 2);
            // generator.addNumber(6, 3, 1);
            generator.addAgent(0, 1);

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

        AStar.search(test, goal, 10000);
    }
}