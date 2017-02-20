/*
 * Name:Jaime Trejo
 * Date:4/10/14
 * 		This class will implement the VertexInterface<T> and have bodies to the methods implemented. 
 * 		Vertex is placed within the package to be hidden from clients of the graph.
 * 		Also, it will have an inner Class called Edge, to indicated the edges that originate at a vertex
 * 		Consists of a Inner class NeighborIterator as well.
 * 
 */

package GraphPackage;
import java.util.Iterator;
import java.util.NoSuchElementException;
import ADTPackage.*;// classes that implement various ADTs

public class Vertex<T> implements VertexInterface<T>
{
	private T label;
	private ListWithIteratorInterface<Edge> edgeList;//edges to neighbors list

	private boolean visited;
	private VertexInterface<T> previousVertex;//on path to this vertex
	private double cost;// of path to this vertex
	
	//constructor
	public Vertex(T vertexLabel)
	{
		label = vertexLabel;
		edgeList = new LinkedListWithIterator<Edge>();
		visited = false;
		previousVertex = null;
		cost = 0;
	}

	// returns the label of the vertex
	public T getLabel()
	{
		return label;
	}

	// marks the vertex as visited
	public void visit()
	{
		visited = true;	
	}

	//removes the vertex as visited
	public void unvisit()
	{
		visited = false;
		
	}

	// returns true if the vertex has been visited, false otherwise
	public boolean isVisited()
	{
		return visited;
	}

	/*Connects this vertex and a given vertex with a weighted edge.
	The two vertices cannot be the same, and must not already
	have this edge between them. In a directed graph, the edge
	points toward the given vertex.
	Returns true if the edge is added, otherwise false*/
	public boolean connect(VertexInterface<T> endVertex, double edgeWeight)
	{
		boolean result = false;
		
		if (!this.equals(endVertex))
		{ 
			// vertices are distinct
			Iterator<VertexInterface<T>> neighbors = this.getNeighborIterator();
			boolean duplicateEdge = false;
			
			while (!duplicateEdge && neighbors.hasNext())
			{
				VertexInterface<T> nextNeighbor = neighbors.next();
				
				if (endVertex.equals(nextNeighbor))
				{
					duplicateEdge = true;
				}
			} 
			if (!duplicateEdge)
			{
				edgeList.add(new Edge(endVertex, edgeWeight));
				result = true;
			}
		}
		return result;
	}

	/*Connects this vertex and a given vertex with an unweighted
	edge. The two vertices cannot be the same, and must not
	already have this edge between them. In a directed graph,
	the edge points toward the given vertex.
	Returns true if the edge is added, otherwise false*/
	public boolean connect(VertexInterface<T> endVertex)
	{
		return connect(endVertex,0);
	}

	//creates an iterator of this vertex's neighbors by following all edges that begin at the given vertex
	public Iterator<VertexInterface<T>> getNeighborIterator()
	{
		return new neighborIterator();
	}

	//creates an iterator of the weights of the edges to this vertex's neighbors.
	public Iterator<Double> getWeightIterator()
	{
		return new weightIterator();
	}

	// returns true if vertex has at least one neighbor, false otherwise
	public boolean hasNeighbor()
	{
		return !edgeList.isEmpty();
	}
	
	/* Gets an unvisited neighbor, if any, of this vertex.
	Returns either a vertex that is an unvisited neighbor or null
	if no such neighbor exists */
	public VertexInterface<T> getUnvisitedNeighbor()
	{
		VertexInterface<T> result = null;
		
		Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
		
		while ((neighbors.hasNext()) && (result == null))
		{
			VertexInterface<T> nextNeighbor = neighbors.next();
			
			if (!nextNeighbor.isVisited())
			{
				result = nextNeighbor;
			}
		} 
		
		return result;
	}

	// Records the previous vertex on a path to this vertex.
	public void setPredecessor(VertexInterface<T> predecessor)
	{
		previousVertex = predecessor;
		
	}

	/* Gets the recorded predecessor of this vertex.returns either this vertex's predecessor or null if no predecessor
	was recorded */
	public VertexInterface<T> getPredecessor()
	{
		return previousVertex;
	}

	// Sees whether a predecessor was recorded, returns true if there is one, false otherwise
	public boolean hasPredecessor()
	{
		return previousVertex!=null;
	}

	// Records the cost of a path to this vertex.
	public void setCost(double newCost)
	{
		cost = newCost;
	}

	// Gets the recorded cost of the path to this vertex 
	public double getCost()
	{
		return cost;
	}
	
	//displays the label
	public String toString()
	{
		return label.toString();
	}
	
	//checks if Two vertices are equal if their labels are equal.
	public boolean equals(Object other)
	{
		boolean result;
		
		if ((other == null) || (getClass() != other.getClass()))
		{
			result = false;
		}
		
		else
		{
			@SuppressWarnings("unchecked")
			Vertex<T> otherVertex = (Vertex<T>)other;
			result = label.equals(otherVertex.label);
		} 
		
	  return result;
	}

	// protected class edge
	protected class Edge 
	{
		private VertexInterface<T> vertex;
		private double weight;
		
		protected Edge(VertexInterface<T> endVertex,double edgeWeight)
		{
			vertex = endVertex;
			weight = edgeWeight;
		}
		
		protected VertexInterface<T> getEndVertex()
		{
			return vertex;
		}
		
		protected double getWeight()
		{
			return weight;
		}
	}// ends Edge class
	
	//private neighborIterator class
	private class neighborIterator implements Iterator<VertexInterface<T>>
	{
		private Iterator<Edge> edges;
		
		private neighborIterator()
		{
			edges = edgeList.getIterator();
		}
		
		public boolean hasNext()
		{
			return edges.hasNext();
		}
		
		public VertexInterface<T> next()
		{
			VertexInterface<T> nextNeighbor = null;
			
			//if there is a neighbor to the edge than do the following
			if (edges.hasNext())
			{
				Edge edgeToNextNeighbor = edges.next();
				nextNeighbor = edgeToNextNeighbor.getEndVertex();
			}
			
			else
			{
				throw new NoSuchElementException();
			}
			
			return nextNeighbor;
		}
		
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}
	
	//private class weightIterator
	private class weightIterator implements Iterator<Double>
	{
		private Iterator<Edge> edges;
		
		//default constructor
		private weightIterator()
		{
			edges = edgeList.getIterator();
		}
		
		public Double next()
		{
			Double edgeWeight = new Double(0);
			
			// it there is an edge than do the following
			if(edges.hasNext())
			{
				Edge edgeToNextNeighbor = edges.next();
				
				// gets the edgeWeight of neighbor
				edgeWeight = edgeToNextNeighbor.getWeight();
			}
			
			else
			{
				throw new NoSuchElementException();
			}
			
			return edgeWeight;
		}
		
		// checks to see if their is a next edge
		public boolean hasNext()
		{
			return edges.hasNext();
		}
		
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
		
	}
}
