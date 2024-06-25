public class HotelViewer {
    private MainModel model;
    private HotelViewerView view;

    public HotelViewer(MainModel model) {
        this.model = model;
        this.view = new HotelViewerView();
    }

    public void displayInterface() {
        int input;
        HotelViewerView.displayLongDivider();
        Hotel hotel = this.model.selectHotel(this.view.promptHotelName());
        do {
            input = this.view.promptInfoMenuResponse();

            switch(input) {
                case HotelViewerView.HIGH_LVL :
                    this.view.displayHighLevelInfo(hotel);
                    HotelViewerView.displayLongDivider();
                    break;

                case HotelViewerView.TOTAL_ROOM :
                    HotelViewerView.displayShortDivider();
                    int month = this.view.promptMonth();
                    int day = this.view.promptDay();
                    int year = this.view.promptYear();
                    HotelViewerView.displayShortDivider();
                    Date targetRoomDate = new Date(year, month, day);
                    this.view.displayRoomAvailability(targetRoomDate, hotel.getAvailableRooms(targetRoomDate), hotel.getBookedRooms(targetRoomDate));
                    HotelViewerView.displayLongDivider();
                    break;
                
                case HotelViewerView.INFO_ROOM :
                    Room room = hotel.getRoom(this.view.promptRoomName());
                    month = this.view.promptMonth();
                    String monthInWords = Date.identifyMonth(month);
                    HotelViewerView.displayShortDivider();
                    boolean[] roomCalendar = hotel.getRoomAvailability(room, month);
                    this.view.displayRoomInformation(room, roomCalendar, monthInWords);
                    HotelViewerView.displayLongDivider();
                    break;
                
                case HotelViewerView.INFO_RESERVATION :
                    String firstName = this.view.promptFirstName();
                    String lastName = this.view.promptLastName();
                    Reservation reservation = hotel.getReservation(firstName, lastName);
                    this.view.displayReservationInfo(reservation);
                    break;
                case HotelViewerView.INFO_EXIT :
                    input = 5;
                default: 
                    System.out.print("INVALID INPUT PLEASE TRY AGAIN");
            }
        } while(input != 5);
    }
}
