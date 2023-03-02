package mazeAISolver;

import java.util.*;

public class DFS {
	
	ArrayList<Character> visited;
	int stepCost;
	
	public DFS(Character initial,Character goal , HashMap<Character, List<Character>> stateSpace ) {
		stepCost = 0;
		visited = new ArrayList<>();
		Node initialNode = new Node(initial, null,stateSpace);
		visited.add(initial);

		String s = search(initialNode,goal);

		if(s.equals("")) {
			System.out.println("no solution with dfs");
		}else {
			System.out.println(s);
		}
	}
	
	public String search(Node next,Character goal) {
		if(next.isSol(goal)) {
			return "solution is found in " + stepCost +" steps\n"+next.getSol();
		}
		ArrayList<Node> neighbors = next.expand();
		for(Node c : neighbors) {
			if(!visited.contains(c.getState())) {
				stepCost++;
				visited.add(c.getState());	
				String s = search(c, goal);
				if(s != "") {
					return s;
				}
			}
		}
		
		return "";
	}
}
