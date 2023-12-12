package group21.calculator.test;

import group21.calculator.exceptions.StackIsEmptyException;
import group21.calculator.type.ComplexNumber;
import group21.calculator.type.StackNumber;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class StackNumberTest {
    StackNumber stackNumber;
    ComplexNumber n;

    @BeforeEach
    void setUp() {
         stackNumber = new StackNumber();
         n = new ComplexNumber(1,10);
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * Test of pushNumber method, of class StackNumber.
     */
    @Test
    void testPushNumber() {
        ComplexNumber n = new ComplexNumber(20,21);
        stackNumber.pushNumber(n);
        assertFalse(stackNumber.isEmpty());
        assertEquals(n, stackNumber.peekNumber());

    }

    /**
     * Test of getStackSize method, of class StackNumber.
     */
    @Test
    void testGetStackSize() {
        stackNumber.pushNumber(n);
        assertEquals(1,stackNumber.getStackSize());

    }

    /**
     * Test of isEmpty method, of class StackNumber.
     */
    @Test
    void testIsEmpty() {
        assertEquals(0,stackNumber.getStackSize());
        assertTrue(stackNumber.isEmpty());
    }

    /**
     * Test of peekNumber method, of class StackNumber.
     */
    @Test
    void testPeekNumber() {
        stackNumber.pushNumber(n);
        assertEquals(n,stackNumber.peekNumber());
    }

    /**
     * Test of dropNumber method, of class StackNumber.
     */
    @Test
    void testDropNumber() {
        stackNumber.pushNumber(new ComplexNumber(20,32));
        stackNumber.pushNumber(n);
        stackNumber.dropNumber();
        assertNotSame(stackNumber.peekNumber(), n);
    }

    /**
     * Test of clearNumber method, of class StackNumber.
     */
    @Test
    void testClearNumber() {
        stackNumber.pushNumber(n);
        stackNumber.pushNumber(new ComplexNumber(20,32));
        stackNumber.pushNumber(new ComplexNumber(24,25.4));
        stackNumber.clearNumber();
        assertTrue(stackNumber.isEmpty());

    }

    /**
     * Test of dupNumber method, of class StackNumber.
     */
    @Test
    void testDupNumber() {
        stackNumber.pushNumber(new ComplexNumber(20,32));
        stackNumber.pushNumber(n);
        stackNumber.dupNumber();
        assertEquals(n,stackNumber.dropNumber());
        assertEquals(n,stackNumber.peekNumber());
    }

    /**
     * Test of swapNumber method, of class StackNumber.
     */
    @Test
    void testSwapNumber() {
        stackNumber.pushNumber(n);
        stackNumber.pushNumber(new ComplexNumber(20,32));
        stackNumber.swapNumber();
        assertEquals(n,stackNumber.peekNumber());

    }

    /**
     * Test of overNumber method, of class StackNumber.
     */
    @Test
    void testOverNumber() {
        stackNumber.pushNumber(n);
        stackNumber.pushNumber(new ComplexNumber(20,32));
        stackNumber.overNumber();
        assertEquals(n,stackNumber.peekNumber());

    }

    /**
     * Test of getNumber method, of class StackNumber.
     */
    @Test
    void testGetNumber() {
        stackNumber.pushNumber(n);
        //ComplexNumber n1 = new ComplexNumber(20,32);
        //stackNumber.pushNumber(n1);
        assertEquals(n.toString(), stackNumber.getNumber(0));
        //assertEquals(n1.toString(), stackNumber.getNumber(1));
        //perchè farne due???
    }


}