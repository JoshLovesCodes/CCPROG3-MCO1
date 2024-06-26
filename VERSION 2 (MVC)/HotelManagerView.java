import java.util.Scanner;

public class HotelManagerView {
    private Scanner scanner;
    public static final int CHANGE_NAME = 1, ADD_ROOM = 2, REMOVE_ROOM = 3, UPDATE_PRICE = 4, REMOVE_RESERVATION = 5, REMOVE_HOTEL = 6, MANAGER_EXIT = 7;

    public HotelManagerView() {
        this.scanner = new Scanner(System.in);
    }

    public int promptInfoMenuResponse() {
        System.out.println("What do you want to do?");
        System.out.println("1) Change Hotel Name");
        System.out.println("2) Add Room(s)");
        System.out.println("3) Remove Room(s)");
        System.out.println("4) Update Room Base Price");
        System.out.println("5) Remove Reservation");
        System.out.println("6) Remove Hotel");
        System.out.println("7) Go Back");
        System.out.print("Enter your choice here: ");

        return this.scanner.nextInt();
    }
    public String promptHotelName() {
        System.out.println("Enter name of the hotel: ");

        return this.scanner.next();
    }

    public String promptNewHotelName() {
        System.out.println("Enter NEW name of the hotel: ");

        return this.scanner.next();
    }

    public char promptConfirmation() {
        System.out.println("Do you want to continue? (Y-yes / N-no)");

        return this.scanner.next().charAt(0);
    }

    public char promptAddingRoom() {
        System.out.println("Do you want to add single(S) or multiple(M) rooms? ");

        return this.scanner.next().charAt(0);
    }

    public int promptNumberOfRooms() {
        System.out.println("Enter number of rooms to be added: ");

        return this.scanner.nextInt();
    }

    public char promptRemovingRoom() {
        System.out.println("Do you want to remove single(S) or multiple(M) rooms? ");

        return this.scanner.next().charAt(0);
    }

    public int promptRemoveNumberOfRooms() {
        System.out.println("Enter number of rooms to be removed: ");

        return this.scanner.nextInt();
    }

    public double promptNewPrice() {
        System.out.println("Enter new base price of rooms: ");

        return this.scanner.nextDouble();
    }

    public String promptFirstName() {
        System.out.println("Enter first name of guest: ");

        return this.scanner.next();
    }

    public String promptLastName() {
        System.out.println("Enter last name of guest: ");

        return this.scanner.next();
    }

    public void displayChangeNameInfo(String oldName, String newName) {
        System.out.println("Current Name: " + oldName);
        System.out.println("Will be changed to: " + newName);
    }

    public void displayChangeNameSuccess() {
        System.out.println("Changed hotel name successfully.");
    }

    public void displayChangeNameFailed() {
        System.out.println("Change hotel name failed.");
    }

    public void displayAddSingleRoom() {
        System.out.println("1 room will be added.");
    }

    public void displayAddRoomSuccess() {
        System.out.println("1 room successfully added.");
    }

    public void displayAddRoomFailed() {
        System.out.println("1 room failed to be added.");
    }

    public void displayAddMultipleRoom(int size) {
        System.out.println(size + " rooms will be added.");
    }

    public void displayAddMultipleRoomSuccess(int size) {
        System.out.println(size + " rooms successfully added.");
    }

    public void displayAddMultipleRoomFailed() {
        System.out.println("Number of rooms to be added exceeds maximum capacity.");
    }

    public void displayRemoveSingleRoom() {
        System.out.println("1 room will be removed.");
    }

    public void displayRemoveRoomSuccess() {
        System.out.println("1 room successfully removed.");
    }

    public void displayRemoveRoomFailed() {
        System.out.println("1 room failed to be removed.");
    }

    public void displayRemoveMultipleRoom(int size) {
        System.out.println(size + " rooms will be removed.");
    }

    public void displayRemoveMultipleRoomSuccess(int size) {
        System.out.println(size + " rooms successfully removed.");
    }

    public void displayRemoveMultipleRoomFailed() {
        System.out.println("Hotel can't have zero rooms or all rooms have reservation.");
    }

    public void displayPromptPriceInvalid() {
        System.out.println("New price is less than 100.00");
    }

    public void displayUpdatePriceInfo(double oldPrice, double newPrice) {
        System.out.println("Current Price: " + oldPrice);
        System.out.println("New Price: " + newPrice);
    }

    public void displayUpdatePriceSuccess() {
        System.out.println("Base price successfully changed.");
    }

    public void displayUpdatePriceFailed() {
        System.out.println("Base price can't be changed because there are reservations.");
    }

    public void displayRemoveReservationInfo(String firstName, String lastName) {
        System.out.println("Reservation of " + firstName + " " + lastName + " will be removed.");
    }

    public void displayRemoveReservationSuccess() {
        System.out.println("Removed reservation successfully.");
    }

    public void displayRemoveReservationFailed() {
        System.out.println("Reservation doesn't exist.");
    }

    public void displayRemoveHotelInfo() {
        System.out.println("You will be removing this hotel.");
    }

    public void displayRemoveHotelSuccess() {
        System.out.println("Removed hotel successfully.");
    }

    public void displayRemoveHotelFailed() {
        System.out.println("Removing hotel failed.");
    }

    public void displayInvalidInput() {
        System.out.println("Invalid input try again.");
    }


}
