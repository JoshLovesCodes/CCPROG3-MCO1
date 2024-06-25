public class HotelViewer {
    private MainModel model;
    private HotelViewerView view;

    public HotelViewer(MainModel model) {
        this.model = model;
        this.view = new HotelViewerView();
    }

    public void displayInterface() {
        int input = 0;

        switch(input) {
            case HotelViewerView.HIGH_LVL :
                break;

            case HotelViewerView.TOTAL_ROOM :
                break;
            
            case HotelViewerView.INFO_ROOM :
                break;
            
            case HotelViewerView.INFO_RESERVATION :
                break;
            default: 
                System.out.print("INVALID INPUT PLEASE TRY AGAIN");
        }
    }
}
