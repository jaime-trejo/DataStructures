/* Name:Jaime Trejo
 * Date:4/11/14
 * 			This class will test some methods that directedGraph has
 * 
 */

package GraphPackage;

public class TestDirectedGraph
{

	public static void main(String[] args)
	{
		GraphInterface<String> test= new DirectedGraph<String>();
		System.out.println("is the maze empty? " +test.isEmpty());
		test.addVertex("A");
		test.addVertex("B");
		test.addEdge("A", "B", 2);
		System.out.println("is the maze empty(After adding)? " +test.isEmpty());
		System.out.println(test.getNumberOfEdges());
		System.out.println("how many vertices is there?: " +test.getNumberOfVertices());
		System.out.println("Does A-B have an edge?: " +test.hasEdge("A", "B"));

	}

}
