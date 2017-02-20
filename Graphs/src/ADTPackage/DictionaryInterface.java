/* Name:Jaime Trejo
 * Date:4/10/14
 * 			This will be the interface for the dictionary
 */
package ADTPackage;
import java.util.Iterator;

public interface DictionaryInterface<K, V>
{
	//Adds a new entry into the dictionary, replaces the value if it already exits
	//return either null if the new entry was added to the dictionary or the value that was associated with key if that value
	//was replaced 
	public V add(K key,V value);
	
	//removes a specific entry from the dictionary, returns either the value that belonged to the key or null
	//if not found
	public V remove(K key);
	
	// returns the value associated with the key given, return either the value or null if it does not exist
	public V getValue(K key);
	
	//Sees whether a specific entry is in this dictionary. return true if key is associated with an entry in the
	//dictionary false otherwise
	public boolean contains(K key);
	
	// removes all entries from the dictionary
	public void clear();
	
	// returns true if the dictionary is Empty false otherwise
	public boolean isEmpty();
	
	// returns the size(number of entries of keys-value) in the dictionary
	public int getSize();
	
	// creates an iterator that traverses all keys in the dictionary
	public Iterator<K> getKeyIterator();
	
	// creates an iterator that traverses all values in the dictionary
	public Iterator<V> getValueIterator();

}
