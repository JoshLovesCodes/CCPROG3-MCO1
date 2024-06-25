public class Creator {
    private MainModel model;
    private CreatorView view;

    public Creator(MainModel model) {
        this.model = model;
        this.view = new CreatorView();
    }

    public void displayInterface() {
        this.view.displayLongDivider();
        String newHotelName = this.view.promptHotelName();
        boolean isCreationSuccessful = this.model.createHotel(newHotelName);
        
        if(isCreationSuccessful) {
            this.view.displayNewHotelSuccessful(newHotelName);
        } else {
            this.view.displayNewHotelFailed();
        }

        this.view.displayLongDivider();
    }
}
