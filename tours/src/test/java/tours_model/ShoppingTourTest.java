package tours_model;

import org.junit.Test;
import static org.junit.Assert.*;

public class ShoppingTourTest {
    private ShoppingTour shoppingTour;

    @Test
    public void executeNormalBehavior() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException {
        shoppingTour = new ShoppingTour();
        int toTourPriceActual = shoppingTour.totalPriceCalculation(shoppingTour.setTransportType(2),
                shoppingTour.setMealType(2),
                shoppingTour.setNumberOfDays(4));
        int totalTourPriceExpected = 229;
        assertEquals(totalTourPriceExpected,toTourPriceActual);
    }

    @Test(expected = NullPointerException.class)
    public void executeNullPointerExceptionCheck() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException {
        int toTourPriceActual = shoppingTour.totalPriceCalculation(shoppingTour.setTransportType(1),
                shoppingTour.setMealType(2),
                shoppingTour.setNumberOfDays(4));
        int totalTourPriceExpected = 229;
        assertEquals(totalTourPriceExpected,toTourPriceActual);
    }

    @Test(expected = NoSuchTransportException.class)
    public void executeAbnormalBehaviorSetTransportType() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException {
        shoppingTour = new ShoppingTour();
        int toTourPriceActual = shoppingTour.totalPriceCalculation(shoppingTour.setTransportType(0),
                shoppingTour.setMealType(2),
                shoppingTour.setNumberOfDays(4));
        int totalTourPriceExpected = 229;
        assertEquals(totalTourPriceExpected,toTourPriceActual);
    }

    @Test(expected = NoSuchMealTypeException.class)
    public void executeAbnormalBehaviorSetMealType() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException {
        shoppingTour = new ShoppingTour();
        int toTourPriceActual = shoppingTour.totalPriceCalculation(shoppingTour.setTransportType(2),
                shoppingTour.setMealType(0),
                shoppingTour.setNumberOfDays(4));
        int totalTourPriceExpected = 229;
        assertEquals(totalTourPriceExpected,toTourPriceActual);
    }

    @Test(expected = NoSuchNumberOfDaysException.class)
    public void executeAbnormalBehaviorNumberOfDaysType() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException {
        shoppingTour = new ShoppingTour();
        int toTourPriceActual = shoppingTour.totalPriceCalculation(shoppingTour.setTransportType(2),
                shoppingTour.setMealType(2),
                shoppingTour.setNumberOfDays(2));
        int totalTourPriceExpected = 229;
        assertEquals(totalTourPriceExpected,toTourPriceActual);
    }
}