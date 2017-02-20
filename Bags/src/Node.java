/*
 *  Name:Jaime Trejo
 *  Date: 1/18/14
 *
 *  	The following will be the Node class of generic type T .
 *
 */
public class Node<T>
{

	private T data;// entry in the bag
	private Node<T> next;// link to the next Node
	
	//constructors
	
	public Node(T dataPortion)
	{
		this(dataPortion,null);
	}
	
	public Node(T dataPortion,Node<T> nextNode)
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
	public Node<T> getNextNode()
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
	public void setNextNode(Node<T> nextNode)
	{
		next = nextNode;
	}
	
	
}
