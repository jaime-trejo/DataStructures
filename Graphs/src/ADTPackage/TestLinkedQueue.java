/* Name:Jaime Trejo
 * Date:4/11/14
 * 			This class will will create an object and test methods of LinkedQueue<T>
 * 
 */

package ADTPackage;

public class TestLinkedQueue 
{

	public static void main(String[] args)
	{
		QueueInterface<String> testLQueue = new LinkedQueue<String>();
		System.out.println("is testLQueue empty?: " +testLQueue.isEmpty());
		testLQueue.enqueue("A");
		testLQueue.enqueue("B");
		testLQueue.enqueue("C");
		System.out.println("is testLQueue empty after adding?: " +testLQueue.isEmpty());
		System.out.println("getFront: " +testLQueue.getFront());
		String tempFront = testLQueue.getFront();
		testLQueue.dequeue();
		System.out.println("getFront after removing " +tempFront + ": " +testLQueue.getFront());
		testLQueue.clear();
		System.out.println("is testLQueue empty after clearing?: " +testLQueue.isEmpty());
		System.out.println("getFront after clearing:  "+testLQueue.getFront());
	}

}
