/*
 * Name:Jaime Trejo
 * Date:2/27/14
 * 			This is the Deck class it extends from Pile. 
 * 			It will have deal,sort,shuffle,display and cardCount method.
 */

import java.util.ArrayList;
import java.util.Random;


public class Deck extends Pile
{
	
	static Card[] cards = new Card[52];
	static Pile newPile = new Pile();
	
	public Deck()
	{
		
			String[] SUITS ={"Spade", "Club", "Heart", "Diamond"};
			String[] FACES = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
			
			//will set myPile, sets them backwards to set them in order (for now)
			for( int i = 51; i >= 0;i--)
			{
				int suitsIndex = i/13;
				String suitText = SUITS[suitsIndex];
					
					
				int facesIndex = i % 13; 
				String faceText = FACES[facesIndex];
				
	    		
				cards[i] = new Card(faceText,suitText,null,null);
				newPile.addFirst(cards[i]);   
					
			}		
	}
	
	// draws a card from the deck
	public Card drawFromDeck(Pile l)
	{
		//System.out.println();// test while building method
		//Random generator = new Random();
		int index= 0;
		Card temp = cards[index];
		int size = 52-1;
		
		
		// created this so it removes the random number i already used
    	ArrayList<Integer> number = new ArrayList<Integer>(size);
        for(int i = 0; i <= size; i++)
        {
            number.add(i);
            
            //System.out.println(list.get(i));// used to test
        }
        
         Random random = new Random();
        
         int Select = random.nextInt(number.size());
         //Select = random.nextInt(number.size());
         index = Select;
         
         // these are used to test my method (used while finalizing)
        // System.out.println(index);
         //System.out.println(number.get(Select));
         
         
         String cardSuitAndFace = cards[Select].toString();
        
         // these are used to test my method (used while finalizing)
         //System.out.println("Suit and face" +cardSuitAndFace);
         // System.out.println(newPile.contains(cardSuitAndFace));
         
         if((newPile.contains(cardSuitAndFace) == false))
         { 
        	 drawFromDeck(newPile);// calls the method again if the pile does not contain a specific card
        	
         }
         else{
        	 //System.out.println(index);// test while building method
             //System.out.println(number.get(Select));// test while building method
             temp = cards[index];
             //System.out.println("Drawing: " +temp);// test while building method
             number.remove(Select);
     	    newPile.remove(cards[index]);
     	    }
         if(number.size() < 0)
         {
        	 System.out.println("Can't deal anymore cards");
        	 System.exit(0);
         }
         
         
		return temp;
		
	}

	// deals the card
	public void deal()
	{
		System.out.println(drawFromDeck(newPile));
	    
	}
	
	// shuffles the deck of card
	public void shuffle()
	{
		shuffle(cards,newPile);
		System.out.println("\nThe shuffled cards are");
		System.out.println("----------------------");
		System.out.println(newPile);
	}
	
	
	// displays the cards in the deck
	public void display()
	{
		System.out.println("The cards are");
		System.out.println("-------------");
		System.out.println(newPile);
	}

	// displays the number of cards in the deck
	public void cardCount()
	{
		System.out.println("\nThe card count in deck is");
		System.out.println("-----------------------------");
		System.out.println(newPile.getNumberOfCards());
	}
	
	// sorts the cards in the deck
	public void sort()
	{
		sort(newPile);
		System.out.println("\nThe sorted cards are");
		System.out.println("-------------------");
		System.out.println(newPile);
	}
}
