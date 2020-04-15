import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class AStar {

	public static List<Move> search(State startState, State goalState, int print){

		ArrayList<Move> moves = null;	
        Queue<State> queue = new PriorityQueue<State>();        
        CostCalculator costCalculator = new CostCalculator(goalState.internalState);				
		int depth = 0, count = 0;
		
        System.out.println("Starting AStar Search...\n");

        queue.add(startState);
				
		while(!queue.isEmpty()){
			
			State expanded = queue.poll();

            if(print != 0 && count % print == 0)
                System.out.println(String.format("Nodes Expanded:  " + count + "  Depth:  " + expanded.depth));
						
			if(ArrayTools.checkSame(expanded.internalState, goalState.internalState)) {	
							
				System.out.println("Goal State Found");
				moves = State.getMovesTaken(expanded);
				depth = expanded.depth;
				
				System.out.println("\n------[ A* COMPLETE ]-----------------\n");
				System.out.println("Pass:\t\t" + (moves == null ? "False" : "True"));
				System.out.println("Nodes Searched:\t" + count);
				System.out.println("Depth:\t\t" + depth + "\n");
				
				if (moves != null) {
					
					System.out.println("Moves From Start To Goal:\n");
					
					for(Move move : moves)				
						System.out.println("\t" + move);				
					System.out.println();
					return moves;	
				}	
            }
            
            count++;
            
            State[] children = ChildMaker.generate(expanded);
			for(State child : children){					
				child.cost = costCalculator.calc(child, false);
				queue.add(child);			
			}						
		}

		return null;
	}	
}



































//https://www.codeproject.com/Articles/203828/AI-Simple-Implementation-of-Uninformed-Search-Stra
//	http://web.mit.edu/eranki/www/tutorials/search/
//		
//		http://theory.stanford.edu/~amitp/GameProgramming/Heuristics.html#S7
//			
//			
//		manhatten(M,P) = |Mx - Px| + |My - Py|