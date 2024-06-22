public class Reservation {
    private Guest guest;
    private Date checkInDate, checkOutDate;
    private Room room;
    private Fees fees;
    private int totalDays;

    public Reservation(Guest guest, Date checkInDate, Date checkOutDate, Room room, Fees fees) {
        this.guest = guest;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.room = room;
        this.fees = fees;
        this.totalDays = this.checkOutDate.getDay - this.checkInDate.getDay;
    }

    public double getTotalPrice() {
        if(this.totalDays == 0)
            return this.room.getPrice + this.fees.getTotalFees;
        else 
            return this.room.getPrice * this.totalDays + this.fees.getTotalFees;
    }

    public double getCostPerNight() {
        return this.getTotalPrice / this.totalDays;
    }
}