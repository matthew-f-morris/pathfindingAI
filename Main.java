public class Main {
    public static void main(String[] args) {

        StartGenerator sg = new StartGenerator(5);

        try {
            sg.add(1, 4, 1);
            sg.add(2, 4, 2);
            sg.add(3, 4, 3);
        } catch (Exception e) {
            System.err.println("Failed to add number!");
            e.printStackTrace();
        }

        int[][] startState = sg.getStartState();
        ArrayPrinter.print(startState);
    }
}