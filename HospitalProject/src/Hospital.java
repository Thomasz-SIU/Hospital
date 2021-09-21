/**
 * @author Thomas Zemen
 * User class takes and stores patients name, national ID, and previews Doctor availability.
 * After storing input, User class verifies with the user that their selection is correct
 * before calling the registry class and printing the appointment data to a txt file that the patient 
 * then print or download.
 */

public class Hospital {

	protected String apptDoc;	// Stores the doctor's name
	protected String name;		// Stores the patient's name
	protected int id;			// Stores the patient's ID

	private String[] docArray = {"Dr.James", "Dr.Townes", "Dr. Johnson", "Dr. Smith"};	// Stores the names of all the doctors
	private boolean[] available = {true, false, true, false};							// Stores the availability of corresponding doctors
	
	/**
	 * Constructor method
	 * 
	 * @param n Sets the patient's name.
	 * @param i	Sets the patient's ID.
	 * @param d	Sets the doctor's name.
	 */
	public Hospital(String n, int i, String d) 
	{
		name = n;
		id = i;
		apptDoc = d;
	}
	
	/**
	 * getDoctors method
	 * 
	 * @return	String of doctors from the array.
	 */
	public String[] getDoctors()
	{
		return docArray;
	}
	
	/**
	 * getAvailability method
	 * 
	 * @return	Show the availability of the doctors
	 */
	public boolean[] getAvailability()
	{
		return available;
	}

	/**
	 * getApptDoctor method
	 * 
	 * @return	Doctor name selected by the user.
	 */
	public String getApptDoctor()
	{
		return apptDoc;
	}
	
	/**
	 * getName method
	 * 
	 * @return	Patients name.
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * getId method
	 * 
	 * @return	Patient's ID.
	 */
	public int getId() 
	{
		return id;
	}
	
	/**
	 * setApptDoctor method
	 * 
	 * @param doc	Doctor name selected by the user.
	 */
	public void setApptDoctor(String doc)
	{
		apptDoc = doc;
	}
	
	/**
	 * setName 
	 * 
	 * @param name	Patients name.
	 */
	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	 * setID method
	 * 
	 * @param id	Patients ID.
	 */
	public void setId(int id) 
	{
		this.id = id;
	}
}
