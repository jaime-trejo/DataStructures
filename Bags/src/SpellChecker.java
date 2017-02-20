/*
 *  Name:Jaime Trejo
 *  Date: 1/18/14
 *  	SpellChecker class will read from an external file and hold methods.
 *    
 */

import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;

public class SpellChecker 
{
	//creates an object dictionary
	BagInterface<String> dictionary = new LinkedBag<String>();
	
	
	// method checks against spelling of a word
	public void checkAgainstDictionary() throws IOException
	{
		String fileName = "mispelledFoodDictionary.txt"; // holds the name that will be loaded
		Scanner inputStream = null;
		
		// will output what the file contains
		System.out.println("The file " + fileName + " contains the following words: ");
		System.out.println("-------------------------------------------------------");
		
		try
		{
			inputStream = new Scanner(new File(fileName));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error opening the file " + fileName);
			System.exit(0);
		}
		
		while(inputStream.hasNextLine())
		{
			String line = inputStream.nextLine();
			System.out.print(line + ", ");
		}	
		
		// will output the words that are misspelled, after comparing against dictionary and file
		System.out.println("");
		System.out.println("\nList of misspelled words in the file after comparing it against the correct dictionary are: ");
		System.out.println("-----------------------------------------");
		
		try
		{
			inputStream = new Scanner(new File(fileName));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error opening the file " + fileName);
			System.exit(0);
		}
		
		while(inputStream.hasNext())
		{
			String word = inputStream.next();
			
			if(!dictionary.contains(word))
			{
				System.out.print(word + ", ");
			}
		}
		// will output the words that are correctly spelled, after comparing against dictionary and file
		System.out.println("");
		System.out.println("\nList of correctly spelled words in the file after comparing it against the correct dictionary are:");
		System.out.println("-----------------------------------------");
		try
		{
			inputStream = new Scanner(new File(fileName));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error opening the file " + fileName);
			System.exit(0);
		}
		
		while(inputStream.hasNext())
		{
			String word = inputStream.next();
			
			if(dictionary.contains(word))
			{
				System.out.print(word + ", ");
			}
		}
		
	}
	
	//builds the default constructor
	public SpellChecker()
	{
		String[] contentsOfBag = {"pasta", "pizza", "hamburger", "hotdog", "fries"};
		testAdd(dictionary, contentsOfBag);
		
	}
	
	public void testAdd(BagInterface<String> dictionary, String[] content)
	{
		
		for (int index = 0; index < content.length; index++)
		{
			dictionary.add(content[index]);
            //System.out.print(content[index] + " "); tester, to see what it adds
		} 
		//System.out.println("\n");
		displayBag(dictionary); // calls display bag to show correct dictionary
      
	} 
	
	// method to displayBag
	public void displayBag(BagInterface<String> dictionary)
	{
		System.out.println("The correct dictionary has " + dictionary.getCurrentSize() + " items which are:");
		System.out.println("---------------------------------------------------------------------------------");
		Object[] bagArray = dictionary.toArray();
		for (int index = 0; index < bagArray.length; index++)
		{
			System.out.print(bagArray[index] + ", ");
		} 
		System.out.println("\n"); // prints empty line
	}

}
