/*
 * Name:Jaime Trejo
 * Date:3/3/14
 * 			This Hand class will extend from Pile. It will put cards into a hand.
 */

public class Hand extends Pile
{
	protected Card[] hand = new Card[8];
	Pile newPile;
	
    public Hand()
	{
    	newPile = new Pile();
		Deck deck = new Deck();
		
		// will hold 8 cards
		for(int i = 0; i < 8; i++)
		{
			hand[i] = deck.drawFromDeck(newPile);
		}
    }
    
    // displays the cards the first hand 4 cards
    public void displayHandOne()
    {
    	for(int i = 0; i < 4;i++)
    	{
    		System.out.println(hand[i]);
    	}
    }
    
    // displays the cards in the second hand the other 4 cards
    public void displayHandTwo()
    {
    	for(int i = 4; i < 8;i++)
    	{
    		System.out.println(hand[i]);
    	}
    }

}
