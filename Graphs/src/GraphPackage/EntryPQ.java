package GraphPackage;
import ADTPackage.*;

public class EntryPQ
{
	Vertex<String> originVertex;
	Vertex<String> endVertex;
	StackInterface<String> path;
	VertexInterface<String> neighbor;
	VertexInterface<String> front;
	VertexInterface<String> origin;
	double cost;

	public EntryPQ(Vertex<String> oVertex,Vertex<String> eVertex,StackInterface<String> pat)
	{
		originVertex = oVertex;
		endVertex = eVertex;
		path = pat;
	}

	public EntryPQ(VertexInterface<String> nextNeighbor, double nextCost,
			VertexInterface<String> frontVertex) {
		
		neighbor = nextNeighbor;
		front = frontVertex;
		cost = nextCost;
		
		
		
	}

	public EntryPQ(VertexInterface<String> originVertex2, Object object)
	{
		origin = originVertex2;
		
	}
}
