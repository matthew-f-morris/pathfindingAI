import java.util.ArrayList;
import java.util.List;

public class ChildMaker {

    public static State[] generate(State state){
        
        int[] pos = getAgent(state);
        int row = pos[0];
        int col = pos[1];   
        int size = state.internalState.length - 1;
        
        if(row == 0 && col == 0)        
            return getChildren(state, Move.DOWN, Move.RIGHT);
		
		else if(row == size && col == size)            
            return getChildren(state, Move.UP, Move.LEFT);
			
		else if(row == size && col == 0)            
            return getChildren(state, Move.UP, Move.RIGHT);
			
		else if(row == 0 && col == size)
            return getChildren(state, Move.LEFT, Move.DOWN);

		else if(col == 0)
            return getChildren(state, Move.UP, Move.DOWN, Move.RIGHT);

		else if(col == size)			
			return getChildren(state, Move.UP, Move.DOWN, Move.LEFT);
			
		else if(row == 0)
			return getChildren(state, Move.LEFT, Move.DOWN, Move.RIGHT);
						
		else if(row == size)			
			return getChildren(state, Move.UP, Move.LEFT, Move.RIGHT);
			
		else 			
			return getChildren(state, Move.UP, Move.DOWN, Move.LEFT, Move.RIGHT);
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

    private static State[] getChildren(State state, Move... moves){

        List<State> children = new ArrayList<State>();

        for(Move move : moves)
            children.add(move(state, move));
        
        return children.toArray(new State[children.size()]);
    }

    private static State move(State parent, Move move){

        int[][] next = ArrayTools.copy(parent);
        int[] agent = ChildMaker.getAgent(parent);
        int row = agent[0];
        int col = agent[1];

        switch (move) {
            case UP:
                return new State(moveUp(next, row, col), parent, Move.UP);
            case DOWN:
                return new State(moveDown(next, row, col), parent, Move.DOWN);
            case LEFT:
                return new State(moveLeft(next, row, col), parent, Move.LEFT);
            case RIGHT:
                return new State(moveRight(next, row, col), parent, Move.RIGHT);
            case NONE:
                return null;
            default:
                return null;
        }       
    }

    private static int[][] moveDown(int[][] addD, int row, int col){
		
        int swap = addD[row + 1][col];        
		addD[row + 1 ][col] = -1;
        addD[row][col] = swap;
        return addD;     
	}
	
	private static int[][] moveLeft(int[][] addL, int row, int col){

        int swap = addL[row][col - 1];        
		addL[row][col - 1] = -1;
        addL[row][col] = swap;	
        return addL;					
	}
	
	private static int[][] moveRight(int[][] addR, int row, int col){

        int swap = addR[row][col + 1];        
		addR[row][col + 1] = -1;
        addR[row][col] = swap;		
        return addR;			
	}
	
	private static int[][] moveUp(int[][] addU, int row, int col){

        int swap = addU[row - 1][col];        
		addU[row - 1 ][col] = -1;
        addU[row][col] = swap;		
        return addU;			
    }
    
    public static State[] getStatesFromMoves(State start, List<Move> moves){
        
        List<State> states = new ArrayList<State>();
        states.add(start);

        for(Move move : moves){
            start = move(start, move);  
            states.add(start);  
        }

        return states.toArray(new State[states.size()]);
    } 
}