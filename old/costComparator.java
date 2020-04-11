package old;

import java.util.Comparator;

class costComparator implements Comparator<Node>{

		//comparator used by priorityQueue in A* search (compares two nodes by cost)
	
		public int compare(Node first, Node second) {
			
			return Integer.compare(first.cost, second.cost);
	}
}