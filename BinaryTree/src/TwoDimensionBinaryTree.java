/*
 * Name:Jaime Trejo
 * Date:4/2/14
 * 		
 * 			This class will be a 2d binary search tree. It will implement TreeInterface<T> since it has methods
 * 			that all trees must have. 
 * 			
 * 			For this class I extend Point so I can try to represent a point in a x,y coordinate plane.
 * 			I got some basic information from 
 * 			http://pic.dhe.ibm.com/infocenter/adiehelp/v5r1m1/index.jsp?topic=%2Fcom.sun.api.doc%2Fjava%2Fawt%2FPoint.html
 *
 * 
 * 			Every node contains and represents a k-dimensional point.
 */


import java.awt.Point;

public class TwoDimensionBinaryTree<T extends Point> implements TreeInterface<T>
{
	private BinaryNodeInterface<T> root;

	// default constructor
	public TwoDimensionBinaryTree()
	{
		root = null;
	}
	
	// overloaded constructor
	public TwoDimensionBinaryTree(T rootData)
	{
		root = new BinaryNode<T>(rootData);
	}
	
	public TwoDimensionBinaryTree(T rootData,TwoDimensionBinaryTree<T> leftTree,TwoDimensionBinaryTree<T> rightTree)
	{
		privateSetTree(rootData,leftTree,rightTree);
	}
	
	// mutators
	
	// mutator method to set tree to 
	public void setTree(T rootData)
	{
		root = new BinaryNode<T>(rootData);
	}
	
	public void setTree(T rootData,TreeInterface<T> leftTree,TreeInterface<T> rightTree)
	{
		privateSetTree(rootData,(TwoDimensionBinaryTree<T>)leftTree,(TwoDimensionBinaryTree<T>)rightTree);
	}
	
	
	
	// method which sets root and left, right tree for 2d tree
	private void privateSetTree(T rootData,TwoDimensionBinaryTree<T> leftTree, TwoDimensionBinaryTree<T> rightTree)
	{
		root = new BinaryNode<T>(rootData);
		
		// check if left sub tree is not empty
		if((leftTree !=null) && !leftTree.isEmpty())
		{
			root.setLeftChild(leftTree.root);
			
		}
		
		// check if the right sub tree is not empty
		
		if((rightTree !=null) && !rightTree.isEmpty())
		{
			// check if the left tree is not equal to right
			if(rightTree!=leftTree)
			{
				root.setRightChild(rightTree.root);
			}
			
			else
			{
				root.setRightChild(rightTree.root.copy());
				
			}
		}
		
		if((leftTree!=null)&&(leftTree !=this))
		{
			leftTree.clear();
		}
		
		if((rightTree!=null)&&(rightTree!=this))
		{
			rightTree.clear();
		}
		
	}
	
	protected void setRootData(T rootData)
	{
		root.setData(rootData);
	}
	
	protected void setRootNode(BinaryNodeInterface<T> rootNode)
	{
		root = rootNode;
	}
	
	//accessors
		
	// returns the value of the root
	public T getRootData()
	{
		T rootData = null;
		
			if (root != null)
			{
				rootData = root.getData();
			}
		return rootData;
	}


	// returns the number of levels that are in the tree
	public int getHeight()
	{
		return root.getHeight();
	}

	
	// returns the number of nodes in the tree
	public int getNumberOfNodes()
	{
		
		return root.getNumberOfNodes();
	}

	
	// method to return rootNode
	protected BinaryNodeInterface<T> getRootNode()
	{
		return root;
	}
	
	// boolean method
	
	
	// returns true if the tree is empty, false otherwise
	public boolean isEmpty()
	{
		return root == null;
	}

	
	
	
	// void methods
	
	// clears the entries in the tree
	public void clear()
	{
		root = null;
	}

	
	// method for inOrdertraverse inorder
	//traversal, for example, visits all nodes in the root�s left subtree, then visits the root, and finally visits
	//all nodes in the root�s right subtree.
	
	public void inorderTraverse()
	{
		inorderTraverse(root);
	}
	
	private void inorderTraverse(BinaryNodeInterface<T> node)
	{
		if (node != null)
		{
			inorderTraverse(node.getLeftChild());
			System.out.println(node.getData());
			inorderTraverse(node.getRightChild());
		} 
	} 
	
	// method for preOrdertraverse preorder
	//traversal, for example, visits all nodes in the root , then visits the left, and finally visits
	//all nodes in the roots right subtree.
	public void preorderTraverse()
	{
		preorderTraverse(root);
	} 
	
	private void preorderTraverse(BinaryNodeInterface<T> node)
	{
		if (node != null)
		{
			System.out.println(node.getData());
			preorderTraverse(node.getLeftChild());
			preorderTraverse(node.getRightChild());
		} 
	}
	
	// adds new point to tree
	public void addPoint(T entry)
	{
		int level = 0; // initializes the levels that are in the tree
		
		
		//node which stores the root
		BinaryNodeInterface<T> currentNode = getRootNode();
		
		// if the tree is empty
		if(currentNode == null)
		{
			// create new node and set it to root
			setRootNode(new BinaryNode<T>(entry,null,null));
		}
		
		// If the tree is not empty then it will do the following
		else
		{
			boolean locationFound = false;
			
			// while the location is not found then it will do the following
			while(locationFound != true)
			{
				if(level%2==0)
				{
					// check if the X cord of entry is greater than the x cord of currentNode
					if(entry.getX() > currentNode.getData().getX())
					{
						// checks if currentNode has rightChild
						if(currentNode.getRightChild() !=null)
						{
							// move to the right
							currentNode = currentNode.getRightChild();
						}
						
						// if no rightChild then it does the following
						else
						{
							BinaryNode<T> tempNode = new BinaryNode<T>(entry,null,null);
								
							// set tempNode as rightChild
							currentNode.setRightChild(tempNode);
							
							locationFound = true;
						}
					}
						
					// check if the X cord of entry is less than the x cord of currentNode
					else
					{
						// checks to see if the currentNode has a left
						if(currentNode.getLeftChild() !=null)
						{
							currentNode = currentNode.getLeftChild();
						}
						
						// if no left child then it will do th efollowing
						else
						{
							BinaryNode<T> tempNode = new BinaryNode<T>(entry,null,null);
									
							currentNode.setLeftChild(tempNode);
									
							locationFound = true;
						}
						
					}
							
							level++;
				}
						
				// if the level is odd
				else
				{
					// check if the Y cord of entry is greater than the Y cord of currentNode
					if(entry.getY() > currentNode.getData().getY())
					{
						
						// if there is a right then it will do the following
						if(currentNode.getRightChild() !=null)
						{
							// move to right tree
							currentNode = currentNode.getRightChild();
						}
								
						// if no rightChild then it will do the following
						else
						{
							BinaryNode<T> tempNode = new BinaryNode<T>(entry,null,null);
									
							//set as rightChild
							currentNode.setRightChild(tempNode);
									
							locationFound = true;
						}
							
					}
							
					// checks if y cord of entry is less than y cord of entry
					else
					{
						// check if has leftChild
						if(currentNode.getLeftChild() !=null)
						{
							currentNode = currentNode.getLeftChild();
						}
									
						//if no leftChild then it will do the following
						else
						{
							BinaryNode<T> tempNode = new BinaryNode<T>(entry,null,null);
										
							currentNode.setLeftChild(tempNode);
										
							locationFound = true;
						}
						
					}
								
					level++;
						
				}
			}
		}
	
	}
	
	// this method will test if a given point is located within the tree
	public boolean contains(T anEntry)
	{
		int level = 0; // level of tree
		
		
		BinaryNodeInterface<T> currNode = getRootNode();
		
		boolean found = false;
		
		// while node not found and currNode empty
		while(found == false && currNode !=null)
		{
			// check if data is equal to anEntry
			if(currNode.getData().equals(anEntry))
			{
				found = true;
				break;
			}
			
			if(level %2 == 0)
			{
				// check if the X cord of entry is greater than the x cord of currNode
				if(anEntry.getX() > currNode.getData().getX())
				{
					currNode = currNode.getRightChild();
				}
				
				else
				{
					currNode = currNode.getLeftChild();
				}
				
				level++;
			}
			
			else
			{
				// check if the Y cord of entry is greater than the Y cord of currNode
				if(anEntry.getY() > currNode.getData().getY())
				{
					// move to right
					currNode = currNode.getRightChild();
				}
				
				else
				{
					currNode = currNode.getLeftChild();
				}
				
				level++;
			}
		}
		
		return found;
	}
}
