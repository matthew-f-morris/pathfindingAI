package old;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		int[][] startState = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{1,2,3,-1}};
		int[][] goalState = {{0,0,0,0},{0,1,0,0},{0,2,0,0},{0,3,0,0}};
		
		Node start = new Node(startState);

		// System.out.println("---------------\nStarting DFS...\n----------------\n");
		// DFS.search(start, goalState);
		// System.out.println("Start State:");
		// print(startState);
		// System.out.println("Goal State:");
		// print(goalState);
	
		// System.out.println("\n\n---------------\nStarting BFS...\n---------------\n");
		// BFS.search(start, goalState);
		// System.out.println("Start State:");
		// print(startState);
		// System.out.println("Goal State:");
		// print(goalState);
		
		// System.out.println("\n\n---------------\nStarting IDS...\n---------------\n");
		// IDS.search(start, goalState);
		// System.out.println("Start State:");
		// print(startState);
		// System.out.println("Goal State:");
		// print(goalState);
		
		System.out.println("\n\n---------------\nStarting A*...\n---------------\n");
		AStar.search(start, goalState);
		// System.out.println("Start State:");
		// print(startState);
		// System.out.println("Goal State:");
		// print(goalState);
			
	}
	
	public void test() {
		
		ArrayList<int[][]> states = new ArrayList<int[][]>();
		
		int[][] startState18 = {{0,0,0,-1},{0,0,0,0},{0,0,0,0},{1,0,2,3}};
		int[][] startState17 = {{0,0,-1,0},{0,0,0,0},{0,0,0,0},{1,0,2,3}};
		int[][] startState16 = {{0,-1,0,0},{0,0,0,0},{0,0,0,0},{1,0,2,3}};
		int[][] startState15 = {{0,0,0,0},{0,-1,0,0},{0,0,0,0},{1,0,2,3}};
		int[][] startState14 = {{0,0,0,0},{-1,0,0,0},{0,0,0,0},{1,0,2,3}};
		int[][] startState13 = {{0,0,0,0},{0,0,0,0},{-1,0,0,0},{1,0,2,3}};
		int[][] startState12 = {{0,0,0,0},{0,0,0,0},{1,0,0,0},{-1,0,2,3}};
		int[][] startState11 = {{0,0,0,0},{0,0,0,0},{1,0,0,0},{0,-1,2,3}};
		int[][] startState10 = {{0,0,0,0},{0,0,0,0},{1,0,0,0},{0,2,-1,3}};
		int[][] startState9 = {{0,0,0,0},{0,0,0,0},{1,0,0,0},{0,2,3,-1}};
		int[][] startState8 = {{0,0,0,0},{0,0,0,0},{1,0,0,-1},{0,2,3,0}};
		int[][] startState7 = {{0,0,0,0},{0,0,0,0},{1,0,-1,0},{0,2,3,0}};
		int[][] startState6 = {{0,0,0,0},{0,0,0,0},{1,-1,0,0},{0,2,3,0}};
		int[][] startState5 = {{0,0,0,0},{0,0,0,0},{-1,1,0,0},{0,2,3,0}};
		int[][] startState4 = {{0,0,0,0},{-1,0,0,0},{0,1,0,0},{0,2,3,0}};
		int[][] startState3 = {{0,0,0,0},{0,-1,0,0},{0,1,0,0},{0,2,3,0}};
		int[][] startState2 = {{0,0,0,0},{0,1,0,0},{0,-1,0,0},{0,2,3,0}};
		int[][] startState1 = {{0,0,0,0},{0,1,0,0},{0,2,0,0},{0,-1,3,0}};
				
		states.add(startState1);
		states.add(startState2);
		states.add(startState3);
		states.add(startState4);
		states.add(startState5);
		states.add(startState6);
		states.add(startState7);
		states.add(startState8);
		states.add(startState9);
		states.add(startState10);
		states.add(startState11);
		states.add(startState12);
		states.add(startState13);
		states.add(startState14);
		states.add(startState15);
		states.add(startState16);
		states.add(startState17);
		states.add(startState18);		
		
		int[][] goalState = {{0,0,0,0},{0,1,0,0},{0,2,0,0},{0,3,0,0}};
		
		for(int[][] state : states) {
			
			Node start = new Node(state);
			DFS.search(start, goalState);
			
		}		
		
		for(int[][] state : states) {
			
			Node start = new Node(state);
			BFS.search(start, goalState);
			
		}		

		for(int[][] state : states) {
	
			Node start = new Node(state);
			IDS.search(start, goalState);
	
		}
		
		
		for(int[][] state : states) {
			
			Node start = new Node(state);
			 AStar.search(start, goalState);
			
		}	
	}
	
	public static void print(int[][] matrix) {
		System.out.println();
		
		for (int i = 0; i < matrix.length; i++) {
		    for (int j = 0; j < matrix[i].length; j++) {
		        System.out.print(matrix[i][j] + " ");
		    }		    
		    System.out.println();
		}		
		System.out.println();		
	}	
}


























































//Iterative_Deepening_Search ids = new Iterative_Deepening_Search();
//boolean passIDS = ids.search(start, goalState);
//		
//System.out.println("\n------[ IDS COMPLETE ]------\n\nPass:   " + passIDS);		//+ "\nDepth:  " + ids.parentSolution.depth + "\nStart State: \n"
//ids.print(startState);
//System.out.println("Final State:\n");
//ids.print(ids.parentSolution.state);

//A_Star astar = new A_Star();
//boolean passAStar = astar.search(start, goalState);
//System.out.println("\n------[ A* COMPLETE ]------\n\nPass:   " + passAStar + "\nDepth:  " + astar.parentSolution.depth + "\nStart State: \n");		

//ArrayList<Move> movesTaken = new ArrayList<Move>(bfsSoln.getMovesTaken(bfsSoln));
//
//System.out.println("Moves Taken:\n");
//for(Move move : movesTaken) {			
//	System.out.println(move);			
//}		