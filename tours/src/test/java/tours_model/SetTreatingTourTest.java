package tours_model;

import org.junit.Test;

import static org.junit.Assert.*;

public class SetTreatingTourTest {
    SetTreatingTour setTreatingTour = new SetTreatingTour(new TreatingTour());

    @Test(expected = NoSuchTransportException.class)
    public void executeNoSuchTransportExceptionExpected() throws NoSuchMealTypeException, NoSuchTransportException, NoSuchNumberOfDaysException {
        setTreatingTour.execute();
        assertNotNull(setTreatingTour);
    }
}