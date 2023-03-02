package mazeAISolver;

import java.util.*;

public class BFS {
	private ArrayList<Node> frontier;
	private ArrayList<Node> visited;
	private int stepsCost;
	
	public BFS(Character initial,Character goal , HashMap<Character, List<Character>> stateSpace ) {
		frontier = new ArrayList<>();
		visited = new ArrayList<>();
		stepsCost = 0;
		Node initialNode = new Node(initial, null,stateSpace);
		frontier.add(initialNode);
		if(initialNode.isSol(goal))
			System.out.println("Already in goal state");
		else {
			System.out.println(search(goal));;
		}
	}
	
	public String search(Character goal) {
		
		Node next = null;
		while(frontier.size() != 0) {
			next = frontier.remove(0);
			stepsCost++;
			ArrayList<Node> neighbors = next.expand();
			for(Node n : neighbors){
				if(n.isSol(goal)) {
					return "the solution was found in " + (stepsCost - 1) +" steps" +"\n" + n.getSol(); 
				}
				boolean f = false;
				for(Node n1 : visited) {

					if(n.getState() == n1.getState()) {
						f = true;
						break;
					}
				}
				for(Node n1 : frontier) {
					if(n.getState() == n1.getState()) {
						f = true;
						break;
					}
				}
				if(!f) {
					frontier.add(n);
				}
				f = false;
			}
			visited.add(next);			
			
		}
		return "no solutuion found in" + stepsCost + "steps" ;
	}
}
