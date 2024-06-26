import java.util.Scanner;

public class BookerView {
    private Scanner scanner;

    public BookerView() {
        this.scanner = new Scanner(System.in);   
    }

    public void displayCheckIn() {
        System.out.println("Please enter your Check In Date");
    }

    public void displayCheckOut() {
        System.out.println("Please enter your Check Out Date");
    }

    public String promptHotelName() {
        System.out.println("Enter Hotel name: ");
        return this.scanner.next();
    }
    
    public int promptDay() {
        System.out.println("Enter day: ");
        return this.scanner.nextInt();
    }
    
    public String promptFirstName() {
        System.out.println("Enter your first name: ");
        return this.scanner.next();
    }
    
    public String promptLastName() {
        System.out.println("Enter your last name: ");
        return this.scanner.next();
    }

    public void displayTimeFrameFailed() {
        System.out.println("Check In Date is must be before the Check Out Date");
    }

    public void displayReservationFailed() {
        System.out.println("Hotel is fully booked please select a different date");
    }

    public void displayReservationSuccess() {
        System.out.println("Reservation has been successfully added");
    }

    public void displayHotelNotFound() {
        System.out.println("Hotel does not exist");
    }

    public void displaySameDayInvalid() {
        System.out.println("You can't book for just a day.");
    }    
}
