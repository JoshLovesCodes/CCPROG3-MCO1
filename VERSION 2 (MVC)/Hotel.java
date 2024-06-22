import java.util.ArrayList;

public class Hotel {
    private String name;
    private ArrayList<Room> roomList;
    private ArrayList<Reservation> reservationList;
    private int maximumRooms;

    public Hotel(String name){
        this.name = name;
        this.roomList = new ArrayList<Room>();
        this.reservationList = new ArrayList<Reservation>();
        this.maximumRooms = 50;
        this.roomList.add(new Room("101"));
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Rooms> getRoomList() {
        return this.roomList;
    }

    public ArrayList<Reservation> getReservationList() {
        return this.reservationList;
    }

    public int getMaximumRooms() {
        return this.maximumRooms;
    }

    public double getEarnings() {
        double totalEarnings;
        for (Reservation reservation : reservationList) {
            totalEarnings += reservation.getTotalPrice();
        }
        return totalEarnings;
    }

    public int getAvailableRooms(Date date) {
        int freeRooms = 0;
        for (Reservation reservation : reservationList) {
            if(!(reservation.getCheckInDate().getDay() == date.getDay() || reservation.getCheckOutDate().getDay() == date.getDay())) {
                freeRooms++;
            }
        }
        return this.freeRooms;
    }

    public int getBookedRooms(Date date) {
        int bookedRooms = 0;
        for (Reservation reservation : reservationList) {
            if(reservation.getCheckInDate().getDay() == date.getDay() || reservation.getCheckOutDate().getDay() == date.getDay()) {
                bookedRooms++;
            }
        }
        return this.bookedRooms;
    }

    
}