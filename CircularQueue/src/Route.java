/*
 *  Name:Jaime Trejo
 *  Date: 2/9/14
 *  	The following will be Route class which will run the simulation of station
 */

public class Route 
{
	public static void main(String[] args)
	{
		
		Station runStation = new Station();
		System.out.println("Train route ");
		System.out.println("-----------");
		// simulate 20 minutes, 50 percent arrival probability, 3 min. boarding time
		runStation.simulate(20, .5, 3);
		runStation.displayResults();
	}

}
