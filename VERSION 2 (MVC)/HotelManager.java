public class HotelManager {
    private MainModel model;
    public HotelManagerView view;

    public HotelManager(MainModel model) {
        this.model = model;
        this.view = new HotelManagerView();
    }

    public void displayInterface() {
        int input = 0;
        String name = "";    // hotel name
        Hotel hotel = this.model.selectHotel(name);  // SELECT HOTEL NAME
        int size = 0;
        String firstName = "";
        String lastName = "";

        if(hotel != null) {
            switch(input) {
                case HotelManagerView.CHANGE_NAME:
                    this.model.changeHotelName(hotel, name);
                    break;
                case HotelManagerView.ADD_ROOM:
                    this.model.addRoom(hotel);
                    this.model.addRoom(hotel, size);
                    break;
                case HotelManagerView.REMOVE_ROOM:
                    this.model.removeRoom(hotel);
                    this.model.removeRoom(hotel, size);
                    break;
                case HotelManagerView.UPDATE_PRICE:
                    this.model.updateRoomPrice(hotel, size);
                    break;
                case HotelManagerView.REMOVE_RESERVATION:
                    this.model.removeReservation(hotel, firstName, lastName);
                    break;
                case HotelManagerView.REMOVE_HOTEL:
                    this.model.removeHotel(hotel);
                    break;
            }
        }
    }
}
