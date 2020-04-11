package old;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	public static void search(Node startNode, int[][] goalState) {
		
		ArrayList<Move> moves = null;
		ArrayChecker checker = new ArrayChecker(); // checks if two int[][] are
													
		Queue<Node> queue = new LinkedList<Node>(); // stores nodes to be queued
		LegalMoves legalMoves = new LegalMoves();

		int depth = 0;
		int count = 0;

		queue.add(startNode);
		
		while (!queue.isEmpty()) {
			
			Node expanded = queue.poll();
			count++;
			System.out.println(String.format("Nodes Expanded:  " + count + "  Depth:  " + expanded.depth));
			
			//check if the goal state is found
			
			if (checker.check(goalState, expanded.state)) {
				
				//return the moves taken to get to the goal state
				
				System.out.println("Goal State Found");
				moves = Node.getMovesTaken(expanded);
				depth = expanded.depth;
				break;				
				
			}
			
			//get the children nodes and add them to the queue
			
			legalMoves.getMoves(expanded, expanded.state);			
			for (Node child : legalMoves.getChildren()) {
				queue.add(child);

			}
		}

		//on completion, print out the depth and the number of nodes expanded, along with the list of moves
		
		System.out.println("\n------[ BFS COMPLETE ]----------------\n\nPass:  " + (moves == null ? "False" : "True") + "\nNodes Expanded: " + count +"\n" + "Depth:  " + depth + "\n");
		if (moves != null) {
			
			System.out.println("Moves From Start To Goal:\n");
						
			for(Move move : moves) {
				
				System.out.println(move.toString());
				
			}			
			System.out.println();			
		}
	}
}
