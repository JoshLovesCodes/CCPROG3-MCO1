public class Reservation {
    private Guest guest;
    private Date checkInDate, checkOutDate;
    private Room room;

    public Reservation(Guest guest, Date checkInDate, Date checkOutDate, Room room) {
        this.guest = guest;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.room = room;
    }

    public double getTotalPrice() {
        
    }
}