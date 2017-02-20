/*
 * Name:Jaime Trejo
 * Date:4/3/14
 * 			This class will focus on creating an object and testing the methods that are givin in 
 * 			the TwoDimensionBinaryTree<T> class
 */

import java.awt.Point;

public class DimensionBinTreeTest
{

	public static void main(String[] args)
	{
		TwoDimensionBinaryTree<Point> twoDTree = new TwoDimensionBinaryTree<Point>();
		
		//tests is empty
		System.out.println("Testing isEmpty on empty tree");
		System.out.println("-----------------------------");
		System.out.println(twoDTree.isEmpty());
		
		// add points (50, 40), (40, 70), (80, 20), (90, 10), and (60, 30)
		twoDTree.addPoint(new Point(50,40));
		twoDTree.addPoint(new Point(40,70));
		twoDTree.addPoint(new Point(80,20));
		twoDTree.addPoint(new Point(90,10));
		twoDTree.addPoint(new Point(60,30));
		
		// tests is empty
		System.out.println("\nTesting isEmpty after adding 5 points");
		System.out.println("-------------------------------------");
		System.out.println(twoDTree.isEmpty());
		
		// testing contains
		System.out.println("\nTesting the points I added to the twoDTree((50, 40), (40, 70), (80, 20), (90, 10), and (60, 30))");
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.println("Does 2D tree contain (50,40): " + twoDTree.contains(new Point(50,40)));
		System.out.println("Does 2D tree contain (40,70): " + twoDTree.contains(new Point(40,70)));
		System.out.println("Does 2D tree contain (80,20): " + twoDTree.contains(new Point(80,20)));
		System.out.println("Does 2D tree contain (90,10): " + twoDTree.contains(new Point(90,10)));
		System.out.println("Does 2D tree contain (60,30): " + twoDTree.contains(new Point(60,30)));
		
		// gets the tree's root
		System.out.println("\nTesting getRootData (should be the point (50,40))");
		System.out.println("----------------------------------------------------");
		System.out.println(twoDTree.getRootData());
		
		
		//tests a point that is not in the tree
		System.out.println("\nTesting a point that is not in the twoDTree");
		System.out.println("---------------------------------------");
		System.out.println("Does 2D tree contain (50,50): " + twoDTree.contains(new Point(50,50)));
		
		// height
		System.out.println("\nTesting getHeight on the twoDTree");
		System.out.println("-------------------------------");
		System.out.println(twoDTree.getHeight());
		
		//  number of nodes
		System.out.println("\nTesting getNumberOfNodes on twoDTree");
		System.out.println("--------------------------------------");
		System.out.println(twoDTree.getNumberOfNodes());
		
		//traverses in order
		System.out.println("\nPrinting out the points by inOrderTraversal");
		System.out.println("-------------------------------------------");
		twoDTree.inorderTraverse();
		
		//traverses preorder
		System.out.println("\nPrinting out the points by preOrderTraversal");
		System.out.println("-------------------------------------------");
		twoDTree.preorderTraverse();
		
		//test isEmpty
		System.out.println("\nTesting isEmpty after using clear() on twoDTree");
		System.out.println("----------------------------------------------");
		twoDTree.clear();// clears the tree
		System.out.println(twoDTree.isEmpty());
		
		// gets the tree's root
		System.out.println("\nTesting getRootData (Should be null since I cleared the tree)");
		System.out.println("---------------------------------------------------------------");
		System.out.println(twoDTree.getRootData());
		
		
	}
}
