package tours_view;

import org.junit.Test;
import tours_model.NoSuchMealTypeException;
import tours_model.NoSuchNumberOfDaysException;
import tours_model.NoSuchTransportException;

import static org.junit.Assert.*;

public class ApplicationTest {
    Menu menu;

    @Test(expected = NullPointerException.class)
    public void mainRunNullPointerException() throws NoSuchMealTypeException, NoSuchTransportException, NoSuchNumberOfDaysException {
        menu.run();
        assertNull(menu);
    }

    @Test
    public void mainRunNotNullPointerException() {
        menu = new Menu();
        assertNotNull(menu);
    }
}