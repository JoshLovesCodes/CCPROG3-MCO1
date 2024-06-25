public class HotelManager {
    private MainModel model;
    public HotelManagerView view;

    public HotelManager(MainModel model) {
        this.model = model;
        this.view = new HotelManagerView();
    }

    public void displayInterface() {
        int input;
        Hotel hotel = this.model.selectHotel(this.view.promptHotelName());

        if(hotel != null) {

            switch(input) {
                do {
                    input = this.view.promptInfoMenuResponse();

                    switch(input){
                        case HotelManagerView.CHANGE_NAME:
                            HotelViewerView.displayLongDivider();
                            String newName = this.view.promptHotelNewName();
                            this.view.displayChangeNameInfo();
                            HotelViewerView.displayShortDivider();
                            char confirmation = this.view.promptConfirmation();
                            if(confirmation == 'Y' || confirmation == 'y') {
                                boolean status = this.model.changeHotelName(hotel, name);
                                if(status) {
                                    this.view.displayChangeNameSuccess();
                                    HotelViewerView.displayLongDivider();
                                    break;
                                } else {
                                    this.view.displayChangeNameFailed();
                                    HotelViewerView.displayLongDivider();
                                    break;
                                }
                            } else if(confirmation == 'N' || confirmation == 'n') {
                                HotelViewerView.displayLongDivider();
                                break;
                            }
                        case HotelManagerView.ADD_ROOM:
                            HotelViewerView.displayLongDivider();
                            char response = this.view.promptAddingRoom();
                            char confirmation;
                            if(response == 'S' || response == 's') {
                                this.view.displayAddSingleRoom();
                                HotelViewerView.displayShortDivider();
                                confirmation = this.view.promptConfirmation();
                                if(confirmation == 'Y' || confirmation == 'y') {
                                    boolean status = hotel.addRoom();
                                    if(status) {
                                        this.view.displayAddRoomSuccess();
                                        HotelViewerView.displayLongDivider();
                                        break;
                                    } else {
                                        this.view.displayAddRoomFailed();
                                        HotelViewerView.displayLongDivider();
                                        break;
                                    }
                                } else if(confirmation == 'N' || confirmation == 'n'){
                                    HotelViewerView.displayLongDivider();
                                    break;
                                }
                            } else if(response == 'M' || response == 'm') {
                                int size = promptNumberOfRooms();
                                this.view.displayAddMultipleRoom(size);
                                HotelViewerView.displayShortDivider();
                                confirmation = this.view.promptConfirmation();
                                if(confirmation == 'Y' || confirmation == 'y') {
                                    boolean status = hotel.addRoom(size);
                                    if(status) {
                                        this.view.displayAddMultipleRoomSuccess(size);
                                        HotelViewerView.displayLongDivider();
                                        break;
                                    } else {
                                        this.view.displayAddMultipleRoomFailed();
                                        HotelViewerView.displayLongDivider();
                                        break;
                                    }
                                } else if(confirmation == 'N' || confirmation == 'n'){
                                    HotelViewerView.displayLongDivider();
                                    break;
                                }
                            }
                        case HotelManagerView.REMOVE_ROOM:
                            HotelViewerView.displayLongDivider();
                            char response = this.view.promptRemovingRoom();
                            char confirmation;
                            if(response == 'S' || response == 's') {
                                this.view.displayRemoveSingleRoom();
                                HotelViewerView.displayShortDivider();
                                confirmation = this.view.promptConfirmation();
                                if(confirmation == 'Y' || confirmation == 'y') {
                                    boolean status = hotel.removeRoom();
                                    if(status) {
                                        this.view.displayRemoveRoomSuccess();
                                        HotelViewerView.displayLongDivider();
                                        break;
                                    } else {
                                        this.view.displayRemoveRoomFailed();
                                        HotelViewerView.displayLongDivider();
                                        break;
                                    }
                                } else if(confirmation == 'N' || confirmation == 'n'){
                                    HotelViewerView.displayLongDivider();
                                    break;
                                }
                            } else if(response == 'M' || response == 'm') {
                                int size = promptRemoveNumberOfRooms();
                                this.view.displayRemoveMultipleRoom(size);
                                HotelViewerView.displayShortDivider();
                                confirmation = this.view.promptConfirmation();
                                if(confirmation == 'Y' || confirmation == 'y') {
                                    boolean status = hotel.removeRoom(size);
                                    if(status) {
                                        this.view.displayRemoveMultipleRoomSuccess(size);
                                        HotelViewerView.displayLongDivider();
                                        break;
                                    } else {
                                        this.view.displayRemoveMultipleRoomFailed();
                                        HotelViewerView.displayLongDivider();
                                        break;
                                    }
                                } else if(confirmation == 'N' || confirmation == 'n'){
                                    HotelViewerView.displayLongDivider();
                                    break;
                                }
                            }
                        case HotelManagerView.UPDATE_PRICE:
                            HotelViewerView.displayLongDivider();
                            int newPrice = this.view.promptNewPrice();
                            char confirmation;
                            if(newPrice < 100.0){
                                this.view.displayPromptPriceInvalid();
                                break;
                            } else {
                                this.view.displayUpdatePriceInfo();
                                HotelViewerView.displayShortDivider();
                                confirmation = this.view.promptConfirmation();
                                if(confirmation == 'Y' || confirmation == 'y') {
                                    boolean status = this.model.updateRoomPrice(hotel, newPrice);
                                    if(status) {
                                        this.view.displayUpdatePriceSuccess();
                                        HotelViewerView.displayLongDivider();
                                        break;
                                    } else {
                                        this.view.displayUpdatePriceFailed();
                                        HotelViewerView.displayLongDivider();
                                        break;
                                    }
                                } else if(confirmation == 'N' || confirmation == 'n'){
                                    HotelViewerView.displayLongDivider();
                                    break;
                                }
                            }
                        case HotelManagerView.REMOVE_RESERVATION:
                            String firstName = this.view.promptFirstName();
                            String lastName = this.view.promptLastName();
                            char confirmation;

                            this.view.displayRemoveReservationInfo();
                            HotelViewerView.displayShortDivider();
                            confirmation = this.view.promptConfirmation();
                            if(confirmation == 'Y' || confirmation == 'y') {
                                boolean status = hotel.removeReservation(firstName, lastName);
                                    if(status) {
                                        this.view.displayRemoveReservationSuccess();
                                        HotelViewerView.displayLongDivider();
                                        break;
                                    } else {
                                        this.view.displayRemoveReservationFailed();
                                        HotelViewerView.displayLongDivider();
                                        break;
                                    }
                            } else if(confirmation == 'N' || confirmation == 'n'){
                                HotelViewerView.displayLongDivider();
                                break;
                            }
                        case HotelManagerView.REMOVE_HOTEL:
                            char confirmation;
                            this.view.displayRemoveHotelInfo();
                            HotelViewerView.displayShortDivider();
                            confirmation = this.view.promptConfirmation();
                            if(confirmation == 'Y' || confirmation == 'y') {
                                boolean status = this.model.removeHotel(hotel);
                                    if(status) {
                                        this.view.displayRemoveHotelSuccess();
                                        HotelViewerView.displayLongDivider();
                                        break;
                                    } else {
                                        this.view.displayRemoveHotelFailed();
                                        HotelViewerView.displayLongDivider();
                                        break;
                                    }
                            } else if(confirmation == 'N' || confirmation == 'n'){
                                HotelViewerView.displayLongDivider();
                                break;
                            }
                        case HotelManagerView.MANAGER_EXIT:
                            input = 7;
                        default:
                            System.out.print("INVALID INPUT PLEASE TRY AGAIN");
                    }
                } while(input != 7);
            }
        }
    }
}
