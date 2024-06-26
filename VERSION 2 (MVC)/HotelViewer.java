import java.util.ArrayList;

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

        if(hotel != null) {
            do {
                input = this.view.promptInfoMenuResponse();

                switch(input) {
                    case HotelViewerView.HIGH_LVL :
                        this.view.displayHighLevelInfo(hotel);
                        HotelViewerView.displayLongDivider();
                        break;

                    case HotelViewerView.TOTAL_ROOM :
                        HotelViewerView.displayShortDivider();
                        int day = this.view.promptDay();
                        HotelViewerView.displayShortDivider();
                        Date targetRoomDate = new Date(day);
                        this.view.displayRoomAvailability(targetRoomDate, hotel.getAvailableRooms(targetRoomDate), hotel.getBookedRooms(targetRoomDate));
                        HotelViewerView.displayLongDivider();
                        break;
                    
                    case HotelViewerView.INFO_ROOM :
                        String roomName = this.view.promptRoomName();
                        Room room = hotel.getRoom(roomName);
                        if(room != null) {
                            HotelViewerView.displayShortDivider();
                            boolean[] roomCalendar = hotel.getRoomAvailability(room);
                            this.view.displayRoomInformation(room, roomCalendar);
                            HotelViewerView.displayLongDivider();
                            break;
                        } else {
                            this.view.displayRoomNotFound();
                            HotelViewerView.displayLongDivider();
                            break;
                        }
                    
                    case HotelViewerView.INFO_RESERVATION :
                        String firstName = this.view.promptFirstName();
                        String lastName = this.view.promptLastName();
                        ArrayList<Reservation> reservationList = hotel.getReservation(firstName, lastName);
                        Fees fees = new Fees();
                        if(reservationList != null) {
                            this.view.displayReservationInfo(reservationList, fees);
                            HotelViewerView.displayLongDivider();
                            break;
                        } else {
                            this.view.displayReservationNotFound();
                            HotelViewerView.displayLongDivider();
                            break;
                        }
                    case HotelViewerView.INFO_EXIT :
                        input = 5;
                        break;
                    default: 
                        System.out.print("INVALID INPUT PLEASE TRY AGAIN\n");
                }
            } while(input != 5);
        }
        else
            this.view.displayHotelNotFound();
    }
}
