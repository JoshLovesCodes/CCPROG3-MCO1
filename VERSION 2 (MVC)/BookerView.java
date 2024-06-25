import java.util.Scanner;

public class BookerView {
    private Scanner scanenr;

    public BookerView() {
        this.scanenr = new Scanner(System.in);   
    }

    public String promptMonth() {
        System.out.println("Enter month: ");
        return this.scanenr.nextLine();
    }
    
    public String promptDay() {
        System.out.println("Enter day: ");
        return this.scanenr.nextLine();
    }
    
    
    public String promptYear() {
        System.out.println("Enter year: ");
        return this.scanenr.nextLine();
    }
    
    public String promptFirstName() {
        System.out.println("Enter your first name: ");
        return this.scanenr.nextLine();
    }
    
    public String promptLastName() {
        System.out.println("Enter your last name: ");
        return this.scanenr.nextLine();
    }

    public void displayReservationFailed() {
        System.out.println("Hotel is fully booked please select a different date");
    }
    
}
