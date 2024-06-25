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
            if(!(reservation.getCheckInDate().getDay() == date.getDay() || reservation.getCheckOutDate().getDay() == date.getDay())) {
                freeRooms++;
            }
        }
        return freeRooms;
    }

    public int getBookedRooms(Date date) {
        int bookedRooms = 0;
        for (Reservation reservation : this.reservationList) {
            if(reservation.getCheckInDate().getDay() == date.getDay() || reservation.getCheckOutDate().getDay() == date.getDay()) {
                bookedRooms++;
            }
        }
        return bookedRooms;
    }

    private int getRoomAvailability(Room room, int month) {
        int ctr = 0;

        for (Reservation reservation : this.reservationList) {
            if(reservation.getRoom() == room && reservation.getCheckInDate().getMonth() == month) {
                for(int i = reservation.getCheckInDate().getDay() - 1; i < reservation.getCheckOutDate().getDay(); i++) {
                    ctr++;
                }
            }
        }

        return ctr;
    }


    public String getRoomInfo(String name, int month) {
        Room room = null;
        String info = "";

        for(int i = 0; i < roomList.size(); i++) {
            if(this.roomList.get(i).getName() == name) {
                room = this.roomList.get(i);
                break;
            }
        }

        if(room != null) {
            info += "Name: " + room.getName() + '\n';
            info += "Price per night: " + room.getPrice() + '\n';
            info += "Availability: " + Integer.toString(getRoomAvailability(room, month));
        }
        
        return info;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void addRoom(String name) {
        this.roomList.add(new Room(this.automateNaming.getName()));
    }

    public boolean removeRoom(String name) {
        for(Room room : this.roomList) {
            if(room.getName() == name) {
                this.automateNaming.setAvailability(name);
                this.roomList.remove(room);
                return true;
            }
        }

        return false;
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