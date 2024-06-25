import java.util.Scanner;

public class HotelViewerView {
    private Scanner scanner;
    public static final int HIGH_LVL = 1, TOTAL_ROOM = 2, INFO_ROOM = 3, INFO_RESERVATION = 4, INFO_EXIT = 5;

    public HotelViewerView() {
        this.scanner = new Scanner(System.in);
    }

    public static final void displayLongDivider() {
        System.out.println("==============================\n");
    }

    public static final void displayShortDivider() {
        System.out.println("===============");
    }
    
    public int promptInfoMenuResponse() {
        System.out.println("What information do you want to see?");
        System.out.println("1) Basic Information");
        System.out.println("2) Total Number of Rooms");
        System.out.println("3) Room Information");
        System.out.println("4) Reservation Information");
        System.out.println("5) Go Back");
        System.out.print("Enter your choice here: ");
        return this.scanner.nextInt();
    }

    public String promptHotelName() {
        System.out.println("What is the name of the hotel? ");

        return this.scanner.nextLine();
    }

    public String promptLastName() {
        System.out.println("Enter last name: ");

        return this.scanner.next();
    }

    public String promptFirstName() {
        System.out.println("Enter first name: ");

        return this.scanner.next();
    }

    public int promptMonth() {
        System.out.println("Enter month (1-12): ");

        return this.scanner.nextInt();
    }

    public int promptDay() {
        System.out.println("Enter day (1-31): ");

        return this.scanner.nextInt();
    }

    public int promptYear() {
        System.out.println("Enter year: ");

        return this.scanner.nextInt();
    }

    public String promptRoomName() {
        System.out.println("Enter Room Name: ");

        return this.scanner.nextLine();
    }

    public void displayHighLevelInfo(Hotel hotel) {
        System.out.println("Name: " + hotel.getName());
        System.out.println("Total number of rooms: " + hotel.getRoomList().size());
        System.out.println("Estimated earnings for the month: " + hotel.getEarnings());
    }

    public void displayRoomAvailability(Date date, int freeRooms, int bookedRooms) {
        String info = "Availability of Rooms for" + date.getMonth() + "/" + date.getDay() + "/" + date.getYear() + ": ";
        System.out.println(info);
        System.out.println("Available: " + freeRooms);
        System.out.println("Booked: " + bookedRooms);
    }

    public void displayRoomInformation(Room room, boolean[] roomAvailability, String month) {
        System.out.println("Room name: " + room.getName());
        System.out.println("Price per night: " + room.getPrice());
        System.out.println("Availability for the month of " + month + ": ");

        int i, day;
        for(i = 0; i < 31; i++) {
            day = i+1;
            if(day % 7 == 0) {
                System.out.println("\n");
            }

            if(roomAvailability[i]) {
                System.out.println("Day " + day + ": Available");
            } else {
                System.out.println("Day " + day + ": Booked");
            }

        }
    }

    public void displayReservationInfo(Reservation reservation) {
        System.out.println("Guest Name: " + reservation.getGuest().getFullName());
        System.out.println("Room Name: " + reservation.getRoom().getName());
        System.out.println("Room Price: " + reservation.getRoom().getPrice());
        System.out.println("Check-In Date: " + reservation.getCheckInDate().getMonth() + "/" + reservation.getCheckInDate().getDay() + "/" + reservation.getCheckInDate().getYear());
        System.out.println("Check-In Date: " + reservation.getCheckOutDate().getMonth() + "/" + reservation.getCheckOutDate().getDay() + "/" + reservation.getCheckOutDate().getYear());
        System.out.println("Reservation Cost: " + reservation.getTotalPrice());
        System.out.println("Breakdown Cost Per Night: " + reservation.getCostPerNight());
    }
}
