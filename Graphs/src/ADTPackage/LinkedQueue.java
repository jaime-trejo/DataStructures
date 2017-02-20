/* Name:Jaime Trejo
 * Date:4/10/14
 * 			This class will be a list of objects chained in nodes. 
 * 			It will implement QueueInterface<T> and have private class Node.
 */

package ADTPackage;

public class LinkedQueue<T> implements QueueInterface<T>
{

	private Node firstNode;// references node at the front of the queue
	private Node lastNode;// references node the back of the queue
	
	//default constructor
	public LinkedQueue()
	{
		firstNode = null;
		lastNode = null;
	}
	
	//Adds a new entry to the back of the queue, newEntry will be the entry added to the back
	public void enqueue(T newEntry)
	{
		Node newNode = new Node(newEntry, null);
		
		if (isEmpty())
		{
			firstNode = newNode;
		}
		else
		{
			lastNode.setNextNode(newNode);
		}
		
		lastNode = newNode;
		
	}

	//removes and returns the value of the front of the queue. 
	//returns null if empty, otherwise it returns the value
	public T dequeue()
	{
		T front = null;
		
		if (!isEmpty())
		{
			front = firstNode.getData();
			firstNode = firstNode.getNextNode();
			
			if (firstNode == null)
			{
				lastNode = null;
			}
		} 
		
		return front;
	}

	//retrieves the queues' front entry, w/o changing queue
	//returns null if empty, otherwise it retrieves the front entry
	public T getFront()
	{
		T front = null;
		
		if (!isEmpty())
		{
			front = firstNode.getData();
		}
		return front;
	}

	//detects if the queue is empty, returns true if empty, false otherwise
	public boolean isEmpty()
	{
		return (firstNode == null) && (lastNode == null);
	}

	//removes all entries from queue
	public void clear()
	{
		firstNode = null;
		lastNode = null;
		
	}

	 //private Node class
	   private class Node
	   {
		   	private T data;// entry in the bag
		   	private Node next;// link to the next Node
		   	
		   	//constructors
		   	
		   	private Node(T dataPortion)
		   	{
		   		this(dataPortion,null);
		   	}
		   	
		   	private Node(T dataPortion,Node nextNode)
		   	{
		   		data = dataPortion;
		   		next = nextNode;
		   	}
		   	
		   	//accessors
		   	
		   	// returns the entry in the bag
		   	public T getData()
		   	{
		   		return data;
		   	}
		   	
		   	// returns a link to the next Node
		   	public Node getNextNode()
		   	{
		   		return next;
		   	}
		   	
		   	//mutators
		   	
		   	// data is set to newData
		   	public void setData(T newData)
		   	{
		   		data = newData;
		   	}
		   	
		   	// next is set to the nextNode
		   	public void setNextNode(Node nextNode)
		   	{
		   		next = nextNode;
		   	}
	   }//end node class
}
