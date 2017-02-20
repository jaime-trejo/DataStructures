/* Name:Jaime Trejo
 * Date:3/25/14
 * 			This class will focus on counting the number of keys and values
 */

import java.util.Iterator;
import java.util.Scanner;

public class WordCounter
{
	public DictionaryInterface<String, Integer> wordTable;

	// default constructor
	public WordCounter() 
    {
       wordTable = new SeparateChainHashDictionary<String, Integer>();
       
    }

   //Reads a text file of words and counts 
	public void readFile(Scanner data)
	{
	   data.useDelimiter("\\W+");
	   
	   while (data.hasNext())
	   {
	      String nextWord = data.next();
	      nextWord = nextWord.toLowerCase();
	      Integer count = wordTable.getValue(nextWord);

	      if (count == null)
	      { 
	    	 // add new word to table
	         wordTable.add(nextWord, new Integer(1));
	      }
	      
	      else
	      { 
	    	  // increment count of existing word; replace wordTable entry
	          count++;
	         wordTable.add(nextWord, count);
	      } 
	   } 

	   data.close();
	} 

   // displays words and count
   public void display()
   {
      Iterator<String> keyIterator = wordTable.getKeyIterator();
      Iterator<Integer> valueIterator = wordTable.getValueIterator();
      
      //displays what the file contains
      System.out.println("The file read contains the following keys and its value of appearance");
      System.out.println("----------------------------------------------------------------------");
      
      while (keyIterator.hasNext()&& valueIterator.hasNext())
      {
    	  System.out.println("Key: " + keyIterator.next() + "    Value(Count): " + valueIterator.next());
      }
      
      //displays the hash table as is
      System.out.println("\nThe hash table looks like the following");
      System.out.println("---------------------------------------");
      ((SeparateChainHashDictionary<String, Integer>) wordTable).display();
      
   } 
} 

