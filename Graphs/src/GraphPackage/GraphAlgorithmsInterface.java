/*
 * Name:Jaime Trejo
 * Date:4/8/14
 * 		I had to create a package that contained multiple classes that would be imported into this interface.
 * 		This interface will consist of methods that process an existing graph.
 */

package GraphPackage;
import ADTPackage.*; // classes that implement various ADTs

public interface GraphAlgorithmsInterface<T>
{
	//Performs a breadth-first traversal of a graph. Origin an object that labels the origin vertex of the
	//traversal. Returns a queue of labels of the vertices in the traversal, with the label of the origin vertex
	//at the queue's front 
	public QueueInterface<T> getBreadthFirstTraversal(T origin);
	
	//Performs a depth-first traversal of a graph. Origin is an object that labels the origin vertex of the
	//traversal. Returns a queue of labels of the vertices in the traversal, with
	//the label of the origin vertex at the queue's front 
	public QueueInterface<T> getDepthFirstTraversal(T origin);
	
	//Performs a topological sort of the vertices in a graph without cycles.
	//returns a stack of vertex labels in topological order, beginning with the stack's top 
	public StackInterface<T> getTopologicalOrder();
	
	//Finds the path between two given vertices that has the shortest length.
	//begin an object that labels the path's origin vertex
	//end an object that labels the path's destination vertex
	//path a stack of labels that is empty initially;at the completion of the method, this stack contains
	//the labels of the vertices along the shortest path;
	//the label of the origin vertex is at the top, and the label of the destination vertex is at the bottom
	//returns the length of the shortest path 
	public int getShortestPath(T begin, T end, StackInterface<T> path);
	
	//Finds the least-cost path between two given vertices.
	//begin an object that labels the path's origin vertex
	//end an object that labels the path's destination vertex
	//path a stack of labels that is empty initially; at the completion of the method, this stack contains the 
	//labels of the vertices along the cheapest path;the label of the origin vertex is at the top, and 
	//the label of the destination vertex is at the bottom
	//returns the cost of the cheapest path 
	public double getCheapestPath(T begin, T end, StackInterface<T> path);
}
