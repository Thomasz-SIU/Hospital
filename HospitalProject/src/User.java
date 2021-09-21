/**
 * @author Thomas Zemen
 * User class takes and stores patients name, national ID, and previews Doctor availability.
 * After storing input, User class verifies with the user that their selection is correct
 * before calling the registry class and printing the appointment data to a txt file that the patient 
 * then print or download.
 */

import java.util.Scanner;
import java.io.*;

public class User {

	public static void main(String[] args) throws IOException{
		
				Scanner keyboard = new Scanner(System.in);
				
				String name = null;				// Stores the patient's name
				String isAvailable = null;		// Stores the doctor's availability as a string
				String apptDoctor = null;		// Stores the doctor's name that the user selected
				String finalChoice = null;		// Stores the user input to check if the user wants to change their doctor choice
				String confirmation = null;		// Stores the user input to check if the ticket information is correct
				int nationalId = 0;				// Stores the patients national ID
				int doctorChoice = 0;			// Stores the integer value of the doctor selected by the user

				System.out.println("Welcome to Carbondale Hospital Patient Registry Management System");
				
				
				/* 
				 * 	Prompts the user for their name and national ID and
				 * 	stores those values in the appropriate variables. 
				 */
				System.out.print("\nPlease enter your name: ");
				name = keyboard.nextLine();
				
				System.out.print("\nPlease enter your national ID : ");
				nationalId = keyboard.nextInt();
				keyboard.nextLine();
				
				Registry user = new Registry(name, nationalId, apptDoctor);
				
			    String[] physician = user.getDoctors();
			    boolean[] availability = user.getAvailability();
			    
			    
				/*
				 * 	Displays a list of the doctors names with their 
				 * 	corresponding numbers to the left and their
				 * 	availability to the right.
				 */
				System.out.println("\nA list of our physicians is found below, along with their availability:\n");
				
				for(int i = 0; i < physician.length; i++)
				{
					if(availability[i])
						isAvailable = "Available";
					else
						isAvailable = "Unavailable";
					
					System.out.println("[" + (i + 1) + "] " + physician[i] + " availibility today: " + isAvailable + "\n");
					
				}
				
				
				/*
				 * 	Prompts the user to choose a doctor by entering
				 * 	the corresponding number. It checks to see if 
				 * 	the user enters information correctly and continues
				 * 	to ask for input if they enter incorrect values.
				 * 
				 * 	It stores the user selected doctors name in the 
				 * 	appropriate variable.
				 * 
				 * 	Checks to see if the doctor selected is available 
				 *	and prompts the user to select a different doctor
				 *	if the selected doctor is unavailable.
				 */
				do
				{
					do
					{
						System.out.print("Please choose a doctor by entering a number seen to the left of the options: ");
						doctorChoice = keyboard.nextInt();
						keyboard.nextLine();

						switch(doctorChoice)
						{
							case 1:
									System.out.print("\nYou have chosen " + physician[0] + ". Is this your final choice? (Y/N) ");
									finalChoice = keyboard.nextLine();
									System.out.println();
										
									while(!finalChoice.equalsIgnoreCase("n") && !finalChoice.equalsIgnoreCase("n") && !finalChoice.equalsIgnoreCase("y") && !finalChoice.equalsIgnoreCase("yes"))
							    	{
							    		System.out.print("\nPlease enter yes or no: ");
							    		finalChoice = keyboard.nextLine();
							    	}
										
									apptDoctor = physician[0];
									break;
							case 2:
								System.out.print("\nYou have chosen " + physician[1] + ". Is this your final choice? (Y/N) ");
								finalChoice = keyboard.nextLine();
								System.out.println();
								
								while(!finalChoice.equalsIgnoreCase("n") && !finalChoice.equalsIgnoreCase("n") && !finalChoice.equalsIgnoreCase("y") && !finalChoice.equalsIgnoreCase("yes"))
						    	{
						    		System.out.print("\nPlease enter yes or no: ");
						    		finalChoice = keyboard.nextLine();
						    	}
									
								apptDoctor = physician[1];
								break;
							case 3:
								System.out.print("\nYou have chosen " + physician[2] + ". Is this your final choice? (Y/N) ");
								finalChoice = keyboard.nextLine();
								System.out.println();
									
								while(!finalChoice.equalsIgnoreCase("n") && !finalChoice.equalsIgnoreCase("n") && !finalChoice.equalsIgnoreCase("y") && !finalChoice.equalsIgnoreCase("yes"))
						    	{
						    		System.out.print("\nPlease enter yes or no: ");
						    		finalChoice = keyboard.nextLine();
						    	}
									
								apptDoctor = physician[2];
								break;
							case 4:
								System.out.print("\nYou have chosen " + physician[3] + ". Is this your final choice? (Y/N) ");
								finalChoice = keyboard.nextLine();
								System.out.println();
								
								while(!finalChoice.equalsIgnoreCase("n") && !finalChoice.equalsIgnoreCase("n") && !finalChoice.equalsIgnoreCase("y") && !finalChoice.equalsIgnoreCase("yes"))
						    	{
						    		System.out.print("\nPlease enter yes or no: ");
						    		finalChoice = keyboard.nextLine();
						    	}
									
								apptDoctor = physician[3];
								break;
							default:
								System.out.println("\nError, please enter a number listed.\n");
								break;
							}
					} while((finalChoice.equalsIgnoreCase("n") || finalChoice.equalsIgnoreCase("no")) || (doctorChoice < 1 || doctorChoice > 4));
					
					if(availability[doctorChoice - 1] == false)
						System.out.println("This doctor is not available please choose an available doctor.\n");
					
				} while(availability[doctorChoice - 1] == false);
				
				
				/*
				 * 	Sets the selected doctor so that it can be
				 * 	displayed on the ticket. Then displays the
				 * 	ticket and asks the user if the information
				 * 	is correct.
				 */
				user.setApptDoctor(apptDoctor);
				System.out.print("\n" + user.toString() + "\n\n\nIs this information correct? (Y/N): ");
				confirmation = keyboard.nextLine();
		        
				
				/*
				 * 	If the user says the information is correct
				 * 	it prints the ticket into a file using the
				 * 	ticket() method from the registry subclass.
				 */
		        if(confirmation.equalsIgnoreCase("y") || confirmation.equalsIgnoreCase("yes"))
		        {
		        	System.out.println("\nPrinting ticket...");
		        }
		        else 
		        {
		        	while(!confirmation.equalsIgnoreCase("n") && !confirmation.equalsIgnoreCase("n") && !confirmation.equalsIgnoreCase("y") && !confirmation.equalsIgnoreCase("yes"))
		    		{
		    			System.out.print("\nPlease enter yes or no: ");
		    			confirmation = keyboard.nextLine();
		    		}
		        	
		            while (confirmation.equalsIgnoreCase("n") || confirmation.equalsIgnoreCase("no"))
		            {
		                System.out.print("\nPlease enter your name: ");
		                user.setName(keyboard.nextLine());

		                System.out.print("\nPlease enter your national id: ");
		                user.setId(keyboard.nextInt());
		                keyboard.nextLine();

		                System.out.print("\n\n" + user.toString() + "\n\n\nIs this information correct? (Y/N): ");
		                confirmation = keyboard.nextLine();
		            }
		            
		            System.out.println("\nPrinting ticket...");
		        }
		        user.ticket();
		keyboard.close();
	}
}