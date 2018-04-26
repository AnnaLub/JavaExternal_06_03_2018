package tours_model;

import tours_view.Menu;

public class SetExcursionTour implements ICommand {
   private ExcursionTour excursionTour;

    public SetExcursionTour(ExcursionTour excursionTour) {
        this.excursionTour = excursionTour;
    }

    public void execute() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException {

        excursionTour.totalPriceCalculation(excursionTour.setTransportType(Menu.getChosenTransport()),
                excursionTour.setMealType(Menu.getChosenMenu()), excursionTour.setNumberOfDays(Menu.getChosenNumberOfDays()));

        excursionTour.setTotalPriceDisplay(excursionTour.getTotalPrice());
    }
}
