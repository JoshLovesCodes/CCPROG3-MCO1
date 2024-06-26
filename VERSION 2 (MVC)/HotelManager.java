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
                do {
                    input = this.view.promptInfoMenuResponse();

                    switch(input){
                        case HotelManagerView.CHANGE_NAME:
                            HotelViewerView.displayLongDivider();
                            String newName = this.view.promptNewHotelName();
                            this.view.displayChangeNameInfo(hotel.getName(), newName);
                            HotelViewerView.displayShortDivider();
                            char confirmationCN = this.view.promptConfirmation();
                            if(confirmationCN == 'Y' || confirmationCN == 'y') {
                                boolean statusCN = this.model.changeHotelName(hotel, newName);
                                if(statusCN) {
                                    this.view.displayChangeNameSuccess();
                                    HotelViewerView.displayLongDivider();
                                    break;
                                } else {
                                    this.view.displayChangeNameFailed();
                                    HotelViewerView.displayLongDivider();
                                    break;
                                }
                            } else if(confirmationCN == 'N' || confirmationCN == 'n') {
                                HotelViewerView.displayLongDivider();
                                break;
                            }
                        case HotelManagerView.ADD_ROOM:
                            HotelViewerView.displayLongDivider();
                            char responseAR = this.view.promptAddingRoom();
                            char confirmationAdd;
                            if(responseAR == 'S' || responseAR == 's') {
                                this.view.displayAddSingleRoom();
                                HotelViewerView.displayShortDivider();
                                confirmationAdd = this.view.promptConfirmation();
                                if(confirmationAdd == 'Y' || confirmationAdd == 'y') {
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
                                } else if(confirmationAdd == 'N' || confirmationAdd == 'n'){
                                    HotelViewerView.displayLongDivider();
                                    break;
                                }
                            } else if(responseAR == 'M' || responseAR == 'm') {
                                int size = this.view.promptNumberOfRooms();
                                this.view.displayAddMultipleRoom(size);
                                HotelViewerView.displayShortDivider();
                                confirmationAdd = this.view.promptConfirmation();
                                if(confirmationAdd == 'Y' || confirmationAdd == 'y') {
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
                                } else if(confirmationAdd == 'N' || confirmationAdd == 'n'){
                                    HotelViewerView.displayLongDivider();
                                    break;
                                } 
                            } else {
                                this.view.displayInvalidInput();
                                HotelViewerView.displayLongDivider();
                                break;
                            }
                        case HotelManagerView.REMOVE_ROOM:
                            HotelViewerView.displayLongDivider();
                            char responseRR = this.view.promptRemovingRoom();
                            char confirmationRR, confirmationRRM;
                            int statusRR;
                            if(responseRR == 'S' || responseRR == 's') {
                                this.view.displayRemoveSingleRoom();
                                HotelViewerView.displayShortDivider();
                                confirmationRR = this.view.promptConfirmation();
                                if(confirmationRR == 'Y' || confirmationRR == 'y') {
                                    statusRR = hotel.removeRoom();
                                    if(statusRR == 1) {
                                        this.view.displayRemoveRoomSuccess();
                                        HotelViewerView.displayLongDivider();
                                        break;
                                    } else {
                                        this.view.displayRemoveRoomFailed();
                                        HotelViewerView.displayLongDivider();
                                        break;
                                    }
                                } else if(confirmationRR == 'N' || confirmationRR == 'n'){
                                    HotelViewerView.displayLongDivider();
                                    break;
                                }
                            } else if(responseRR == 'M' || responseRR == 'm') {
                                int size = this.view.promptRemoveNumberOfRooms();
                                this.view.displayRemoveMultipleRoom(size);
                                HotelViewerView.displayShortDivider();
                                confirmationRRM = this.view.promptConfirmation();
                                if(confirmationRRM == 'Y' || confirmationRRM == 'y') {
                                    int statusRRM = hotel.removeRoom(size);
                                    if(statusRRM == size) {
                                        this.view.displayRemoveMultipleRoomSuccess(size);
                                        HotelViewerView.displayLongDivider();
                                        break;
                                    } else {
                                        this.view.displayRemoveMultipleRoomFailed();
                                        HotelViewerView.displayLongDivider();
                                        break;
                                    }
                                } else if(confirmationRRM == 'N' || confirmationRRM == 'n'){
                                    HotelViewerView.displayLongDivider();
                                    break;
                                }
                            } else {
                                this.view.displayInvalidInput();
                                HotelViewerView.displayLongDivider();
                                break;
                            }
                        case HotelManagerView.UPDATE_PRICE:
                            HotelViewerView.displayLongDivider();
                            double newPrice = this.view.promptNewPrice();
                            char confirmationUP;
                            if(newPrice < 100.0){
                                this.view.displayPromptPriceInvalid();
                                break;
                            } else {
                                this.view.displayUpdatePriceInfo(hotel.getRoomList().get(0).getPrice(), newPrice);
                                HotelViewerView.displayShortDivider();
                                confirmationUP = this.view.promptConfirmation();
                                if(confirmationUP == 'Y' || confirmationUP == 'y') {
                                    boolean statusUP = this.model.updateRoomPrice(hotel, newPrice);
                                    if(statusUP) {
                                        this.view.displayUpdatePriceSuccess();
                                        HotelViewerView.displayLongDivider();
                                        break;
                                    } else {
                                        this.view.displayUpdatePriceFailed();
                                        HotelViewerView.displayLongDivider();
                                        break;
                                    }
                                } else if(confirmationUP == 'N' || confirmationUP == 'n'){
                                    HotelViewerView.displayLongDivider();
                                    break;
                                }
                            }
                        case HotelManagerView.REMOVE_RESERVATION:
                            String firstName = this.view.promptFirstName();
                            String lastName = this.view.promptLastName();
                            char confirmationRS;

                            this.view.displayRemoveReservationInfo(firstName, lastName);
                            HotelViewerView.displayShortDivider();
                            confirmationRS = this.view.promptConfirmation();
                            if(confirmationRS == 'Y' || confirmationRS == 'y') {
                                boolean statusRS = hotel.removeReservation(firstName, lastName);
                                    if(statusRS) {
                                        this.view.displayRemoveReservationSuccess();
                                        HotelViewerView.displayLongDivider();
                                        break;
                                    } else {
                                        this.view.displayRemoveReservationFailed();
                                        HotelViewerView.displayLongDivider();
                                        break;
                                    }
                            } else if(confirmationRS == 'N' || confirmationRS == 'n'){
                                HotelViewerView.displayLongDivider();
                                break;
                            }
                        case HotelManagerView.REMOVE_HOTEL:
                            char confirmationRH;
                            this.view.displayRemoveHotelInfo();
                            HotelViewerView.displayShortDivider();
                            confirmationRH = this.view.promptConfirmation();
                            if(confirmationRH == 'Y' || confirmationRH == 'y') {
                                boolean statusRH = this.model.removeHotel(hotel);
                                    if(statusRH) {
                                        this.view.displayRemoveHotelSuccess();
                                        HotelViewerView.displayLongDivider();
                                        input = 7;
                                        break;
                                    } else {
                                        this.view.displayRemoveHotelFailed();
                                        HotelViewerView.displayLongDivider();
                                        break;
                                    }
                            } else if(confirmationRH == 'N' || confirmationRH == 'n'){
                                HotelViewerView.displayLongDivider();
                                break;
                            }
                        case HotelManagerView.MANAGER_EXIT:
                            input = 7;
                            break;
                        default:
                            System.out.print("INVALID INPUT PLEASE TRY AGAIN\n");
                    }
                } while(input != 7);
            }
        }
    }
