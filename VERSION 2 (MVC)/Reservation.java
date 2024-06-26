public class Reservation {
    private Guest guest;
    private Date checkInDate, checkOutDate;
    private Room room;
    private int totalDays;

    public Reservation(Guest guest, Date checkInDate, Date checkOutDate, Room room) {
        this.guest = guest;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.room = room;
        this.totalDays = this.checkOutDate.getDay() - this.checkInDate.getDay();
    }

    public double getTotalPrice(Fees fees) {
        return this.room.getPrice() * this.totalDays + fees.getTotalFees();
    }

    public double getCostPerNight(Fees fees) {
        return this.getTotalPrice(fees) / this.totalDays;
    }

    public Guest getGuest() {
        return this.guest;
    }

    public Date getCheckInDate() {
        return this.checkInDate;
    }

    public Date getCheckOutDate() {
        return this.checkOutDate;
    }

    public Room getRoom() {
        return this.room;
    }
}
