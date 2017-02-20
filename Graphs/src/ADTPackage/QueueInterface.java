/*
 * Name:Jaime Trejo
 * Date:4/8/14
 * 		This interface contains the methods for a Queue ADT
 * 
 */

package ADTPackage;

public interface QueueInterface<T>
{
	//Adds a new entry to the back of the queue, newEntry will be the entry added to the back
	public void enqueue(T newEntry);
	
	//removes and returns the value of the front of the queue. 
	//returns null if empty, otherwise it returns the value
	public T dequeue();
	
	//retrieves the queues' front entry, w/o changing queue
	//returns null if empty, otherwise it retrieves the front entry
	public T getFront();
	
	//detects if the queue is empty, returns true if empty, false otherwise
	public boolean isEmpty();
	
	//removes all entries from queue
	public void clear();
}