
public class StateChecker {
	
	public static boolean check(int[][] first, int[][] second) {

		for (int row = 0; row < first.length; row++) {			
			for (int col = 0; col < first[row].length; col++) {				
				if (first[row][col] != second[row][col] && (first[row][col] > 0 || second[row][col] > 0))			
					return false;
			}
        }	
        	
		return true;		
	}
}