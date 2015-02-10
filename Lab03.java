/** Lab03
 * For this assignment, we are completing the last section of Lab02. We already did the first two steps of the software development cycle,
 * so now we are implementing the code, testing and debugging, and documenting it.
 * This program should take two inputs from the user - a specific choice of internet package (either A, B, or C) and the amount of hours used (a number above or equal to 0).
 * This program should then output the total cost to the user in an easily understandable format.
 */
//Finishing and coding the last section of Lab2. Calculating rates for internet packages

import java.text.NumberFormat;
import java.util.*;

public class Lab03
{
	public static void main(String[] args)
    {		
		
		//opening dialogue of the program. displays available packages and asks user which program they selected
		
		System.out.println("These are the available internet packages.");
		System.out.println("Package A: $9.95 a month, with 10 hours provided. Additional hours are $2.00/hr");
		System.out.println("Package B: $13.95 a month, with 20 hours provided. Additional hours are $1.00/hr");
		System.out.println("Package C: $19.95 a month, with unlimited hours.");
		System.out.println("Which package did you select? Please enter A, B, or C");
		
		//gets user's first input (package selected)
		Scanner keyboard = new Scanner(System.in);
		String product = keyboard.nextLine();
			if (product.equalsIgnoreCase("a"))
				{}
			else if (product.equalsIgnoreCase("b"))
				{}
			else if (product.equalsIgnoreCase("c"))
				{}
			else {
				System.out.println("Please enter A, B, or C next time.");
				System.exit(0);
			}
			
		//gets user's second input (hours used)
		System.out.println("How many hours did you use?");
		double hours = keyboard.nextDouble();
			if (hours < 0) {
				System.out.println("Please enter a number greater than or equal to zero next time.");
				System.exit(0);
			}
			
		/*now that we have the two inputs, we need to calculate the total charge for the user*/
		//defining variable for total charge
		double charge = 0;
		if (product.equalsIgnoreCase("a")) {
			if (hours <= 10) {
				charge = 9.95;
			} else 
				charge = (9.95 + 2.00 * hours - 20);
		} else if (product.equalsIgnoreCase("b")) {
			if (hours <= 20) {
				charge = 13.95;
			} else 
				charge = (13.95 + 1.00 * hours - 20);
		} else if (product.equalsIgnoreCase("c")) {
			charge = 19.95; 
		}
		
		//prints the total in a currency format
		NumberFormat fmtCurr = NumberFormat.getCurrencyInstance();
		System.out.println("Your total charge is " + fmtCurr.format(charge) + ".");
    }
}