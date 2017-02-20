/*
 * Name:Jaime Trejo
 * Date:3/4/14
 * 			This is the player test it will run and display the methods in the Player class.
 */

public class PlayerTest
{

	public static void main(String[] args)
	{
		Player player1 = new Player();
		Player player2 = new Player();
		
		System.out.println("\nTesting toString for Players names and score (user input)");
		System.out.println("-------------------------------------------");
		System.out.println(player1);
		
		System.out.println("\nTesting toString for Players names and score (user input)");
		System.out.println("-------------------------------------------");
		System.out.println(player2);
		
		player1.setPlayerName("Mike");
		player2.setPlayerName("Steve");
		System.out.println("\nTesting toString for Players names and score after setting names(with mutators)");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println(player1);
		System.out.println(player2);
		
		player1.showPlayerHandOne();
		player2.showPlayerHandTwo();
	}

}
