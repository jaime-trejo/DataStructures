/* Name:Jaime Trejo
 * Date:4/11/14
 * 			This class will will create the maze I want to build by making an object.
 * 
 * 			The way I tried to build this maze is how maze.jpg image look like which is in this project folder.
 * 
 */

package GraphPackage;
import ADTPackage.*;

public class Maze
{
	public static void main(String[] args)
	{

		GraphInterface<String> maze= new DirectedGraph<String>();
		
		System.out.println("Is the maze empty? ");
		System.out.println("------------------");
		System.out.println(maze.isEmpty());
		
		//adds the following vertices
		maze.addVertex("Start");
		maze.addVertex("B");
		maze.addVertex("C");
		maze.addVertex("D");
		maze.addVertex("E");
		maze.addVertex("F");
		maze.addVertex("G");
		maze.addVertex("H");
		maze.addVertex("I");
		maze.addVertex("J");
		maze.addVertex("K");
		maze.addVertex("L");
		maze.addVertex("M");
		maze.addVertex("N");
		maze.addVertex("O");
		maze.addVertex("P");
		maze.addVertex("Q");
		maze.addVertex("R");
		maze.addVertex("S");
		maze.addVertex("T");
		maze.addVertex("Exit");
		
		
		//gets the count of vertices after adding 21 vertices and tests if it's empty
		System.out.println("\nIs the maze empty after adding 21 entries? ");
		System.out.println("-------------------------------------------");
		System.out.println(maze.isEmpty());
		
		//displays the count of vertices
		System.out.println("\nThe count of vertices in the maze are: " );
		System.out.println("----------------------------------------");
		System.out.println(maze.getNumberOfVertices());
		
		// add edges with weights
		maze.addEdge("Start", "B", 4);
		maze.addEdge("B", "C", 1);
		maze.addEdge("B", "D", 8);
		maze.addEdge("D", "E", 3);
		maze.addEdge("E", "F", 4);
		maze.addEdge("F", "G", 5);
		maze.addEdge("G", "H", 7);
		maze.addEdge("F", "I", 3);
		maze.addEdge("E", "J", 6);
		maze.addEdge("J", "K", 3);
		maze.addEdge("K", "L", 3);
		maze.addEdge("L", "M", 5);
		maze.addEdge("M", "N", 4);
		maze.addEdge("N", "O", 3);
		maze.addEdge("N", "P", 3);
		maze.addEdge("P", "Q", 3);
		maze.addEdge("Q", "R", 3);
		maze.addEdge("Q", "M", 3);
		maze.addEdge("K", "S", 3);
		maze.addEdge("S", "T", 1);
		maze.addEdge("S", "Exit", 4);
		
		// will count the number ofEdges after doing 21 edges
		System.out.println("\nNumber of Edges: ");
		System.out.println("----------------");
		System.out.println(maze.getNumberOfEdges());
		
		//will output the shortest path
		System.out.println("\nThe shortest path from Start to Exit is:");
		System.out.println("-----------------------------------------");
		StackInterface<String> path = new LinkedStack<String>();
		
		int pathLength = maze.getShortestPath("Start", "Exit", path);
		
		System.out.println("Path length(Number of Edges): " + pathLength + "\nPasses through the following vertices:");
		
		while (!path.isEmpty())
		{
			System.out.print(path.pop() + " ");
		}
		System.out.println();
		
		
		//will output the breath first traversal
		System.out.println("\nBreath First Traversal Starting from (Start):");
		System.out.println("---------------------------------------------");
		
		QueueInterface<String> breadthTraversal = maze.getBreadthFirstTraversal("Start");
		
		while (!breadthTraversal.isEmpty())
		{
			System.out.print(breadthTraversal.dequeue() + " ");
		}
		System.out.println();
		
		
		/*//will output the depth first traversal
		System.out.println("\nDepth First Traversal Starting from (Start):");
		System.out.println("---------------------------------------------");
		
		QueueInterface<String> depthTraversal = maze.getDepthFirstTraversal("Start");
		
		while (!depthTraversal.isEmpty())
		{
			System.out.print(depthTraversal.dequeue() + " ");
		}
		System.out.println();*/
		
	}

}
