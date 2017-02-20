/*
 *  Name:Jaime Trejo
 *  Date: 2/7/14
 *  	The following class tests the CircularArrayQueue I created to check if it runs correctly in situations
 */

public class CircularArrayQueueTester
{
	public static void main(String[] args)
	{
		System.out.println("Create an empty queue of 7 elements");
		System.out.println("---------------------");
		QueueInterface<String> myTestQueue = new CircularArrayQueue<String>();
		System.out.println("Testing method isEmpty() it returns: " + myTestQueue.isEmpty());
		
		// adding to the queue
		System.out.println("\nAdding 6 elements to the queue");
		System.out.println("-------------------------------------------");
		System.out.println("Adding (Walter,Sam,Oliver,Bruce,Diana,Clark)");
		
		myTestQueue.enqueue("Walter");
		myTestQueue.enqueue("Sam");
		myTestQueue.enqueue("Oliver");
		myTestQueue.enqueue("Bruce");
		myTestQueue.enqueue("Diana");
		myTestQueue.enqueue("Clark");
		
		System.out.println("\nTesting method isEmpty() it returns: " + myTestQueue.isEmpty());
		System.out.println("Testing method isFull() it returns: " + ((CircularArrayQueue<String>) myTestQueue).isFull());
		
		// adding to the queue
		System.out.println("\nAdding the 7th element to the queue");
		System.out.println("---------------------------------");
		System.out.println("Adding (Barry)");
		myTestQueue.enqueue("Barry");
		System.out.println("\nTesting method isEmpty() it returns: " + myTestQueue.isEmpty());
		System.out.println("Testing method isFull() it returns: " + ((CircularArrayQueue<String>) myTestQueue).isFull());
		
		// Test to get the front element, front should be Walter
		System.out.println("\nTesting getFront() ");
		System.out.println("------------------");
		System.out.println("The value that is at the front is: " + myTestQueue.getFront());
		
		// Test to remove front element, the value removed should be walter
		System.out.println("\nRemoving dequeue() ");
		System.out.println("------------------");
		System.out.println("The value that was removed is: " + myTestQueue.dequeue());
		
		// Test to get the front element, front should be Sam
		System.out.println("\nTesting getFront() ");
		System.out.println("------------------");
		System.out.println("The value that is at the front is: " + myTestQueue.getFront());
		
		// Test to clear all
		System.out.println("\nTest to clear all array");
		System.out.println("-------------------------");
		myTestQueue.clear();
		System.out.println("Testing method isEmpty() it returns: " + myTestQueue.isEmpty());
		System.out.println("Testing method isFull() it returns: " + ((CircularArrayQueue<String>) myTestQueue).isFull());
		
		// Test to get the front element, front should be Null
		System.out.println("\nTesting getFront() ");
		System.out.println("------------------");
		System.out.println("The value that is at the front is: " + myTestQueue.getFront());
		
		// adding to the queue
		System.out.println("\nAdding 1 element to the queue");
		System.out.println("------------------------------");
		System.out.println("Adding (Walter)");
		myTestQueue.enqueue("Walter");
		
		// Test to get the front element, front should be Walter
		System.out.println("\nTesting getFront() ");
		System.out.println("------------------");
		System.out.println("The value that is at the front is: " + myTestQueue.getFront());
		
		// Test to clear all
		System.out.println("\nClearing all array");
		System.out.println("-------------------------");
		myTestQueue.clear();
		System.out.println("Testing method isEmpty() it returns: " + myTestQueue.isEmpty());
		System.out.println("Testing method isFull() it returns: " + ((CircularArrayQueue<String>) myTestQueue).isFull());
		
	}
}