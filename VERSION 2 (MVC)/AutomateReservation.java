import java.util.ArrayList;

public class AutomateReservation {
    private ArrayList<Room> roomList;
    private ArrayList<Reservation> reservationList;

    public AutomateReservation(ArrayList<Room> roomList, ArrayList<Reservation> reservationList) {
        this.roomList = roomList;
        this.reservationList = reservationList;
    }

    public Reservation getReservation(Guest guest, Date checkIn, Date checkOut) {
        boolean found = false;

        for(Room r : this.roomList) {   
            for(Reservation reservation : this.reservationList) {
                if(reservation.getRoom() == r) {
                    found = true;
                    break;
                }
            }

            if(!found)
                return new Reservation(guest, checkIn, checkOut, r);
        }

        for(Room r : this.roomList) {
            for(Reservation reservation : this.reservationList) {
                if(reservation.getRoom() == r) {
                    if(!Date.isAfter(reservation.getCheckInDate(), checkIn) && !Date.isAfter(reservation.getCheckOutDate(), checkOut)) 
                        return new Reservation(guest, checkIn, checkOut, r);
                }
            }
        }

        return null;
    }
}
