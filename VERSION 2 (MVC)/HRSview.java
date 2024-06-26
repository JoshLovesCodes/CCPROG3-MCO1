import java.util.Scanner;

public class HRSview {
    private Scanner scanner;
    public static final int CREATE_HOTEL = 1, VIEW_HOTEL = 2, MANAGE_HOTEL = 3, SIMULATE_BOOKING = 4, EXIT = 5;

    public HRSview() {
        this.scanner = new Scanner(System.in);
    }

    public int promptInfoMenuResponse() {
        System.out.println("\nWhat can I do for you today?");
        System.out.println("1) Create Hotel");
        System.out.println("2) View Hotel");
        System.out.println("3) Manage Hotel");
        System.out.println("4) Simulate Booking");
        System.out.println("5) Exit");
        System.out.print("Enter your choice here: ");

        return this.scanner.nextInt();
    }

    public void displayWelcomeMessage() {
        System.out.println("Welcome to Hotel Reservation System!");
    }

    public void displayInvalidInput() {
        System.out.println("Invalid input try again.");
    }
}

