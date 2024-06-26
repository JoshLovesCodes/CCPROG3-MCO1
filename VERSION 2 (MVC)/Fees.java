/**
 * Manages the fees for the hotel.
 */

public class Fees {
    private double bookingFee, amenitiesFee;

/**
 * Constructs the Fees class with a specified booking fee and amenities fee.
 * @param bookingFee the fee for booking
 * @param amenitiesFee the fee for amenities
 */
    public Fees(double bookingFee, double amenitiesFee) {
        this.bookingFee = bookingFee;
        this.amenitiesFee = amenitiesFee;
    }

/**
 * Constructs the Fees class
 */
    public Fees(){
        this(50.00, 150.00);
    }

    
    /** 
     * Gets the booking fee
     * @return the booking fee
     */
    public double getBookingFee() {
        return this.bookingFee;
    }

    
    /**
     * Gets the amenities fee
     * @return the amenities fee
     */
    public double getAmenitiesFee() {
        return this.amenitiesFee;
    }

    
    /**
     * Solves for the total fees 
     * @return the total fees
     */
    public double getTotalFees() {
        return this.bookingFee + this.amenitiesFee;
    }
}