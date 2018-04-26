package tours_model;

import tours_view.Menu;

public class SetCruiseTour implements ICommand {
    private CruiseTour cruiseTour;

    public SetCruiseTour(CruiseTour cruiseTour) {
        this.cruiseTour = cruiseTour;
    }

    @Override
    public void execute() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException {

        cruiseTour.totalPriceCalculation(cruiseTour.setTransportType(Menu.getChosenTransport()),
                cruiseTour.setMealType(Menu.getChosenMenu()), cruiseTour.setNumberOfDays(Menu.getChosenNumberOfDays()));

        cruiseTour.setTotalPriceDisplay(cruiseTour.getTotalPrice());

    }
}
