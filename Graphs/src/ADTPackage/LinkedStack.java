/* Name:Jaime Trejo
 * Date:4/10/14
 * 			This class will be stacks chained in nodes. It will implement StackInterface<T> and have private class Node.
 */

package ADTPackage;

public class LinkedStack<T> implements StackInterface<T>
{
	private Node topNode;
	
	//default constructor
	public LinkedStack()
	{
		topNode = null;
	}
	
	//adds a new entry to the top of the stack
	public void push(T newEntry)
	{
		Node newNode = new Node(newEntry, topNode);
		topNode = newNode;
	}

	//Removes and returns the stack's top entry, if stack is empty it will return null
	public T pop() 
	{
		T top = peek();
		if (topNode != null)
		{
			topNode = topNode.getNextNode();
		}
		return top;
	}

	//Retrieves the top entry of the stack, returns top entry if stack not empty, null otherwise
	public T peek() 
	{
		T top = null;
		
		if(topNode != null)
		{
			top = topNode.getData();
		}
		
		return top;
	}

	//Finds out if the stack is empty or not, returns true if it is, false otherwise
	public boolean isEmpty()
	{
		return topNode == null;
	}

	// removes all entries from the stack
	public void clear()
	{
		topNode = null;	
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
