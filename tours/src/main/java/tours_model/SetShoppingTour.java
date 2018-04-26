package tours_model;

import tours_view.Menu;

public class SetShoppingTour implements ICommand {
    private ShoppingTour shoppingTour;

    public SetShoppingTour(ShoppingTour shoppingTour) {
        this.shoppingTour = shoppingTour;
    }

    @Override
    public void execute() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException {

        shoppingTour.totalPriceCalculation(shoppingTour.setTransportType(Menu.getChosenTransport()),
                shoppingTour.setMealType(Menu.getChosenMenu()), shoppingTour.setNumberOfDays(Menu.getChosenNumberOfDays()));

        shoppingTour.setTotalPriceDisplay(shoppingTour.getTotalPrice());
    }
}
