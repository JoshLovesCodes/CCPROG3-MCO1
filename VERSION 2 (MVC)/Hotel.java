import java.util.ArrayList;
import java.util.Arrays;

public class Hotel {
    private String name;
    private ArrayList<Room> roomList;
    private ArrayList<Reservation> reservationList;
    private int maximumRooms;
    private AutomateNaming automateNaming;
    private AutomateReservation automateReservation;

    public Hotel(String name){
        this.name = name;
        this.roomList = new ArrayList<Room>();
        this.reservationList = new ArrayList<Reservation>();
        this.maximumRooms = 50;
        this.automateNaming = new AutomateNaming();
        this.automateReservation = new AutomateReservation(this.roomList, this.reservationList);
        this.roomList.add(new Room(this.automateNaming.getName()));
    }

    
    /** 
     * @return String
     */
    public String getName() {
        return this.name;
    }   
    
    
    /** 
     * @return ArrayList<Room>
     */
    public ArrayList<Room> getRoomList() {
        return this.roomList;
    }

    
    /** 
     * @return ArrayList<Reservation>
     */
    public ArrayList<Reservation> getReservationList() {
        return this.reservationList;
    }

    
    /** 
     * @return int
     */
    public int getMaximumRooms() {
        return this.maximumRooms;
    }

    
    /** 
     * @param name
     * @return Room
     */
    public Room getRoom(String name) {
        for(Room r : this.roomList) {
            if(r.getName().equals(name))
                return r;
        }

        return null;
    }

    
    /** 
     * @param firstName
     * @param lastName
     * @return ArrayList<Reservation>
     */
    public ArrayList<Reservation> getReservation(String firstName, String lastName) {
        ArrayList<Reservation> newReservationList = new ArrayList<Reservation>();
        for(Reservation reservation : this.reservationList) {
            if(reservation.getGuest().getFirstName().equals(firstName) && reservation.getGuest().getLastName().equals(lastName)) 
                newReservationList.add(reservation);
        }

        if(newReservationList.isEmpty())
            return null;

        return newReservationList;
    }

    
    /** 
     * @return double
     */
    public double getEarnings() {
        double totalEarnings = 0;
        Fees fees = new Fees();
        for (Reservation reservation : this.reservationList) {
            totalEarnings += reservation.getTotalPrice(fees);
        }
        return totalEarnings;
    }

    
    /** 
     * @param date
     * @return int
     */
    public int getAvailableRooms(Date date) {
        int freeRooms = this.roomList.size();
        for (Reservation reservation : this.reservationList) {
            if(!(reservation.getCheckInDate().getDay() == date.getDay() || reservation.getCheckOutDate().getDay() == date.getDay())) {
                freeRooms--;
            }
            
        }
        return freeRooms;
    }

    
    /** 
     * @param date
     * @return int
     */
    public int getBookedRooms(Date date) {
        int bookedRooms = 0;
        for (Reservation reservation : this.reservationList) {
            if(reservation.getCheckInDate().getDay() == date.getDay() || reservation.getCheckOutDate().getDay() == date.getDay()) {
                bookedRooms++;
            }
            
        }
        return bookedRooms;
    }

    
    /** 
     * @param room
     * @return boolean[]
     */
    public boolean[] getRoomAvailability(Room room) {
        boolean[] bookedDates = new boolean[31];

        Arrays.fill(bookedDates, true);

        for (Reservation reservation : this.reservationList) {
            if(reservation.getRoom().equals(room)) {
                for(int i = reservation.getCheckInDate().getDay() - 1; i < reservation.getCheckOutDate().getDay(); i++) {
                    bookedDates[i] = false;
                }
            }
        }

        return bookedDates;
    }

    
    /** 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * @return boolean
     */
    public boolean addRoom() {
        if(this.roomList.size() < this.maximumRooms) {
            this.roomList.add(new Room(this.automateNaming.getName()));
            return true;
        }

        return false;
    }

    
    /** 
     * @param ctr
     * @return boolean
     */
    public boolean addRoom(int ctr) {
        if(this.roomList.size() + ctr <= this.maximumRooms) {
            for(int i = 0; i < ctr; i++)
                addRoom();

            return true;
        }
        
        return false;
    }

    
    /** 
     * @return int
     */
    public int removeRoom() {

        boolean found;

        if(this.roomList.size() != 1) {
            for(Room room : this.roomList) {

                found = false;

                for(Reservation reservation : this.reservationList) {
                    if(room.equals(reservation.getRoom())) {
                        found = true;
                        break;
                    }
                }

                if(!found) {
                    this.automateNaming.setAvailability(room.getName());
                    this.roomList.remove(room);
                    return 1;
                }
            }
        }

        return 0;
    }

    
    /** 
     * @param ctr
     * @return int
     */
    public int removeRoom(int ctr) {

        int count = 0;

        for(int i = 0; i < ctr; i++)
            if(removeRoom() == 1)
                count++;
            
        return count;
    }
    
    
    /** 
     * @param guest
     * @param checkIn
     * @param checkOut
     * @return boolean
     */
    public boolean addReservation(Guest guest, Date checkIn, Date checkOut) {
        Reservation reservation = this.automateReservation.getReservation(guest, checkIn, checkOut);
        
        if(reservation != null) {
            this.reservationList.add(reservation);
            return true;
        }

        return false;
    }

    
    /** 
     * @param firstName
     * @param lastName
     * @return boolean
     */
    public boolean removeReservation(String firstName, String lastName) {
        int ctr = 0;

        for(Reservation reservation : this.reservationList) {
            if(reservation.getGuest().getFirstName().equals(firstName) && reservation.getGuest().getLastName().equals(lastName)) {
                this.reservationList.remove(reservation);
                ctr++;
            }
        }

        if(ctr > 0)
            return true;

        return false;
    }
}