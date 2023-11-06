package lab5;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Astar implements IPuzzleAlgo {

	@Override
	public Node execute(Puzzle model) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> queue = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByF);
		Set<Node> visited = new HashSet<Node>();
		queue.add(model.getInitialState());
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			if (current.getH() ==0 ) {
				
				return current;
			} else {
				visited.add(current);
//				queue.add(current);
				for(Node node : model.getSuccessors(current)) {
					if(!queue.contains(node) && !visited.contains(node)) {
						node.setG(current.getG() +1);
						visited.add(node);
						queue.add(node);
					}
					else if(queue.contains(node) && node.getG() > current.getG() + node.getG()) {
						node.setG(current.getG() + node.getG());
					}
				}

			}
		}
		return null;
	}
	
	

}
