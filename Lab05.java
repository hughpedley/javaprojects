/** Lab05
 * This is an extension of the program made in lab 3.
 * The previous lab calculated a price for the user based on their choice of internet packages and
 * how many hours they used it. The inputs were a string character (A, B, or C) for the internet,
 * and any number greater than or equal to zero. The output was a currency formatted price that
 * was mathematically calculated from their inputs.
 * 
 * The updates to this lab require exception handling, loops for input validation, and saving the
 * information in a file.
 */

import java.util.*;
import java.io.*;
import java.text.NumberFormat;

public class Lab05
{	
	public static void main(String[] args)
    {		
		//starts off by asking user to input a filename and establishes some global variables
		Scanner keyboard = new Scanner(System.in);
		Scanner reader;
		System.out.print("Data file of prior internet usage: ");
		String filename = keyboard.nextLine();
		File inputFile = new File(filename);
		List<String> previousProducts = new ArrayList<String>();
		double totPrevHours = 0;
		double totPrevCharges = 0;
		double count = 0;
		
		//if there is no file, program makes one
		if (!inputFile.exists()){
			System.out.println("That file does not exist; creating it now.");
			try{
				PrintWriter outputFile = new PrintWriter(filename);
				outputFile.close();
			}
			catch(IOException e){
				System.out.println("Fatal error.");
				System.exit(0);
			}
		}
		//reads in the file if it exists
		else {
			try{	
				reader = new Scanner(inputFile);
				while (reader.hasNext()){
					try{
						previousProducts.add(reader.next());
						totPrevHours += reader.nextDouble();
						totPrevCharges += reader.nextDouble();
						count++;
					}
					catch (NoSuchElementException nsee){
						break;
					}	
				}
				reader.close();
			}
			catch(FileNotFoundException fnfe){
				System.out.println("File not found. Fatal error.");
				System.exit(0);
			}
			//calculates and prints out the average previous hours	
			double avePrevHours = totPrevHours / count;
			System.out.println("Average hours used: "+avePrevHours);
			//calculates average previous charges		
			double avePrevCharges = totPrevCharges / count;
			//prints out in money format average charges and total charges	
			NumberFormat fmtCurr = NumberFormat.getCurrencyInstance();
			System.out.println("Average amount paid each month: "+fmtCurr.format(avePrevCharges));
			System.out.println("Total amount paid: "+fmtCurr.format(totPrevCharges));
		}
		
		//displays available packages and asks user which program they selected
		System.out.println("These are the available internet packages.");
		System.out.println("Package A: $9.95 a month, with 10 hours provided. Additional hours are $2.00/hr");
		System.out.println("Package B: $13.95 a month, with 20 hours provided. Additional hours are $1.00/hr");
		System.out.println("Package C: $19.95 a month, with unlimited hours.");
		System.out.println("Which package did you select? Please enter A, B, or C");
		
		//gets user's first input (package selected)
		String product = keyboard.nextLine();
		//input validation loop. makes sure that a valid answer is input for product	
		while(!(product.equalsIgnoreCase("A") || product.equalsIgnoreCase("B") || product.equalsIgnoreCase("C"))){
			System.out.println("Please enter A, B, or C. Case does not matter.");
			product = keyboard.nextLine();
		}
			
		//gets user's second input (hours used)
		System.out.println("How many hours did you use?");
		//try catch block followed by a while loop for input validation and exception handling; makes sure that hours is an int > 0
		double hours = 0;
		while (true){	
			try{
				hours = keyboard.nextDouble();
				break;
			}
			catch (InputMismatchException ime){
				System.out.println("Please enter a number greater than or equal to zero.");
				System.out.println("How many hours did you use?");
				keyboard.next();
			}
		}
		while (hours < 0) {
			System.out.println("Please enter a number greater than or equal to zero next time.");
			System.out.println("How many hours did you use?");
			hours = keyboard.nextDouble();
		}
			
		/*now that we have the two inputs, we need to calculate the total charge for the user*/
		//defining variable for total charge
		double charge = 0;
		if (product.equalsIgnoreCase("a")) {
			if (hours <= 10) {
				charge = 9.95;
			} else 
				charge = (9.95 + 
						2.00 * hours - 20);
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
		
		keyboard.close();
		//writes results to the file
		try {
			FileWriter fw = new FileWriter(filename, true);
			PrintWriter outputFile = new PrintWriter(fw);
			outputFile.print(product);
			outputFile.print(" "+hours);
			outputFile.println(" "+charge);
			outputFile.close();
			fw.close();
		}
		catch (IOException e){
			System.out.println("Fatal error.");
			System.exit(0);
		}
    }
}	