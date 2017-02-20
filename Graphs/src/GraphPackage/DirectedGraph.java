/*
 * Name:Jaime Trejo
 * Date:4/10/14
 * 		This will be the class for the Directed graph. It will import the ADTPackage that I created.
 *
 * 		I had to create and test ADTs that would be used in this class. These files are found in 
 * 		ADTPackage.
 */

package GraphPackage;

import java.util.Iterator;
import ADTPackage.*;

public class DirectedGraph<T> implements GraphInterface<T>
{

	private DictionaryInterface<T, VertexInterface<T>> vertices;
	private int edgeCount;
	
	//default constructor
	public DirectedGraph()
	{
		vertices = new LinkedDictionary<T , VertexInterface<T>>();
		edgeCount = 0;
	}
	
	// adds a given vertex to the graph. returns true if the vertex is added, otherwise false
	public boolean addVertex(T vertexLabel)
	{
		VertexInterface<T> isDuplicate = vertices.add(vertexLabel, new Vertex<T>(vertexLabel));
		return isDuplicate == null; 
	}

	/*Adds a weighted edge between two given distinct vertices that
	are currently in the graph. Edge must not already
	be in the graph. In a directed graph, the edge points toward
	the second vertex given.
		begin an object that labels the origin vertex of the edge
		end an object, distinct from begin, that labels the end vertex of the edge
		edgeWeight the real value of the edge's weight
	returns true if added, otherwise false
	*/
	public boolean addEdge(T begin, T end, double edgeWeight)
	{
		boolean result = false;
		
		VertexInterface<T> beginVertex = vertices.getValue(begin);
		VertexInterface<T> endVertex = vertices.getValue(end);
		
		if ((beginVertex != null) && (endVertex != null))
		{
			result = beginVertex.connect(endVertex, edgeWeight);
		}
		
		if (result)
		{
			edgeCount++;
		}
		
		return result;
		
	}

	/*Adds a weighted edge between two given distinct vertices that
	are currently in the graph. Edge must not already
	be in the graph. In a directed graph, the edge points toward
	the second vertex given.
		begin an object that labels the origin vertex of the edge
		end an object, distinct from begin, that labels the end vertex of the edge
	returns true if added, false otherwise
		*/
	public boolean addEdge(T begin, T end)
	{
		return addEdge(begin, end, 0);
	}

	// checks if there exists an edge between origin and end vertex, returns true if an edge exists, false otherwise
	public boolean hasEdge(T begin, T end)
	{
		boolean found = false;
		
		VertexInterface<T> beginVertex = vertices.getValue(begin);
		VertexInterface<T> endVertex = vertices.getValue(end);
		
		if ( (beginVertex != null) && (endVertex != null) )
		{
			Iterator<VertexInterface<T>> neighbors = beginVertex.getNeighborIterator();
		
			while (!found && neighbors.hasNext())
			{
				VertexInterface<T> nextNeighbor = neighbors.next();
				
				if (endVertex.equals(nextNeighbor))
				{
					found = true;
				}
			}
		} 
		
		return found;
	}

	// checks to see if the graph is empty, returns true if the graph is empty, false otherwise
	public boolean isEmpty()
	{
		return vertices.isEmpty();
	}

	// gets and returns the number of vertices that are located in the graph
	public int getNumberOfVertices()
	{
		return vertices.getSize();
	}

	// gets and returns the number of edges that are located in the graph
	public int getNumberOfEdges()
	{
		return edgeCount;
	}

	//removes all edges and vertices from the graph
	public void clear()
	{
		vertices.clear();
		edgeCount = 0;
	}

	//Performs a breadth-first traversal of a graph. Origin an object that labels the origin vertex of the
	//traversal. Returns a queue of labels of the vertices in the traversal, with the label of the origin vertex
	//at the queue's front 
	public QueueInterface<T> getBreadthFirstTraversal(T origin)
	{
		resetVertices();
		
		QueueInterface<T> traversalOrder = new LinkedQueue<T>();
		QueueInterface<VertexInterface<T>> vertexQueue = new LinkedQueue<VertexInterface<T>>();
		VertexInterface<T> originVertex = vertices.getValue(origin);
		originVertex.visit();
		traversalOrder.enqueue(origin); // enqueue vertex label
		vertexQueue.enqueue(originVertex); // enqueue vertex
		
		while (!vertexQueue.isEmpty())
		{
			VertexInterface<T> frontVertex = vertexQueue.dequeue();
			Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();
		
			while (neighbors.hasNext())
			{
				VertexInterface<T> nextNeighbor = neighbors.next();
				
				if (!nextNeighbor.isVisited())
				{
					nextNeighbor.visit();
					traversalOrder.enqueue(nextNeighbor.getLabel());
					vertexQueue.enqueue(nextNeighbor);
				} 
			} 
		} 
		
		return traversalOrder;
	}

	//Performs a depth-first traversal of a graph. Origin is an object that labels the origin vertex of the
	//traversal. Returns a queue of labels of the vertices in the traversal, with
	//the label of the origin vertex at the queue's front 
	
	public QueueInterface<T> getDepthFirstTraversal(T origin)
	{
		resetVertices();
		QueueInterface<T> traversalOrder = new LinkedQueue<T>();
		
		StackInterface<VertexInterface<T>> vertexStack = new LinkedStack<VertexInterface<T>>();
		VertexInterface<T> originVertex = vertices.getValue(origin);
		originVertex.visit();
		traversalOrder.enqueue(origin); // enqueue vertex label
		vertexStack.push(originVertex);
		
		while(!vertexStack.isEmpty())
		{
			VertexInterface<T> topVertex = vertexStack.peek();
			//Iterator<VertexInterface<T>> neighbors = topVertex.getNeighborIterator();
			
			//while (neighbors.hasNext())
			//{
				//VertexInterface<T> nextNeighbor = neighbors.next();
				
				if (!topVertex.isVisited())
				{
					Iterator<VertexInterface<T>> neighbors = topVertex.getNeighborIterator();
					VertexInterface<T> nextNeighbor = neighbors.next();
					
						nextNeighbor.visit();
						traversalOrder.enqueue(nextNeighbor.getLabel());
						vertexStack.push(nextNeighbor);
					
				} 
				else
				{
					vertexStack.pop();
				} 	
			
		}
		
		return traversalOrder;	
	}

	//Performs a topological sort of the vertices in a graph without cycles.
	//returns a stack of vertex labels in topological order, beginning with the stack's top 
	@Override
	public StackInterface<T> getTopologicalOrder()
	{
		/*resetVertices();
		
		StackInterface<T> vertexStack = new LinkedStack<T>();
		int numberOfVertices = getNumberOfVertices();
		
		for(int count = 1; count <= numberOfVertices;count++)
		{
			VertexInterface<T> nextVertex = vertices.;
			
			nextVertex.visit();
			
			vertexStack.push(nextVertex);
		}
		
		return vertexStack;*/
		return null;
		
	}

	//Before you could perform a topological sort on the same graph, you would have to reset the field visited for
	//each vertex in the graph. Since if you run other searches the vertices might be marked as visited and unvisited.
	protected void resetVertices()
	{
		Iterator<VertexInterface<T>> vertexIterator = vertices.getValueIterator();
		
		while (vertexIterator.hasNext())
		{
			VertexInterface<T> nextVertex = vertexIterator.next();
			nextVertex.unvisit();
			nextVertex.setCost(0);
			nextVertex.setPredecessor(null);
		} 
	}
	
	//Finds the path between two given vertices that has the shortest length.
	//begin an object that labels the path's origin vertex
	//end an object that labels the path's destination vertex
	//path a stack of labels that is empty initially;at the completion of the method, this stack contains
	//the labels of the vertices along the shortest path;
	//the label of the origin vertex is at the top, and the label of the destination vertex is at the bottom
	//returns the length of the shortest path
	public int getShortestPath(T begin, T end, StackInterface<T> path)
	{
		resetVertices();
		boolean done = false;
		
		QueueInterface<VertexInterface<T>> vertexQueue = new LinkedQueue<VertexInterface<T>>();
		
		VertexInterface<T> originVertex = vertices.getValue(begin);
		VertexInterface<T> endVertex = vertices.getValue(end);
		originVertex.visit();
		
		// Assertion: resetVertices() has executed setCost(0)
		// and setPredecessor(null) for originVertex
		vertexQueue.enqueue(originVertex);
		
		while (!done && !vertexQueue.isEmpty())
		{
			VertexInterface<T> frontVertex = vertexQueue.dequeue();
			Iterator<VertexInterface<T>> neighbors =
			frontVertex.getNeighborIterator();
			
			while (!done && neighbors.hasNext())
			{
				VertexInterface<T> nextNeighbor = neighbors.next();
				
				if (!nextNeighbor.isVisited())
				{
					nextNeighbor.visit();
					nextNeighbor.setCost(1 + frontVertex.getCost());
					nextNeighbor.setPredecessor(frontVertex);
					vertexQueue.enqueue(nextNeighbor);
				} 
				
				if (nextNeighbor.equals(endVertex))
				{
					done = true;
				}
			} 
		}
		
		// traversal ends; construct shortest path
		int pathLength = (int)endVertex.getCost();
		path.push(endVertex.getLabel());
		VertexInterface<T> vertex = endVertex;
		
		while (vertex.hasPredecessor())
		{
			vertex = vertex.getPredecessor();
			path.push(vertex.getLabel());
		} 
		
		return pathLength;
	}

	//Finds the least-cost path between two given vertices.
	//begin an object that labels the path's origin vertex
	//end an object that labels the path's destination vertex
	//path a stack of labels that is empty initially; at the completion of the method, this stack contains the 
	//labels of the vertices along the cheapest path;the label of the origin vertex is at the top, and 
	//the label of the destination vertex is at the bottom
	//returns the cost of the cheapest path 
	public double getCheapestPath(T begin, T end, StackInterface<T> path)
	{
		return 0;
	 /*
		
	}
		resetVertices();
		boolean done = false;
		
		PriorityQueueInterface<EntryPQ> priorityQueue = new LinkedPriorityQueue<EntryPQ>();
		
		VertexInterface<T> originVertex = vertices.getValue(begin);
		VertexInterface<T> endVertex = vertices.getValue(end);
		
		priorityQueue.add(new EntryPQ(originVertex,null));
		
		while(!done&&priorityQueue.isEmpty())
		{
			EntryPQ frontEntry = priorityQueue.remove();
			
			VertexInterface<T> frontVertex = frontEntry.getVertex();
			
			if(!frontVertex.isVisited())
			{
				frontVertex.visit();
				
				// get cost and set
				frontVertex.setCost(frontEntry.getCost());
				
				frontVertex.setPredessor(frontEntry.getPredecessor());
				
				if(frontVertex.equals(endVertex))
				{
					done = true;
				}
				else
				{
					Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();
					
					// get the edgeWeight of neighbor
					Iterator<Double> edgeWeights = frontVertex.getWeightIterator();
					
					while(neighbors.hasNext())
					{
						VertexInterface<T> nextNeighbor = neighbors.next();
						
						Double weightOfEdgeNeighbors = edgeWeights.next();
						
						// continue checking neighbors
						if(!nextNeighbor.isVisited())
						{
							double nextCost = weightOfEdgeNeighbors + frontVertex.getCost();
							
							priorityQueue.add(new EntryPQ(nextNeighbor,nextCost,frontVertex));
							
						}
					}
				}
			}
		}
		
		double pathCost = endVertex.getCost();
		
		// get label of endVertex and then push
		path.push(endVertex.getLabel());
		
		VertexInterface<T> vertex = endVertex;
		
		while(vertex.hasPredecessor())
		{
			vertex = vertex.getPredecessor();
			path.push(vertex.getLabel());
		}
		
		return pathCost;
	}*/}
	
}
