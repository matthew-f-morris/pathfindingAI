package old;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Bidirectional {
	
	//Bi-directional search 
	//DFS forward 
	//BFS backwards

	static ArrayChecker checker = new ArrayChecker();
	
	public static ArrayList<Move> search(Node startNode, Node goalNode){
		
		ArrayList<Move> moves = null;		
		LegalMoves legalMoves = new LegalMoves();
		
		Stack<Node> forward = new Stack<Node>();			//DFS forwards from start
		Queue<Node> backward = new LinkedList<Node>();		//BFS backwards from goal
				
		backward.add(goalNode);
		forward.add(startNode);
		
		int depth = 0;
		int count = 0;
		
		while((!backward.isEmpty()) && (!forward.isEmpty())){
			
			Node expandedF = forward.pop();
			count++;
			System.out.println(String.format("Nodes Expanded:  " + count + "  Depth:  " + expandedF.depth));
			
			//check goal state is found, or current state is in the other search (means both searches have met)
			
			if (checker.check(goalNode.state, expandedF.state) || containsA(backward, expandedF)) {
				
				moves = Node.getMovesTaken(expandedF);
				depth = expandedF.depth;
				break;				
				
			}
			
			//generate children and add to stack
			
			legalMoves.getMoves(expandedF, expandedF.state);
			ArrayList<Node> children = legalMoves.getChildren();
			Collections.shuffle(children);
			
			for (Node child : children) {
				
				forward.add(child);

			}
			
			Node expandedB = backward.peek();
			count++;
			System.out.println(String.format("Nodes Expanded:  " + count));
			
			//check goal state is found, or current state is in the other search (means both searches have met)
			
			if (checker.check(startNode.state, expandedB.state) || containsB(forward, expandedB)) {
				
				moves = Node.getMovesTaken(expandedB);
				depth = expandedB.depth;
				break;				
				
			}
			
			//generate children and add to queue
			
			legalMoves.getMoves(expandedB, expandedB.state);			
			for (Node child : legalMoves.getChildren()) {
				
				backward.add(child);

			}			
		}
		
		System.out.println("\n------[ Bi-Directional COMPLETE ]----------------\n\nPass:  " + (moves == null ? "False" : "True") + "\nNodes Expanded: " + count +"\n" + "Depth:  " + depth + "\n");
		if (moves != null) {
			
			System.out.println("Moves From Start To Goal:\n");
				
			for(Move move : moves) {
				
				System.out.println(move.toString());	
				
			}			
			System.out.println();			
		}		
		return moves;		
	}
	
	//checks if a node is in the queue
	
	public static boolean containsA(Queue<Node> queue, Node parent) {
		
		Object[] nodes = new Object[queue.size()];
		nodes = queue.toArray();
		
		for(Object node : nodes) {
			
			Node nodeA = (Node) node;
			
			if(checker.check(nodeA.state, parent.state)) {
				
				return true;				
			}			
		}		
		return false;		
	}	
	
	//checks if a node is in the stack
	
	public static boolean containsB(Stack<Node> queue, Node parent) {
		
		Object[] nodes = new Object[queue.size()];
		nodes = queue.toArray();
		
		for(Object node : nodes) {
			
			Node nodeA = (Node) node;
			
			if(checker.check(nodeA.state, parent.state)) {
				
				return true;				
			}			
		}		
		return false;		
	}		
}
