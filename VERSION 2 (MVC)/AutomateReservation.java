import java.util.ArrayList;

public class AutomateReservation {
    private ArrayList<Room> roomList;
    private ArrayList<Reservation> reservationList;

    public AutomateReservation(ArrayList<Room> roomList, ArrayList<Reservation> reservationList) {
        this.roomList = roomList;
        this.reservationList = reservationList;
    }

    
    /** 
     * @param guest
     * @param checkIn
     * @param checkOut
     * @return Reservation
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
