/**
 * Class responsible for resevations.
 */
public class Reservation {
    private Guest guest;
    private Date checkInDate, checkOutDate;
    private Room room;
    private int totalDays;
/**
 * Constructs the Reservation class with guest, checkInDate, checkOutDate and a room.
 */
    public Reservation(Guest guest, Date checkInDate, Date checkOutDate, Room room) {
        this.guest = guest;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.room = room;
        this.totalDays = this.checkOutDate.getDay() - this.checkInDate.getDay();
    }

/**
 * Gets the total price of reservation
 * @param fees fees in the hotel
 * @return the total price
 */
    public double getTotalPrice(Fees fees) {
        return this.room.getPrice() * this.totalDays + fees.getTotalFees();
    }

/**
 * Gets the cost per night of reservation
 * @param fees fees in the hotel
 * @return the cost per night
 */
    public double getCostPerNight(Fees fees) {
        return this.getTotalPrice(fees) / this.totalDays;
    }

/**
 * Gets the guest
 * @return the guest
 */
    public Guest getGuest() {
        return this.guest;
    }

/**
 * Gets the check-in date
 * @return the check in date
 */
    public Date getCheckInDate() {
        return this.checkInDate;
    }

/**
 * Gets the check-out date
 * @return the check-out date
 */
    public Date getCheckOutDate() {
        return this.checkOutDate;
    }

/**
 * Gets the room
 * @return the room
 */
    public Room getRoom() {
        return this.room;
    }
}
