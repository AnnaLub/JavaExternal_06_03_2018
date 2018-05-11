package inputdata_inversion;

import org.junit.Test;

import static org.junit.Assert.*;

public class InputStackTest {

    @Test
    public void pushNormalBehaviour() {
        String expected = "q";
        InputStack actualStack = new InputStack(1);
        actualStack.push("q");
        String actual = actualStack.pop();
        assertEquals(expected,actual);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void pushException() {
        String expected = "y";
        InputStack actualStack = new InputStack(4);
        actualStack.push("q");
        actualStack.push("w");
        actualStack.push("e");
        actualStack.push("r");
        actualStack.push("t");
        actualStack.push("y");
        assertTrue(expected==actualStack.pop());
    }

    @Test
    public void popNormalBehaviour() {
        String expected = "w";
        InputStack actualStack = new InputStack(1);
        actualStack.push("w");
        String actual = actualStack.pop();
        assertEquals(expected,actual);
    }

    @Test
    public void popAbnormalBehaviour() {
        String expected = "w";
        InputStack actualStack = new InputStack(1);
        actualStack.push("y");
        String actual = actualStack.pop();
        assertNotEquals(expected,actual);
    }

    @Test
    public void peekNormalBehaviour() {
        String expected = "e";
        InputStack actualStack = new InputStack(2);
        actualStack.push("e");
        String actual = actualStack.peek();
        assertEquals(expected,actual);
    }

    @Test
    public void peekAbnormalBehaviour() {
        String expected = "w";
        InputStack actualStack = new InputStack(1);
        actualStack.push("y");
        String actual = actualStack.peek();
        assertNotEquals(expected,actual);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void peekException() {
        String expected = "y";
        InputStack actualStack = new InputStack(4);
        actualStack.push("q");
        actualStack.push("w");
        actualStack.push("e");
        actualStack.push("r");
        actualStack.push("t");
        String actual = actualStack.peek();
        assertEquals(expected,actual);
    }

    @Test
    public void isNotEmptyTest() {
        InputStack actualStack = new InputStack(1);
        actualStack.push("a");
        boolean actual = actualStack.isEmpty();
        assertFalse("not Empty", actual);
    }

    @Test
    public void isEmptyTest() {
        boolean expected = false;
        InputStack actualStack = new InputStack(0);
        boolean actual = actualStack.isEmpty();
        assertTrue("is Empty", actual);
    }

    @Test
    public void sizeNormalBehaviour() {
        int expected = 4;
        InputStack actualStack = new InputStack(4);
        actualStack.push("q");
        actualStack.push("q");
        actualStack.push("q");
        actualStack.push("q");
        int actual = actualStack.size();
        assertEquals(expected,actual);
    }
    @Test
    public void sizeAbNormalBehaviour() {
        int expected = 4;
        InputStack actualStack = new InputStack(4);
        int actual = actualStack.size();
        assertNotEquals(expected,actual);
    }

    @Test
    public void peekNNormalBehaviour() {
        String expected = "e";
        InputStack actualStack = new InputStack(1);
        actualStack.push("e");
        String actual = actualStack.peekN(0);
        assertEquals(expected,actual);
    }

    @Test
    public void peekNAbNormalBehaviour() {
        String expected = "e";
        InputStack actualStack = new InputStack(1);
        String actual = actualStack.peekN(0);
        assertNotEquals(expected,actual);
    }

}