/* Name:Jaime Trejo
 * Date:3/25/14
 * 			This will be a test class for some of the methods in the SeperateChainHashDictionary Test
 * 
 * 			Testing my class as a telephone directory.
 */

import java.util.Iterator;

public class SeparateChainHashDictTest
{

	public static void main(String[] args)
	{
		//create a dictionary
		DictionaryInterface<String,String> telephoneDirectory = new SeparateChainHashDictionary<String,String>();
	
		// test to see if telephoneDirectory is empty
		System.out.println("Testing isEmpty()");
		System.out.println("-----------------");
		System.out.println("isEmpty?: " + telephoneDirectory.isEmpty());
		
		// test to see the size
		System.out.println("\nTesting getSize()");
		System.out.println("-----------------");
		System.out.println("telephoneDirectory size: " + telephoneDirectory.getSize());
		
		System.out.println("\nAdding four names with phone numbers");
		System.out.println("-------------------------------------");
		telephoneDirectory.add("Jimmy Page", "567-4356");
		telephoneDirectory.add("Ritchie Blackmore","789-3214");
		telephoneDirectory.add("Jimi Hendrix","674-2321");
		telephoneDirectory.add("Uli Jon Roth", "231-4214");
		System.out.println("telephoneDirectory size: " + telephoneDirectory.getSize());
		
		//tests the display static method
		System.out.println("\nDisplay the four entries I added using static method");
		System.out.println("------------------------------------------------------");
		display(telephoneDirectory);
		
		// tests the display method inside the SeparteChainHashDictionary class
		System.out.println("\nDisplay the telephoneDirectory using .display()");
		System.out.println("-------------------------------------------------");
		((SeparateChainHashDictionary<String, String>) telephoneDirectory).display();
		
		// tests to see if the telephoneDirectory contains values
		System.out.println("\nTesting contains");
		System.out.println("----------------");
		System.out.println("Is \"Jason Becker\" in telephoneDirectory? " + telephoneDirectory.contains("Jason Becker"));
		System.out.println("Is \"Jimi Hendrix\" in telephoneDirectory? " + telephoneDirectory.contains("Jimi Hendrix"));
		
		// tests to see what values the following keys contain
		// the value for Jason Becker should be null because it is not in telephoneDirectory
		System.out.println("\nTesting getValue()");
		System.out.println("------------------");
		System.out.println("The value \"Jimi Hendrix\" contains is: " + telephoneDirectory.getValue("Jimi Hendrix"));
		System.out.println("The value \"Jason Becker\" contains is: " + telephoneDirectory.getValue("Jason Becker"));
		
		//testing remove
		System.out.println("\nTesting remove()");
		System.out.println("----------------");
		System.out.println("Removing \"Jimi Hendrix\" which contained the value " + telephoneDirectory.remove("Jimi Hendrix"));
		
		//output the size
		System.out.println("\nAfter removing \"Jimi Hendrix\" the size is now");
		System.out.println("--------------------------------------------------");
		System.out.println("telephoneDirectory size: " + telephoneDirectory.getSize());
		
		//testing clear
		System.out.println("\nTesting clear() after removing all the size is");
		System.out.println("---------------------------------------------");
		telephoneDirectory.clear();
		System.out.println("telephoneDirectory size: " + telephoneDirectory.getSize());
		
		// testing isEmpty
		System.out.println("\nTesting isEmpty()");
		System.out.println("-----------------");
		System.out.println("isEmpty?: " + telephoneDirectory.isEmpty());
		
		
	}
	
	// display method with parameter
	public static void display(DictionaryInterface<String,String>  telephoneDirectory)
	{
		Iterator<String> keyIterator = telephoneDirectory.getKeyIterator();
		Iterator<String> valueIterator = telephoneDirectory.getValueIterator();
		
		while(keyIterator.hasNext() && valueIterator.hasNext())
		{
			System.out.println("Key:" + keyIterator.next() + " Value:" + valueIterator.next());
			
		}

	}
	
}
