public class Fees {
    private double bookingFee, baseParkingFee, amenitiesFee;

    public Fees(double bookingFee, double baseParkingFee, double amenitiesFee) {
        this.bookingFee = bookingFee;
        this.baseParkingFee = baseParkingFee;
        this.amenitiesFee = amenitiesFee;
    }

    public Fees(){
        this(50.00, 30.00, 150.00);
    }

    public double getBookingFee() {
        return this.bookingFee;
    }

    public double getBaseParkingFee() {
        return this.baseParkingFeeFee;
    }

    public double getTotalParkingFee() {
        return this.bookingFee;
    }

    public double getBookingFee() {
        return this.bookingFee;
    }


}