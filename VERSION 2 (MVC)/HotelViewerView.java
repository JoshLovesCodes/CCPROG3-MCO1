/**
 * View class responsible for viewing a hotel.
 */
import java.util.Scanner;
import java.util.ArrayList;

public class HotelViewerView {
    private Scanner scanner;
    public static final int HIGH_LVL = 1, TOTAL_ROOM = 2, INFO_ROOM = 3, INFO_RESERVATION = 4, INFO_EXIT = 5;

/**
 * Constructs the BookerView class
 */
    public HotelViewerView() {
        this.scanner = new Scanner(System.in);
    }

/**
 * Displays a long divider
 */
    public static final void displayLongDivider() {
        System.out.println("==============================");
    }


/**
 * Displays a short divider
 */
    public static final void displayShortDivider() {
        System.out.println("===============");
    }

/**
 * Asks for a response in a menu of options
 * @return the response
 */
    public int promptInfoMenuResponse() {
        System.out.println("\nWhat information do you want to see?");
        System.out.println("1) Basic Information");
        System.out.println("2) Total Number of Rooms");
        System.out.println("3) Room Information");
        System.out.println("4) Reservation Information");
        System.out.println("5) Go Back");
        System.out.print("Enter your choice here: ");
        return this.scanner.nextInt();
    }

/**
 * Asks for the hotel name
 * @return the hotel name
 */
    public String promptHotelName() {
        System.out.println("Enter name of the hotel: ");

        return this.scanner.nextLine();
    }

/**
 * Asks for the last name of the guest
 * @return the last name
 */
    public String promptLastName() {
        System.out.println("Enter last name: ");

        return this.scanner.next();
    }

/**
 * Asks for the first name of the guest
 * @return the first name
 */
    public String promptFirstName() {
        System.out.println("Enter first name: ");

        return this.scanner.next();
    }
    
/**
 * Asks for the day
 * @return the day
 */
    public int promptDay() {
        System.out.println("Enter day (1-31): ");

        return this.scanner.nextInt();
    }

    
/**
 * Asks for the room name
 * @return the room name
 */
    public String promptRoomName() {
        System.out.println("Enter Room Name: ");

        return this.scanner.next();
    }

/**
 * Displays the high level information of the hotel
 * @param hotel the hotel to be viewed
 */
    public void displayHighLevelInfo(Hotel hotel) {
        HotelViewerView.displayLongDivider();
        System.out.println("Name: " + hotel.getName());
        System.out.println("Total number of rooms: " + hotel.getRoomList().size());
        System.out.println("Estimated earnings for the month: " + hotel.getEarnings());
    }

/**
 * Displays the availablity of the room
 * @param date the day to be checked
 * @param freeRooms the number of available rooms
 * @param bookedRooms the number of booked rooms
 */
    public void displayRoomAvailability(Date date, int freeRooms, int bookedRooms) {
        HotelViewerView.displayLongDivider();
        String info = "Availability of Rooms for Day" + date.getDay() + ": ";
        System.out.println(info);
        System.out.println("Available: " + freeRooms);
        System.out.println("Booked: " + bookedRooms);
    }

/**
 * Displays the information of a room
 * @param room the room to be viewed
 * @param roomAvailability list of days the room is booked or available
 */
    public void displayRoomInformation(Room room, boolean[] roomAvailability) {
        System.out.println("Room name: " + room.getName());
        System.out.println("Price per night: " + room.getPrice());
        System.out.println("Availability for the whole month: ");

        int i, day;
        for(i = 0; i < 31; i++) {
            day = i+1;
            if(day % 8 == 0) {
                System.out.println("\n");
            }

            if(roomAvailability[i]) {
                System.out.println("Day " + day + ": Available");
            } else {
                System.out.println("Day " + day + ": Booked");
            }

        }
    }

/**
 * Displays the info of a reservation
 * @param reservationList list of reservations
 * @param fees fees in a hotel
 */
    public void displayReservationInfo(ArrayList<Reservation> reservationList, Fees fees) {
        for (Reservation r: reservationList) {
            HotelViewerView.displayShortDivider();
            System.out.println("Guest Name: " + r.getGuest().getFullName());
            System.out.println("Room Name: " + r.getRoom().getName());
            System.out.println("Room Price: " + r.getRoom().getPrice());
            System.out.println("Check-In Day: " + r.getCheckInDate().getDay());
            System.out.println("Check-In Day: " + r.getCheckOutDate().getDay());
            System.out.println("Reservation Cost: " + r.getTotalPrice(fees));
            System.out.println("Breakdown Cost Per Night: " + r.getCostPerNight(fees));
            HotelViewerView.displayShortDivider();
        }
        
    }

/**
 * Displays message if hotel not found
 */
    public void displayHotelNotFound() {
        System.out.println("Hotel does not exist");
    }    

/**
 * Displays message if room not found
 */
    public void displayRoomNotFound() {
        System.out.println("Room does not exist");
    }   

/**
 * Displays message if reservation not found
 */
    public void displayReservationNotFound() {
        System.out.println("Reservation does not exist");
    }    
}
