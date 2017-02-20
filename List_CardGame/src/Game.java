/*
 * Name:Jaime Trejo
 * Date:3/7/14
 * 			This is the game class it will have instances of the other previous classes I created.
 * 
 * 			Was not able to work out the game like I wanted. SO i just displayed basic stuff. 
 */

public class Game
{
	//Pile newPile = new Pile();
	static Deck deck = new Deck();
	//Hand hand = new Hand();
	Player player1;
	Player player2;
	
	Game()
	{
		
		//shows the deck
		deck.display();
		
		//shuffles the deck
		deck.shuffle();
		
		//asks for two players
		System.out.println("\nPlayer input");
		System.out.println("-----------");
		player1 = new Player();
		player2 = new Player();
		
		
		// displays info of player 1
		System.out.println("\nInformation of player1");
		System.out.println("---------------------");
		System.out.println(player1);
		
		// displays info of player 2
		System.out.println("\nInformation of player2");
		System.out.println("---------------------");
		System.out.println(player2);
		
		player1.showPlayerHandOne();
		player2.showPlayerHandTwo();
	}
	
	
}
