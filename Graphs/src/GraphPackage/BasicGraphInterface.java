/*
 * Name:Jaime Trejo
 * Date:4/8/14
 * 		This interface will consist of methods providing basic operations for directed
 * 		and undirected graphs that are either weighted or unweighted.
 */

package GraphPackage;

public interface BasicGraphInterface<T>
{
	// adds a given vertex to the graph. returns true if the vertex is added, otherwise false
	public boolean addVertex(T vertexLabel);
	
	/*Adds a weighted edge between two given distinct vertices that
	are currently in the graph. Edge must not already
	be in the graph. In a directed graph, the edge points toward
	the second vertex given.
		begin an object that labels the origin vertex of the edge
		end an object, distinct from begin, that labels the end vertex of the edge
		edgeWeight the real value of the edge's weight
	returns true if added, otherwise false
	*/
	public boolean addEdge(T begin, T end, double edgeWeight);
	
	/*Adds a weighted edge between two given distinct vertices that
	are currently in the graph. Edge must not already
	be in the graph. In a directed graph, the edge points toward
	the second vertex given.
		begin an object that labels the origin vertex of the edge
		end an object, distinct from begin, that labels the end vertex of the edge
	returns true if added, false otherwise
		*/
	public boolean addEdge(T begin,T end);
	
	// checks if there exists an edge between origin and end vertex, returns true if an edge exists, false otherwise
	public boolean hasEdge(T begin,T end);
	
	// checks to see if the graph is empty, returns true if the graph is empty, false otherwise
	public boolean isEmpty();
	
	// gets and returns the number of vertices that are located in the graph
	public int getNumberOfVertices();
	
	// gets and returns the number of edges that are located in the graph
	public int getNumberOfEdges();
	
	//removes all edges and vertices from the graph
	public void clear();

}
