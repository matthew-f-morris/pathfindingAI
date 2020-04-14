import java.util.Arrays;

public class ArrayTools {
    public static void print(int[][] array){
        System.out.println(Arrays.deepToString(array).replace("], ", "]\n").replace("[[", "[").replace("]]", "]").concat("\n"));
    }

    public static int[][] copy(State state){
        
        return Arrays.stream(state.internalState)
                        .map(int[]::clone)
                        .toArray(int[][]::new);

    }

    public static boolean checkSame(int[][] first, int[][] second) {

		for (int row = 0; row < first.length; row++) {			
			for (int col = 0; col < first[row].length; col++) {				
				if (first[row][col] != second[row][col] && (first[row][col] > 0 || second[row][col] > 0))			
					return false;
			}
        }	
        	
		return true;		
	}
}