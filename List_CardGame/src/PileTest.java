/*
 * Name:Jaime Trejo
 * Date:2/22/14
 * 			This Pile Test class will test all the methods I created in Pile. I checked all theses methods a lot
 * 			some of the methods took me days to figure them out. But I'm glad I kept testing and testing.
 */

public class PileTest
{
	static Card[] cards = new Card[52];
	
	public static void main(String[] args)
	{
		String[] SUITS ={"Spade", "Club", "Heart", "Diamond"};
		String[] FACES = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
		
		Pile myPile = new Pile();
		
		// checks to see if myPile is empty
		System.out.println("Testing isEmpty on myPile before adding");
		System.out.println("--------------------------------------");
		System.out.println("Output: " + myPile.isEmpty());
		
		
		//will set myPile, sets them backwards to set them in order (for now)
		for( int i = 51; i >= 0;i--)
		{
			int suitsIndex = i/13;
			String suitText = SUITS[suitsIndex];
				
				
			int facesIndex = i % 13; 
			String faceText = FACES[facesIndex];
			
    		
			cards[i] = new Card(faceText,suitText,null,null);
			myPile.addFirst(cards[i]);   
				
		}

		
		// checks to see if myPile is empty
		System.out.println("\nTesting isEmpty on myPile after adding");
		System.out.println("--------------------------------------");
		System.out.println("Output: " + myPile.isEmpty());
		
		// gets the value of cards in myPile
		System.out.println("\nThe the number of cards in my pile");
		System.out.println("----------------------------------");
		System.out.println(myPile.getNumberOfCards());
		
		//gets the topCard and bottomCard
		System.out.println("\nTesting getFirst and getLast on myPile");
		System.out.println("--------------------------------------");
		System.out.println("topCard is: " + myPile.getFirst());
		System.out.println("bottomCard is: " + myPile.getLast());
		
		//output for pile
		System.out.println("\nOutput of myPile using toString");
		System.out.println("-------------------------------");
		System.out.println(myPile);

		//output after sorting
		System.out.println("\nOutput of myPile using toString after sorting");
		System.out.println("-------------------------------");
		myPile.sort(myPile);
		System.out.println(myPile);
		
		//output for shuffle
		myPile.shuffle(cards,myPile); // shuffles
		System.out.println("\nOutput of myPile using toString after shuffling");
		System.out.println("-------------------------------------------------");
		System.out.println(myPile);
		
		
		
		// removing cards cards[0] to card[48]
		for(int i = 0; i < 49;i++)
		{
			myPile.remove(cards[i]);
		}
		
		// gets the value of cards in myPile after removing
		System.out.println("\nThe the number of cards in my pile after removal of cards[0] to card[48]");
		System.out.println("----------------------------------");
		System.out.println(myPile.getNumberOfCards());
		
		//output after shuffling 
		myPile.shuffle(cards,myPile); // shuffles
		System.out.println("\nOutput of myPile using toString after shuffling, after removal of cards[0] to card[48]");
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println(myPile);
		
		System.out.println("\nTesting getFirst and getLast on myPile after shuffling");
		System.out.println("--------------------------------------------------------");
		System.out.println("topCard is: " + myPile.getFirst());
		System.out.println("bottomCard is: " + myPile.getLast());
		
		//output after sorting
		System.out.println("\nOutput of myPile using toString after sorting cards[49] to cards[51]");
		System.out.println("----------------------------------------------------------------------");
		myPile.sort(myPile);
		System.out.println(myPile);
		
		System.out.println("\nTesting getFirst and getLast on myPile after sorting");
		System.out.println("------------------------------------------------------");
		System.out.println("topCard is: " + myPile.getFirst());
		System.out.println("bottomCard is: " + myPile.getLast());
		
		
		// test using search setting topCard(which is myPile.getFirst(), and looking for A of Diamond
		System.out.println("\nTesting search method, checking if myPile contains 3 of Club");
		System.out.println("-----------------------------------------------------------");
		System.out.println("Return: " + myPile.search(myPile.getFirst(),"3 of Club"));
		
		// Returns true if there is a 3 of Diamond, false otherwise
		System.out.println("\nTesting contains, checking if myPile contains 8 of Diamond");
		System.out.println("-----------------------------------------------------------");
		System.out.println("Return: " + myPile.contains("8 of Diamond"));
		
		System.out.println("\n                                            Output for prev and next for cards");
		//Output for prev and next for " + cards[i]
		for(int i = 0; i <52;i++)
		{
			System.out.println("\nOutput for prev and next for cards["+i+"]" + " which its value is: " + cards[i]);
			System.out.println("----------------------------------------");
			System.out.println("Previous: " + myPile.getPrev(cards[i]));
			System.out.println("Next: " + myPile.getNext(cards[i]));
		}
			
		System.out.println("\n                                             Output for hasPrev and hasNext for cards");
		//Output for if hasPrev and hasNext for " + cards[i]
		for(int i = 0; i <52;i++)
		{
			System.out.println("\nOutput for hasPrev and hasNext for cards["+i+"]" + " which its value is: " + cards[i]);
			System.out.println("----------------------------------------");
			System.out.println("Previous: " + myPile.hasPrev(cards[i]));
			System.out.println("Next: " + myPile.hasNext(cards[i]));
		}
	
		
		System.out.println("\nRemoving cards[49],cards[50]");
		myPile.remove(cards[49]);
		myPile.remove(cards[50]);
		System.out.println("testing getPrev and getNext for cards[51] is " +cards[51]+" after removing the cards above");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("Prev: " +myPile.getPrev(cards[51]));
		System.out.println("Next: " +myPile.getNext(cards[51]));
		
		
		
		// removing all the rest of the cards
		for(int i = 51; i < 52;i++)
		{
			myPile.remove(cards[i]);
		}
		
		System.out.println("\nOutput of my pile after all cards removed");
		System.out.println("----------------------------------------");
		System.out.println("Nothing follows: " +myPile);
		System.out.println("Number of cards: " +myPile.getNumberOfCards());
		
		for(int i = 0; i < 52;i++)
		{
			System.out.println("\nNext after all cards removed, for card["+i+"]: "+myPile.getNext(cards[i]));
			System.out.println("Previous after all cards removed, for card["+i+"]: "+myPile.getPrev(cards[i]));
		}
	}

}
