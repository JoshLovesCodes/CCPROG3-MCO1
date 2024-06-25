public class Booker {
    private MainModel model;
    private BookerView view;

    public Booker(MainModel model) {
        this.model = model;
        this.view = new BookerView();
    }

    public void displayInterface() {

        String hotelName = this.view.promptHotelName();
        Hotel hotel = this.model.selectHotel(hotelName);
        if(hotel != null) {
            this.view.displayCheckIn();

            int year = this.view.promptYear();
            int month = this.view.promptMonth();
            int day = this.view.promptDay();
            
            Date checkIn = new Date(year, month, day);
            
            this.view.displayCheckOut();
            year = this.view.promptYear();
            month = this.view.promptMonth();
            day = this.view.promptDay();

            Date checkOut = new Date(year, month, day);

            String firstName = this.view.promptFirstName();
            String lastName = this.view.promptLastName();

            Guest guest = new Guest(firstName, lastName);

            if(Date.isAfter(checkIn, checkOut))
                this.view.displayTimeFrameFailed();
            else if(hotel.addReservation(guest, checkIn, checkOut)) {
                
            }
            else
                this.view.displayReservationFailed();
        }
        else
            this.view.displayHotelNotFound();
    }   
}
