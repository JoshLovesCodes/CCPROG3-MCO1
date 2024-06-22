public class Fees {
    private double bookingFee, baseParkingFee, amenitiesFee;

    public Fees(double bookingFee, double amenitiesFee) {
        this.bookingFee = bookingFee;
        this.amenitiesFee = amenitiesFee;
    }

    public Fees(){
        this(50.00, 150.00);
    }

    public double getBookingFee() {
        return this.bookingFee;
    }

    public double getAmenitiesFee() {
        return this.amenitiesFeeFee;
    }

    public double getTotalFees() {
        return this.bookingFee + this.amenitiesFee;
    }
}