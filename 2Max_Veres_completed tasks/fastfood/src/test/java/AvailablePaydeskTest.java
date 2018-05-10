import org.junit.Test;

import static org.junit.Assert.*;

public class AvailablePaydeskTest {

    @Test
    public void setAvailablePaydeskBooleanCkeck() {
        int i = 1;
        boolean flag = false;
        AvailablePaydesk.setAvailablePaydesk(i,flag);
        boolean actual = AvailablePaydesk.getAvailablePaydesk(i);
        boolean expected = false;
        assertEquals(expected,actual);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void setAvailablePaydeskArrayBoundsException() {
        int i = 8;
        boolean flag = false;
        AvailablePaydesk.setAvailablePaydesk(i,flag);
        boolean actual = AvailablePaydesk.getAvailablePaydesk(i);
        boolean expected = false;
        assertEquals(expected,actual);
    }

    @Test
    public void getAvailablePaydesk() {
        int i = 1;
        assertNotNull(AvailablePaydesk.getAvailablePaydesk(i));
    }
}