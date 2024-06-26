/**
 * Automates the assignment of rooms in a reservation.
 */

import java.util.ArrayList;

public class AutomateReservation {
    private ArrayList<Room> roomList;
    private ArrayList<Reservation> reservationList;
/**
 * Contructs the AutomateReservation class with a specified list of rooms and reservations
 * @param roomList the list where rooms will be stored
 * @param reservationList the list where reservations will be stored
 */
    public AutomateReservation(ArrayList<Room> roomList, ArrayList<Reservation> reservationList) {
        this.roomList = roomList;
        this.reservationList = reservationList;
    }

    
    /** 
     * Gets the reservation base on the guest and their dates of booking
     * 
     * @param guest the guest of a specific reservation
     * @param checkIn the check-in date of a specific reservation
     * @param checkOut the check-out date of a specific reservation
     * @return the Reservation object which was found based on the given parameters
     */
    public Reservation getReservation(Guest guest, Date checkIn, Date checkOut) {
        boolean found;

        for(Room r : this.roomList) {   
            found = false;
            for(Reservation reservation : this.reservationList) {
                if(reservation.getRoom().equals(r)) {
                    found = true;
                    break;
                }
            }

            if(!found)
                return new Reservation(guest, checkIn, checkOut, r);

        }

        for(Room r : this.roomList) {
            for(Reservation reservation : this.reservationList) {
                if(reservation.getRoom().equals(r)) {
                    if(reservation.getCheckOutDate().getDay() <= checkIn.getDay()) 
                        return new Reservation(guest, checkIn, checkOut, r);
                }
            }
        }

        return null;
    }
}
