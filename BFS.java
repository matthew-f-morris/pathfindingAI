
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	public static void search(State startNode, State goalState, int print) {
		
		ArrayList<Move> moves = null;	
        Queue<State> queue = new LinkedList<State>(); // stores nodes to be queued
        int depth = 0, count = 0;
		
        System.out.println("Starting BFS Search...\n");

		queue.add(startNode);
		
		while (!queue.isEmpty()) {
			
			State expanded = queue.poll();
			
            if(print != 0 && count % print == 0)
                System.out.println(String.format("Nodes Expanded:  " + count + "  Depth:  " + expanded.depth));			
            
            if(ArrayTools.checkSame(expanded.internalState, goalState.internalState)){	
				
				System.out.println("Goal State Found");
				moves = State.getMovesTaken(expanded);
				depth = expanded.depth;
				
            } else {
            
				count++;
							
				State[] children = ChildMaker.generate(expanded);
				for(State child : children)				
					queue.add(child);	
			}
		}
		
		System.out.println("\n------[ BFS COMPLETE ]-----------------\n");
        System.out.println("Pass:\t\t" + (moves == null ? "False" : "True"));
        System.out.println("Nodes Searched:\t" + count);
        System.out.println("Depth:\t\t" + depth + "\n");
        
        if (moves != null) {
			
			System.out.println("Moves From Start To Goal:\n");
			
			for(Move move : moves)				
				System.out.println("\t" + move);				
			System.out.println();		
		}	
	}
}
