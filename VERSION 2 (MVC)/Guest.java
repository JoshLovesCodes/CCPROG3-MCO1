public class Guest {
    private String firstName, lastName, fullName;
    
    public Guest(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
    }

    
    /** 
     * @return String
     */
    public String getFirstName() {
        return this.firstName;
    }

    
    /** 
     * @return String
     */
    public String getLastName() {
        return this.lastName;
    }

    
    /** 
     * @return String
     */
    public String getFullName() {
        return this.fullName;
    }
}