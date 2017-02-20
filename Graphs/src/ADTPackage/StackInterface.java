/*
 * Name:Jaime Trejo
 * Date:4/8/14
 * 		This interface contains the methods for a Stack ADT
 * 
 */

package ADTPackage;

public interface StackInterface<T>
{
	//adds a new entry to the top of the stack
	public void push(T newEntry);
	
	//Removes and returns the stack's top entry, if stack is empty it will return null
	public T pop();
	
	//Retrieves the top entry of the stack, returns top entry if stack not empty, null otherwise
	public T peek();
	
	//Finds out if the stack is empty or not, returns true if it is, false otherwise
	public boolean isEmpty();
	
	// removes all entries from the stack
	public void clear();
}
