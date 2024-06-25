import java.util.Scanner;

public class CreatorView {
    private Scanner scanner;
    public static final int CREATE = 1;

    public CreatorView() {
        this.scanner = new Scanner(System.in);
    }

    private void displayLongDivider() {
        System.out.println("==============================");
    }

    private void displayShortDivider() {
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

    public void displayNewHotelFailed(String newHotelName) {
        displayShortDivider();

        System.out.println("Creating hotel failed.");
    }
}
