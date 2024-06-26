/**
 * Class responsible for a room.
 */
public class Room {
    private String name;
    private double price = 1299.0;

/**
 * Constructs the Room class given a name
 */
    public Room(String name) {
        this.name = name;
    }

/**
 * Gets the name of the room
 * @return name of the room
 */
    public String getName() {
        return this.name;
    }

/**
 * Gets the price of the room
 * @return price of the room
 */
    public double getPrice() {
        return this.price;
    }

/**
 * Sets the price of the room
 * @param price new price of the room
 */
    public void setPrice(double price) {
        this.price = price;
    }
}