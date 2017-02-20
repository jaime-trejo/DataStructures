/*
 * Name:Jaime Trejo
 * Date:4/8/14
 * 		This interface contains the methods for a List ADT
 * 
 */

package ADTPackage;

public interface ListInterface<T>
{
   //Adds a new entry to the end of this list. The list's size is increased by 1.
   public void add(T newEntry);
   
   /* Adds a new entry at a specified position within this list.
       Entries originally at and above the specified position
       are at the next higher position within the list.
       The list'ss size is increased by 1.
      	true if the addition is successful, or
               false if newPosition < 1*/
   public boolean add(int newPosition, T newEntry);
   
   // Removes the entry at a given position from this list.
   public T remove(int givenPosition);
   
   //Removes all entries from this list. 
   public void clear();
   
   //Replaces the entry at a given position in this list.Returns true if the replacement occurs, or false if either the
   //list is empty, 
   public boolean replace(int givenPosition, T newEntry);
   
   /* Retrieves the entry at a given position in this list.
      Returns a reference to the indicated entry or null, if either
               the list is empty, givenPosition < 1, or
               givenPosition > getLength() */
   public T getEntry(int givenPosition);
   
   //Sees whether this list contains a given entry. Return true if the list contains anEntry, or false if not 
   	public boolean contains(T anEntry);
   
   	//returns the number of entries in the list
    public int getLength();
       
    //Sees whether this list is empty. returns true if the list is empty,false otherwise
    public boolean isEmpty();
       
    //Retrieves all entries that are in this list in the order in which they occur in the list. 
    public T[] toArray();   
}