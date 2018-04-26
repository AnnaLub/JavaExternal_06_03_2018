package tours_model;

import org.junit.Test;

import static org.junit.Assert.*;

public class SetRecreationTourTest {
    SetRecreationTour setRecreationTour = new SetRecreationTour(new RecreationTour());

    @Test(expected = NoSuchTransportException.class)
    public void executeNoSuchTransportExceptionExpected() throws NoSuchMealTypeException, NoSuchTransportException, NoSuchNumberOfDaysException {

        setRecreationTour.execute();
        assertNotNull(setRecreationTour);
    }
}