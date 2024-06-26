/**
 * Represents the hotel in the system
 */

import java.util.ArrayList;
import java.util.Arrays;


public class Hotel {
    private String name;
    private ArrayList<Room> roomList;
    private ArrayList<Reservation> reservationList;
    private int maximumRooms;
    private AutomateNaming automateNaming;
    private AutomateReservation automateReservation;

/**
 * Constructs the Hotel class with a given name
 * @param name the name of the hotel
 */
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
     * Gets the name of the hotel 
     * @return the name of the hotel
     */
    public String getName() {
        return this.name;
    }   
    
    
    /** 
     * Gets the list of rooms in the hotel
     * @return the list of rooms
     */
    public ArrayList<Room> getRoomList() {
        return this.roomList;
    }

    
    /** 
     * Gets the list of reservations in the hotel
     * @return list of reservations
     */
    public ArrayList<Reservation> getReservationList() {
        return this.reservationList;
    }

    
    /**
     * Gets the maximum number of rooms in the hotel 
     * @return the maximum number of rooms
     */
    public int getMaximumRooms() {
        return this.maximumRooms;
    }

    
    /**
     * Gets the room based on its name 
     * @param name the name of the room
     * @return the room or null if the room doesn't exist
     */
    public Room getRoom(String name) {
        for(Room r : this.roomList) {
            if(r.getName().equals(name))
                return r;
        }

        return null;
    }

    
    /**
     * Gets the reservation(s) based on first name and last name of the guest 
     * @param firstName first name of the guest
     * @param lastName last name of the guest
     * @return the reservation(s) or null if the reservations doesn't exist
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
     * Gets the earning of the hotel 
     * @return the earnings of the hotel
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
     * Gets the number of available rooms in a hotel 
     * @param date the date to check the number of available rooms
     * @return number of available rooms in a given day
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
     * Gets the number of booked rooms in a hotel 
     * @param date the date to check the number of booked rooms
     * @return number of booked rooms in a given day
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
     * Gets the availability of the room for the whole month 
     * @param room the room to be checked its availability
     * @return the boolean list where the room is available or not
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
     * Sets the name of the hotel 
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /**
     * Adds a single room to the hotel 
     * @return true if successful, false if not
     */
    public boolean addRoom() {
        if(this.roomList.size() < this.maximumRooms) {
            this.roomList.add(new Room(this.automateNaming.getName()));
            return true;
        }

        return false;
    }

    
    /**
     * Adds multiple rooms to the hotel 
     * @param ctr the number of rooms to be added
     * @return true if successful, false if not 
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
     * Removes a single room 
     * @return 1 if success, 0 if not
     */
    public int removeRoom() {

        boolean found;

        for(Room room : this.roomList) {
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
     * Removes multiple room 
     * @param ctr number of rooms to be removed
     * @return the number of rooms removed
     */
    public int removeRoom(int ctr) {

        if(return )

        int count = 0;

        for(int i = 0; i < ctr; i++)
            if(removeRoom() == 1)
                count++;
            
        return count;
    }
    
    
    /**
     * Adds a resevation 
     * @param guest the guest
     * @param checkIn the check-in date of the reservation
     * @param checkOut the check-out date of ther reservation
     * @return true if successful, false if not
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
     * Removed a reservation based on name of the guest 
     * @param firstName the firstname of the guest
     * @param lastName the last name of the guest
     * @return true if successful, false if not
     */
    public boolean removeReservation(String firstName, String lastName) {

        for(Reservation reservation : this.reservationList) {
            if(reservation.getGuest().getFirstName().equals(firstName) && reservation.getGuest().getLastName().equals(lastName)) {
                this.reservationList.remove(reservation);
                return true;
            }
        }

        return false;
    }
}