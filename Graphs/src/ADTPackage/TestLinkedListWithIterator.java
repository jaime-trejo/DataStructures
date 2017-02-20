/* Name:Jaime Trejo
 * Date:4/11/14
 * 			This class will will create an object and test methods of LinkedListWithIterator<T>
 * 
 */

package ADTPackage;

import java.util.Iterator;


public class TestLinkedListWithIterator
{

	public static void main(String[] args)
	{
		ListWithIteratorInterface<String> testListWIterator =  new LinkedListWithIterator<String>();
		System.out.println("is testListWIterator empty?: " +testListWIterator.isEmpty());
		testListWIterator.add("A");
		System.out.println("is testListWIterator empty(after adding)?: " +testListWIterator.isEmpty());
		System.out.println("Does testListWIterator contain \'A'?: "+ testListWIterator.contains("A"));
		System.out.println("Does testListWIterator contain \'B'?: "+ testListWIterator.contains("B"));
		System.out.println("size of testListWIterator: " + testListWIterator.getLength());
		testListWIterator.add(1,"C");
		System.out.println("size of testListWIterator: " + testListWIterator.getLength());
		System.out.println("getEntry after adding (1,'C'): " +testListWIterator.getEntry(1));
		System.out.println("removing: " + testListWIterator.remove(1));
		
		// display what it has
		display(testListWIterator);
		
		testListWIterator.clear();
		System.out.println("size of testListWIterator after clearing: " + testListWIterator.getLength());
	}

	// display method with parameter
	public static void display(ListWithIteratorInterface<String>  list)
	{
		Iterator<String> keyIterator = list.getIterator();
		
		
		while(keyIterator.hasNext())
		{
			System.out.println("Entry:" + keyIterator.next());
			
		}
		
	}
}
