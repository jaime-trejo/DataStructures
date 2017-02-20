/*
 * Name:Jaime Trejo
 * Date:2/18/14
 * 			The following tests all the methods I created in the card class. The cards will be an an array of size 52.
 */

public class CardTest
{
	static Card[] card = new Card[52]; // created an array that will hold 52 cards
	
	public static void main(String[] args)
	{
		
		
		String[] SUITS ={"Spade", "Club", "Heart", "Diamond"};
		String[] FACES = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "H", "A"};
		
		System.out.println("Testing with for loop input and for loop toString printout");
		System.out.println("---------------------------------------------------------");
		
		for( int i = 0; i < 52;i++)
		{
			int suitsIndex = i/13;
			String suitText = SUITS[suitsIndex];
				
				
			int facesIndex = i % 13; 
			String faceText = FACES[facesIndex];
			
			card[i] = new Card(faceText,suitText);
				
		}
		
		
		// testing differently
		System.out.println("\n                               Testing with input");
		System.out.println("------------------");
		card[0] = new Card("2","Spade");// face will be two
		card[1] = new Card("3","Diamond");// face will be three
		
		
		System.out.println("Testing getFace");
		System.out.println("---------------");
		System.out.println("The face for card[0] is: " + card[0].getFace());
		
		System.out.println("\nTesting getSuit");
		System.out.println("---------------");
		System.out.println("The suit for card[1] is: " +card[1].getSuit());
		
		// sets the next node to this node
		card[0].setNext(card[1]);
		//sets the previous node to this node
		card[1].setPrevious(card[0]);
		
		// print out the values after setting cards to one another
		System.out.println("\nUsing getNext and getPrevious (after setting nodes)");
		System.out.println("-----------------------------------------------------------------");
		System.out.println("getNext for card[0]: " + card[0].getNext());
		System.out.println("getPrevious for card[1]: " + card[1].getPrevious());
		
		//toString method output
		System.out.println("\nTesting toString");
		System.out.println("---------------");
		System.out.println("Output for card[0] is: " + card[0]);
		System.out.println("Output for card[1] is: " + card[1]);
		
		// calls the compared method
		Compared();
		
		
		card[2] = new Card("4","Club",card[1],card[3]);
		card[3] = new Card("10","Diamond",card[2],null);
		
		// testing toString
		System.out.println("\nTesting toString");
		System.out.println("---------------");
		System.out.println("Output for card[3] is: " + card[3]);
		
		// print out the values after setting cards to one another
		System.out.println("\nUsing getNext and getPrevious (after setting nodes)");
		System.out.println("-----------------------------------------------------------------");
		System.out.println("getPrevious for card[2]: " + card[2].getPrevious());
		System.out.println("getNext for card[3]: " + card[3].getNext());
		System.out.println("getPrevious for card[3]: " + card[3].getPrevious());
		
	}
	
	public static void Compared()
	{
		//testing compareTo
		
		System.out.println("\nTesting compareTo between card[0] and card[1]");
		System.out.println("---------------------------------------------");
		System.out.println("card[0]: " + card[0]);
		System.out.println("card[1]: " + card[1]);
		System.out.println("compareTo returns: " + card[0].compareTo(card[1]));
		
		if(card[0].compareTo(card[1]) == 1)
		{
			
			System.out.println(card[0] + " is greater than " + card[1]);
		}
		
		else if(card[0].compareTo(card[1]) == 2)
		{
			System.out.println(card[0] + " is less than " + card[1]);
		}
		
		else if(card[0].compareTo(card[1]) == -1)
		{
			System.out.println(card[0] + " is equal to " + card[1]);
		}
		
		else
		{
			System.out.println("Not Valid");
		}
	}
	
}
