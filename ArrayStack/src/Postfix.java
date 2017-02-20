/*
 *  Name:Jaime Trejo
 *  Date: 1/26/14
 *  	The following will be the Postfix class where I have methods that check for precedence, convert to postfix
 *  	and evaluate the postfix value.  Convert to Postfix will accept the infix expression.
 *
 * 		Contains a restriction if you divide by zero.
 * 
 * 		Will not allow the user to start with an operator.
 * 
 */

public class Postfix
{
		// calculate the value of the postfix expression 
		public Integer evaluatePostfix(String postfix)
		{
			
			StackInterface<Integer> valuestack = new ArrayStack<Integer>();
			
			int characterCount = postfix.length();
			
			int index =0;
			char nextCharacter = ' ';
			Integer operandTwo,operandOne,result;
			
			for(;index <characterCount;index++)
				
			{	
				nextCharacter = postfix.charAt(index);
				
			
				switch(nextCharacter)
				{
				case'+':
					operandTwo = valuestack.pop();
					operandOne = valuestack.pop();
					result = operandOne+operandTwo;
					valuestack.push(result);
					break;
					case'-':
					operandTwo = valuestack.pop();
					operandOne = valuestack.pop();
					result = operandOne-operandTwo;
					valuestack.push(result);
					break;
				case'*':
					operandTwo = valuestack.pop();
					operandOne = valuestack.pop();
					result = operandOne*operandTwo;
					valuestack.push(result);
					break;
				case'/':
					operandTwo = valuestack.pop();
					operandOne = valuestack.pop();
					// will not allow user to divide by 0
						if(operandTwo == 0)
						{
							System.out.println("You can't divide by zero.Program will now end.");
							System.exit(0);
						}
						else
						{
							result = operandOne/operandTwo;
							valuestack.push(result);
						}
						
					break;
				case'^':
					operandTwo = valuestack.pop();
					operandOne = valuestack.pop();
					result = operandOne^operandTwo;
					valuestack.push(result);
					break;
					default:
						String nextChar = postfix.substring(index,index+1);
						valuestack.push(Integer.parseInt(nextChar));
						break;
				}
				
			}
			return valuestack.peek(); 
			
		}
		
		
		// will figure out what the precedence for each operator, lowest to highest precedence
		public int getPrecedence(char operator)
		{
			switch(operator)
			{
			case '(':
			case')':
				return 0;
			case'+':
			case'-':
				return 1;
			case'*':
			case'/':
				return 2;
			case'^':
				return 3;
			}
			return -1;
			
		}
		
		 	/*converts an infix expression to postfix, following the infix to postfix conversion method
	 
	 		Operand -  Append each operand to the end of the output expression.
	 
	 		Operator ^ - Push ^ onto the stack.
	 
	 		Operator +, -, *, or /  - Pop operators from the stack, appending them to the output
	 		expression, until the stack is empty or its top entry has a lower
	 		precedence than the new operator. Then push the new operator onto the stack.
	 
	 		Open parenthesis - Push ( onto the stack.
	 
	 		Close parenthesis - Pop operators from the stack and append them to the output
	 		expression until*/
		 
		public String convertToPostfix(String infix)
		{
			
			StringBuilder postfix = new StringBuilder();
			
			StackInterface<Character> operatorStack = new ArrayStack<Character>();
			int characterCount = infix.length();
			
			char topOperator = ' ',nextCharacter = ' ';
			int index = 0;
			
			for (;index < characterCount; index++)
			{
				boolean done = false;
				
				nextCharacter = infix.charAt(index);
				
				// will not allow the user to start an expression with the given operator
				if(index == 0 && (nextCharacter == '+' || nextCharacter == '-' ||
					nextCharacter == '*' || nextCharacter == '/' || nextCharacter == '^' || nextCharacter ==')'))
				{
					System.out.println("You can't start the expression with +,-,*,/,),or ^ .");
					System.out.println("The calculator will close.");
					System.exit(0);
				}
	
				if(isVariable(nextCharacter))
				{
					postfix = postfix.append(nextCharacter);
				}
				else
				{
					switch(nextCharacter)
					{
					//push onto the stack
					case '^': 
						operatorStack.push(nextCharacter);
					break;
				
					// pop operators from stack,appends to output expression
					//until stack is empty or top has lower precedence
					case '+': case'-': case'*': case '/':
						while(!done && !operatorStack.isEmpty())
						{
							topOperator = operatorStack.peek();
						
							if(getPrecedence(nextCharacter) <= getPrecedence(topOperator))
							{
								postfix = postfix.append(topOperator);
								operatorStack.pop();
							}
							else
							{
								done = true; 
							}
						}
						operatorStack.push(nextCharacter);
						break;
						
					//push onto the stack
					case '(':
						operatorStack.push(nextCharacter);
						break;
					//pop operators from the stack, output expressions until you pop an open parentheses
					// then remove both parentheses
					case ')':
						topOperator = operatorStack.pop();
						while(topOperator != '(')
						{
							postfix = postfix.append(topOperator);
							topOperator = operatorStack.pop();
						}
						break;
						default:
							postfix = postfix.append(nextCharacter);
							break;
					}
				}
			}
			while(!operatorStack.isEmpty())
			{
				topOperator = operatorStack.pop();
				postfix = postfix.append(topOperator);
			}
			
			return postfix.toString();
			
		}
		
		// Will check if it's a letter if so then it will return true and that value, it not false
		public boolean isVariable(char character)
		{
			return Character.isLetter(character);
		}
		
}
