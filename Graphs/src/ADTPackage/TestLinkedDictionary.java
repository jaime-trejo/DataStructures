/* Name:Jaime Trejo
 * Date:4/11/14
 * 			This class will will create an object and test methods of LinkedDictionary<K,V>
 */

package ADTPackage;

public class TestLinkedDictionary
{

	public static void main(String[] args) 
	{
		DictionaryInterface<String,String> testDictionary = new LinkedDictionary<String,String>();
		System.out.println("is  testDictionary empty?: " +testDictionary.isEmpty());
		testDictionary.add("h", "a");
		testDictionary.add("r", "z");
		System.out.println("is  testDictionary empty?:  " + testDictionary.isEmpty());
		System.out.println("Removed \'r' having value: "+ testDictionary.remove("r"));
		System.out.println("Size: " +testDictionary.getSize());
		System.out.println("Contains (h)?: "+ testDictionary.contains("h"));
		System.out.println("Contains (r)?: "+testDictionary.contains("r"));
	}

}
