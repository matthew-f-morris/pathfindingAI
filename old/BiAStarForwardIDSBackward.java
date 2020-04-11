package old;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class BiAStarForwardIDSBackward {

	//same as the other two bidirectional classes, but has the A* searching forward from the the start
	//and the IDS search searching from the goal state
	
	static ArrayChecker checker = new ArrayChecker(); 
	
	public static ArrayList<Move> search(Node startNode, Node goalNode){
		
		ArrayList<Move> moves = null;
		costCalculator ccalc = new costCalculator();
		Comparator<Node> comparator = new costComparator();		
		LegalMoves legalMoves = new LegalMoves();
		
		PriorityQueue<Node> forward = new PriorityQueue<Node>(1, comparator);	
		Stack<Node> backward = new Stack<Node>();		
				
		backward.add(goalNode);
		forward.add(startNode);
		
		int depth = 0;
		int count = 0;
		
		while((!backward.isEmpty()) && (!forward.isEmpty())){
			
			Node expandedF = forward.poll();
			count++;
			System.out.println(String.format("Nodes Expanded:  " + count + "  Depth:  " + expandedF.depth));
			
			if (checker.check(goalNode.state, expandedF.state) || containsB(backward, expandedF)) {
				
				moves = Node.getMovesTaken(expandedF);
				depth = expandedF.depth;
				break;				
				
			}
			
			legalMoves.getMoves(expandedF, expandedF.state);
			for(Node child : legalMoves.getChildren()){	
				
				child.cost = ccalc.calculateCost(child.state, goalNode.state, child);
				forward.add(child);
			
			}				
			
			while(moves == null) {
				
				moves = DFS.search(goalNode, startNode.state, depth);			
				depth++;
				count += DFS.count;
				
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
	
	public static boolean containsA(PriorityQueue<Node> queue, Node parent) {
		
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
