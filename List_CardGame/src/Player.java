/*
 * Name:Jaime Trejo
 * Date:3/4/14
 * 			This is the player class. It will have methods for two players. Sets scores and names. Also asks for user input.
 */

import java.util.*;

public class Player
{
	Scanner keyboard = new Scanner(System.in);
	protected int playerScore = 0;
	String playerName;
	static Hand hand;
	
	//default constructor
	public Player()
	{
		System.out.println("Please enter the name of the player:");
		playerName = keyboard.nextLine();
		playerScore = 0;
	}
	
	//mutators
	public void setPlayerName(String newPlayerName)
	{
		playerName = newPlayerName;
	}
	
	//accessors
	
	public String getPlayerName()
	{
		return playerName;
	}
	
	
	public int getPlayerScore()
	{
		return playerScore;
	}
	
	
	
	// will print out the name of the players and scores
	public String toString()
	{
		return "Player one name: " + getPlayerName() + "\nPlayer one score: " + getPlayerScore();
	}
	
	public void showPlayerHandOne()
	{	
		hand = new Hand();
		System.out.println("\n" +getPlayerName() + "'s hand is");
		System.out.println("----------------------------");
		hand.displayHandOne();
	}
	
	public void showPlayerHandTwo()
	{	
		hand = new Hand();
		System.out.println("\n" +getPlayerName() + "'s hand is");
		System.out.println("----------------------------");
		hand.displayHandTwo();
	}
	
	
}
