package tours_model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CruiseTourTest {
    private CruiseTour cruiseTour;

    @Test
    public void executeNormalBehavior() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException {
        cruiseTour = new CruiseTour();
        int toTourPriceActual = cruiseTour.totalPriceCalculation(cruiseTour.setTransportType(1),
                cruiseTour.setMealType(5),
                cruiseTour.setNumberOfDays(14));
        int totalTourPriceExpected = 759;
        assertEquals(totalTourPriceExpected,toTourPriceActual);
    }

    @Test(expected = NullPointerException.class)
    public void executeNullPointerExceptionCheck() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException {
        int toTourPriceActual = cruiseTour.totalPriceCalculation(cruiseTour.setTransportType(1),
                cruiseTour.setMealType(5),
                cruiseTour.setNumberOfDays(14));
        int totalTourPriceExpected = 759;
        assertEquals(totalTourPriceExpected,toTourPriceActual);
    }

    @Test(expected = NoSuchTransportException.class)
    public void executeAbnormalBehaviorSetTransportType() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException {
        cruiseTour = new CruiseTour();
        int toTourPriceActual = cruiseTour.totalPriceCalculation(cruiseTour.setTransportType(0),
                cruiseTour.setMealType(5),
                cruiseTour.setNumberOfDays(14));
        int totalTourPriceExpected = 759;
        assertEquals(totalTourPriceExpected,toTourPriceActual);
    }

    @Test(expected = NoSuchMealTypeException.class)
    public void executeAbnormalBehaviorSetMealType() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException {
        cruiseTour = new CruiseTour();
        int toTourPriceActual = cruiseTour.totalPriceCalculation(cruiseTour.setTransportType(1),
                cruiseTour.setMealType(0),
                cruiseTour.setNumberOfDays(14));
        int totalTourPriceExpected = 759;
        assertEquals(totalTourPriceExpected,toTourPriceActual);
    }

    @Test(expected = NoSuchNumberOfDaysException.class)
    public void executeAbnormalBehaviorNumberOfDaysType() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException {
        cruiseTour = new CruiseTour();
        int toTourPriceActual = cruiseTour.totalPriceCalculation(cruiseTour.setTransportType(1),
                cruiseTour.setMealType(5),
                cruiseTour.setNumberOfDays(2));
        int totalTourPriceExpected = 759;
        assertEquals(totalTourPriceExpected,toTourPriceActual);
    }
}