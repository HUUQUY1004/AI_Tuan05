package lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Greedy implements IPuzzleAlgo{
	public Node execute(Puzzle model) {
		PriorityQueue<Node> frontier = new PriorityQueue<>(PuzzleUtils.HeuristicComparatorByH);
		List<Node> explore = new ArrayList<>();
		frontier.add(model.getInitialState());
		int i = 0;
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			explore.add(current);
			System.out.println("num step : " + i++);
			System.out.println("H :" + current.getH() + " ");
			System.out.println("G :" + current.getG());
			System.out.println(current);
			if (current.getH() == 0) {
				return current;
			} else {
				List<Node> children = model.getSuccessors(current);
				for (Node child : children) {
					if (!frontier.contains(child) && !explore.contains(child)) {
						frontier.add(child);
						child.setG(current.getG() + 1);
						child.setH(model.computeH1(child));
					}
				}
			}
		}
		return null;
	}

}
