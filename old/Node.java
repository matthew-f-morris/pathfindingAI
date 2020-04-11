package old;

import java.util.ArrayList;
import java.util.Collections;

public class Node {

	int[][] state;			//state of state space
	Node parentNode;		//node that generated this node
	Move move;				//operator applied to generate this node
	int depth;				//no. of nodes from root
	int cost;				//cost only used for A* heuristic
	
	public Node(int[][] state) {
		
		//constructor for constructing root node (starting board state)
		
		this.state = state;
		this.parentNode = null;
		this.depth = 0;
		this.move = Move.START_NODE;
		this.cost = 0;
		
	}
	
	public Node(int[][] state, Node parent, Move move) {
		
		//constructor for constructing children given a parent node and a move
		
		this.state = state;
		this.parentNode = parent;
		this.depth = parentNode.depth+1;
		this.move = move;
		
	}
	
	public static ArrayList<Move> getMovesTaken(Node solution) {
		
		//method used to get list of all moves taken from start to goal state
		//when a solution node is found
		// moves are reversed to allow printing in the correct order
		
		ArrayList<Move> movesTaken = new ArrayList<Move>();
		Node current = solution;
		while (current != null) {
			
			if (current.move != Move.START_NODE) {
				
				movesTaken.add(current.move);				
			}			
			current = current.parentNode;			
		}		
		Collections.reverse(movesTaken);
		return movesTaken;		
	}		
}
