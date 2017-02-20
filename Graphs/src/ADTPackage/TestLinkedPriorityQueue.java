/* Name:Jaime Trejo
 * Date:4/11/14
 * 			This class will will create an object and test methods of LinkedPriorityQueue<T>
 * 
 */

package ADTPackage;

public class TestLinkedPriorityQueue
{
	public static void main(String[] args)
	{
		PriorityQueueInterface<String>  testPriQueue = new LinkedPriorityQueue<String>();
		System.out.println("testPriQueue is empty?: " + testPriQueue.isEmpty());
		testPriQueue.add("A", 5);
		testPriQueue.add("D", 4);
		testPriQueue.add("C", 1);
		System.out.println("testPriQueue is empty?: " + testPriQueue.isEmpty());
		System.out.println("testPriQueue peek: " + testPriQueue.peek());
		System.out.println("Removes high priority: "+testPriQueue.remove());
		System.out.println("Removes high priority: "+testPriQueue.remove());
		testPriQueue.clear();
		System.out.println("After clearing queue is empty?: " + testPriQueue.isEmpty());
	}

}
