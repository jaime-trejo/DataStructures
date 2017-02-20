/*
 *  Name:Jaime Trejo
 *  Date: 2/7/14
 *  	The following will be the implementation of the circular array queue(all locations used)
 *  
 *  	There will be a counter for when things get added and removed.
 */

public class CircularArrayQueue<T> implements QueueInterface<T>
{
	private T[] queue; // circular array of queue entries
	private int frontIndex;
	private int backIndex;
	private int count = 0;// will keep the count to check later to see if the queue is empty or full
	
	private static final int DEFAULT_INITIAL_CAPACITY = 7;
	
	// default constructor
	public CircularArrayQueue()
	{
		this(DEFAULT_INITIAL_CAPACITY);
	}
	
	// overloaded constructor
	public CircularArrayQueue(int initialCapacity)
	{
		// the cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempQueue = (T[]) new Object[initialCapacity + 1];
		queue = tempQueue;
		frontIndex = 0;
		backIndex = initialCapacity;	
	}
	
	//detects if the queue is empty, returns true if empty, false otherwise
	public boolean isEmpty()
	{
		return (count == 0); // if the count is zero then the queue is empty
	}
	
	// detects if the queue is full, returns true if fill, false otherwise
	public boolean isFull()
	{
		return (count == queue.length -1);
	}

	//Adds a new entry to the back of the queue, newEntry will be the entry added to the back
	// increases the count
	public void enqueue(T newEntry)
	{
		ensureCapacity();
		backIndex = (backIndex + 1) % queue.length;
		queue[backIndex] = newEntry;
		count++;
	}

	//removes and returns the value of the front of the queue. 
	//returns null if empty, otherwise it returns the value
	// decreases the count whenever an element is removed
	public T dequeue()
	{
		T front = null;
		if(!isEmpty())
		{
			front = queue[frontIndex];
			queue[frontIndex] = null;
			frontIndex = (frontIndex + 1) % queue.length;
			count --;
		}
		return front;
	}

	//retrieves the queues' front entry, w/o changing queue
	//returns null if empty, otherwise it retrieves the front entry
	public T getFront()
	{
		T front = null;
		if(!isEmpty())
		{
			front = queue[frontIndex];
		}
		return front;
	}

	//removes all entries from queue
	public void clear()
	{
		while (!isEmpty())
		{
			dequeue();
		}
	}

	// Doubles the size of the array queue if it is full
	private void ensureCapacity()
	{
		// checks to see if the array is full, if it is then it will double the size
		if(isFull())
		{
			T[] oldQueue = queue;
			int oldSize = oldQueue.length;
			
			// the cast is safe because the new array contains null entries
			@SuppressWarnings("unchecked")
			T[] tempQueue = (T[]) new Object[2 * oldSize];
			queue = tempQueue;
			
			for (int index = 0; index < oldSize - 1; index++)
			{
				queue[index] = oldQueue[frontIndex];
				frontIndex = (frontIndex + 1) % oldSize;
			} 
			
			frontIndex = 0;
			backIndex = oldSize - 2;
		}
	}
}
