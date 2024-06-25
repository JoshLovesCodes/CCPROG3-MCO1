import java.util.ArrayList;

public class MainModel {
    private ArrayList<Hotel> hotelList;


    public MainModel() {
        this.hotelList = new ArrayList<Hotel>();
    }

    
    public boolean nameChecker(String name) {
        for(Hotel h: this.hotelList) {
            if(h.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    public boolean createHotel(String newHotelName) {
        boolean isNameUnique = nameChecker(newHotelName);

        if(isNameUnique) {
            this.hotelList.add(new Hotel(newHotelName));
            return true;
        } else {
            return false;
        }
    }

    public Hotel selectHotel(String name) {
        for(Hotel h : this.hotelList) {
            if(h.getName().equals(name))
                return h;
        }

        return null;
    }

    public boolean changeHotelName(Hotel hotel, String name) {
        if(nameChecker(name))
            return false;

        hotel.setName(name);
        return true;
    }

    public boolean updateRoomPrice(Hotel hotel, double price) {
        if(hotel.getReservationList().isEmpty()) {
            for(Room r : hotel.getRoomList()) {
                r.setPrice(price);
            }
            return true;
        }

        return false;
    }

    public boolean removeHotel(Hotel hotel) {
        return this.hotelList.remove(hotel);
    }
}
