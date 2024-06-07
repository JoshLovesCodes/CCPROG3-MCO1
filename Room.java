public class Room {
    private String name;
    private double price = 1299.0;

    public Room(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getPrice() {
        return this.price;
    }
}