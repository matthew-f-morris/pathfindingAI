package old;

import java.util.ArrayList;


public class ArrayChecker {
	
	//takes two arrays (board states) and checks if they are the same, returns a boolean;
	
	ArrayList<Integer> firsts = new ArrayList<Integer>();
	ArrayList<Integer> seconds = new ArrayList<Integer>();
	
	public boolean check(int[][] first, int[][] second) {

		for (int row = 0; row < first.length; row++) {
			
			for (int col = 0; col < first[row].length; col++) {
				
				if (first[row][col] != second[row][col] && (first[row][col] > 0 || second[row][col] > 0)) {
					
					return false;
				}
			}
		}		
		return true;		
	}
}

