package old;

import java.awt.Point;

public class costCalculator {
		
	int[][] state;
	int[][] goal;
	
	public int calculateCost(int[][] state, int[][] goal, Node node){
		
		//calculates the heuristic (sum of Manhattan distances of blocks from goal positions)
		
		this.state = state;
		this.goal = goal;
		
		int one = getManhatten(getState(1), getGoal(1));
		int two = getManhatten(getState(2), getGoal(2));
		int three = getManhatten(getState(3), getGoal(3));
				
		return one + two + three + node.depth;
		
	}
	
	public int getManhatten(Point pointx, Point pointy){	
		
		return Math.abs(pointx.x - pointy.x) + Math.abs(pointx.y - pointy.y);
		
	}	

	//returns the coordinates of the specified block in the 2d array of the goal state
	
	public Point getGoal(int n) {

		for (int row = 0; row < goal.length; row++) {
			for (int col = 0; col < goal[row].length; col++) {
				if (goal[row][col] == n){
					return new Point(row,col);
				}
			}
		}
		
		return null;
		
	}
	
	//returns the coordinates of the specified block in the 2d array of the current state
	
	public Point getState(int n) {

		for (int row = 0; row < state.length; row++) {
			for (int col = 0; col < state[row].length; col++) {
				if (state[row][col] == n){
					return new Point(row,col);
				}
			}
		}
		
		return null;
		
	}
	
	//allows an array to be copied
	
	public int[][] copy(int[][] array){

		int [][] copy = new int[array.length][];
		for(int i = 0; i < array.length; i++)
		   copy[i] = array[i].clone();		
		return copy;				
	}
}
