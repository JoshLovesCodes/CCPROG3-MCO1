/**
 * View class responsible for simulating a booking.
 */
import java.util.Scanner;

public class BookerView {
    private Scanner scanner;

/**
 * Constructs the BookerView class
 */
    public BookerView() {
        this.scanner = new Scanner(System.in);   
    }

/**
 * Displays the check-in message
 */
    public void displayCheckIn() {
        System.out.println("Please enter your Check In Date");
    }

/**
 * Displays the check-out message
 */
    public void displayCheckOut() {
        System.out.println("Please enter your Check Out Date");
    }

/**
 * Asks for the hotel name
 * @return the name of the hotel
 */
    public String promptHotelName() {
        System.out.println("Enter Hotel name: ");
        return this.scanner.next();
    }
    
/**
 * Asks for the day
 * @return the day
 */
    public int promptDay() {
        System.out.println("Enter day: ");
        return this.scanner.nextInt();
    }

/**
 * Asks for the first name
 * @return the first name
 */
    public String promptFirstName() {
        System.out.println("Enter your first name: ");
        return this.scanner.next();
    }

/**
 * Asks for the last name
 * @return the last name
 */
    public String promptLastName() {
        System.out.println("Enter your last name: ");
        return this.scanner.next();
    }

/**
 * Displays a message if the check-in date is earlier than check-out date
 */
    public void displayTimeFrameFailed() {
        System.out.println("Check In Date is must be before the Check Out Date");
    }

/**
 * Displays a message if the reservation failed because the hotel is fully booked
 */
    public void displayReservationFailed() {
        System.out.println("Hotel is fully booked please select a different date");
    }

/**
 * Displays a message if the reservation is a success
 */
    public void displayReservationSuccess() {
        System.out.println("Reservation has been successfully added");
    }

/**
 * Displays a message if the hotel is not found
 */
    public void displayHotelNotFound() {
        System.out.println("Hotel does not exist");
    }

/**
 * Displays a message if the booking is just one day
 */
    public void displaySameDayInvalid() {
        System.out.println("You can't book for just a day.");
    }    
}
