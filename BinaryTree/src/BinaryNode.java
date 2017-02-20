/*
 * Name:Jaime Trejo
 * Date:4/2/14
 * 			This class will be for the BinaryNode, it will implement BinaryNodeInterface<T>
 * 			and will have bodies for the methods.
 * 
 * 			Want to hide the node from clients of the binary tree, along with BinaryNodeInterface, and omit its access modifier.
 *
 */


class BinaryNode<T> implements BinaryNodeInterface<T>
{

	private T data;
	private BinaryNode<T> left;
	private BinaryNode<T> right;
	
	// default constructor
	public BinaryNode()
	{
		this(null);// calls the next constructor
	}
	
	// overloaded constructor
	public BinaryNode(T dataPortion)
	{
		this(dataPortion,null,null);
	}
	
	public BinaryNode(T dataPortion, BinaryNode<T> leftChild, BinaryNode<T> rightChild)
	{
		data = dataPortion;
		left = leftChild;
		right = rightChild;
		
	}

	
	// mutator methods
	
	//Sets the data portion of this node.
	public void setData(T newData)
	{
		data = newData;
	}

	//Sets this node�s left child to a given node. 
	public void setLeftChild(BinaryNodeInterface<T> leftChild)
	{
		left = (BinaryNode<T>) leftChild;
	}

	//Sets this node�s right child to a given node.
	public void setRightChild(BinaryNodeInterface<T> rightChild)
	{
		right = (BinaryNode<T>) rightChild;
	}

	// boolean methods
	
	//Detects whether this node has a left child, true if has left,false otherwise
	public boolean hasLeftChild()
	{
		return left!= null;
	}

	//Detects whether this node has a right child, true if has right, false otherwise
	public boolean hasRightChild()
	{
		return right!=null;
	}

	//Detects whether this node is a leaf, true if leaf, false otherwise
	public boolean isLeaf()
	{
		return (left == null) && (right == null);
	}

	// accessor methods
	
	//Retrieves the data portion of this node.
	public T getData()
	{
		return data;
	}
	
	//Retrieves the left child of this node.Return the node that is this node's left child
	public BinaryNodeInterface<T> getLeftChild()
	{
		return left;
	}

	//Retrieves the right child of this node.Return the node that is this node's right child
	public BinaryNodeInterface<T> getRightChild()
	{
		return right;
	}
	
	//Counts the nodes in the subtree rooted at this node
	public int getNumberOfNodes()
	{
		int leftNumber = 0;
		int rightNumber = 0;
		
		if (left != null)
		{
			leftNumber = left.getNumberOfNodes();
		}
		
		if (right != null)
		{
			rightNumber = right.getNumberOfNodes();
		}
		
		return 1 + leftNumber + rightNumber;
	}

	//Computes the height of the subtree rooted at this node.
	public int getHeight()
	{
		return getHeight(this); // call private getHeight
	} 
	
	private int getHeight(BinaryNode<T> node)
	{
		int height = 0;
		if (node != null)
		{
			height = 1 + Math.max(getHeight(node.left),getHeight(node.right));
		}
		
		return height;
	}

	// copy method
	
	//Copies the subtree rooted at this node.
	//return the root of a copy of the subtree rooted at this node
	public BinaryNodeInterface<T> copy()
	{
		BinaryNode<T> newRoot = new BinaryNode<T>(data);
		
		if (left != null)
		{
			newRoot.left = (BinaryNode<T>)left.copy();
		}
		
		if (right != null)
		{
			newRoot.right = (BinaryNode<T>)right.copy();
		}
		
		return newRoot;
	}

	
}
