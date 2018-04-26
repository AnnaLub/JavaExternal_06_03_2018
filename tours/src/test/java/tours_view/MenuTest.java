package tours_view;

import org.junit.Test;

import static org.junit.Assert.*;

public class MenuTest {

    @Test
    public void getChosenTransport() {
        int expected = 0;
        int actual = Menu.getChosenTransport();
        assertEquals(expected,actual);
    }

    @Test
    public void getChosenMenu() {
        int expected = 0;
        int actual = Menu.getChosenMenu();
        assertEquals(expected,actual);
    }

    @Test
    public void getChosenNumberOfDays() {
        int expected = 0;
        int actual = Menu.getChosenNumberOfDays();
        assertEquals(expected,actual);
    }
}