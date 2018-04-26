package tours_model;

import org.junit.Test;

import static org.junit.Assert.*;

public class SetShoppingTourTest {
    SetShoppingTour setShoppingTour = new SetShoppingTour(new ShoppingTour());

    @Test(expected = NoSuchTransportException.class)
    public void executeNoSuchTransportExceptionExpected() throws NoSuchMealTypeException, NoSuchTransportException, NoSuchNumberOfDaysException {
        setShoppingTour.execute();
        assertNotNull(setShoppingTour);
    }

}