public class Fees {
    private double bookingFee, amenitiesFee;

    public Fees(double bookingFee, double amenitiesFee) {
        this.bookingFee = bookingFee;
        this.amenitiesFee = amenitiesFee;
    }

    public Fees(){
        this(50.00, 150.00);
    }

    
    /** 
     * @return double
     */
    public double getBookingFee() {
        return this.bookingFee;
    }

    
    /** 
     * @return double
     */
    public double getAmenitiesFee() {
        return this.amenitiesFee;
    }

    
    /** 
     * @return double
     */
    public double getTotalFees() {
        return this.bookingFee + this.amenitiesFee;
    }
}