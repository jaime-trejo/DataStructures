/*
 *  Name:Jaime Trejo
 *  Date: 2/9/14
 *  
 *  	Write a program to simulate a train route. A train route consists of a number of stations, starting and ending with a
 *		terminal station. The time that the train needs to travel between a pair of consecutive stations on the route is given.
 *		Associated with each station is a queue of passengers. Passengers are generated at random times, assigned to entry
 *		stations randomly, and given random destination stations. Trains leave a terminal at regular intervals and visit the
 *		stations on the route. When a train stops at a station, all passengers for that station exit first. Then any passengers
 *		waiting in the queue at the station board the train until either the queue is empty or the train is full
 *
 *
 *		
 *  	The following will be Station class for the queue application it will have a queue of Passengers.
 *
 */

import java.util.Random;

public class Station
{
	private QueueInterface <Passenger> line;
    private int numberOfArrivals; // keep track of passengers
    private int numberDroppedOff;
    private int numberOfStations = 3; // number of stations in this program
    private int numberOfDestinations = 3; // number of stations, that are destinations
    private int totalTimeWaited;
    private int station;
    private int destination;

    //default constructor
    public Station()  
    {
        line = new CircularArrayQueue<Passenger>();
        line.clear(); // clears the array
        numberOfArrivals = 0;
        numberDroppedOff = 0;
        totalTimeWaited = 0;
    } 

    // displays the number of people who got to their destination
    public void displayResults()
    {
        System.out.println ("\nNumber of people who made it to their destination = " + numberDroppedOff);
    }
    
    //Simulates a passenger line 
    public void simulate (int duration, double arrivalProbability,int maxBoardingTime)
    {

        int boardingTimeLeft = 0;
        for (int clock = 0 ; clock < duration ; clock++)
        {
        	Random generate = new Random();
        	Random gen = new Random();
    		station = (generate.nextInt(numberOfStations)+1);// will generate a station between 1 and 3
    		destination = (gen.nextInt(numberOfDestinations)+1); // will generate a destination between 1 and 3
    		
            if (Math.random () < arrivalProbability)
            {
                numberOfArrivals++; // keeps count of passengers entering the station
                int boardingTime = (int)(Math.random()* maxBoardingTime + 1);
                
                Passenger nextArrival = new Passenger(clock,boardingTime,numberOfArrivals,station,destination);
                line.enqueue(nextArrival); // adds the passenger into the queue
                
              
                
                System.out.println ("Passenger " + numberOfArrivals + " enters station " + nextArrival.getArrivalStation()
                		+", at the "+ clock + " minute mark. "
                        + "Heading to station " + nextArrival.getDestinationStation() 
                        + ". Boarding time is " + boardingTime + " min.");
                
                 // if the passenger who enters has the same destination as the one they entered then they will be removed from
                //the queue
                if(nextArrival.getArrivalStation() == nextArrival.getDestinationStation())
                {
                	System.out.println("Passenger " + nextArrival.getPassengerNumber()+ " is already at there destination. Goodbye\n");
                	numberDroppedOff++;
                	nextArrival = line.dequeue();// if they arrived at their destination then they will be removed
                	
                }    
            } 
            
            // if the boarding time is greater than zero it will keep decrementing
            if (boardingTimeLeft > 0)
            {
            	boardingTimeLeft--;
            }
           
            // if the queue is not empty then it will do the following
            else if(!line.isEmpty())
            {
            	
                Passenger nextCustomer = line.getFront();
                boardingTimeLeft = nextCustomer.getBoardingTime()- 1;
                int timeWaited = clock - nextCustomer.getArrivalTime();
                
                nextCustomer = line.dequeue();// removes from the queue
                
                totalTimeWaited = totalTimeWaited + timeWaited;
                
                numberDroppedOff++; // increases the amount of people that are dropped off
                
                System.out.println ("Passenger " + nextCustomer.getPassengerNumber()
                        + " begins boarding the train at time " + boardingTimeLeft
                        + ". Time waited is " + timeWaited + " min.");
                
                // if timeWaited is any of the following then it will output the following
                if(timeWaited == 0 || timeWaited == 1 || timeWaited == 2 || timeWaited == 3 || timeWaited == 4 ||
                		timeWaited == 5 || timeWaited == 6 || timeWaited == 7 || timeWaited == 8 || timeWaited == 9)
                {
                	System.out.println("Passenger " + nextCustomer.getPassengerNumber() + " arrived at station " +
                			nextCustomer.getDestinationStation());
                	System.out.println();
                }
                
            } 
            
        } 
    } 
  

}
