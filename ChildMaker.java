import java.util.ArrayList;
import java.util.List;

public class ChildMaker {

    public static State[] genChildren(State parent, State state){
        
        int[] pos = getAgent(state);
        int row = pos[0];
        int col = pos[1];   
        int size = state.internalState.length - 1;
        
        if(row == 0 && col == 0)        
            return getChildren(Move.DOWN, Move.RIGHT);
		
		else if(row == size && col == size)            
            return getChildren(Move.UP, Move.LEFT);
			
		else if(row == size && col == 0)            
            return getChildren(Move.UP, Move.RIGHT);
			
		else if(row == 0 && col == size)
            return getChildren(Move.LEFT, Move.DOWN);

		else if(col == 0)
            return getChildren(Move.UP, Move.DOWN, Move.RIGHT);

		else if(col == size)			
			return getChildren(Move.UP, Move.DOWN, Move.LEFT);
			
		else if(row == 0)
			return getChildren(Move.LEFT, Move.DOWN, Move.RIGHT);
						
		else if(row == size)			
			return getChildren(Move.UP, Move.LEFT, Move.RIGHT);
			
		else 			
			return getChildren(Move.UP, Move.DOWN, Move.LEFT, Move.RIGHT);
    }

    private static int[] getAgent(State state) {
        
        int[][] intState = state.internalState;
        int[] pos = new int[2];

		for(int row = 0; row < intState.length; row++){
			for(int col = 0; col < intState[row].length; col++){
				if(intState[row][col] == -1) {					
					pos[0] = row;
					pos[1] = col;
					break;
				}
			}
        }

        return pos;
    }

    private static State[] getChildren(Move... moves){

        List<State> children = new ArrayList<State>();
        return null;
    }
}