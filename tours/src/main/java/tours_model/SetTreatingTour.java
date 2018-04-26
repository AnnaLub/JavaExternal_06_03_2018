package tours_model;

import tours_view.Menu;

public class SetTreatingTour implements ICommand {
    private TreatingTour treatingTour;

    public SetTreatingTour(TreatingTour treatingTour) {
        this.treatingTour = treatingTour;
    }

    @Override
    public void execute() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException {

        treatingTour.totalPriceCalculation(treatingTour.setTransportType(Menu.getChosenTransport()),
                treatingTour.setMealType(Menu.getChosenMenu()), treatingTour.setNumberOfDays(Menu.getChosenNumberOfDays()));

        treatingTour.setTotalPriceDisplay(treatingTour.getTotalPrice());

    }
}

