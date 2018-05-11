package outputdata_parsing;

import org.junit.Test;

import static org.junit.Assert.*;

public class RPNStackTest {

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void pushException() {
        int expected = 42;
        RPNStack actualStack = new RPNStack(4);
        actualStack.push(1);
        actualStack.push(2);
        actualStack.push(3);
        actualStack.push(4);
        actualStack.push(5);
        actualStack.push(42);
        assertTrue(expected==actualStack.pop());
    }

    public void push() {
        int expected = 42;
        RPNStack actualStack = new RPNStack(1);
        actualStack.push(42);
        int actual = (int)actualStack.pop();
        assertEquals(expected,actual);
    }

    @Test
    public void popNormalBehaviour() {
        int expected = 1;
        RPNStack actualStack = new RPNStack(1);
        actualStack.push(1);
        int actual = (int)actualStack.pop();
        assertEquals(expected,actual);
    }

    @Test
    public void popAbnormalBehaviour() {
        int expected = 42;
        RPNStack actualStack = new RPNStack(1);
        actualStack.push(4);
        int actual = (int)actualStack.pop();
        assertNotEquals(expected,actual);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void peekException() {
        int expected = 42;
        RPNStack actualStack = new RPNStack(4);
        actualStack.push(1);
        actualStack.push(2);
        actualStack.push(3);
        actualStack.push(4);
        actualStack.push(42);
        int actual = (int)actualStack.peek();
        assertEquals(expected,actual);
    }

    @Test
    public void isNotEmptyTest() {
        RPNStack actualStack = new RPNStack(1);
        actualStack.push(42);
        boolean actual = actualStack.isEmpty();
        assertFalse("not Empty", actual);
    }

    @Test
    public void isEmptyTest() {
        boolean expected = false;
        RPNStack actualStack = new RPNStack(0);
        boolean actual = actualStack.isEmpty();
        assertTrue("is Empty", actual);
    }

    @Test
    public void sizeNormalBehaviour() {
        int expected = 4;
        RPNStack actualStack = new RPNStack(4);
        actualStack.push(4);
        actualStack.push(4);
        actualStack.push(4);
        actualStack.push(4);
        int actual = actualStack.size();
        assertEquals(expected,actual);
    }

    @Test
    public void sizeAbNormalBehaviour() {
        int expected = 4;
        RPNStack actualStack = new RPNStack(4);
        int actual = actualStack.size();
        assertNotEquals(expected,actual);
    }

    @Test
    public void peekNNormalBehaviour() {
        int expected = 42;
        RPNStack actualStack = new RPNStack(1);
        actualStack.push(42);
        int actual = (int)actualStack.peekN(0);
        assertEquals(expected,actual);
    }

    @Test
    public void peekNAbNormalBehaviour() {
        int expected = 42;
        RPNStack actualStack = new RPNStack(1);
        int actual = (int)actualStack.peekN(0);
        assertNotEquals(expected,actual);
    }
}