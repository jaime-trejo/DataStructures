/*
 * Name:Jaime Trejo
 * Date:2/27/14
 * 			This is the Deck test it will test methods that are in the deck class.
 */
public class DeckTest
{
	
	public static void main(String[] args)
	{
		Deck myDeck = new Deck();
		
		// displays the cards in the deck
		myDeck.display();
		
		//displays the sorted deck
		myDeck.sort();
		
		//displays the shuffled cards in the deck
		myDeck.shuffle();
		
		
		//displays the cards in the deck
		myDeck.cardCount();
		
		//System.out.println(""+myDeck.drawFromDeck());
		//System.out.println(""+myDeck.drawFromDeck());
		
		System.out.println("\nDealing 5 cards from the deck they are the following:");
		System.out.println("-----------------------------------------------------");
		
		// draws 5 cards
		for(int i = 0;i<5;i++)
		{
			myDeck.deal();
		}
		
		
		// shows the card count after dealing 5 cards from deck
		myDeck.cardCount();
	}
		

}
