package old;

import java.util.ArrayList;

public class LegalMoves {

	//class that takes in a node, calculates all the possible board states from the parent nodes current state
																		
	int[][] state;
	int agentRow;
	int agentCol;
	Node parent;
	
	//list with nodes of newly created children
	//arraylist returned via getChildren() method
	
	ArrayList<Node> validMoves = new ArrayList<Node>();					
	
	public ArrayList<Node> getChildren(){
		
		return validMoves;
		
	}
	
	public void getMoves(Node parent, int[][] state) {
		
		//method that calculates all the possible new positions of the agent from the agents current position, used to generate children
		//gets the coordinate of the agent and decides on the legal moves
																		
		this.parent = parent;		
		this.state = state;				
		int size = state.length-1;
		
		validMoves.clear();	
		
		//gets the current position of the agent from the parent 
		getAgent();														
		
		if(agentRow == 0 && agentCol == 0) {
		
			moveDown();
			moveRight();	
			return;
		
		}else if(agentRow == size && agentCol == size) {
			
			moveUp();
			moveLeft();
			return;
			
		}else if(agentRow == size && agentCol == 0) {
			
			moveUp();
			moveRight();
			return;
			
		}else if(agentRow == 0 && agentCol == size) {
			
			moveLeft();
			moveDown();
			return;
			
		}else if(agentCol == 0) {

			moveUp();
			moveDown();
			moveRight();
			return;
			
		}else if(agentCol == size) {
			
			moveUp();
			moveDown();
			moveLeft();
			return;
			
		}else if(agentRow == 0) {
			
			moveLeft();
			moveRight();
			moveDown();
			return;
						
		}else if(agentRow == size) {
			
			moveLeft();
			moveRight();
			moveUp();
			return;
			
		} else {
			
			moveUp();
			moveDown();
			moveLeft();
			moveRight();
			return;
			
		}
	}			
	
	public void moveDown(){
		//creates the new board state given the specified move, creates the new child with all the relevant information
		//Separate methods for moving up, down, left, and right
		
		int[][] addD = copy(state);
		int swap = state[agentRow+1][agentCol];
		addD[agentRow+1][agentCol] = -1;
		addD[agentRow][agentCol] = swap;					
		newChildNode(addD, parent, Move.DOWN );
	}
	
	public void moveLeft(){

		int[][] addL = copy(state);
		int swap = state[agentRow][agentCol-1];
		addL[agentRow][agentCol-1] = -1;
		addL[agentRow][agentCol] = swap;				
		newChildNode(addL, parent, Move.LEFT );	
	}
	
	public void moveRight(){
				
		int[][] addR = copy(state);
		int swap = state[agentRow][agentCol+1];
		addR[agentRow][agentCol+1] = -1;
		addR[agentRow][agentCol] = swap;				
		newChildNode(addR, parent, Move.RIGHT );
	}
	
	public  void moveUp(){
		
		int[][] addU = copy(state);
		int swap = state[agentRow-1][agentCol];
		addU[agentRow-1][agentCol] = -1;
		addU[agentRow][agentCol] = swap;				
		newChildNode(addU, parent, Move.UP );		
	}	
	
	public int[][] copy(int[][] array){
		
		//method to make a copy of an array (copy is modified version of parent state used to set the children state)
		
		int [][] copy = new int[array.length][];
		for(int i = 0; i < array.length; i++)
		   copy[i] = array[i].clone();
		
		return copy;		
	}	
	
	public void getAgent() {
		
		//searches through array for agent, when it finds it, saves the row and column the agent is in
		
		for(int row = 0; row < state.length; row++){
			for(int col = 0; col < state[row].length; col++){

				if(state[row][col] == -1) {
					
					agentRow = row;
					agentCol = col;
					break;	
				}
			}
		}
	}
	
	public void newChildNode(int[][] state, Node parent, Move move ) {
	
		//method that stores the new child in the array of children nodes
		
		Node child = new Node(state, parent, move);
		validMoves.add(child);	
	}
}
