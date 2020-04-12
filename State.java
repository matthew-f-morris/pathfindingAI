
import java.util.ArrayList;
import java.util.Collections;

public class State {

	int[][] internalState;			//state of state space
	State parentNode;		//node that generated this node
	Move move;				//operator applied to generate this node
	int depth = 0;				//no. of nodes from root
	int cost = 0;				//cost only used for A* heuristic
	
	public State(int[][] startState) {
		
		//constructor for constructing root node (starting board state)
		
		this.internalState = startState;
		this.parentNode = null;
		this.move = Move.NONE;		
	}
	
	public State(int[][] state, State parent, Move move) {
		
		//constructor for constructing children given a parent node and a move
		
		this.internalState = state;
		this.parentNode = parent;
		this.depth = parentNode.depth + 1;
		this.move = move;
		
	}
	
	public static ArrayList<Move> getMovesTaken(State solution) {
		
		//method used to get list of all moves taken from start to goal state
		//when a solution node is found
		// moves are reversed to allow printing in the correct order
		
		ArrayList<Move> movesTaken = new ArrayList<Move>();
		State current = solution;
		while (current != null) {
			
			if (current.move != Move.NONE) {
				
				movesTaken.add(current.move);				
			}			
			current = current.parentNode;			
		}		

		Collections.reverse(movesTaken);
		return movesTaken;		
	}		
}
