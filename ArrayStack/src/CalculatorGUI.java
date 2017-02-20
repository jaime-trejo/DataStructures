/*
 *  Name:Jaime Trejo
 *  Date: 1/25/14
 *  	The following will be the CalculatorGUI where I will be setting everything for the Calculator GUI.
 *  	It will implement ActionListener. Also, I will load the specific packages for creating a GUI
 *  
 *  	Will have a restriction if divide by zero, but that will be in the postfix class.
 *  
 *  	Will not allow the user to start an expression with +,-,^,*, or divide. Restriction in Postfix Class.
 *  
 *  	Backspace will delete the previous number. Also clear(C) will clear it all.
 *  
 *  	There is no doubles in this calculator. Values will be in integer. Set in Postfix class
 *  	For example:
 *  	 1/2 = 0
 *  	 7/2 = 3 
 * 
 * 
 *  
 *  	Use the mouse to click on the keys.
 *  
 *  	Rules:
 *  	Enter infix expression by clicking the buttons, after you're done entering the infix expression click the equals button.
 *  	After you get a result press clear(C) if you want to enter another.
 *  
 *  	Only good for infix expressions.
 *  	Does not accept double digit variables like 10+2, would give you 2 instead of 12.
 *  	For example if you enter (9+3)*2 you will get 25.
 *  
 *		The calculator has a display and a keypad of 20 keys, which are arranged as follows
 *			C < Q /
 *			7 8 9 *
 *			4 5 6 -
 *			1 2 3 +
 *			0 ( ) =
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CalculatorGUI implements ActionListener
{
	String expression = new String(); // declare a new string called expression
	
	int index = 0; // declare a int variable called index and initiate it to 0
	
	// create the display screen 
	JFrame windowScreen = new JFrame("Calculator GUI"); 
	
	// create variable names for each key
	JButton clear,backspace,quit,divide,seven,eight,nine,multiply,four,five,six,subtract,
	one,two,three,addition,zero,openParen,closeParen,equal;
	
	JTextField display = new JTextField(20);
	
	// create the JPanels for the upper display for text fields and lower display for keys
	JPanel upper = new JPanel();
	JPanel lower = new JPanel();
	
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		
		// if user clicks clear then it will clear the display
		if(source == clear)
		{
			expression = new String();
			display.setText(" ");
		}
		
		// if user clicks quit then it will prompt the user
		if(source == quit)
		{
			int option = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Exit",
					JOptionPane.YES_NO_OPTION);
			
			if(option == JOptionPane.YES_OPTION)
			{
				System.exit(0);
			}
		}
		
		// if user clicks zero then it will appear on display,function for zero
		if(source == zero)
		{
			expression +="0";
			display.setText(expression);
		}
		// if user clicks one then it will appear on display,function for one
		if(source == one)
		{
			expression +="1";
			display.setText(expression);
		}
		
		// if user clicks two then it will appear on display,function for two
		if(source == two)
		{
			expression +="2";
			display.setText(expression);
		}
		// if user clicks three then it will appear on display,function three
		if(source == three)
		{
			expression +="3";
			display.setText(expression);
		}
		// if user clicks four then it will appear on display,function four
		if(source == four)
		{
			expression +="4";
			display.setText(expression);
		}
		// if user clicks five then it will appear on display,function five
		if(source == five)
		{
			expression +="5";
			display.setText(expression);
		}
		// if user clicks six then it will appear on display,function six
		if(source == six)
		{
			expression +="6";
			display.setText(expression);
		}
		// if user clicks seven then it will appear on display,function seven
		if(source == seven)
		{
			expression +="7";
			display.setText(expression);
		}
		// if user clicks eight then it will appear on display,function eight
		if(source == eight)
		{
			expression +="8";
			display.setText(expression);
		}
		// if user clicks nine then it will appear on display,function nine
		if(source == nine)
		{
			expression +="9";
			display.setText(expression);
		}
		
		
		// if user clicks multiply then it will appear on display,function multiply
		if(source == multiply)
		{
			expression +="*";
			display.setText(expression);
		}
		// if user clicks divide then it will appear on display,function divide
		if(source == divide)
		{
			expression +="/";
			display.setText(expression);
		}
		// if user clicks addition then it will appear on display,function addition
		if(source == addition)
		{
			expression +="+";
			display.setText(expression);
		}
		// if user clicks subtraction then it will appear on display,function subtraction
		if(source == subtract)
		{
			expression +="-";
			display.setText(expression);
		}
		
		// if user clicks ( then it will appear on display,function for openParen
		if(source == openParen)
		{
			expression +="(";
			display.setText(expression);
		}
		// if user clicks ) then it will appear on display,function for closeParen
		if(source == closeParen)
		{
			expression +=")";
			display.setText(expression);
		}
		// if user clicks backspace then it will appear on display,function for backspace
		// will remove last item from expression
		if(source == backspace)
		{
			String expression2 = display.getText();
			String expression3 = expression2.substring(0,expression2.length()-1);
			expression = expression3;
			display.setText(expression);
		}
		
		// if user clicks equals then it will evaluate the expression
		if(source == equal)
		{
			ArrayStack<String> tester = new ArrayStack<String>();
			String postfix;
			postfix = tester.convertToPostfix(expression);
			String evaluate = "" + tester.evaluatePostfix(postfix);
			expression = evaluate;
			display.setText(expression);
		}
	}

	// default constructor
	public CalculatorGUI()
	{
	
		// set the screen
		windowScreen.setLayout( new FlowLayout());
		windowScreen.setResizable(false);
		windowScreen.setLocation(625,250);
		windowScreen.setSize(350, 350);
		windowScreen.setVisible(true);
		windowScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// add the text field to the upper area and add the upper to the screen
		upper.add(display);
		windowScreen.add(upper);
			
		// set the layout for lower , the keys in 4 columns
		lower.setLayout( new GridLayout(0,4));
		
		/* set the buttons in the lower panel
		
		The calculator has a display and a keypad of 20 keys, which are arranged as follows:
			C < Q /
			7 8 9 *
			4 5 6 -
			1 2 3 +
			0 ( ) =
		 
		 */
		
		lower.add(clear = new JButton("C")); // add the clear button
		lower.add(backspace= new JButton("<")); // add the backspace button
		lower.add(quit = new JButton("Q")); // add the quit button
		lower.add(divide = new JButton("/"));// add the divide button
		lower.add(seven = new JButton("7"));// add the seven button
		lower.add(eight = new JButton("8"));// add the eight button
		lower.add(nine = new JButton("9"));// add the nine button
		lower.add(multiply = new JButton("*"));// add the multiply button
		lower.add(four = new JButton("4"));// add the four button
		lower.add(five = new JButton("5"));// add the five button
		lower.add(six = new JButton("6"));// add the six button
		lower.add(subtract = new JButton("-"));// add the subtract button
		lower.add(one = new JButton("1"));// add the one button
		lower.add(two = new JButton("2"));// add the two button
		lower.add(three = new JButton("3")); // add the three button
		lower.add(addition = new JButton("+"));// add the addition button
		lower.add(zero = new JButton("0"));// add the zero button
		lower.add(openParen= new JButton("("));// add the open parentheses button
		lower.add(closeParen = new JButton(")"));// add the close parentheses button
		lower.add(equal = new JButton("="));// add the equal button
		
		// add lower panel to frame
		windowScreen.add(lower);
		
		//set the action listeners for each button so action can take place
		clear.addActionListener((ActionListener)this);
		backspace.addActionListener((ActionListener)this);
		quit.addActionListener((ActionListener)this);
		divide.addActionListener((ActionListener)this);
		seven.addActionListener((ActionListener)this);
		eight.addActionListener((ActionListener)this);
		nine.addActionListener((ActionListener)this);
		multiply.addActionListener((ActionListener)this);
		four.addActionListener((ActionListener)this);
		five.addActionListener((ActionListener)this);
		six.addActionListener((ActionListener)this);
		subtract.addActionListener((ActionListener)this);
		one.addActionListener((ActionListener)this);
		two.addActionListener((ActionListener)this);
		three.addActionListener((ActionListener)this);
		addition.addActionListener((ActionListener)this);
		zero.addActionListener((ActionListener)this);
		openParen.addActionListener((ActionListener)this);
		closeParen.addActionListener((ActionListener)this);
		equal.addActionListener((ActionListener)this);
		
		
	}

	
}
