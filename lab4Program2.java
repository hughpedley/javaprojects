/** This is the second program assigned in Lab 4. This program should be able to tell you whether
 * a numbered one way street in New York City is eastbound or westbound based on whether the street
 * is even or odd. The one input from the user will be the street number - a whole number between
 * 1 and 155. The output will be telling the user that the street they entered is either
 * eastbound or westbound.
 */
/**
 * @author Hugh Pedley
 *
 */
package lab4Program2;

import java.util.Scanner;

public class lab4Program2
{
	
	public static void main(String[] args)
    {
		System.out.println("This program will tell you whether a street in New York City is Eastbound or Westbound!");
		
		
		do {
			System.out.println("Please enter street number of a one way street in New York.");
			Scanner keyboard = new Scanner(System.in);
			//This gets the street number input from the user
			int streetNumber = keyboard.nextInt();
			
			//functions as input validation
			if (streetNumber < 0 || streetNumber > 155) {
				System.out.println("Please enter a valid street number in New York. 1-155 are valid street numbers.");
				//Commented out this exit because rubric/description did not require it
				//System.exit(0);
			}
			//Ends the loop if 0 is input
			else if (streetNumber == 0) {
				break;
			}
			//Returns eastbound or westbound based on even/odd number input
			else if (streetNumber > 0 && streetNumber <= 155) {
				int direction = streetNumber % 2;
					if (direction == 0){
						System.out.println(streetNumber + " Street is eastbound.");
						System.out.println("You may proceed or push 0 to exit.");
					}
					else {
						System.out.println(streetNumber + " Street is westbound.");
						System.out.println("You may proceed or push 0 to exit.");
					}
			}
		} while (true);
		System.out.println("Program ended.");
    }
}