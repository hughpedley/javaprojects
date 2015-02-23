/**
 * This is programming project 1 for CS 0401. We have been tasked with creating an inventory system for an imagined company.
 * We have to load in a file selected by the user with current inventory information. That includes a budget, quantity and name for several items,
 * and the price they are currently being sold at. The program then takes the user through a series of menus deciding whether they want to
 * buy or sell pieces of inventory, change the selling price, or change nothing at all. This will occur three times, and then the program will
 * save the changes to the inventory to the file.
 * 
 * The user input will be ints (0,1,2,3, or 4) to navigate the menu, and then ints (greater than or equal to zero) to determine changes to selling price
 * and quantity. The program output will inform the user of the changes to the inventory at every step.
 */
/**
 * @author Hugh Pedley
 *
 */
package project1;

import java.text.NumberFormat;
import java.util.*;
import java.io.*;

public class project1
{
	
	public static void main(String[] args)
    {
		//Gets the inventory filename from the user and declares global variables
		System.out.print("Please enter input filename: ");
		Scanner keyboard = new Scanner(System.in);
		String filename = keyboard.nextLine();
		File inputFile = new File(filename);
		double currentBalance = 0;
		String productLamps = "Lamps";
		double priceLamps = 0;
		double quantityLamps = 0;
		String productChairs = "Chairs";
		double priceChairs = 0;
		double quantityChairs = 0;
		String productDesks = "Desks";
		double priceDesks = 0;
		double quantityDesks = 0;
		int sellAmount = 0;
		double pricePerItem = 0;
		int buyAmount = 0;
		double newPrice = 0;
		
		//This will be used several times throughout the program, placing it here lets it have best used scope
		NumberFormat fmtCurr = NumberFormat.getCurrencyInstance();
		
		//If the filename does not exist, program informs the user and then exits. If it does exist, program reads in inventory and assigns it to variables
		if (!inputFile.exists()){
			System.out.println("That file does not exist. Make sure you are typing the filename correctly and that it is in the correct folder.");
			System.out.println("Ending program now.");
			System.exit(0);
		} try{
			Scanner reader = new Scanner(inputFile);
			currentBalance = reader.nextDouble();
			productLamps = reader.next();
			priceLamps = reader.nextDouble();
			quantityLamps = reader.nextDouble();
			productChairs = reader.next();
			priceChairs = reader.nextDouble();
			quantityChairs = reader.nextDouble();
			productDesks = reader.next();
			priceDesks = reader.nextDouble();
			quantityDesks = reader.nextDouble();
			reader.close();
		} catch(FileNotFoundException fnfe){
			System.out.println("File not found. Fatal error.");
			System.exit(0);	
		}	
			
		//displays menu, makes sure that user picks valid option, and loops through options
		int userChoice = 0;
		while(true){
			System.out.println("---------------");
			System.out.println("Current balance: "+fmtCurr.format(currentBalance));
			System.out.println("1. "+productLamps+"         "+"("+quantityLamps+" at "+fmtCurr.format(priceLamps)+")");
			System.out.println("2. "+productChairs+"        "+"("+quantityChairs+" at "+fmtCurr.format(priceChairs)+")");
			System.out.println("3. "+productDesks+"         "+"("+quantityDesks+" at "+fmtCurr.format(priceDesks)+")");
			System.out.println("0. Exit");
			System.out.println();
			System.out.println("Please enter choice: ");
			while(true){
				try{
					userChoice = keyboard.nextInt();
					break;
				} catch(InputMismatchException ime){
					System.out.println("Please enter an option from the menu, using 1, 2, 3, or 0.");
					keyboard.next();
				}	
			}
			while(!(userChoice==0||userChoice==1||userChoice==2||userChoice==3)){
				System.out.println("Please enter an option from the menu, using 1, 2, 3, or 0.");
				userChoice = keyboard.nextInt();
			}
			if(userChoice==0){
				System.out.println("Saving changes and exiting program.");
				break;
			}
			//This is the menu for if 'Lamps' was selected. Presents and executes options for selling, buying, and changing the price, as well as a menu return.
			else if(userChoice==1){
				while(true){
					System.out.println("---------------");
					System.out.println("Current balance: "+fmtCurr.format(currentBalance));
					System.out.println("Current quantity: "+quantityLamps);
					System.out.println("Current price: "+fmtCurr.format(priceLamps));
					System.out.println("1. Sell "+productLamps);
					System.out.println("2. Buy "+productLamps);
					System.out.println("3. Change price");
					System.out.println("0. Return to main menu");
					System.out.print("Please enter choice: ");
					while(true){
						try{
							userChoice = keyboard.nextInt();
							break;
						} catch(InputMismatchException ime){
							System.out.println("Please enter an option from the menu, using 1, 2, 3, or 0.");
							keyboard.next();
						}	
					}
					while(!(userChoice==0||userChoice==1||userChoice==2||userChoice==3)){
						System.out.println("Please enter an option from the menu, using 1, 2, 3, or 0.");
						userChoice = keyboard.nextInt();
					}
					if(userChoice==0){
						System.out.println("Returning to main menu.");
						break;
					}
					//User decides how many lamps to sell
					else if(userChoice==1){
						System.out.println("Amount to sell (current quality: "+productLamps+"): ");
						while(true){
							try{
								sellAmount = keyboard.nextInt();
								break;
							}catch(InputMismatchException ime){
								System.out.println("Please enter a whole number.");
								keyboard.next();
							}	
						}
						while(sellAmount<0){
							System.out.println("Please enter a number greater than or equal to zero.");
							sellAmount = keyboard.nextInt();
						}
						if(sellAmount>quantityLamps){
							System.out.println("Warning: Selling more than is in stock!");
							System.out.print("Do you wish to proceed (yes or no)?");
							String sellAnswer = keyboard.nextLine();
							while(!(sellAnswer.equalsIgnoreCase("yes")||sellAnswer.equalsIgnoreCase("no"))){
								System.out.println("Please enter yes or no.");
								sellAnswer = keyboard.nextLine();
							}
							if(sellAnswer.equalsIgnoreCase("yes")){
								quantityLamps = quantityLamps - sellAmount;
								currentBalance = currentBalance + (sellAmount * priceLamps);
							}	
						}
						else{
							quantityLamps = quantityLamps - sellAmount;
							currentBalance = currentBalance + (sellAmount * priceLamps);
						}
					}
					//user decides how many lamps to buy and at what price
					else if(userChoice==2){
						System.out.print("Amount to buy: ");
						while(true){
							try{
								buyAmount = keyboard.nextInt();
								break;
							}catch(InputMismatchException ime){
								System.out.println("Please enter a whole number.");
								keyboard.next();
							}	
						}
						while(buyAmount<0){
							System.out.println("Please enter a number greater than or equal to zero.");
							buyAmount = keyboard.nextInt();
						} 
						quantityLamps = quantityLamps + buyAmount;
						System.out.println("Price per item: ");
						while(true){
							try{
								pricePerItem = keyboard.nextDouble();
								break;
							}catch(InputMismatchException ime){
								System.out.println("Please enter a value greater than or equal to zero.");
								keyboard.next();
							}	
						}
						while(pricePerItem<0){
							System.out.println("Please enter a value greater than or equal to zero.");
							pricePerItem = keyboard.nextDouble();
						}
						currentBalance = currentBalance - (buyAmount * pricePerItem);
					}
					//user sets new price for lamps
					else if(userChoice==3){
						System.out.print("New price: ");
						while(true){
							try{
								newPrice = keyboard.nextDouble();
								break;
							}catch(InputMismatchException ime){
								System.out.println("Please enter a value greater than or equal to zero.");
								keyboard.next();
							}	
						}
						while(newPrice<0){
							System.out.println("Please enter a value greater than or equal to zero.");
							pricePerItem = keyboard.nextDouble();
						}
						priceLamps = newPrice;
					}
				}		
			}
			//This is the menu for if 'Chairs' was selected. Presents and executes options for selling, buying, and changing the price, as well as a menu return.
			else if(userChoice==2){
				while(true){
					System.out.println("---------------");
					System.out.println("Current balance: "+fmtCurr.format(currentBalance));
					System.out.println("Current quantity: "+quantityChairs);
					System.out.println("Current price: "+fmtCurr.format(priceChairs));
					System.out.println("1. Sell "+productChairs);
					System.out.println("2. Buy "+productChairs);
					System.out.println("3. Change price");
					System.out.println("0. Return to main menu");
					System.out.print("Please enter choice: ");
					while(true){
						try{
							userChoice = keyboard.nextInt();
							break;
						} catch(InputMismatchException ime){
							System.out.println("Please enter an option from the menu, using 1, 2, 3, or 0.");
							keyboard.next();
						}	
					}
					while(!(userChoice==0||userChoice==1||userChoice==2||userChoice==3)){
						System.out.println("Please enter an option from the menu, using 1, 2, 3, or 0.");
						userChoice = keyboard.nextInt();
					}
					if(userChoice==0){
						System.out.println("Returning to main menu.");
						break;
					}
					//user decides how many chairs to sell
					else if(userChoice==1){
						System.out.println("Amount to sell (current quality: "+productChairs+"): ");
						while(true){
							try{
								sellAmount = keyboard.nextInt();
								break;
							}catch(InputMismatchException ime){
								System.out.println("Please enter a whole number.");
								keyboard.next();
							}	
						}
						while(sellAmount<0){
							System.out.println("Please enter a number greater than or equal to zero.");
							sellAmount = keyboard.nextInt();
						}
						if(sellAmount>quantityChairs){
							System.out.println("Warning: Selling more than is in stock!");
							System.out.print("Do you wish to proceed (yes or no)?");
							String sellAnswer = keyboard.nextLine();
							while(!(sellAnswer.equalsIgnoreCase("yes")||sellAnswer.equalsIgnoreCase("no"))){
								System.out.println("Please enter yes or no.");
								sellAnswer = keyboard.nextLine();
							}
							if(sellAnswer.equalsIgnoreCase("yes")){
								quantityChairs = quantityChairs - sellAmount;
								currentBalance = currentBalance + (sellAmount * priceLamps);
							}	
						}
						else{
							quantityChairs = quantityChairs - sellAmount;
							currentBalance = currentBalance + (sellAmount * priceChairs);
						}	
					}
					//user decides how many chairs to buy and at what price
					else if(userChoice==2){
						System.out.print("Amount to buy: ");
						while(true){
							try{
								buyAmount = keyboard.nextInt();
								break;
							}catch(InputMismatchException ime){
								System.out.println("Please enter a whole number.");
								keyboard.next();
							}	
						}
						while(buyAmount<0){
							System.out.println("Please enter a number greater than or equal to zero.");
							buyAmount = keyboard.nextInt();
						} 
						quantityChairs = quantityChairs + buyAmount;
						System.out.println("Price per item: ");
						while(true){
							try{
								pricePerItem = keyboard.nextDouble();
								break;
							}catch(InputMismatchException ime){
								System.out.println("Please enter a value greater than or equal to zero.");
								keyboard.next();
							}	
						}
						while(pricePerItem<0){
							System.out.println("Please enter a value greater than or equal to zero.");
							pricePerItem = keyboard.nextDouble();
						}
						currentBalance = currentBalance - (buyAmount * pricePerItem);
					}
					//user sets the new price for chairs
					else if(userChoice==3){
						System.out.print("New price: ");
						while(true){
							try{
								newPrice = keyboard.nextDouble();
								break;
							}catch(InputMismatchException ime){
								System.out.println("Please enter a value greater than or equal to zero.");
								keyboard.next();
							}	
						}
						while(newPrice<0){
							System.out.println("Please enter a value greater than or equal to zero.");
							pricePerItem = keyboard.nextDouble();
						}
						priceChairs = newPrice;
					}
				}
			}
			//This is the menu for if 'Desks' was selected. Presents and executes options for selling, buying, and changing the price, as well as a menu return.
			else if(userChoice==3){
				while(true){
					System.out.println("---------------");
					System.out.println("Current balance: "+fmtCurr.format(currentBalance));
					System.out.println("Current quantity: "+quantityDesks);
					System.out.println("Current price: "+fmtCurr.format(priceDesks));
					System.out.println("1. Sell "+productDesks);
					System.out.println("2. Buy "+productDesks);
					System.out.println("3. Change price");
					System.out.println("0. Return to main menu");
					System.out.print("Please enter choice: ");
					while(true){
						try{
							userChoice = keyboard.nextInt();
							break;
						} catch(InputMismatchException ime){
							System.out.println("Please enter an option from the menu, using 1, 2, 3, or 0.");
							keyboard.next();
						}	
					}
					while(!(userChoice==0||userChoice==1||userChoice==2||userChoice==3)){
						System.out.println("Please enter an option from the menu, using 1, 2, 3, or 0.");
						userChoice = keyboard.nextInt();
					}
					if(userChoice==0){
						System.out.println("Returning to main menu.");
						break;
					}
					//user decides how many desks to sell
					else if(userChoice==1){
						System.out.println("Amount to sell (current quality: "+productDesks+"): ");
						while(true){
							try{
								sellAmount = keyboard.nextInt();
								break;
							}catch(InputMismatchException ime){
								System.out.println("Please enter a whole number.");
								keyboard.next();
							}	
						}
						while(sellAmount<0){
							System.out.println("Please enter a number greater than or equal to zero.");
							sellAmount = keyboard.nextInt();
						}
						if(sellAmount>quantityDesks){
							System.out.println("Warning: Selling more than is in stock!");
							System.out.print("Do you wish to proceed (yes or no)?");
							String sellAnswer = keyboard.nextLine();
							while(!(sellAnswer.equalsIgnoreCase("yes")||sellAnswer.equalsIgnoreCase("no"))){
								System.out.println("Please enter yes or no.");
								sellAnswer = keyboard.nextLine();
							}
							if(sellAnswer.equalsIgnoreCase("yes")){
								quantityDesks = quantityDesks - sellAmount;
								currentBalance = currentBalance + (sellAmount * priceDesks);
							}	
						}
						else{
							quantityDesks = quantityDesks - sellAmount;
							currentBalance = currentBalance + (sellAmount * priceDesks);
						}	
					}
					//user decides how many desks to buy and at what price
					else if(userChoice==2){
						System.out.print("Amount to buy: ");
						while(true){
							try{
								buyAmount = keyboard.nextInt();
								break;
							}catch(InputMismatchException ime){
								System.out.println("Please enter a whole number.");
								keyboard.next();
							}	
						}
						while(buyAmount<0){
							System.out.println("Please enter a number greater than or equal to zero.");
							buyAmount = keyboard.nextInt();
						} 
						quantityDesks = quantityDesks + buyAmount;
						System.out.println("Price per item: ");
						while(true){
							try{
								pricePerItem = keyboard.nextDouble();
								break;
							}catch(InputMismatchException ime){
								System.out.println("Please enter a value greater than or equal to zero.");
								keyboard.next();
							}	
						}
						while(pricePerItem<0){
							System.out.println("Please enter a value greater than or equal to zero.");
							pricePerItem = keyboard.nextDouble();
						}
						currentBalance = currentBalance - (buyAmount * pricePerItem);
					}
					//user sets new price for desks
					else if(userChoice==3){
						System.out.print("New price: ");
						while(true){
							try{
								newPrice = keyboard.nextDouble();
								break;
							}catch(InputMismatchException ime){
								System.out.println("Please enter a value greater than or equal to zero.");
								keyboard.next();
							}	
						}
						while(newPrice<0){
							System.out.println("Please enter a value greater than or equal to zero.");
							pricePerItem = keyboard.nextDouble();
						}
						priceDesks = newPrice;
					}
				}
			}	
		}
		
		//saves new balance, quantities, and selling prices to file before ending program
		keyboard.close();
		PrintWriter outputFile = null;
		try{
			outputFile = new PrintWriter(filename);
		} catch(FileNotFoundException fnfe){
			System.out.println("Fatal error.");
			System.exit(0);
		} catch(Exception e){
			System.out.println("Fatal error.");
			System.exit(0);
		}
		
		outputFile.println(currentBalance);
		outputFile.print(productLamps);
		outputFile.print(" "+priceLamps);
		outputFile.println(" "+quantityLamps);
		outputFile.print(productChairs);
		outputFile.print(" "+priceChairs);
		outputFile.println(" "+quantityChairs);
		outputFile.print(productDesks);
		outputFile.print(" "+priceDesks);
		outputFile.println(" "+quantityDesks);
		outputFile.close();
    }
}