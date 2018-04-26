package tours_model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExcursionTourTest {
    private ExcursionTour excursionTour;

    @Test
    public void executeNormalBehavior() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException {
        excursionTour = new ExcursionTour();
        int toTourPriceActual = excursionTour.totalPriceCalculation(excursionTour.setTransportType(4),
                excursionTour.setMealType(4),
                excursionTour.setNumberOfDays(4));
        int totalTourPriceExpected = 120;
        assertEquals(totalTourPriceExpected,toTourPriceActual);
    }

    @Test(expected = NullPointerException.class)
    public void executeNullPointerExceptionCheck() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException {
        int toTourPriceActual = excursionTour.totalPriceCalculation(excursionTour.setTransportType(4),
                excursionTour.setMealType(4),
                excursionTour.setNumberOfDays(4));
        int totalTourPriceExpected = 120;
        assertEquals(totalTourPriceExpected,toTourPriceActual);
    }

    @Test(expected = NoSuchTransportException.class)
    public void executeAbnormalBehaviorSetTransportType() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException {
        excursionTour = new ExcursionTour();
        int toTourPriceActual = excursionTour.totalPriceCalculation(excursionTour.setTransportType(0),
                excursionTour.setMealType(4),
                excursionTour.setNumberOfDays(4));
        int totalTourPriceExpected = 120;
        assertEquals(totalTourPriceExpected,toTourPriceActual);
    }

    @Test(expected = NoSuchMealTypeException.class)
    public void executeAbnormalBehaviorSetMealType() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException {
        excursionTour = new ExcursionTour();
        int toTourPriceActual = excursionTour.totalPriceCalculation(excursionTour.setTransportType(4),
                excursionTour.setMealType(0),
                excursionTour.setNumberOfDays(4));
        int totalTourPriceExpected = 120;
        assertEquals(totalTourPriceExpected,toTourPriceActual);
    }

    @Test(expected = NoSuchNumberOfDaysException.class)
    public void executeAbnormalBehaviorNumberOfDaysType() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException {
        excursionTour = new ExcursionTour();
        int toTourPriceActual = excursionTour.totalPriceCalculation(excursionTour.setTransportType(4),
                excursionTour.setMealType(4),
                excursionTour.setNumberOfDays(2));
        int totalTourPriceExpected = 120;
        assertEquals(totalTourPriceExpected,toTourPriceActual);
    }
}