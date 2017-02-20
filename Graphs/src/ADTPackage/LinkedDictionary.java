/* Name:Jaime Trejo
 * Date:4/10/14
 * 			This class will have dictionary entries connected in a chain of nodes.
 * 			
 * 			It will implement DictionaryInterface<T> and create its methods
 */

package ADTPackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedDictionary<K, V>  implements DictionaryInterface<K, V>
{

	private Node firstNode;
	private int numberOfEntries;
	
	// default constructor
	public LinkedDictionary()
	{
		firstNode = null;
		numberOfEntries = 0;
	}
	
	//Adds a new entry into the dictionary, replaces the value if it already exits
	//return either null if the new entry was added to the dictionary or the value that was associated with key if that value
	//was replaced 
	public V add(K key, V value)
	{
		V result = null;
		
		Node currentNode = firstNode;
		Node nodeBefore = null;
		
		//traverse through chain
		while((currentNode !=null)&&  !key.equals(currentNode.getKey()))
		{
			nodeBefore = currentNode;
			currentNode = currentNode.getNextNode();
		}
		
		if(currentNode!=null)
		{
			result = currentNode.getValue();
			currentNode.setValue(value);
		}
		
		else
		{
			Node newNode= new Node(key,value);
			
			numberOfEntries++;
			
			if(nodeBefore == null)
			{
				newNode.setNextNode(firstNode);
				firstNode = newNode;
			}
			
			else
			{
				newNode.setNextNode(currentNode);
				nodeBefore.setNextNode(newNode);
			}
		}
		return result;
	}

	//removes a specific entry from the dictionary, returns either the value that belonged to the key or null
	//if not found
	public V remove(K key)
	{
		V result = null;
		
		Node currentNode = firstNode;
		
		Node nodeBefore = null;
		
		//traverse
		while((currentNode !=null)&&!key.equals(currentNode.getKey()))
		{
			nodeBefore = currentNode;
			currentNode = currentNode.getNextNode();
		}
		
		if(currentNode !=null)
		{
			result = currentNode.getValue();
			
			if(nodeBefore !=null)
			{
				nodeBefore.setNextNode(currentNode.getNextNode());
			}
			
			else
			{
				firstNode = currentNode.getNextNode();
			}
			
			numberOfEntries--;
		}
		
		
		return result;
	}

	// returns the value associated with the key given, return either the value or null if it does not exist
	public V getValue(K key)
	{
		V result = null;
		
		// traverse until locate key
		Node currentNode = firstNode;
		Node nodeBefore = null;
		
		while((currentNode!=null)&&!key.equals(currentNode.getKey()))
		{
			nodeBefore = currentNode;
			currentNode = currentNode.getNextNode();
		}
		
		if(currentNode!=null)
		{
			result = currentNode.getValue();
		}
		
		return result;
	}

	//Sees whether a specific entry is in this dictionary. return true if key is associated with an entry in the
	//dictionary false otherwise
	public boolean contains(K key)
	{
		return getValue(key) != null;
	}

	// removes all entries from the dictionary
	public void clear()
	{
		firstNode = null;
		numberOfEntries = 0;
		
	}

	// removes all entries from the dictionary
	public boolean isEmpty()
	{
		return (numberOfEntries ==0);
	}

	// returns the size(number of entries of keys-value) in the dictionary
	public int getSize()
	{
		return numberOfEntries;
	}

	// creates an iterator that traverses all keys in the dictionary
	public Iterator<K> getKeyIterator()
	{
		return new KeyIterator();
	}

	// creates an iterator that traverses all values in the dictionary
	public Iterator<V> getValueIterator()
	{
		return new ValueIterator();
	}

	//private Node class
	private class Node
	{
		K key;
		V value;
		Node next;
		
		// overloaded constructor
		private Node(K nkey, V nvalue)
		{
			key = nkey;
			value = nvalue;
		}
		
		//get next node
		private Node getNextNode()
		{
			return next;
		}
		
		// sets the next node
		private void setNextNode(Node n_next)
		{
			this.next = n_next;
		}
		
		// sets the value
		private void setValue(V v_value)
		{
			this.value = v_value;
		}
		
		// retrieves the key
		private K getKey()
		{
			return key;
		}
		
		// retrieves the value
		private V getValue()
		{
			return value;
		}
	}
	
	//private KeyIterator class
	private class KeyIterator implements Iterator<K>
	{
		private Node nextNode;
		
		// default constructor
		private KeyIterator()
		{
			nextNode = firstNode;
		}
		
		public boolean hasNext()
		{
			return nextNode !=null;
		}
		
		public K next()
		{
			K result;
			
			if(hasNext())
			{
				result = nextNode.getKey();
				nextNode = nextNode.getNextNode();
			}
			
			else
			{
				throw new NoSuchElementException();
			}
			
			return result;
		}
		
		public void remove()
		{
			throw new UnsupportedOperationException("Not supported yet");
		}
	}
	
	//private ValueIterator class
	private class ValueIterator implements Iterator<V>
	{
		private Node nextNode;
		
		//default constructor
		private ValueIterator()
		{
			nextNode = firstNode;
		}
		
		public boolean hasNext()
		{
			return nextNode !=null;
		}
		
		public V next()
		{
			V result;
			
			if(hasNext())
			{
				result = nextNode.getValue();
				nextNode = nextNode.getNextNode();
			}
			else
			{
				throw new NoSuchElementException();
			}
			
			return result;
		}
		
		public void remove()
		{
			throw new UnsupportedOperationException("Not supported yet");
		}
	}

	
	
}
