/*
 *  Name:Jaime Trejo
 *  Date: 1/18/14
 *  
 *  	The following will be the LinkedBag class of generic type T that describes the objects in a bag. 
 *  	It will implement the BagInterface<T> so I must create bodies for those methods in this class.
 *  	It will also use the Node<T> class.
 *
 */

public class LinkedBag<T> implements BagInterface<T>
{
	private Node<T> firstNode; // reference to the firstNode, head reference
	private int numberOfEntries;
	
	// default constructor
	public LinkedBag()
	{
		firstNode = null;
		numberOfEntries = 0;
	}
	
	// Checks to see if the bag is full or not. Returns true if it's full, false if not.
	//The method isFull should always return false
	public boolean isFull()
	{
		return false;
	}
	
	// Checks to see if the bag is empty or not. Returns true if it's empty, false if not.
	public boolean isEmpty()
	{
		return numberOfEntries == 0;
	}
	
	// Gets and returns the number of entries the bag contains.
	public int getCurrentSize()
	{
		return numberOfEntries;
	}
	
	//Counts and returns the number of times a specific anEntry appears in the bag.
	public int getFrequencyOf(T anEntry)
	{
		int frequency = 0;
		int counter = 0;
		Node<T> currentNode = firstNode;
		
		while ((counter < numberOfEntries) && (currentNode != null))
		{
			if (anEntry.equals(currentNode.getData()))
			{
					frequency++;
					
			}
		counter++;		
		currentNode = currentNode.getNextNode();
		
		} 
		return frequency;
	}
	
	//removes all entries of the bag
	public void clear()
	{
		while(!isEmpty())
		{
			remove();
		}	
	}
	
	//removes an unspecified entry from the linked nodes(first Node) chain, 
	//returns the entry that was removed or null if successful
	public T remove()
	{
		T result = null;
			if (firstNode != null)
			{
				result = firstNode.getData();
				firstNode = firstNode.getNextNode(); // remove first node from chain
				numberOfEntries--;
			} 
			
		return result;
	}
	
	//locates with entry and moves it to first node to remove it
	//returns true if removed occurred, false otherwise
	
	public boolean remove(T anEntry)
	{
		boolean result = false;
		
		Node<T> nodeN = getReferenceTo(anEntry);
		
		if (nodeN != null)
		{
			
			nodeN.setData(firstNode.getData()); // replace located entry with entry in first node
			remove(); // remove first node
			result = true;
		} 
		
		return result;
	}
	
	
	//Adds a given newEntry to the bag, true if added into the bag, false otherwise
	public boolean add(T newEntry)
	{
		// add to beginning of chain
		Node<T> newNode = new Node<T>(newEntry);
		newNode.setNextNode(firstNode); // Make new node reference rest of chain
		
		firstNode = newNode; // new node is at beginning of chain
		numberOfEntries++;
		
		return true;
	}
	
	//Tests to see if the given anEntry is located in a Node, true if it's in the node,false otherwise
	public boolean contains(T anEntry)
	{
		return getReferenceTo(anEntry) != null;
	}
	
	//creates an array of all the items that are in the bag
	public T[] toArray()
	{
		// the cast is safe because the new array contains null entries
	    @SuppressWarnings("unchecked")
	    T[] result = (T[])new Object[numberOfEntries]; // unchecked cast

	      int index = 0;
	      Node<T> currentNode = firstNode;
	      
	      while ((index < numberOfEntries) && (currentNode != null))
	      {
	         result[index] = currentNode.getData();
	         index++;
	         currentNode = currentNode.getNextNode();
	      } 
	     
	      return result;
	}
	
	// Locates a given entry within this bag, returns a reference to the node containing the entry, if located,
	// or null otherwise.
	public Node<T> getReferenceTo(T anEntry)
	{
		boolean found = false;
		Node<T> currentNode = firstNode;
		
		while (!found && (currentNode != null))
		{
			if (anEntry.equals(currentNode.getData()))
			{
				found = true;
			}
			else
			{
				currentNode = currentNode.getNextNode();
			}
		} 
		
		return currentNode;
	}

	// mutator to set numberOfEntries to newNumberOfEntries
	public void setNumberOfEntries(int newNumberOfEntries)
	{
		numberOfEntries = newNumberOfEntries;
	}
	
	//mutator to set firstNode to newFirstNode
	public void setFirstNode(Node<T> newFirstNode)
	{
		firstNode = newFirstNode;
	}
	
	// returns a link to the first Node
	public Node<T> getFirstNode()
	{
		return firstNode;
	}
}
