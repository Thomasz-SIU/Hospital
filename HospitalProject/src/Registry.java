/**
 * @author Thomas Zemen
 * User class takes and stores patients name, national ID, and previews Doctor availability.
 * After storing input, User class verifies with the user that their selection is correct
 * before calling the registry class and printing the appointment data to a txt file that the patient 
 * then print or download.
 */

import java.io.*;

public class Registry extends Hospital{
	
	/**
	 * Constructor method
	 * 
	 * @param n Stores the patient's from the superclass.
	 * @param i	Stores the patient's ID from the superclass.
	 * @param d	Stores the doctor's name from the superclass.
	 */
	public Registry(String n, int i, String d)
	{
		super(n, i, d);
	}
	
	/**
	 * ticket method
	 * Prints the appointment ticket to a file called appointment.txt.
	 * @throws IOException
	 */
	public void ticket() throws IOException{
		
		File file = new File("appointment.txt");
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);
		pw.print(toString());
		pw.close();
	}
	
	/**
	 * toString method
	 * 
	 * @return	The appointment ticket as a string.
	 */
	public String toString() {
		
		return "Appointment Ticket\n" + 
				"-------------------\n" 
							+ "Name: " + getName() + 
							"\nID: "+ getId() + "\nDoctor: " + getApptDoctor();
	}

}
