public class HRS {
    private MainModel model;
    private HRSview view;
    private Creator creator;
    private HotelViewer viewer;
    private HotelManager manager;
    private Booker booker;

    public HRS() {
        this.model = new MainModel();
        this.view = new HRSview();
        this.creator = new Creator(this.model);
        this.viewer = new HotelViewer(this.model);
        this.manager = new HotelManager(this.model);
        this.booker = new Booker(this.model);
    }   
    
    public void displayInterface() {
        int input;
        HotelViewerView.displayLongDivider();
        this.view.displayWelcomeMessage();
        do {
            input = this.view.promptInfoMenuResponse();

            switch(input) {
                case HRSview.CREATE_HOTEL : 
                    this.creator.displayInterface(); 
                    break;
                case HRSview.VIEW_HOTEL : 
                    this.viewer.displayInterface(); 
                    break;
                case HRSview.MANAGE_HOTEL : 
                    this.manager.displayInterface(); 
                    break;
                case HRSview.SIMULATE_BOOKING : 
                    this.booker.displayInterface(); 
                    break;
                case HRSview.EXIT :
                    input = 5;
                    break;
                default: 
                    System.out.print("INVALID INPUT PLEASE TRY AGAIN");
            }
        } while(input != 5);
    }
}
