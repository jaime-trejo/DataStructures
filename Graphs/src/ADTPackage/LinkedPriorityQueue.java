/*
 * Name:Jaime Trejo
 * Date:4/8/14
 * 		This class will implement PriorityQueueInterface<T> and create bodies
 * 		This will be a linked list priority queue
 * 
 */

package ADTPackage;

public class LinkedPriorityQueue<T> implements PriorityQueueInterface<T>
{
	private Node firstNode;
	private int numberOfEntries;
	
	// default constructor
	public LinkedPriorityQueue()
	{
		firstNode = null;
	}

	// Adds a new entry to this priority queue.
	public void add(T newEntry,int priority)
	{
		Node newNode = new Node(newEntry,priority);
		
		if(isEmpty())
		{
			firstNode = newNode;
		}
		
		else
		{
			if(firstNode.getPriority() < newNode.getPriority())
			{
				newNode.setNextNode(firstNode);
				firstNode = newNode;
			}
			else
			{
				Node temp = firstNode,current = firstNode;
				while(current!=null && current.getPriority() >= newNode.getPriority())
				{
					temp = current;
					current = current.getNextNode();
				}
				
				temp.setNextNode(newNode);
				newNode.setNextNode(current);
			}
		}
		numberOfEntries++;
	}

	// Removes and returns the item with the highest priority.Returns priority queue is empty before the operation, null 
	public T remove()
	{
		T front = null;
		
		if(!isEmpty())
		{
			Node temp = firstNode;
			front = firstNode.getData();
			
			firstNode = firstNode.getNextNode();
			temp.setNextNode(null);
		}
		
		numberOfEntries--;
		return front;
	}

	// Retrieves the item with the highest priority.either the object with the highest priority or, if the
	//priority queue is empty, null 
	public T peek()
	{
		T front = null;
		
		if(!isEmpty())
		{
			front = firstNode.getData();
		}
		
		return front;
	}

	// Detects whether this priority queue is empty. returns true if empty, false otherwise
	public boolean isEmpty()
	{
		return firstNode == null;
	}
	
	// gets the size of the queue
	public int getSize()
	{
		return numberOfEntries;
	}
	
	// Removes all entries from this priority queue 
	public void clear()
	{
		firstNode = null;
	}
	
	//private Node class
	   private class Node
	   {
		   	private T data;// entry in the bag
		   	private Node next;// link to the next Node
		   	private int priority;
		   	
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
		   	
		   	private Node(T newEntry, int pri)
		   	{
		   		data = newEntry;
		   		priority = pri;
		   		next = null;
		   	}
		   	
		   	//accessors
		   	
		   	// returns the entry in the bag
		   	public T getData()
		   	{
		   		return data;
		   	}
		   	
		   	// returns priority of node
		   	private int getPriority()
		   	{
		   		return priority;
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
