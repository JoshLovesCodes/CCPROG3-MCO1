public class Room {
    private String name;
    private double price = 1299.0;
    private boolean availbility = true;


    public Room(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public boolean getAvailability() {
        return this.availbility;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailability(boolean availbility) {
        this.availbility = availbility;
    }
}