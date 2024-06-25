public class HotelViewer {
    private MainModel model;
    private HotelViewerView view;

    public HotelViewer(MainModel model) {
        this.model = model;
        this.view = new HotelViewerView();
    }

    public void displayInterface() {
        int input;
        do {
            input = this.view.promptInfoMenuResponse();

            switch(input) {
                case HotelViewerView.HIGH_LVL :
                    displayLongDivider();
                    Hotel hotel = this.model.selectHotel(promptHotelName());
                    this.view.displayHighLevelInfo(hotel);
                    displayLongDivider();
                    break;

                case HotelViewerView.TOTAL_ROOM :
                    displayLongDivider();
                    Hotel hotel = this.model.selectHotel(promptHotelName());
                    displayShortDivider();
                    int month = promptMonth();
                    int day = promptDay();
                    int year = promptYear();
                    displayShortDivider();
                    Date targetRoomDate = new Date(year, month, day);
                    this.view.displayRoomAvailability(targetRoomDate, this.hotel.getAvailableRooms(targetRoomDate), this.hotel.getBookedRooms(targetRoomDate));
                    displayLongDivider();
                    break;
                
                case HotelViewerView.INFO_ROOM :
                    displayLongDivider();
                    Hotel hotel = this.model.selectHotel(promptHotelName());
                    Room room = hotel.getRoom(promptRoomName());
                    int month = this.view.promptMonth();
                    String monthInWords = date.identifyMonth(month);
                    displayShortDivider();
                    boolean[] roomCalendar = hotel.getRoomAvailability(room, month);
                    this.view.displayRoomInformation(room, roomCalendar, monthInWords);
                    displayLongDivider();
                    break;
                
                case HotelViewerView.INFO_RESERVATION :
                    displayLongDivider();
                    Hotel hotel = this.model.selectHotel(promptHotelName());
                    String firstName = this.view.promptFirstName();
                    String lastName = this.view.promptLastName();
                    Reservation reservation = hotel.getReservation(firstName, lastName);
                    this.view.displayReservationInfo(reservation);
                    break;
                case HotelViewerView.INFO_EXIT;
                    input = 5;
                default: 
                    System.out.print("INVALID INPUT PLEASE TRY AGAIN");
            }
        } while(input != 5);
    }
}
