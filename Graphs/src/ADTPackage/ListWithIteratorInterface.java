/*
 * Name:Jaime Trejo
 * Date:4/8/14
 * 		This interface contains the methods from ListInterface and method getIterator
 * 
 */

package ADTPackage;

import java.util.Iterator;

public interface ListWithIteratorInterface<T> extends ListInterface<T>
{
	public Iterator<T> getIterator();
}