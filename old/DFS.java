package old;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class DFS {
	
	static int count = 0;
	
	//allows DFS search without executing as IDS search 
	//IDS uses the DFS class in its search
	
	public static void search(Node startNode, int[][] goalState) {
		
		search(startNode, goalState, -1);
		
	}
		
	public static ArrayList<Move> search(Node startNode, int[][] goalState, int limit) {
		
		count = 0;
		ArrayList<Move> moves = null;
		ArrayChecker checker = new ArrayChecker(); // checks if two int[][] are
		LegalMoves legalMoves = new LegalMoves();
		
		Stack<Node> stack = new Stack<Node>();	//
		
		stack.push(startNode);
		int count = 0;
			
		while(!stack.isEmpty()) {
			
			Node expanded = stack.pop();
			count++;
			System.out.println(String.format("Nodes Expanded:  " + count + "  Depth:  " + expanded.depth));
		
			if (checker.check(goalState, expanded.state)) {
				
				System.out.println("Goal State Found");
				moves = Node.getMovesTaken(expanded);
				break;
				
			}
			
			
			if (expanded.depth != limit) {
				
				legalMoves.getMoves(expanded, expanded.state);
				ArrayList<Node> children = legalMoves.getChildren();
				Collections.shuffle(children);
				
				for (Node child : children) {
					stack.add(child);
					
				}
			}
		}
		
		//on completion (if the search is DFS, not IDS), print out the depth and the number of nodes expanded, along with the list of moves
		
		if(limit == -1){		
			
			System.out.println("\n------[ DFS COMPLETE ]----------------\n\nPass:  " + (moves == null ? "False" : "True") + "\nNodes Expanded: " + count +"\n" + "Depth:  " + count + "\n");
			System.out.println("Moves From Start To Goal:\n");
			
			for(Move move : moves) {
				
				System.out.println(move.toString());
				
			}
			System.out.println();
		}	
		return moves;	
	}	
}
