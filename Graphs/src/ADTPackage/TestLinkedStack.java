/* Name:Jaime Trejo
 * Date:4/11/14
 * 			This class will will create an object and test methods of LinkedStack<T>
 * 
 */
package ADTPackage;

public class TestLinkedStack
{
	public static void main(String[] args)
	{
		StackInterface<String> testStack = new LinkedStack<String>();
		System.out.println("is testStack empty?: "+ testStack.isEmpty());
		testStack.push("A");
		testStack.push("B");
		testStack.push("C");
		System.out.println("is testStack empty?: "+ testStack.isEmpty());
		System.out.println("topNode is: " + testStack.peek());
		System.out.println("poppinng topNode: " + testStack.pop());
		System.out.println("topNode is: " + testStack.peek());
		testStack.clear();
		System.out.println("After using clear(),topNode is: " + testStack.peek());	
	}

}
