/*
 *  Name:Jaime Trejo
 *  Date: 2/9/14
 *  	The following will be the Passenger class for the train application
 */

public class Passenger
{
	
	private int arrivalTime;
	private int boardingTime;
	private int passengerNumber;
	private int arrivalStation;
	private int destinationStation;

	// overloaded constructor
	public Passenger(int clock,int time,int passenger, int station, int destination)
	{
	      arrivalTime = clock;
	      boardingTime = time;
	      passengerNumber = passenger;
	      arrivalStation = station;
	      destinationStation = destination;
	}

	//accessors
	public int getArrivalTime()
	{ 
		return arrivalTime;
	}
	
	public int getBoardingTime()
	{ 
		return boardingTime;
	}
	  
	public int getPassengerNumber()
	{ 
		return passengerNumber;
	}
	  
	public int getArrivalStation()
	{ 
		return arrivalStation;
	}
	public int getDestinationStation()
	{ 
		return destinationStation;
	}
	  
	//mutators
	public void setArrivalTime(int clock)
	{
		arrivalTime = clock;
	}
	  
	public void setBoardingTime(int time)
	{
		boardingTime = time;
	}
	  
	public void setPassengerNumber(int passenger)
	{
		passengerNumber = passenger;
	}
	  
	public void setArrivalStation(int station)
	{
		arrivalStation = station;
	}
	public void setDestinationStation(int destination)
	{
		destinationStation = destination;
	}
}
