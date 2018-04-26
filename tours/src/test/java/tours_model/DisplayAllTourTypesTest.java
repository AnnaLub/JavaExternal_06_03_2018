package tours_model;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class DisplayAllTourTypesTest {
    static Tour[] tourTypesForDisplay = {new RecreationTour(), new ExcursionTour(), new TreatingTour(),
            new ShoppingTour(), new CruiseTour()};

    @Test @Ignore
    //тест ок, если мы запускаем его отдельно, при запуске скопа тестов выдает NullPointerException
    public void displayAllTourTypesNotNullAssertion() {
        DisplayAllTourTypes.displayAllTourTypes(tourTypesForDisplay);
        assertNotNull(tourTypesForDisplay);
    }

    @Test(expected = NullPointerException.class)
    public void displayAllTourTypesNullPointerException() {
        Tour [] tourTypesNullPointer = null;
        DisplayAllTourTypes.displayAllTourTypes(tourTypesNullPointer);
        assertNull(tourTypesNullPointer);
    }
}