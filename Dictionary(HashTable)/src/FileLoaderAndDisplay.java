/* Name:Jaime Trejo
 * Date:3/25/14
 * 			This class will focus on loading the "Data.txt" file I created
 *
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileLoaderAndDisplay
{
   public static void main(String[] args) 
   {
      WordCounter wordCount = new WordCounter();   
      
      // will hold the name of the file that will be loaded
      String fileName = "Data.txt"; 

      try
      {
         Scanner data = new Scanner(new File(fileName));
        
         wordCount.readFile(data);
      }
      
      // if the file is not found it will display a message
      catch (FileNotFoundException e)
      {
         System.out.println("File not found: " + e.getMessage());
      }
      
      // will display a message
      catch (@SuppressWarnings("hiding") IOException e)
      {
         System.out.println("I/O error " + e.getMessage());
      }

      wordCount.display();
      
   } 
} 
