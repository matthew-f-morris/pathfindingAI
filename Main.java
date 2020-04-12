public class Main {
    public static void main(String[] args) {

        Generator generator = new Generator(4);

        try {
            generator.add(1, 1, 1);
            generator.add(2, 2, 2);
            generator.add(3, 3, 3);
        } catch (Exception e) {
            System.err.println("Failed to add number!");
            e.printStackTrace();
        }

        int[][] startState = generator.generate();

        try {
            generator.add(1, 0, 0);
            generator.add(2, 1, 1);
            generator.add(3, 2, 2);
        } catch (Exception e) {
            System.err.println("Failed to add number!");
            e.printStackTrace();
        }

        int[][] startState2 = generator.generate();

        ArrayPrinter.print(startState);
        ArrayPrinter.print(startState2);

    }
}