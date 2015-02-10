/** This is the third program assigned in Lab 4. For this assignment, we are supposed to find the
 * floor of a logarithm. The user needs to enter two integer inputs, both greater than or equal to 1.
 * If b = x^y, the user must input b and x. The output will be the floor of the logarithm. 
 */
/**
 * @author Hugh Pedley
 *
 */
package lab4Program3;

import java.util.Scanner;

public class lab4Program3
{
	
	public static void main(String[] args)
    {
		//gets b
		System.out.println("We're going to find the floor of a logarithm.");
		System.out.println("Please enter the base of the logarithm, b.");
		Scanner keyboard = new Scanner(System.in);
		int b = keyboard.nextInt();
		if (b < 1){
			System.out.println("Please input an integer greater than or equal to 1 next time.");
			System.exit(0);
		}
		//gets x
		System.out.println("Please enter the value x, such that logb(x).");
		int x = keyboard.nextInt();
		if (x < 1) {
			System.out.println("Please input an integer greater than or equal to 1 next time.");
			System.exit(0);
		}
		//while loop to use repeated division to find the floor of the log
		int floor = 0;
		while (x >= b){
			x = x/b;
			floor++;
		}
		
		//output value of floor
		System.out.println("The floor of the logarithm is " + floor + ".");
	}
}
