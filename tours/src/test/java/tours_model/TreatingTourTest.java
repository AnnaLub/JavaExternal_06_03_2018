package tours_model;

import org.junit.Test;
import static org.junit.Assert.*;

public class TreatingTourTest {
    private TreatingTour treatingTour;

    @Test
    public void executeNormalBehavior() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException {
        treatingTour = new TreatingTour();
        int toTourPriceActual = treatingTour.totalPriceCalculation(treatingTour.setTransportType(1),
                treatingTour.setMealType(1),
                treatingTour.setNumberOfDays(14));
        int totalTourPriceExpected = 2299;
        assertEquals(totalTourPriceExpected,toTourPriceActual);
    }

    @Test(expected = NullPointerException.class)
    public void executeNullPointerExceptionCheck() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException {
        int toTourPriceActual = treatingTour.totalPriceCalculation(treatingTour.setTransportType(1),
                treatingTour.setMealType(1),
                treatingTour.setNumberOfDays(14));
        int totalTourPriceExpected = 2299;
        assertEquals(totalTourPriceExpected,toTourPriceActual);
    }

    @Test(expected = NoSuchTransportException.class)
    public void executeAbnormalBehaviorSetTransportType() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException {
        treatingTour = new TreatingTour();
        int toTourPriceActual = treatingTour.totalPriceCalculation(treatingTour.setTransportType(0),
                treatingTour.setMealType(1),
                treatingTour.setNumberOfDays(14));
        int totalTourPriceExpected = 2299;
        assertEquals(totalTourPriceExpected,toTourPriceActual);
    }

    @Test(expected = NoSuchMealTypeException.class)
    public void executeAbnormalBehaviorSetMealType() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException {
        treatingTour = new TreatingTour();
        int toTourPriceActual = treatingTour.totalPriceCalculation(treatingTour.setTransportType(1),
                treatingTour.setMealType(0),
                treatingTour.setNumberOfDays(14));
        int totalTourPriceExpected = 2299;
        assertEquals(totalTourPriceExpected,toTourPriceActual);
    }

    @Test(expected = NoSuchNumberOfDaysException.class)
    public void executeAbnormalBehaviorNumberOfDaysType() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException {
        treatingTour = new TreatingTour();
        int toTourPriceActual = treatingTour.totalPriceCalculation(treatingTour.setTransportType(1),
                treatingTour.setMealType(1),
                treatingTour.setNumberOfDays(2));
        int totalTourPriceExpected = 2299;
        assertEquals(totalTourPriceExpected,toTourPriceActual);
    }
}