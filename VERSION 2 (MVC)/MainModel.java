import java.util.ArrayList;

public class MainModel {
    private ArrayList<Hotel> hotelList;


    public boolean nameChecker(String name) {
        for(Hotel h: this.hotelList) {
            if(h.getName() == name) {
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
        for(int i = 0; i < this.hotelList.size(); i++) {
            if(this.hotelList.get(i).getName() == name) {
                return this.hotelList.get(i);
            }
        }

        return null;
    }

    public boolean changeHotelName(Hotel hotel, String name) {
        if(nameChecker(name))
            return false;

        hotel.setName(name);
        return true;
    }


    public boolean addRoom(Hotel hotel) {
        return hotel.addRoom();
    }

    public boolean addRoom(Hotel hotel, int ctr) {
        return hotel.addRoom(ctr);
    }


    public boolean updateRoomPrice(Hotel hotel, double price) {
        if(hotel.getReservationList().size() == 0) {
            for(Room r : hotel.getRoomList()) {
                r.setPrice(price);
            }
            return true;
        }

        return false;
    }


    public boolean removeReservation(Hotel hotel, String firstName, String lastName) { 
        return hotel.removeReservation(firstName, lastName);
    }


    public boolean removeHotel(Hotel hotel) {
        return this.hotelList.remove(hotel);
    }
}
