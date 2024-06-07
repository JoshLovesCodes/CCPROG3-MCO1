public class Fees {
    private double bookingFee, baseParkingFee, amenitiesFee;

    public Fees(double bookingFee, double baseParkingFee, double amenitiesFee) {
        this.bookingFee = bookingFee;
        this.baseParkingFee = baseParkingFee;
        this.amenitiesFee = amenitiesFee;
    }

    public Fees(){
        this(50.00, 0.00, 0.00);
    }


}