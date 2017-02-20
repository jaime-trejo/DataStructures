/*
 * Name:Jaime Trejo
 * Date:4/8/14
 * 		This interface contains the methods for a priority queue
 * 
 */

package ADTPackage;

public interface PriorityQueueInterface<T>
{

	// Adds a new entry to this priority queue.
	public void add(T newEntry, int priority);
	
	// Removes and returns the item with the highest priority.Returns priority queue is empty before the operation, null 
	public T remove();
	
	// Retrieves the item with the highest priority.either the object with the highest priority or, if the
	//priority queue is empty, null 
	public T peek();
	
	// Detects whether this priority queue is empty. returns true if empty, false otherwise
	public boolean isEmpty();
	
	// retrieves the size of the priority queue
	public int getSize();
	
	// Removes all entries from this priority queue 
	public void clear();
}
