package mazeAISolver;
import java.util.*;
public class Node {
	private HashMap<Character, List<Character>> stateSpace;
	private Character state;
	private Node parent;
	
	
	public Node(Character s , Node p) {
		state = s;
		parent = p;
	}
	public Node(Character s , Node p , HashMap<Character, List<Character>> g) {
		state = s;
		parent = p;
		stateSpace = g;
	}
	
	public Node getParent() {
		return parent;
	}
	public Character getState() {
		return state;
	}
	
	public boolean equals(Object node) {
		return ((Node)node).state == state;
	}
	public boolean isSol(Character g) {
		return state == g;
	}
	
	public ArrayList<Node> expand(){
		ArrayList<Node> children = new ArrayList<>();
		List<Character> neighbors = stateSpace.get(this.state);
		for(Character child : neighbors){
			children.add(new Node(child, this, stateSpace));
		}
		return children;
	}
	
	
	
	public String getSol(){
		ArrayList<Character> path = new ArrayList<>();
		String s = "";
		Node temp = this;
		while(temp.parent != null) {
			path.add(0,temp.state); // insert at first
			temp = temp.parent;
		}
		path.add(0,temp.state);
		for(int i = 0 ; i < path.size() ; i++) {
			s += i != path.size() - 1 ? (path.get(i) + "->") : path.get(i); 
		}
		return s;
	}
}
