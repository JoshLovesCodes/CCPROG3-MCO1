/**
 * View class responsible for creating a hotel.
 */
import java.util.Scanner;

public class CreatorView {
    private Scanner scanner;

/**
 * Constructs the CreatorView class
 */
    public CreatorView() {
        this.scanner = new Scanner(System.in);
    }

/**
 * Displays a long divider
 */
    public static final void displayLongDivider() {
        System.out.println("==============================\n");
    }

/**
 * Displays a short divider
 */
    public static final void displayShortDivider() {
        System.out.println("===============");
    }

/**
 * Asks for the hotel name
 * @return the name of the hotel
 */
    public String promptHotelName() {
        displayLongDivider();

        System.out.println("Enter the name of new hotel: ");

        return this.scanner.next();
    }

/**
 * Displays a message if the creation of hotel is successful
 */
    public void displayNewHotelSuccessful(String newHotelName) {
        displayShortDivider();

        System.out.println("Created '" + newHotelName +"' successfully!");
    }

/**
 * Displays a message if the creation of hotel is unsuccessful
 */
    public void displayNewHotelFailed() {
        displayShortDivider();

        System.out.println("Creating hotel failed. Enter a unique name.");
    }
}
