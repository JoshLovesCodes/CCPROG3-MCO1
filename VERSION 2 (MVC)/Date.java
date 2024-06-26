/**
 * Manages the date functionality in the program.
 */

public class Date {
    private int day;

/**
 * Constructs the Date class with a specified day
 * @param day the day in a month
 */
    public Date(int day) {
        this.day = day;
    } 

    
/** 
 * Gets the day
 * @return the day
  */
public int getDay() {
    return this.day;
}
 
    
/**
 * Checks if the date given is after the date compared to
 * @param toBeChecked date that will be checked
 * @param toCompareTo date that will be compared to the given date
 * @return true if it is after the compared day, false if not
 */
public static boolean isAfter(Date toBeChecked, Date toCompareTo) {
    if(toBeChecked.getDay() > toCompareTo.getDay())
        return true;

    return false;
    }
}