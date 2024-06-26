/**
 * Model class responsible for the whole system.
 */
import java.util.ArrayList;

public class MainModel {
    private ArrayList<Hotel> hotelList;

/**
 * Constructs the MainModel class
 */
    public MainModel() {
        this.hotelList = new ArrayList<Hotel>();
    }

/**
 * Checks the uniqueness of the name
 * @param name the name to be checked
 * @return true if unique, false if not
 */
    public boolean nameChecker(String name) {
        for(Hotel h: this.hotelList) {
            if(h.getName().equals(name)) {
                return false;
            }
        }

        return true;
    }

/**
 * Creates a hotel
 * @param newHotelName the name of the new hotel
 * @return true if success, false if not
 */
    public boolean createHotel(String newHotelName) {
        boolean isNameUnique = nameChecker(newHotelName);

        if(isNameUnique) {
            this.hotelList.add(new Hotel(newHotelName));
            return true;
        } else {
            return false;
        }
    }

/**
 * Selects a hotel based on its name
 * @param name the name to be checked
 * @return hotel or null if it doesn't exist
 */
    public Hotel selectHotel(String name) {
        for(Hotel h : this.hotelList) {
            if(h.getName().equals(name))
                return h;
        }

        return null;
    }

/**
 * Changes the name of a hotel
 * @param hotel the hotel which the name will be changed
 * @param name the new name for the hotel
 * @return true if success, false if not
 */
    public boolean changeHotelName(Hotel hotel, String name) {
        if(nameChecker(name)) {
            hotel.setName(name);
            return true;
        }
        return false;
    }

/**
 * Updates the price of the room
 * @param hotel the target hotel
 * @param price the new price
 * @return true if success, false if not
 */
    public boolean updateRoomPrice(Hotel hotel, double price) {
        if(hotel.getReservationList().isEmpty()) {
            for(Room r : hotel.getRoomList()) {
                r.setPrice(price);
            }
            return true;
        }

        return false;
    }
/**
 * Removed a hotel
 * @param hotel the hotel to be removed
 * @return true if success, false if not
 */
    public boolean removeHotel(Hotel hotel) {
        return this.hotelList.remove(hotel);
    }
}
