/* Name:Jaime Trejo
 * Date:4/11/14
 * 			This class will will create an object and test methods of Vertex<T>
 * 
 */
package GraphPackage;

public class TestVertex
{

	public static void main(String[] args)
	{
		VertexInterface<String> vertexA = new Vertex<String>("A");
		System.out.println("Getting the label of vertexA: " +vertexA.getLabel());
		vertexA.visit();
		System.out.println("is vertexA visited(after setting it to visit): "+vertexA.isVisited());
		vertexA.unvisit();
		System.out.println("is vertexA visited(after setting it to unvisit): "+vertexA.isVisited());
		
		VertexInterface<String> vertexB = new Vertex<String>("B");
		VertexInterface<String> vertexC = new Vertex<String>("C");
		vertexA.connect(vertexB, 2);
		System.out.println("Does vertexA have a neighbor after connecting to vertexB?: " +vertexA.hasNeighbor());
		vertexB.setPredecessor(vertexA);
		System.out.println("What's the predecessor of vertexB?: " + vertexB.getPredecessor());
		vertexB.connect(vertexC);
		System.out.println("Does vertexB have a neighbor after connecting to vertexC?: " +vertexA.hasNeighbor());
		
		//set cost to vertexA
		vertexA.setCost(1);
		System.out.println("What'? the cost of vertexA?: " + vertexA.getCost());
	}

}
