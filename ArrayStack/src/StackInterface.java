/*
 *  Name:Jaime Trejo
 *  Date: 1/26/14
 *  	The following will be the interface for the stack. It will have the methods that have to be implemented
 *  	in the ArrayStack<T> class
 */

public interface StackInterface<T>
{
	//adds a new entry to the top of the stack
	public void push(T newEntry);
	
	//Removes and returns the stack's top entry, if stack is empty it will return null
	public T pop();
	
	// removes all entries from the stack
	public void clear();
	
	//Finds out if the stack is empty or not, returns true if it is, false otherwise
	public boolean isEmpty();
	
	//Retrieves the top entry of the stack, returns top entry if stack not empty, null otherwise
	public T peek();

}
