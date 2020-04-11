import java.util.Arrays;

public class ArrayPrinter {
    public static void print(int[][] array){
        System.out.println(Arrays.deepToString(array).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
    }
}