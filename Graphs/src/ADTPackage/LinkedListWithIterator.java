/*
 * Name:Jaime Trejo
 * Date:4/9/14
 * 		This class will be a LinkedListWithIterator it implements ListWithIteratorInterface. It will have inner
 *		classes IteratorForLinkedList and Node.
 * 		
 * 		To build this class I read Chapter 15.
 * 
 */

package ADTPackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListWithIterator<T> implements ListWithIteratorInterface<T>
{
   private Node firstNode;
   private int  numberOfEntries;;

   public LinkedListWithIterator()
   {
      clear();
   } // end default constructor
  
   private Node getNodeAt(int givenPosition)
   {
	   assert (firstNode != null) &&
	   (1 <= givenPosition) && (givenPosition <= numberOfEntries);
	   Node currentNode = firstNode;
	   // traverse the chain to locate the desired node
   		for (int counter = 1; counter < givenPosition; counter++)
   			{
   				currentNode = currentNode.getNextNode();
   				assert currentNode != null;
   			}
   		
   		return currentNode;			
   }
   
   public void add(T newEntry)
   {
	   Node newNode = new Node(newEntry);
	   if (isEmpty())
		   firstNode = newNode;
	   else // add to end of nonempty list
	   {
		   Node lastNode = getNodeAt(numberOfEntries);
		   lastNode.setNextNode(newNode); // make last node reference new node
   	   } 
	   
	   numberOfEntries++;
   }
   
   public boolean add(int newPosition, T newEntry)
   {
	   boolean isSuccessful = true;
	   if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1))
	   {
		   Node newNode = new Node(newEntry);
		   if (newPosition == 1) // case 1
		   {
			   newNode.setNextNode(firstNode);
			   firstNode = newNode;
		   }
		   else // case 2: list is not empty
		   { // and newPosition > 1
			   Node nodeBefore = getNodeAt(newPosition - 1);
			   Node nodeAfter = nodeBefore.getNextNode();
			   newNode.setNextNode(nodeAfter);
			   nodeBefore.setNextNode(newNode);
		   } // end if
		   
		 numberOfEntries++;
	   }
	   else
		   isSuccessful = false;
	   return isSuccessful;
   }
   
   public boolean isEmpty()
   {
	   boolean result;
	   if (numberOfEntries == 0) // or getLength() == 0
	   {
		   assert firstNode == null;
		   result = true;
	   }
	   else
	   {
		   assert firstNode != null;
		   result = false;
	   } 
	   
	   return result;
   }
   
   public T[] toArray()
   {
	   // the cast is safe because the new array contains null entries
	   @SuppressWarnings("unchecked")
   		T[] result = (T[])new Object[numberOfEntries];
	   	int index = 0;
	   	Node currentNode = firstNode;
	   	while ((index < numberOfEntries) && (currentNode != null))
	   	{
	   		result[index] = currentNode.getData();
	   		currentNode = currentNode.getNextNode();
	   		index++;
	   	} 
	  
	   	return result;  
   }
   
   public T remove(int givenPosition)
   {
	   T result = null; // return value
	   if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
	   {
		   assert !isEmpty();
		   if (givenPosition == 1) // case 1: remove first entry
		   {
			   result = firstNode.getData(); // save entry to be removed
			   firstNode = firstNode.getNextNode();
		   }
		   else // case 2: not first entry
		   {
			   Node nodeBefore = getNodeAt(givenPosition - 1);
			   Node nodeToRemove = nodeBefore.getNextNode();
			   Node nodeAfter = nodeToRemove.getNextNode();
			   nodeBefore.setNextNode(nodeAfter);
			   result = nodeToRemove.getData(); // save entry to be removed
		   }
		   
		  numberOfEntries--;
	   } 
	   
   return result; // return removed entry, or null if operation fails
   }
   
   public boolean replace(int givenPosition, T newEntry)
   {
	   boolean isSuccessful = true;
	   if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
	   {
		   assert !isEmpty();
		   Node desiredNode = getNodeAt(givenPosition);
		   desiredNode.setData(newEntry);
	   }
	   else
		   isSuccessful = false;
	   
	   return isSuccessful;
   }
   
   public T getEntry(int givenPosition)
   {
	   T result = null; // result to return
	   if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
	   {
		   assert !isEmpty();
		   result = getNodeAt(givenPosition).getData();
	   } 
	  
	   return result;
	}
   
   public boolean contains(T anEntry)
   {
	   boolean found = false;
	   Node currentNode = firstNode;
	   
	   while (!found && (currentNode != null))
	   {
		   if (anEntry.equals(currentNode.getData()))
			   found = true;
		   else
			   currentNode = currentNode.getNextNode();
	   } 
	   
	   return found;
   }
   
   public final void clear()
   {
	   firstNode = null;
	   //lastNode = null;
	   numberOfEntries = 0;
   }
   
   public int getLength()
   {
   		return numberOfEntries;
   }

   public Iterator<T> getIterator()
   {
      return new IteratorForLinkedList();
   } 
  
   private class IteratorForLinkedList implements Iterator<T>
   {
	   
	   private Node nextNode;

	   private IteratorForLinkedList()
	   {
		   nextNode = firstNode;
	   } 

	   public boolean hasNext()
	   {
		   return nextNode != null;
	   }

	   public T next()
	   {
		   if (hasNext())
		   {
			   Node returnNode = nextNode; // get next node
			   nextNode = nextNode.getNextNode(); // advance iterator
			
			   return returnNode.getData(); // return next entry in iteration
		   }
		   else
			   	
			   throw new NoSuchElementException("Illegal call to next(); " + "iterator is after end of list.");
      }

      public void remove()
      {
    	  throw new UnsupportedOperationException("remove() is not " + "supported by this iterator");
      }
	
   }// end IteratorForLinkedList
    
   
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
   
} // end LinkedListWithIterator