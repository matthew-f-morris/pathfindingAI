import java.util.ArrayList;
import java.util.List;

public class CostCalculator {
		
	private int[][] goal;
	private int[] ints;
    
    public CostCalculator(int[][] goal){       
		
		this.goal = goal;
		List<Integer> temp = new ArrayList<Integer>();

		for (int row = 0; row < goal.length; row++)
			for (int col = 0; col < goal[row].length; col++)
				if (goal[row][col] > 0)
					temp.add(goal[row][col]);
		
		ints = temp.stream().mapToInt(Integer::intValue).toArray();
    }
	
	public int calc(State state, boolean weight){

		int score = state.depth;
		
		for(int num : ints){
			int[] goalPos = goal(num);
			int[] numPos = num(state.internalState, num);
			score += Math.abs(goalPos[0] - numPos[0]) + Math.abs(goalPos[1] - numPos[1]);
		}
				
		if(weight){
			int[] numPos = num(state.internalState, -1);
			for(int i : this.ints){
				int[] goalPos = goal(i);			
				score += Math.abs(goalPos[0] - numPos[0]) + Math.abs(goalPos[1] - numPos[1]);
			}
		}

		return score;
	}

	//returns the coordinates of the specified block in the 2d array of the goal state
	
	private int[] goal(int n){

		for (int row = 0; row < goal.length; row++)
			for (int col = 0; col < goal[row].length; col++)
				if (goal[row][col] == n)
					return new int[]{row, col};
		
		return null;		
	}
	
	//returns the coordinates of the specified block in the 2d array of the current state
	
	private int[] num(int[][] state, int n){

		for (int row = 0; row < state.length; row++)
			for (int col = 0; col < state[row].length; col++)
				if (state[row][col] == n)
					return new int[]{row, col};
		
		return null;		
	}
}