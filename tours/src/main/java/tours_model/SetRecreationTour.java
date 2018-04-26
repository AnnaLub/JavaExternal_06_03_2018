package tours_model;

import tours_view.Menu;

public class SetRecreationTour implements ICommand {
   private RecreationTour recreationTour;

    public SetRecreationTour(RecreationTour recreationTour) {
        this.recreationTour = recreationTour;
    }

    public void execute() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException {

        recreationTour.totalPriceCalculation(recreationTour.setTransportType(Menu.getChosenTransport()),
                recreationTour.setMealType(Menu.getChosenMenu()), recreationTour.setNumberOfDays(Menu.getChosenNumberOfDays()));

        recreationTour.setTotalPriceDisplay(recreationTour.getTotalPrice());
    }
}
