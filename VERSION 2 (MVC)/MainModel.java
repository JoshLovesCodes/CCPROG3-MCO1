import java.util.ArrayList;

public class MainModel {
    private ArrayList<Hotel> hotelList;

    public boolean nameChecker(String name) {
        for(Hotel h: this.hotelList) {
            if(h.getName == name) {
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
}
