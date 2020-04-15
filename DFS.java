import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DFS {
	
	public static List<Move> finalMoves;

	public static boolean search(State startNode, State goalState, int print, int limit) {
		
		List<Move> moves = null;
	    Stack<State> stack = new Stack<State>();
        int depth = 0, count = 0;
		
        System.out.println("Starting DFS Search with limit " + limit + "...\n");

		stack.push(startNode);
			
		while(!stack.isEmpty()) {
			
			State expanded = stack.pop();
            
            if(print != 0 && count % print == 0)
                System.out.println(String.format("Nodes Expanded:  " + count + "  Depth:  " + expanded.depth));			
        		
            if(ArrayTools.checkSame(expanded.internalState, goalState.internalState)){	
				
				System.out.println("Goal State Found");
                moves = State.getMovesTaken(expanded);
				depth = expanded.depth;
				
				System.out.println("\n------[ DFS COMPLETE ]-----------------\n");
				System.out.println("Pass:\t\t" + (moves == null ? "False" : "True"));
				System.out.println("Nodes Searched:\t" + count);
				System.out.println("Depth:\t\t" + depth + "\n");
				
				if (moves != null) {
					
					System.out.println("Moves From Start To Goal:\n");
					
					for(Move move : moves)				
						System.out.println("\t" + move);				
					System.out.println();		
				}	

				finalMoves = moves;
				return true;
				
			} else if (expanded.depth != limit) {
				
				count++;

                State[] children = ChildMaker.generate(expanded);
                List<State> childrenList = Arrays.asList(children);
		        Collections.shuffle(childrenList);
		        childrenList.toArray(children);
				
				for (State child : children)
					stack.add(child);

			} else if (expanded.depth == limit){

				return false;
			}
		}

		return false;
	}	
}
