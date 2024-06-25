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
        if(this.totalDays == 0)
            return this.room.getPrice() + fees.getTotalFees();
        else 
            return this.room.getPrice() * this.totalDays + fees.getTotalFees();
    }

    public double getCostPerNight() {
        return this.getTotalPrice() / this.totalDays;
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
