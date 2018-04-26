package tours_model;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecreationTourTest {
    private RecreationTour recreationTour;

    @Test
    public void executeNormalBehavior() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException {
        recreationTour = new RecreationTour();
        int toTourPriceActual = recreationTour.totalPriceCalculation(recreationTour.setTransportType(3),
                recreationTour.setMealType(3), recreationTour.setNumberOfDays(3));
        int totalTourPriceExpected = 339;
        assertEquals(totalTourPriceExpected,toTourPriceActual);
    }

    @Test(expected = NullPointerException.class)
    public void executeNullPointerExceptionCheck() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException {
        int toTourPriceActual = recreationTour.totalPriceCalculation(recreationTour.setTransportType(3),
                recreationTour.setMealType(3), recreationTour.setNumberOfDays(3));
        int totalTourPriceExpected = 339;
        assertEquals(totalTourPriceExpected,toTourPriceActual);
    }

    @Test(expected = NoSuchTransportException.class)
    public void executeAbnormalBehaviorSetTransportType() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException {
        recreationTour = new RecreationTour();
        int toTourPriceActual = recreationTour.totalPriceCalculation(recreationTour.setTransportType(0),
                recreationTour.setMealType(3), recreationTour.setNumberOfDays(3));
        int totalTourPriceExpected = 339;
        assertEquals(totalTourPriceExpected,toTourPriceActual);
    }

    @Test(expected = NoSuchMealTypeException.class)
    public void executeAbnormalBehaviorSetMealType() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException {
        recreationTour = new RecreationTour();
        int toTourPriceActual = recreationTour.totalPriceCalculation(recreationTour.setTransportType(3),
                recreationTour.setMealType(0), recreationTour.setNumberOfDays(3));
        int totalTourPriceExpected = 339;
        assertEquals(totalTourPriceExpected,toTourPriceActual);
    }

    @Test(expected = NoSuchNumberOfDaysException.class)
    public void executeAbnormalBehaviorNumberOfDaysType() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException {
        recreationTour = new RecreationTour();
        int toTourPriceActual = recreationTour.totalPriceCalculation(recreationTour.setTransportType(3),
                recreationTour.setMealType(3), recreationTour.setNumberOfDays(2));
        int totalTourPriceExpected = 339;
        assertEquals(totalTourPriceExpected,toTourPriceActual);
    }
}