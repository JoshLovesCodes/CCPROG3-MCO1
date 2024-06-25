import java.util.ArrayList;

public class Hotel {
    private String name;
    private ArrayList<Room> roomList;
    private ArrayList<Reservation> reservationList;
    private int maximumRooms;
    private AutomateNaming automateNaming;

    public Hotel(String name){
        this.name = name;
        this.roomList = new ArrayList<Room>();
        this.reservationList = new ArrayList<Reservation>();
        this.maximumRooms = 50;
        this.automateNaming = new AutomateNaming();
        this.roomList.add(new Room(this.automateNaming.getName()));
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Room> getRoomList() {
        return this.roomList;
    }

    public ArrayList<Reservation> getReservationList() {
        return this.reservationList;
    }

    public int getMaximumRooms() {
        return this.maximumRooms;
    }

    public Room getRoom(String name) {
        for(Room r : this.roomList) {
            if(r.getName() == name)
                return r;
        }

        return null;
    }

    public Reservation getReservation(String firstName, String lastName) {
        for(Reservation reservation : this.reservationList) {
            if(reservation.getGuest().getFirstName() == firstName && reservation.getGuest().getLastName() == lastName) {
                return reservation;
        }

        return null;
    }

    public double getEarnings() {
        double totalEarnings = 0;
        for (Reservation reservation : this.reservationList) {
            totalEarnings += reservation.getTotalPrice();
        }
        return totalEarnings;
    }

    public int getAvailableRooms(Date date) {
        int freeRooms = 0;
        for (Reservation reservation : this.reservationList) {
            if(reservation.getCheckInDate().getMonth() == date.getMonth()) {
                if(!(reservation.getCheckInDate().getDay() == date.getDay() || reservation.getCheckOutDate().getDay() == date.getDay())) {
                    freeRooms++;
                }
            }
        }
        return freeRooms;
    }

    public int getBookedRooms(Date date) {
        int bookedRooms = 0;
        for (Reservation reservation : this.reservationList) {
            if(reservation.getCheckInDate().getMonth() == date.getMonth()) {
                if(reservation.getCheckInDate().getDay() == date.getDay() || reservation.getCheckOutDate().getDay() == date.getDay()) {
                    bookedRooms++;
                }
            }
        }
        return bookedRooms;
    }

    public boolean[] getRoomAvailability(Room room, int month) {
        boolean[] bookedDates = new boolean[30];

        for(boolean day : bookedDates) {
            day = false;
        }

        for (Reservation reservation : this.reservationList) {
            if(reservation.getRoom() == room && reservation.getCheckInDate().getMonth() == month) {
                for(int i = reservation.getCheckInDate().getDay() - 1; i < reservation.getCheckOutDate().getDay(); i++) {
                    bookedDates[i] = true;
                }
            }
        }

        return bookedDates;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean addRoom() {
        if(this.roomList.size() < this.maximumRooms) {
            this.roomList.add(new Room(this.automateNaming.getName()));
            return true;
        }

        return false;
    }

    public boolean addRoom(int ctr) {
        if(this.roomList.size() + ctr <= this.maximumRooms) {
            for(int i = 0; i < ctr; i++)
                addRoom();

            return true;
        }
        
        return false;
    }

    public int removeRoom() {
        int index = -1;

        for(Room room : this.roomList) {
            index = this.reservationList.indexOf(room);
            
            if(index == -1) {
                this.roomList.remove(room);
                return 1;
            }
        }

        return 0;
    }

    public int removeRoom(int ctr) {

        int count = 0;

        for(int i = 0; i < ctr; i++)
            if(removeRoom() == 1)
                count++;
            
        return count;
    }
    
    public boolean removeReservation(String firstName, String lastName) {
        for(Reservation reservation : this.reservationList) {
            if(reservation.getGuest().getFirstName() == firstName && reservation.getGuest().getLastName() == lastName) {
                this.reservationList.remove(reservation);
                return true;
            }
        }

        return false;
    }
}