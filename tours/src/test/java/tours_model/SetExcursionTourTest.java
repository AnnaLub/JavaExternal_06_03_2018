package tours_model;

import org.junit.Test;

import static org.junit.Assert.*;

public class SetExcursionTourTest {
    SetExcursionTour setExcursionTour = new SetExcursionTour(new ExcursionTour());

    @Test(expected = NoSuchTransportException.class)
    public void executeNoSuchTransportExceptionExpected() throws NoSuchMealTypeException, NoSuchTransportException, NoSuchNumberOfDaysException {
        setExcursionTour.execute();
        assertNotNull(setExcursionTour);
    }
}