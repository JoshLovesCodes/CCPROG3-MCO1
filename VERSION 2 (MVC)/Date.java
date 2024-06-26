public class Date {
    private int day;

    public Date(int day) {
        this.day = day;
    } 

    
    /** 
     * @return int
     */
    public int getDay() {
        return this.day;
    }
 
    
    /** 
     * @param toBeChecked
     * @param toCompareTo
     * @return boolean
     */
    public static boolean isAfter(Date toBeChecked, Date toCompareTo) {
        if(toBeChecked.getDay() > toCompareTo.getDay())
            return true;

        return false;
    }
}