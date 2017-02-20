/*
 * Name:Jaime Trejo
 * Date:3/31/14
 * 			This class will have the methods for the tree interface
 */


public interface TreeInterface<T>
{
	// returns the value of the root
	public T getRootData();
	
	// returns the number of levels that are in the tree
	public int getHeight();
	
	// returns the number of nodes in the tree
	public int getNumberOfNodes();
	
	// returns true if the tree is empty, false otherwise
	public boolean isEmpty();
	
	// clears the entries in the tree
	public void clear();
	
}
