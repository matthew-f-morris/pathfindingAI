package old;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AStar {

	public static void search(Node startNode, int[][] goalState){
		
		//uses a priority queue to order the nodes by the heuristic (lowest cost at the front of the queue)
		
		ArrayList<Move> moves = null;
		ArrayChecker checker = new ArrayChecker();
		costCalculator ccalc = new costCalculator();
		Comparator<Node> comparator = new costComparator();
		LegalMoves legalMoves = new LegalMoves();		
		PriorityQueue<Node> queue = new PriorityQueue<Node>(1, comparator);
		
		int depth = 0;
		int count = 0;
		
		queue.add(startNode);
				
		while(!queue.isEmpty()){
			
			Node expanded = queue.poll();
			count++;
			System.out.println(String.format("Nodes Expanded:  " + count + "  Depth:  " + expanded.depth));
			
			//check if the goal state is found
			
			if(checker.check(expanded.state, goalState)) {
				
				//return the moves taken to get to the goal state
				
				System.out.println("Goal State Found");
				moves = Node.getMovesTaken(expanded);
				depth = expanded.depth;
				break;
				
			}
			
			//get the children nodes and add them to the queue
			
			legalMoves.getMoves(expanded, expanded.state);
			for(Node child : legalMoves.getChildren()){	
				
				child.cost = ccalc.calculateCost(child.state, goalState, child);
				queue.add(child);
			
			}						
		}
		
		//on completion, print out the depth and the number of nodes expanded, along with the list of moves
		
		System.out.println("\n------[ A* COMPLETE ]-----------------\n\nPass:  " + (moves == null ? "False" : "True") +  "\nNodes Expanded:  " + count + "\n"  + "Depth:  " + depth + "\n");
		if (moves != null) {
			
			System.out.println("Moves From Start To Goal:\n");
			
			for(Move move : moves) {
				
				System.out.println(move.toString());
				
			}			
			System.out.println();		
		}	
	}	
}



































//https://www.codeproject.com/Articles/203828/AI-Simple-Implementation-of-Uninformed-Search-Stra
//	http://web.mit.edu/eranki/www/tutorials/search/
//		
//		http://theory.stanford.edu/~amitp/GameProgramming/Heuristics.html#S7
//			
//			
//		manhatten(M,P) = |Mx - Px| + |My - Py|