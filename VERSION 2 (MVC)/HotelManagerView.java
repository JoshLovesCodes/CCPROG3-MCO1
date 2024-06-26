/**
 * View class responsible for managing a hotel.
 */
import java.util.Scanner;

public class HotelManagerView {
    private Scanner scanner;
    public static final int CHANGE_NAME = 1, ADD_ROOM = 2, REMOVE_ROOM = 3, UPDATE_PRICE = 4, REMOVE_RESERVATION = 5, REMOVE_HOTEL = 6, MANAGER_EXIT = 7;

/**
 * Constructs the BookerView class
 */
    public HotelManagerView() {
        this.scanner = new Scanner(System.in);
    }

/**
 * Asks for a response in a menu of options
 * @return the response
 */
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

/**
 * Asks for the hotel name
 * @return the hotel name
 */
    public String promptHotelName() {
        System.out.println("Enter name of the hotel: ");

        return this.scanner.next();
    }


/**
 * Asks for the new hotel name
 * @return the new hotel name
 */
    public String promptNewHotelName() {
        System.out.println("Enter NEW name of the hotel: ");

        return this.scanner.next();
    }

/**
 * Asks for confirmation
 * @return Y/y if yes, N/n if no
 */
    public char promptConfirmation() {
        System.out.println("Do you want to continue? (Y-yes / N-no)");

        return this.scanner.next().charAt(0);
    }


/**
 * Asks for what mode in adding rooms
 * @return S/s for single room, M/m for multiple room
 */
    public char promptAddingRoom() {
        System.out.println("Do you want to add single(S) or multiple(M) rooms? ");

        return this.scanner.next().charAt(0);
    }


/**
 * Asks for the number of rooms to be added
 * @return the number of rooms
 */
    public int promptNumberOfRooms() {
        System.out.println("Enter number of rooms to be added: ");

        return this.scanner.nextInt();
    }

/**
 * Asks for the mode of removing rooms
 * @return S/s if single room, M/m for multiple rooms
 */
    public char promptRemovingRoom() {
        System.out.println("Do you want to remove single(S) or multiple(M) rooms? ");

        return this.scanner.next().charAt(0);
    }

/**
 * Asks for the number of rooms to be removed
 * @return the number of rooms to be removed
 */
    public int promptRemoveNumberOfRooms() {
        System.out.println("Enter number of rooms to be removed: ");

        return this.scanner.nextInt();
    }

/**
 * Asks for the new price
 * @return the new price
 */
    public double promptNewPrice() {
        System.out.println("Enter new base price of rooms: ");

        return this.scanner.nextDouble();
    }

/**
 * Asks for the first name of the guest
 * @return the first name
 */
    public String promptFirstName() {
        System.out.println("Enter first name of guest: ");

        return this.scanner.next();
    }

/**
 * Asks for the last name of the guest
 * @return the last name
 */
    public String promptLastName() {
        System.out.println("Enter last name of guest: ");

        return this.scanner.next();
    }

/**
 * Displays the changing name information
 */
    public void displayChangeNameInfo(String oldName, String newName) {
        System.out.println("Current Name: " + oldName);
        System.out.println("Will be changed to: " + newName);
    }

/**
 * Displays the change name success message
 */
    public void displayChangeNameSuccess() {
        System.out.println("Changed hotel name successfully.");
    }

/**
 * Displays the change name failed message
 */
    public void displayChangeNameFailed() {
        System.out.println("Change hotel name failed.");
    }

/**
 * Displays 1 room will be added.
 */
    public void displayAddSingleRoom() {
        System.out.println("1 room will be added.");
    }


/**
 * Displays 1 room successfully added.
 */
    public void displayAddRoomSuccess() {
        System.out.println("1 room successfully added.");
    }

/**
 * Displays a message if adding room failed.
 */
    public void displayAddRoomFailed() {
        System.out.println("1 room failed to be added.");
    }

/**
 * Displays a message for adding multiple rooms.
 */
    public void displayAddMultipleRoom(int size) {
        System.out.println(size + " rooms will be added.");
    }

/**
 * Displays a message if adding multiple room is successful.
 */
    public void displayAddMultipleRoomSuccess(int size) {
        System.out.println(size + " rooms successfully added.");
    }
    
/**
 * Displays a message if adding multiple room failed.
 */
    public void displayAddMultipleRoomFailed() {
        System.out.println("Number of rooms to be added exceeds maximum capacity.");
    }

/**
 * Displays a message for removing room.
 */
    public void displayRemoveSingleRoom() {
        System.out.println("1 room will be removed.");
    }
    
/**
 * Displays a message if removing room is successful.
 */
    public void displayRemoveRoomSuccess() {
        System.out.println("1 room successfully removed.");
    }
    
/**
 * Displays a message if removing room failed.
 */
    public void displayRemoveRoomFailed() {
        System.out.println("1 room failed to be removed.");
    }
    
/**
 * Displays a message for removing multiple room.
 */
    public void displayRemoveMultipleRoom(int size) {
        System.out.println(size + " rooms will be removed.");
    }
    
/**
 * Displays a message if adding multiple room succeded.
 */
    public void displayRemoveMultipleRoomSuccess(int size) {
        System.out.println(size + " rooms successfully removed.");
    }
    
/**
 * Displays a message if adding multiple room failed.
 */
    public void displayRemoveMultipleRoomFailed() {
        System.out.println("Hotel can't have zero rooms or all rooms have reservation.");
    }
    
/**
 * Displays a message if new price is invalid.
 */
    public void displayPromptPriceInvalid() {
        System.out.println("New price is less than 100.00");
    }
    
/**
 * Displays a message for changing price information.
 */
    public void displayUpdatePriceInfo(double oldPrice, double newPrice) {
        System.out.println("Current Price: " + oldPrice);
        System.out.println("New Price: " + newPrice);
    }

    
/**
 * Displays a message if changing price succeeded.
 */
    public void displayUpdatePriceSuccess() {
        System.out.println("Base price successfully changed.");
    }
    
/**
 * Displays a message if changing price failed.
 */
    public void displayUpdatePriceFailed() {
        System.out.println("Base price can't be changed because there are reservations.");
    }
    
/**
 * Displays a message for removing reservation.
 */
    public void displayRemoveReservationInfo(String firstName, String lastName) {
        System.out.println("Reservation of " + firstName + " " + lastName + " will be removed.");
    }
    
/**
 * Displays a message if removing reservation succeeded.
 */
    public void displayRemoveReservationSuccess() {
        System.out.println("Removed reservation successfully.");
    }
    
/**
 * Displays a message if removing reservation failed.
 */
    public void displayRemoveReservationFailed() {
        System.out.println("Reservation doesn't exist.");
    }

/**
 * Displays a message for removing a hotel.
 */
    public void displayRemoveHotelInfo() {
        System.out.println("You will be removing this hotel.");
    }

    
/**
 * Displays a message if removing hotel succeeded.
 */
    public void displayRemoveHotelSuccess() {
        System.out.println("Removed hotel successfully.");
    }
    
/**
 * Displays a message if removing hotel failed.
 */
    public void displayRemoveHotelFailed() {
        System.out.println("Removing hotel failed.");
    }
    
/**
 * Displays a message if input is invalid.
 */
    public void displayInvalidInput() {
        System.out.println("Invalid input try again.");
    }


}
