package tours_model;

import org.junit.Test;

import static org.junit.Assert.*;

public class SetCruiseTourTest {
    SetCruiseTour setCruiseTour = new SetCruiseTour(new CruiseTour());

    @Test(expected = NoSuchTransportException.class)
    public void executeNoSuchTransportExceptionExpected() throws NoSuchMealTypeException, NoSuchTransportException, NoSuchNumberOfDaysException {
        setCruiseTour.execute();
        assertNotNull(setCruiseTour);
    }
}