package old;

import java.util.ArrayList;

public class IDS {
	
	static int count = 0;
	int[][] goalState;
	Node parentSolution;
	
	public static ArrayList<Move> search(Node startNode, int[][] goalNode) {

		int count = 0;
		int depth = 0;
		
		ArrayList<Move> moves = null;
		
		while(moves == null) {
			
			moves = DFS.search(startNode, goalNode, depth);			
			depth++;
			count = DFS.count;
			
		}
				
		System.out.println("\n------[ IDS COMPLETE ]----------------\n\nPass:  " + (moves == null ? "False" : "True") + "\n" + "Depth:  " + (depth-1) + "\n" + "Nodes Expanded" + count);	
		System.out.println("\nMoves From Start To Goal:\n");

		for(Move move : moves) {
			
			System.out.println(move.toString());
			
		}			
		System.out.println();		
		return moves;		
	}	
}
