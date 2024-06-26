/**
 * Controller class responsible for simulating a booking.
 */

public class Booker {
    private MainModel model;
    private BookerView view;

/**
 * Constructs the Booker class with a model class
 * @param model the model class for this controller class
 */
    public Booker(MainModel model) {
        this.model = model;
        this.view = new BookerView();
    }

/**
 * Displays the interface of booking simulation
 */
    public void displayInterface() {

        String hotelName = this.view.promptHotelName();
        Hotel hotel = this.model.selectHotel(hotelName);
        if(hotel != null) {
            this.view.displayCheckIn();
            int day = this.view.promptDay();
                
            Date checkIn = new Date(day);
            
            this.view.displayCheckOut();
            day = this.view.promptDay();

            Date checkOut = new Date(day);

            String firstName = this.view.promptFirstName();
            String lastName = this.view.promptLastName();

            Guest guest = new Guest(firstName, lastName);

            if(Date.isAfter(checkIn, checkOut))
                this.view.displayTimeFrameFailed();
            else if(checkIn.getDay() == checkOut.getDay())
                this.view.displaySameDayInvalid();
            else if(hotel.addReservation(guest, checkIn, checkOut)) 
                this.view.displayReservationSuccess();
            else
                this.view.displayReservationFailed();
        }
        else
            this.view.displayHotelNotFound();
    }   
}
