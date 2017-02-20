/*
 * Name:Jaime Trejo
 * Date:3/3/14
 * 			This class will test the Hand class. It will show the display of two hands.
 */

public class HandTest
{
	
	public static void main(String[] args)
	{
		Hand hand = new Hand();
		
		System.out.println("This is the first hand");
		System.out.println("---------------------");
		hand.displayHandOne();
		
		System.out.println("\nThis is the second hand");
		System.out.println("---------------------");
		hand.displayHandTwo();

	}

}
