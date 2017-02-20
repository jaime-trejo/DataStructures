/* Name:Jaime Trejo
 * Date:3/20/14
 * 			This will be a hashed dictionary with separate chain and will implement DictionaryInterface<K,V>
 *
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SeparateChainHashDictionary<K,V> implements DictionaryInterface<K,V>
{
	private Node<K,V>[] hashTable;
	private int numberOfEntries;
	private static final double MAX_LOAD_FACTOR = 0.9;
	private static final int DEFAULT_SIZE = 21;
	
	//default constructor
	public SeparateChainHashDictionary()
	{	
		this(DEFAULT_SIZE);
	}
	
	// constructor with size
	public SeparateChainHashDictionary(int tableSize)
	{
		// get the next prime number
		int primeSize = getNextPrime(tableSize);
		
		@SuppressWarnings("unchecked")
		Node<K,V>[] temp = new Node[primeSize];
		hashTable = temp;
		numberOfEntries = 0;
		
	}
	
	//return either null if the new entry was added to the dictionary or the value that was associated with key if that value
	//was replaced 
	public V add(K key, V value)
	{
		V oldVal = null;
		
		// checks if table needs to be extended
		if(isHashTableTooFull())
		{
			rehash();
		}
		
		// get index
		int index = getHashIndex(key);
		
		// checks to see if the index is valid and increases entries
		if(hashTable[index] == null)
		{
			//if the key is not in the dictionary then it will add it and update count
			hashTable[index] = new Node<K,V>(key,value);
			numberOfEntries++;
		}
		
		else
		{
			// if the key is already in the list then replace the old value with new
			Node<K,V> currentNode = hashTable[index];
			Node<K,V> nodeBefore = null;
			
			// searches through the bucket and replaces
			while(currentNode !=null && !key.equals(currentNode.getKey()))
			{
				nodeBefore = currentNode;
				currentNode = currentNode.getNextNode();
			}
			
			// if key is not in the list then it will add it
			if(currentNode == null)
			{
				// adds new key 
				Node<K,V> newNode = new Node<K,V>(key,value);
				nodeBefore.setNextNode(newNode);
				numberOfEntries++;
			}
			else
			{
				// key is in dictionary, replace
				oldVal = currentNode.getValue();
				currentNode.setValue(value);
				
			}
		}
		
		return oldVal;
	}

	

	// returns the value associated with the key given, return either the value or null if it does not exist
	public V getValue(K key)
	{
		V result = null;
		
		// gets the index of the key
		int index = getHashIndex(key);
		
		// gets reference to node
		//Node<K,V> nodeBefore = null;
		Node<K,V> currentNode = hashTable[index];
		
		while(currentNode !=null && !key.equals(currentNode.getKey()))
		{
			currentNode = currentNode.getNextNode();
		}
	
		if(currentNode!=null)
		{
			// gets value
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
		// loop to remove the values
		for(int index = 0; index < hashTable.length;index++)
		{
			hashTable[index] = null;
		}
		
		numberOfEntries = 0;
	}

	// if dictionary is full
	public boolean isFull()
	{
		return false;
	}
	
	// returns true if the dictionary is Empty false otherwise
	public boolean isEmpty()
	{
		return numberOfEntries == 0;
	}

	
	// returns the size(number of entries of keys-value) in the dictionary
	public int getSize()
	{
		return numberOfEntries;
	}

	// method to see if hashTable is full, returns true if full, false otherwise
	private boolean isHashTableTooFull()
	{
		return numberOfEntries > (MAX_LOAD_FACTOR*hashTable.length);
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

	//removes a specific entry from the dictionary, returns either the value that belonged to the key or null
	//if not found
	public V remove(K key)
	{
		V removedVal = null;
		
		// get the index of the key
		int index = getHashIndex(key);
		
		Node<K,V> nodeBefore = null;
		Node<K,V> currentNode = hashTable[index];
		
		// checks to see if the key is in the dictionary
		while(currentNode!=null && !key.equals(currentNode.getKey()))
		{
			nodeBefore = currentNode;
			currentNode = currentNode.getNextNode();
		}
		
		
		if(currentNode!=null)
		{
			// gets value
			removedVal = currentNode.getValue();
			
			// check if key found
			if(nodeBefore == null)
			{
				// checks first node
				hashTable[index] = currentNode.getNextNode();
			}
			
			else
			{
				nodeBefore.setNextNode(currentNode.getNextNode());
				
			}
			numberOfEntries--;
		}
		return removedVal;
	}
	
	// method to display
	public void display()
	{
		for(int index = 0; index < hashTable.length;index++)
		{
			//check to see if dictionary is empty
			if(hashTable[index] == null)
			{
				System.out.println("null");
				
			}
			
			else
			{
				// traverses through the nodes and prints the values
				Node<K,V> currentNode = hashTable[index];
				
				while(currentNode !=null)
				{
					// get the key and value printed
					System.out.println("Key:" + currentNode.getKey() + " Value: " + currentNode.getValue());
					
					// move to next
					currentNode = currentNode.getNextNode();
				}
				
			}
			
		}
	}
	
	// method to rehash the hash table
	private void rehash()
	{
		// variable to hold details of previous table
		Node<K,V>[] oldTable = hashTable;
		int oldSize = oldTable.length;
		int newSize = getNextPrime(oldSize+oldSize);
		
		// create a new dictionary
		@SuppressWarnings("unchecked")
		Node<K,V>[] temp = new Node[newSize];
		hashTable = temp;
		numberOfEntries = 0;
		
		// copy old values to new table
		for(int i = 0; i < oldSize;++i)
		{
			Node<K,V> currentNode = oldTable[i];
			
			while(currentNode !=null)
			{
				add(currentNode.getKey(),currentNode.getValue());
				currentNode = currentNode.getNextNode();
			}
		}
	}
	
	//method to get the index of the key from hash
	private int getHashIndex(K key)
	{
		int hashIndex = key.hashCode()% hashTable.length;
		
		if(hashIndex < 0)
		{
			hashIndex = hashIndex + hashTable.length;
		}
		
		return hashIndex;
	}
	
	// method to check if a number is prime
	private boolean isPrime(int numValue)
	{
		boolean result;
		boolean done = false;
		
		// check if the number is not prime
		if((numValue  == 1)|| (numValue %2 == 0))
		{
			result = false;
		}
		
		else if (( numValue == 2) ||(numValue == 3))
		{
			result = true;
		}
		
		else
		{
			assert(numValue % 2 != 0) && (numValue >=5);
			result = true;
			
			// checks number for other values
			for(int div = 3; !done &&(div*div <=numValue);div = div+2)
			{
				// checks if # is divisible
				if(numValue % div == 0)
				{
					result = false;
					done = true;
				}
			}
		}
		
		return result;
	}
	
	// method to retrieve the next prime number
	private int getNextPrime(int numberValue)
	{
		// checks if the # is even
		if(numberValue % 2 ==0)
		{
			numberValue ++;
		}
		
		// loop to find next prime
		while(!isPrime(numberValue))
		{
			numberValue = numberValue +2;
		}
		
		return numberValue;
	}
	
	/* Name:Jaime Trejo
	 * Date:3/20/14
	 * Compiler: Eclipse Helios
	 * Class: Comp 310 Data Structures
	 * Project: Lab 5
	 * 			This will be the node class that will be used in SeparateChainHashDictionary<K, V>
	 * 			For this Node class I just got an idea of how to create it from previous node classes from previous projects
	 */
	
	private class Node<S,T>
	{
		private S nodeKey;
		private T nodeValue;
		private Node<S,T> nextNode;
		
		
		// constructor
		private Node(S newKey,T newValue)
		{
			nodeKey = newKey;
			nodeValue = newValue;
			nextNode = null;
		}
		
		// constructor sets node 
		private Node(S newKey,T newValue,Node<S,T> newNextNode)
		{
			nodeKey = newKey;
			nodeValue = newValue;
			nextNode = newNextNode;
		}
		
		// accessors
		
		// returns the key from the node
		private S getKey()
		{
			return nodeKey;
		}
		
		//returns the value from the node
		private T getValue()
		{
			return nodeValue;
		}
		
		// returns the nextNode
		private Node<S,T> getNextNode()
		{
			return nextNode;
		}
		
		// mutators
		
		// sets the newKey for the node
		private void setKey(S newKey)
		{
			nodeKey = newKey;
		}
		
		//sets the newValue for the node
		private void setValue(T newValue)
		{
			nodeValue = newValue;
		}
		
		//sets the newNode for the node
		private void setNextNode(Node<S,T> newNextNode)
		{
			nextNode = newNextNode;
		}
		
		
	}

	/* Name:Jaime Trejo
	 * Date:3/20/14
	 * Compiler: Eclipse Helios
	 * Class: Comp 310 Data Structures
	 * Project: Lab 5
	 * 			This will be the KeyIterator class that will be used in SeparateChainHashDictionary<K, V>
	 * 			For this class I just got an idea of how to create it from the hash dictionary in blackboard and 
	 * 			in chapter 22 in Data Structures with Java 3rd edition by Frank Carrano
	 */
	
	private class KeyIterator implements Iterator<K>
	{
		private int currentIndex;
		private Node<K,V> currentlyNode;
		
		//default constructor
		private KeyIterator()
		{
			currentIndex = -1;
			currentlyNode = getNextChain();
		}
		
		//method to get next bucket from the dictionary
		private Node<K,V> getNextChain()
		{
			while((currentlyNode == null) && (currentIndex < hashTable.length -1))
			{
				currentIndex ++;
				currentlyNode = hashTable[currentIndex];
			}
			
		
			return currentlyNode;
		}

		// method to see if the node has a next node
		public boolean hasNext()
		{
			return currentlyNode != null;
		}
		
		//method to return the next key
		public K next()
		{
			K result = null;
			
			// checks to see if there is any next
			if(hasNext())
			{
				// get key from the node
				result = currentlyNode.getKey();
				currentlyNode = currentlyNode.getNextNode();	
			
			
				if(currentlyNode == null)
				{
					currentlyNode = getNextChain();
				}
			}
			
			else
			{
				throw new NoSuchElementException();
			}
			
			return result;
		}

		// method to remove key from iterator
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
		
	}
	
	/* Name:Jaime Trejo
	 * Date:3/20/14
	 * Compiler: Eclipse Helios
	 * Class: Comp 310 Data Structures
	 * Project: Lab 5
	 * 			This will be the ValueIterator class that will be used in SeparateChainHashDictionary<K, V>
	 * 			For this class I just got an idea of how to create it from the hash dictionary in blackboard and 
	 * 			in chapter 22 in Data Structures with Java 3rd edition by Frank Carrano
	 */
	
	private class ValueIterator implements Iterator<V>
	{
		private int currentIndex;
		private Node<K,V> currentlyNode;
		
		//default constructor
		private ValueIterator()
		{
			currentIndex = -1;
			currentlyNode = getNextChain();
		}
		
		//method to get next bucket from the dictionary
		private Node<K,V> getNextChain()
		{
			while((currentlyNode == null) && (currentIndex < hashTable.length -1))
			{
				currentIndex ++;
				currentlyNode = hashTable[currentIndex];
			}
			
		
			return currentlyNode;
		}

		// method to see if the node has a next node
		public boolean hasNext()
		{
			return currentlyNode != null;
		}
		
		//method to return the next value
		public V next()
		{
			V result = null;
			
			// checks to see if there is any next
			if(hasNext())
			{
				// get value from the node
				result = currentlyNode.getValue();
				currentlyNode = currentlyNode.getNextNode();	
			
			
				if(currentlyNode == null)
				{
					currentlyNode = getNextChain();
				}
			}
			
			else
			{
				throw new NoSuchElementException();
			}
			
			return result;
		}

		// method to remove key from iterator
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}
}