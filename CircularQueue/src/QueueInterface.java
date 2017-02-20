/*
 *  Name:Jaime Trejo
 *  Date: 2/3/14
 *  	The following will be the interface for the queue. It will have the methods that have to be implemented
 *  	in the CircularArrayQueue
 */
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
