/*
 * Name:Jaime Trejo
 * Date:4/10/14
 * 		This interface will provide the operations for the Vertex class
 */
package GraphPackage;
import java.util.Iterator;

public interface VertexInterface<T>
{
	// returns the label of the vertex
	public T getLabel();
	
	// marks the vertex as visited
	public void visit();
	
	//removes the vertex as visited
	public void unvisit();
	
	// returns true if the vertex has been visited, false otherwise
	public boolean isVisited();
	
	/*Connects this vertex and a given vertex with a weighted edge.
	The two vertices cannot be the same, and must not already
	have this edge between them. In a directed graph, the edge
	points toward the given vertex.
	Returns true if the edge is added, otherwise false*/
	public boolean connect(VertexInterface<T> endVertex, double edgeWeight);
	
	/*Connects this vertex and a given vertex with an unweighted
	edge. The two vertices cannot be the same, and must not
	already have this edge between them. In a directed graph,
	the edge points toward the given vertex.
	Returns true if the edge is added, otherwise false*/
	public boolean connect(VertexInterface<T> endVertex);
	
	//creates an iterator of this vertex's neighbors by following all edges that begin at the given vertex
	public Iterator<VertexInterface<T>> getNeighborIterator();

	//creates an iterator of the weights of the edges to this vertex's neighbors.
	public Iterator<Double> getWeightIterator();
	
	// returns true if vertex has at least one neighbor, false otherwise
	public boolean hasNeighbor();
	
	/* Gets an unvisited neighbor, if any, of this vertex.
	Returns either a vertex that is an unvisited neighbor or null
	if no such neighbor exists */
	public VertexInterface<T> getUnvisitedNeighbor();
	
	// Records the previous vertex on a path to this vertex.
	public void setPredecessor(VertexInterface<T> predecessor);
	
	/* Gets the recorded predecessor of this vertex.returns either this vertex's predecessor or null if no predecessor
	was recorded */
	public VertexInterface<T> getPredecessor();
	
	// Sees whether a predecessor was recorded, returns true if there is one, false otherwise
	public boolean hasPredecessor();
	
	// Records the cost of a path to this vertex.
	public void setCost(double newCost);
	
	// Gets the recorded cost of the path to this vertex 
	public double getCost();
}
