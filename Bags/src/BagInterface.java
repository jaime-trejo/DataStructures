/*
 *  Name:Jaime Trejo
 *  Date: 1/18/14
 *  	The following will be an interface that describes the objects in a bag. 
 */

public interface BagInterface<T>
{
	// Checks to see if the bag is full or not. Returns true if it's full, false if not.
	public boolean isFull();
	
	// Checks to see if the bag is empty or not. Returns true if it's empty, false if not.
	public boolean isEmpty();

	// Gets and returns the number of entries the bag contains.
	public int getCurrentSize();
	
	//Counts and returns the number of times a specific anEntry appears in the bag.
	public int getFrequencyOf(T anEntry);
	
	//removes all entries of the bag
	public void clear();
	
	//removes an unspecified entry from bag, returns the entry that was removed or null if successful 
	public T remove();
	
	//removes one occurrence of the entry given, returns true if removed occurred, false otherwise
	public boolean remove(T anEntry);
	
	//Adds a given newEntry to the bag, true if added into the bag, false otherwise
	public boolean add(T newEntry);
	
	//Tests to see if the given anEntry is located in the bag, true if it's in the bag,false otherwise
	public boolean contains(T anEntry);
	
	//creates an array of all the items that are in the bag
	public T[] toArray();
	
}
