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
        
    }
}
