import java.util.Scanner;

public class CreatorView {
    private Scanner scanner;

    public CreatorView() {
        this.scanner = new Scanner(System.in);
    }

    public static final void displayLongDivider() {
        System.out.println("==============================\n");
    }

    public static final void displayShortDivider() {
        System.out.println("===============");
    }

    public String promptHotelName() {
        displayLongDivider();

        System.out.println("Enter the name of new hotel: ");

        return this.scanner.next();
    }

    public void displayNewHotelSuccessful(String newHotelName) {
        displayShortDivider();

        System.out.println("Created '" + newHotelName +"' successfully!");
    }

    public void displayNewHotelFailed() {
        displayShortDivider();

        System.out.println("Creating hotel failed. Enter a unique name.");
    }
}
