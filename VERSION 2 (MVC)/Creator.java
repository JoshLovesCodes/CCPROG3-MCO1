/**
 * Controller class responsible for creating a hotel.
 */

public class Creator {
    private MainModel model;
    private CreatorView view;


/**
 * Constructs the Creator class with a model class
 * @param model the model class for this controller class
 */
    public Creator(MainModel model) {
        this.model = model;
        this.view = new CreatorView();
    }

/**
 * Displays the interface of creating a hotel
 */
    public void displayInterface() {
        CreatorView.displayLongDivider();
        String newHotelName = this.view.promptHotelName();
        boolean isCreationSuccessful = this.model.createHotel(newHotelName);
        
        if(isCreationSuccessful) {
            this.view.displayNewHotelSuccessful(newHotelName);
        } else {
            this.view.displayNewHotelFailed();
        }

        CreatorView.displayLongDivider();
    }
}
