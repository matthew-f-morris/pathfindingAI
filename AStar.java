import java.util.ArrayList;
import java.util.PriorityQueue;

public class AStar {

	public static void search(State startState, State goalState, int print){

		ArrayList<Move> moves = null;	
        PriorityQueue<State> queue = new PriorityQueue<State>();        
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
				break;
            }
            
            count++;
            
            State[] children = ChildMaker.generate(expanded);
			for(State child : children){					
				child.cost = costCalculator.calc(child, false);
				queue.add(child);			
			}						
		}
		
		System.out.println("\n------[ A* COMPLETE ]-----------------\n");
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



































//https://www.codeproject.com/Articles/203828/AI-Simple-Implementation-of-Uninformed-Search-Stra
//	http://web.mit.edu/eranki/www/tutorials/search/
//		
//		http://theory.stanford.edu/~amitp/GameProgramming/Heuristics.html#S7
//			
//			
//		manhatten(M,P) = |Mx - Px| + |My - Py|