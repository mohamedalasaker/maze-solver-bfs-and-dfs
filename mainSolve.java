package mazeAISolver;

import java.util.*;

public class mainSolve {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Character, List<Character>> stateSpace = new HashMap<>();
		
//		stateSpace.put('A',(List<Character>) Arrays.asList('B','K'));
//		stateSpace.put('B',(List<Character>) Arrays.asList('A','I','R'));
//		stateSpace.put('I',(List<Character>) Arrays.asList('B'));
//		stateSpace.put('R',(List<Character>) Arrays.asList('B'));
//		stateSpace.put('K',(List<Character>) Arrays.asList('A','S','T'));
//		stateSpace.put('S',(List<Character>) Arrays.asList('K','N'));
//		stateSpace.put('T',(List<Character>) Arrays.asList('D','K'));
//		stateSpace.put('D',(List<Character>) Arrays.asList('N','T'));
//		stateSpace.put('N',(List<Character>) Arrays.asList('D'));
//		
		stateSpace.put('A',(List<Character>) Arrays.asList('B','K'));
		stateSpace.put('B',(List<Character>) Arrays.asList('A','I','R'));
		stateSpace.put('I',(List<Character>) Arrays.asList('B'));
		stateSpace.put('R',(List<Character>) Arrays.asList('B'));
		stateSpace.put('K',(List<Character>) Arrays.asList('A','S','T'));
		stateSpace.put('S',(List<Character>) Arrays.asList('K','N'));
		stateSpace.put('T',(List<Character>) Arrays.asList('D','K'));
		stateSpace.put('D',(List<Character>) Arrays.asList('N','T'));
		stateSpace.put('N',(List<Character>) Arrays.asList('D'));
		
		System.out.println("Start bfs search");
		BFS bfs = new BFS('A', 'N', stateSpace);
		System.out.println("================================");
		System.out.println("Start dfs search");
		DFS dfs = new DFS('A','N',stateSpace);
	}

}
