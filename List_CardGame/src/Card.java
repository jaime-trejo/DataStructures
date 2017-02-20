/*
 * Name:Jaime Trejo
 * Date:2/18/14
 * 			This Card class will be somewhat similar to a node class that has a next and a previous. It will implement Comparable
 * 			of type Card.
 */
public class Card implements Comparable<Card>
{
	protected String face, suit;
	protected Card next,previous;

	// default constructor
	public Card()
	{
		face = "";// nothing assigned to face
		suit = ""; // nothing assigned to suit
	}
	
	// overloaded constructor
	public Card(String newFace, String newSuit)
	{
		face = newFace;
		suit = newSuit;
	}
	
	// overloaded constructor
	public Card(String newFace,String newSuit, Card newPrev, Card newNext)
	{
		face = newFace;
		suit = newSuit;
		previous = newPrev;
		next = newNext;
	}
	
	//accessors
	public String getFace()
	{
		return face;
	}
	
	public String getSuit()
	{
		return suit;
	}
	
	public Card getPrevious()
	{
		return previous;
	}
	
	public Card getNext()
	{
		return next;
	}
	
	//mutators
	public void setFace(String newFace)
	{
		face = newFace;
	}
	
	public void setSuit(String newSuit)
	{
		suit = newSuit;
	}
	
	// sets the  previous node of this node
	public void setPrevious(Card newPrev)
	{
		previous = newPrev;
	}
	
	// sets the next node of this node
	public void setNext(Card newNext)
	{
		next = newNext;
	}
	
	//compareTo method
	// if the value of this.getFace() is less than other.getFace() then it will return 2
	//if the value of this.getFace() is equal to other.getFace() then it will return -1
	//if the value of this.getFace() is greater than other.getFace() then it will return 1
	
	@Override
	public int compareTo(Card other)
	{
		// checks to see if this two is less than  other 3,4,5,6,7,8,9,10,J,Q,K,A
		if(this.getFace().equalsIgnoreCase("2") && (other.getFace().equalsIgnoreCase("3") || 
				other.getFace().equalsIgnoreCase("4") 
			|| other.getFace().equalsIgnoreCase("5")  || other.getFace().equalsIgnoreCase("6")  ||
			other.getFace().equalsIgnoreCase("7")|| other.getFace().equalsIgnoreCase("8") 
				|| other.getFace().equalsIgnoreCase("9") || other.getFace().equalsIgnoreCase("10") 
					|| other.getFace().equalsIgnoreCase("J") || other.getFace().equalsIgnoreCase("Q") 
					|| other.getFace().equalsIgnoreCase("K") 
						|| other.getFace().equalsIgnoreCase("A")))
		{
			return 2;
		}
		
		// checks to see if this two equals other two
		if(this.getFace().equalsIgnoreCase("2") && other.getFace().equalsIgnoreCase("2"))
		{
			return -1;
		}
		
		// checks to see if this three is less than other 4,5,6,7,8,9,10,J,Q,K,A
		if(this.getFace().equalsIgnoreCase("3") && (
				other.getFace().equalsIgnoreCase("4") 
			|| other.getFace().equalsIgnoreCase("5")  || other.getFace().equalsIgnoreCase("6")  ||
			other.getFace().equalsIgnoreCase("7")|| other.getFace().equalsIgnoreCase("8") 
				|| other.getFace().equalsIgnoreCase("9") || other.getFace().equalsIgnoreCase("10") 
					|| other.getFace().equalsIgnoreCase("J") || other.getFace().equalsIgnoreCase("Q") 
					|| other.getFace().equalsIgnoreCase("K") 
						|| other.getFace().equalsIgnoreCase("A")))
		{
			return 2;
		}
		
		// checks to see if this three is equal to other three
		if(this.getFace().equalsIgnoreCase("3") && other.getFace().equalsIgnoreCase("3"))
		{
			return -1;
		}
		
		// checks to see if this three is greater than other 2
		if(this.getFace().equalsIgnoreCase("3") && (other.getFace().equalsIgnoreCase("2")))
		{
			return 1;
		}
		
		// checks to see if this four is less than other 5,6,7,8,9,10,J,Q,K,A
		if(this.getFace().equalsIgnoreCase("4") && (other.getFace().equalsIgnoreCase("5") 
				|| other.getFace().equalsIgnoreCase("6")  ||
			other.getFace().equalsIgnoreCase("7")|| other.getFace().equalsIgnoreCase("8") 
				|| other.getFace().equalsIgnoreCase("9") || other.getFace().equalsIgnoreCase("10") 
					|| other.getFace().equalsIgnoreCase("J") || other.getFace().equalsIgnoreCase("Q") 
					|| other.getFace().equalsIgnoreCase("K") 
						|| other.getFace().equalsIgnoreCase("A")))
		{
			return 2;
		}
		
		// checks to see if this four is equal to other four
		if(this.getFace().equalsIgnoreCase("4") && other.getFace().equalsIgnoreCase("4"))
		{
			return -1;
		}
		
		// checks to see if this four is greater than other 2,3
		if(this.getFace().equalsIgnoreCase("4") && (other.getFace().equalsIgnoreCase("2") ||
				other.getFace().equalsIgnoreCase("3")))
		{
			return 1;
		}
		
		// checks to see if this five is less than  other 6,7,8,9,10,J,Q,K,A
		if(this.getFace().equalsIgnoreCase("5") && ( other.getFace().equalsIgnoreCase("6")  ||
			other.getFace().equalsIgnoreCase("7")|| other.getFace().equalsIgnoreCase("8") 
				|| other.getFace().equalsIgnoreCase("9") || other.getFace().equalsIgnoreCase("10") 
					|| other.getFace().equalsIgnoreCase("J") || other.getFace().equalsIgnoreCase("Q") 
					|| other.getFace().equalsIgnoreCase("K") 
						|| other.getFace().equalsIgnoreCase("A")))
		{
			return 2;
		}
		
		// checks to see if this five is equal to other five
		if(this.getFace().equalsIgnoreCase("5") && other.getFace().equalsIgnoreCase("5"))
		{
			return -1;
		}
		
		// checks to see if this five is greater than  other 2,3,4,
		if(this.getFace().equalsIgnoreCase("5") && (other.getFace().equalsIgnoreCase("2") ||
				other.getFace().equalsIgnoreCase("3")||
				other.getFace().equalsIgnoreCase("4")))
		{
			return 1;
		}
		
		// checks to see if this six is less than  other 7,8,9,10,J,Q,K,A
		if(this.getFace().equalsIgnoreCase("6") && ( other.getFace().equalsIgnoreCase("7")
				|| other.getFace().equalsIgnoreCase("8") 
					|| other.getFace().equalsIgnoreCase("9") || other.getFace().equalsIgnoreCase("10") 
						|| other.getFace().equalsIgnoreCase("J") || other.getFace().equalsIgnoreCase("Q") 
						|| other.getFace().equalsIgnoreCase("K") 
							|| other.getFace().equalsIgnoreCase("A")))
		{
			return 2;
		}
		
		// checks to see if this six is equal to other six
		if(this.getFace().equalsIgnoreCase("6") && other.getFace().equalsIgnoreCase("6"))
		{
			return -1;
		}
		
		// checks to see if this six is less than  other 2,3,4,5
		if(this.getFace().equalsIgnoreCase("6") && (other.getFace().equalsIgnoreCase("2") ||
					other.getFace().equalsIgnoreCase("3")||
					other.getFace().equalsIgnoreCase("4")||
					other.getFace().equalsIgnoreCase("5")))
		{
			return 1;
		}
		
		// checks to see if this seven is less than  other 8,9,10,J,Q,K,A
		if(this.getFace().equalsIgnoreCase("7") && ( other.getFace().equalsIgnoreCase("8") 
					|| other.getFace().equalsIgnoreCase("9") || other.getFace().equalsIgnoreCase("10") 
						|| other.getFace().equalsIgnoreCase("J") || other.getFace().equalsIgnoreCase("Q") 
						|| other.getFace().equalsIgnoreCase("K") 
							|| other.getFace().equalsIgnoreCase("A")))
		{
			return 2;
		}
		
		// checks to see if this seven is equal to other seven
		if(this.getFace().equalsIgnoreCase("7") && other.getFace().equalsIgnoreCase("7"))
		{
			return -1;
		}
		
		// checks to see if this seven is greater than  other 2,3,4,5,6
		if(this.getFace().equalsIgnoreCase("7") && (other.getFace().equalsIgnoreCase("2") ||
					other.getFace().equalsIgnoreCase("3")||
					other.getFace().equalsIgnoreCase("4")||
					other.getFace().equalsIgnoreCase("5")||
					other.getFace().equalsIgnoreCase("6")))
		{
			return 1;
		}
		
		// checks to see if this eight is less than  other 9,10,J,Q,K,A
		if(this.getFace().equalsIgnoreCase("8") && (other.getFace().equalsIgnoreCase("9") || 
				other.getFace().equalsIgnoreCase("10") 
					|| other.getFace().equalsIgnoreCase("J") || other.getFace().equalsIgnoreCase("Q") 
					|| other.getFace().equalsIgnoreCase("K") 
						|| other.getFace().equalsIgnoreCase("A")))
		{
			return 2;
		}
		
		// checks to see if this eight is equal to other eight
		if(this.getFace().equalsIgnoreCase("8") && other.getFace().equalsIgnoreCase("8"))
		{
			return -1;
		}
		
		// checks to see if this eight is greater than  other 2,3,4,5,6,7
		if(this.getFace().equalsIgnoreCase("8") && (other.getFace().equalsIgnoreCase("2") ||
				other.getFace().equalsIgnoreCase("3")||
				other.getFace().equalsIgnoreCase("4")||
				other.getFace().equalsIgnoreCase("5")||
				other.getFace().equalsIgnoreCase("6")||
				other.getFace().equalsIgnoreCase("7")))
		{
			return 1;
		}
		
		// checks to see if this nine is less than  other 10,J,Q,K,A
		if(this.getFace().equalsIgnoreCase("9") && (other.getFace().equalsIgnoreCase("10") 
					|| other.getFace().equalsIgnoreCase("J") || other.getFace().equalsIgnoreCase("Q") 
					|| other.getFace().equalsIgnoreCase("K") 
						|| other.getFace().equalsIgnoreCase("A")))
		{
			return 2;
		}
		
		// checks to see if this nine is equal to other nine
		if(this.getFace().equalsIgnoreCase("9") && other.getFace().equalsIgnoreCase("9"))
		{
			return -1;
		}
		
		// checks to see if this nine is greater than  other 2,3,4,5,6,7,8
		if(this.getFace().equalsIgnoreCase("9") && (other.getFace().equalsIgnoreCase("2") ||
				other.getFace().equalsIgnoreCase("3")||
				other.getFace().equalsIgnoreCase("4")||
				other.getFace().equalsIgnoreCase("5")||
				other.getFace().equalsIgnoreCase("6")||
				other.getFace().equalsIgnoreCase("7")||
				other.getFace().equalsIgnoreCase("8")))
		{
			return 1;
		}
		
		// checks to see if this ten is less than  other J,Q,K,A
		if(this.getFace().equalsIgnoreCase("10") && (other.getFace().equalsIgnoreCase("J") 
				|| other.getFace().equalsIgnoreCase("Q") 
				|| other.getFace().equalsIgnoreCase("K") 
					|| other.getFace().equalsIgnoreCase("A")))
		{
			return 2;
		}
		
		// checks to see if this ten is equal to other then
		if(this.getFace().equalsIgnoreCase("10") && other.getFace().equalsIgnoreCase("10"))
		{
			return -1;
		}
		
		// checks to see if this ten is greater than  other 2,3,4,5,6,7,8,9
		if(this.getFace().equalsIgnoreCase("10") && (other.getFace().equalsIgnoreCase("2") ||
			other.getFace().equalsIgnoreCase("3")||
			other.getFace().equalsIgnoreCase("4")||
			other.getFace().equalsIgnoreCase("5")||
			other.getFace().equalsIgnoreCase("6")||
			other.getFace().equalsIgnoreCase("7")||
			other.getFace().equalsIgnoreCase("8")||
			other.getFace().equalsIgnoreCase("9")))
		{
			return 1;
		}
		
		// checks to see if this jack is less than  other Q,K,A
		if(this.getFace().equalsIgnoreCase("J") && (other.getFace().equalsIgnoreCase("Q") 
				|| other.getFace().equalsIgnoreCase("K") 
					|| other.getFace().equalsIgnoreCase("A")))
		{
			return 2;
		}
		
		// checks to see if this jack is equal to other jack
		if(this.getFace().equalsIgnoreCase("J") && other.getFace().equalsIgnoreCase("J"))
		{
			return -1;
		}
		
		// checks to see if this jack is greater than  other 2,3,4,5,6,7,8,9,10
		if(this.getFace().equalsIgnoreCase("J") && (other.getFace().equalsIgnoreCase("2") ||
			other.getFace().equalsIgnoreCase("3")||
			other.getFace().equalsIgnoreCase("4")||
			other.getFace().equalsIgnoreCase("5")||
			other.getFace().equalsIgnoreCase("6")||
			other.getFace().equalsIgnoreCase("7")||
			other.getFace().equalsIgnoreCase("8")||
			other.getFace().equalsIgnoreCase("9")||
			other.getFace().equalsIgnoreCase("10")))
		{
			return 1;
		}
		
		// checks to see if this queen is less than  other K,A
		if(this.getFace().equalsIgnoreCase("Q") && (other.getFace().equalsIgnoreCase("K") 
					|| other.getFace().equalsIgnoreCase("A")))
		{
			return 2;
		}
		
		// checks to see if this queen is equal to other queen
		if(this.getFace().equalsIgnoreCase("Q") && other.getFace().equalsIgnoreCase("Q"))
		{
			return -1;
		}
		
		// checks to see if this queen is greater than  other 3,4,5,6,7,8,9,10,J
		if(this.getFace().equalsIgnoreCase("Q") && (other.getFace().equalsIgnoreCase("2") ||
			other.getFace().equalsIgnoreCase("3")||
			other.getFace().equalsIgnoreCase("4")||
			other.getFace().equalsIgnoreCase("5")||
			other.getFace().equalsIgnoreCase("6")||
			other.getFace().equalsIgnoreCase("7")||
			other.getFace().equalsIgnoreCase("8")||
			other.getFace().equalsIgnoreCase("9")||
			other.getFace().equalsIgnoreCase("10")||
			other.getFace().equalsIgnoreCase("J")))
		{
			return 1;
		}
		
		// checks to see if this king is less than  other A
		if(this.getFace().equalsIgnoreCase("K") && (other.getFace().equalsIgnoreCase("A")))
		{
			return 2;
		}
		
		// checks to see if this king is equal to other king
		if(this.getFace().equalsIgnoreCase("K") && other.getFace().equalsIgnoreCase("K"))
		{
			return -1;
		}
		
		// checks to see if this king is greater than  other 2,3,4,5,6,7,8,9,10,J,Q
		if(this.getFace().equalsIgnoreCase("K") && (other.getFace().equalsIgnoreCase("2") ||
			other.getFace().equalsIgnoreCase("3")||
			other.getFace().equalsIgnoreCase("4")||
			other.getFace().equalsIgnoreCase("5")||
			other.getFace().equalsIgnoreCase("6")||
			other.getFace().equalsIgnoreCase("7")||
			other.getFace().equalsIgnoreCase("8")||
			other.getFace().equalsIgnoreCase("9")||
			other.getFace().equalsIgnoreCase("10")||
			other.getFace().equalsIgnoreCase("J")||
			other.getFace().equalsIgnoreCase("Q")))
		{
			return 1;
		}
		
		// checks to see if this ace is equal to other ace
		if(this.getFace().equalsIgnoreCase("A") && other.getFace().equalsIgnoreCase("A"))
		{
			return -1;
		}
		
		// checks to see if this ace is greater than  other 2,3,4,5,6,7,8,9,10,J,Q,K
		if(this.getFace().equalsIgnoreCase("A") && (other.getFace().equalsIgnoreCase("2") ||
				other.getFace().equalsIgnoreCase("3")||
				other.getFace().equalsIgnoreCase("4")||
				other.getFace().equalsIgnoreCase("5")||
				other.getFace().equalsIgnoreCase("6")||
				other.getFace().equalsIgnoreCase("7")||
				other.getFace().equalsIgnoreCase("8")||
				other.getFace().equalsIgnoreCase("9")||
				other.getFace().equalsIgnoreCase("10")||
				other.getFace().equalsIgnoreCase("J")||
				other.getFace().equalsIgnoreCase("Q")||
				other.getFace().equalsIgnoreCase("K")))
		{
			return 1;
		}
		
		
		return 0;
	}
	
	//toStringMethod
	public String toString()
	{
		return face+ " of " + suit;
	}
	

}
