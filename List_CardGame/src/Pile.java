/*
 * Name:Jaime Trejo
 * Date:2/20/14
 * 			This pile class is somewhat similar to a doubly linked list.
 * 
 */

import java.util.Arrays;
import java.util.Collections;

public class Pile
{
	protected int numberOfCards;
	protected Card topCard,bottomCard;
	
	
	public Pile()
	{
		clear();
		topCard = new Card(null,null,null,null);
		bottomCard = new Card(null,null,topCard,null);
		topCard.setNext(bottomCard); // make topCard and bottomCard point to each other
		bottomCard.setPrevious(topCard);// make bottomCard and topCard point to each other
	}
	

	// Recursively searches a chain of cards for desiredFaceAndSuit,
	// beginning with the node that currentNode references.
	// search method is default
	 boolean search(Card currentCard, String desiredFaceSuit)
	 {
		boolean found;
		if (currentCard == null)
		{
			found = false;
		}
		else if (desiredFaceSuit.equalsIgnoreCase(currentCard.toString()) )
		{
			found = true;
		}
		else
		{
			found = search(currentCard.getNext(), desiredFaceSuit);
		}
		return found;
	 }
	 
	 
	
	// checks if a chain of cards contains the specific entry given
	public boolean contains(String aEntry)
	{
		return search(topCard,aEntry);
	}
	
	// will sort cards by suit order, club,diamond,hear,suits, in order of 2-A
	 public void sort(Pile L) 
	 {
		    if (L.getNumberOfCards() <= 1) 
		    {
		    	return; // L is already sorted in this case
		    }
		    Card pivot; // pivot node 
		    Card ins;  // insertion point 
		    Card end = L.getFirst(); // end of run
		    
		    while (end != L.getLast())
		    {
		      pivot = end.getNext(); // get the next pivot node
		      L.remove(pivot);  // remove it
		      ins = end;  // start searching from the end of the sorted run
		    
		      while (L.hasPrev(ins) && (ins.getSuit().compareTo(pivot.getSuit()) > 0))
		      {
		        ins = ins.getPrevious(); // move left
		      }
		      L.addAfter(ins,pivot); // add the pivot back, after insertion point
		      
		      if (ins == end)  // we just added pivot after end in this case
		      {
		        end = end.getNext(); // so increment the end marker
		      }
		      
		    }
	 }
	 
	// returns whether the list is empty 
	public boolean isEmpty()
	{
		return (numberOfCards == 0);
	}
	
	// accessors
	
	//Returns whether a given node has a previous node 
	  public boolean hasPrev(Card card)
	  { 
		  return card != topCard;
	  }
	  
	  // Returns whether a given node has a next node 
	  public boolean hasNext(Card card)
	  { 
		  return card != topCard; 
	  }
	  
	// gets the size
	public int getNumberOfCards()
	{
		return numberOfCards;
	}
	// returns the node after the given, card error if card is bottomCard
	public Card getNext(Card card)
	{
		if(card == bottomCard)
		{
			System.out.println("Cannot move past the bottomCard");
		}
		
		return card.getNext();
	}
	
	// returns the node before the given, card error if car is topCard
	public Card getPrev(Card card) 
	{
		if(card == topCard)
		{
			System.out.println("Cannot move past the topCard");
		}
		return card.getPrevious();
	}
	
	//returns the first card of the list
	public Card getFirst() throws IllegalStateException
	{
	    if (isEmpty())
	    {
	    	throw new IllegalStateException("List is empty");
	    }
	    return topCard.getNext();
	}
	
	// returns the last node on the list
	public Card getLast() throws IllegalStateException
	{
		if(isEmpty())
		{
			throw new IllegalStateException("List is empty");
		}
		
		return bottomCard.getPrevious();
	}
	
	// clear function
	public final void clear()
	{
		topCard = null;
		bottomCard = null;
		numberOfCards = 0;
	}
	
	 //Removes the given node v from the list. An error occurs if v is the header or trailer */
	  public void remove(Card a)
	  {
	    Card u = getPrev(a); 
	    Card w = getNext(a);
	    
	    // unlink the node from the list 
	    w.setPrevious(u);
	    u.setNext(w);
	    a.setPrevious(null);
	    a.setNext(null);
	    numberOfCards--;
	  }
	  
	//inserts the given node to the topCard of the list
	public void addFirst(Card card)
	{
		addAfter(topCard,card);
	}
	
	//inserts the given node to the bottomCard of the list
	public void addLast(Card card)
	{
		addBefore(bottomCard,card);
	}
	
	//Inserts the given node b before the given node a. An error occurs if a is the topCard 
	public void addBefore(Card a, Card b)throws IllegalArgumentException
	{
		Card c = getPrev(a); 
		b.setPrevious(c);
		b.setNext(a);
		a.setPrevious(b);
		c.setNext(b);
		numberOfCards++;
	}
	
	//Inserts the given node z after the given node v. An error occurs if a is the bottomCard
	 public void addAfter(Card a, Card b)
	 {
		  Card c = getNext(a); 
		  b.setPrevious(a);
		  b.setNext(c);
		  c.setPrevious(b);
		  a.setNext(b);
		  numberOfCards++;
	 }
	 
	 // will shuffle
	 public void shuffle(Card[] cards,Pile L)
	 {
		//Card[] temp = new Card[52]; // test while building method
		String suit,face;
		
		
		//test while building method
		/*for(int i = 0;i < 52;i++)
		 {
			// System.out.println("Card:"+i+" " +cards[i]);
			 temp[i] = cards[i];
			// System.out.println("Cards"+i+" " + cards[i]); test
			// System.out.println("Temp"+i+" " + temp[i]);// test	
		
		}*/
		
		//test while building method
		/*for(int i = 0;i < 52;i++)
		{
			System.out.println("temp"+i+" " + temp[i]);
		}*/
		
		
		int s = L.getNumberOfCards();// gets the number of cards
		int r = 52-s;// gets the new value for the start index
		
		
		for(int i = r; i < 52;i++)
		{
			L.remove(cards[i]);
		}
		
		Collections.shuffle(Arrays.asList(cards));
		
		for(int i = 51; i>=r; i--)
		{
			suit = cards[i].getSuit();
			face = cards[i].getFace();
			cards[i] = new Card(face,suit,null,null);
			L.addFirst(cards[i]);
		}
		
	 }
	 
	
	 public String toString()
	 {
		  String s = "";
		  Card v = topCard.getNext();
		  
		  while (v != bottomCard)
		  {
		      s += v.toString();
		      v = v.getNext();
		      if (v != bottomCard)
		      {
		    	  s += "\n";
		      }
		  }
	 s += "";
	 return s;
	}

	

	 
}


