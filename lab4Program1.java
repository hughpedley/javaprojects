/** This is the first program for Lab 4. This program will offer to flip a coin for the user.
 * The only input required is for the user to enter how many times they want to flip the coin.
 * Input should be a whole number greater than or equal to 1.
 * The output will show the user how many times Heads showed up in their coin flips, and nothing else.
 * This is how I interpreted the intention of this lab based off of the example text.
 */
/**
 * @author Hugh Pedley
 *
 */
package lab4Program1;

import java.util.Scanner;
import java.util.Random;

public class lab4Program1
{
	
	public static void main(String[] args)
    {
		System.out.println("Please enter how many times you want to flip a coin.");
		Scanner keyboard = new Scanner(System.in);
		//This gets the user input for the number of coin flips
		int coinFlips = keyboard.nextInt();
		if (coinFlips < 1) {
			System.out.println("Please enter a whole number greater than or equal to one next time.");
			System.out.println("This way, we can flip the coin at least one time.");
			System.exit(0);
		}
		
		//For loop to do the coin flips for us; every value below .5 will increment var heads by one	
		int heads = 0;
		Random headsTails = new Random();
		for (int i =0; i < coinFlips; i++){
			double result = headsTails.nextInt();
			if (result < 0.5) {
				heads++;
			}
		}
		
		//prints out however many times heads showed up
		System.out.println("Heads showed up " + heads + " time(s) in those flips.");	
    }
}