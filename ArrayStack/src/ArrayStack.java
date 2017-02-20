/*
 *  Name:Jaime Trejo
 *  Date: 1/26/14
 *  	The following will be the the ArrayStack<T> class it will implement StackInterface<T> and 
 *  	have bodies for all the methods and have methods of its own that will be used.
 *  
 *  	Extends from Postfix class so it can have all the methods Postfix contains
 *  	so I'm able to call convertToPostfix and evaluatePostfix when I call it with 
 *  	a type of ArrayStack
 */

import java.util.Arrays;

public class ArrayStack<T> extends Postfix implements StackInterface<T>
{
	private T[] stack;// an array of stack entries
	private int topIndex; // holds the index of the top entry in the stack
	private static final int DEFAULT_INITIAL_CAPACITY = 50; // sets the capacity to 50
	
	// default constructor
	 ArrayStack()
	 {
	      this(DEFAULT_INITIAL_CAPACITY);
	 } 
	 
	 // overloaded constructor
	@SuppressWarnings("unchecked")
	ArrayStack(int initialCapacity)
	 {
	       // the cast is safe because the new array contains null entries
	      T[] tempStack = (T[])new Object[initialCapacity];
	      stack = tempStack;
	      topIndex = -1;
	 }
	      
	//checks to see if the array is big enough by calling ensureCapacity if not then it does what it's supposed to do
	//adds a new entry to the top of the stack
	public void push(T newEntry)
	{
		ensureCapacity();
		topIndex++;
		stack[topIndex] = newEntry;

	}

	//Removes and returns the stack's top entry, if stack is empty it will return null
	public T pop()
	{
		T top = peek();
		
		if(!isEmpty())
		{
			stack[topIndex] = null;
			topIndex--;
		}
		return top;
	}

	// removes all entries from the stack
	public void clear()
	{
		while(!isEmpty())
		{
			pop();
		}
	}

	//Finds out if the stack is empty or not, returns true if it is, false otherwise
	public boolean isEmpty()
	{
		return topIndex < 0;
	}

	//Retrieves the top entry of the stack, returns top entry if stack not empty, null otherwise
	public T peek()
	{
		T top = null;
		if(!isEmpty())
		{
			top = stack[topIndex];
		}
		return top;
	}

	// checks to see if the array is big enough, if not it then increases the size of the arrar
	private void ensureCapacity()
	{
		if(topIndex == stack.length -1)
		{
			stack = Arrays.copyOf(stack,2*stack.length);
		}
		
	}
	
}
