/*
 * Name:Jaime Trejo
 * Date:4/1/14
 * 			This will contain methods for the interface BinaryNodeInterface<T>
 *
 */

interface BinaryNodeInterface<T>
{

	//Retrieves the data portion of this node.
	public T getData();
	
	//Sets the data portion of this node
	public void setData(T newData);
	
	//Retrieves the left child of this node
	public BinaryNodeInterface<T> getLeftChild();
	
	//Retrieves the right child of this node
	public BinaryNodeInterface<T> getRightChild();
	
	//Sets this node?s left child to a given node
	public void setLeftChild(BinaryNodeInterface<T> leftChild);
	
	//Sets this node?s right child to a given node
	public void setRightChild(BinaryNodeInterface<T> rightChild);
	
	//Detects whether this node has a left child, true if has left,false otherwise
	public boolean hasLeftChild();
	
	//Detects whether this node has a right child, true if has right, false otherwise
	public boolean hasRightChild();
	
	//Detects whether this node is a leaf, true if leaf, false otherwise
	public boolean isLeaf();
	
	//Counts the nodes in the subtree rooted at this node
	public int getNumberOfNodes();
	
	//Computes the height of the subtree rooted at this node.
	public int getHeight();
	
	//Copies the subtree rooted at this node.
	//return the root of a copy of the subtree rooted at this node
	public BinaryNodeInterface<T> copy();
	
}
