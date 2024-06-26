/**
 * Class for guest in the system.
 */
public class Guest {
    private String firstName, lastName, fullName;

/**
 * Constructs the Guest class with a first name and last name
 * @param firstName the first name of the guest
 * @param lastName the last name of the guest
 */   
    public Guest(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
    }

    
    /**
     * Gets the first name of the guest
     * @return the first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    
    /**
     * Gets the last name of the guest
     * @return the last name
     */
    public String getLastName() {
        return this.lastName;
    }

    
    /**
     * Gets the full name of the guest 
     * @return the full name
     */
    public String getFullName() {
        return this.fullName;
    }
}