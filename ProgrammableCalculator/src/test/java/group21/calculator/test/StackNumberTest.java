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
        System.out.println("Testing pushNumber");
        stackNumber.pushNumber(n);
        assertFalse(stackNumber.isEmpty());
        assertEquals(n, stackNumber.peekNumber());

    }

    /**
     * Test of getStackSize method, of class StackNumber.
     */
    @Test
    void testGetStackSize() {
        System.out.println("Testing getStackSize");
        stackNumber.pushNumber(n);
        assertEquals(1,stackNumber.getStackSize());

    }

    /**
     * Test of isEmpty method, of class StackNumber.
     */
    @Test
    void testIsEmpty() {
        System.out.println("Testing isEmpty");
        assertEquals(0,stackNumber.getStackSize());
        assertTrue(stackNumber.isEmpty());
    }

    /**
     * Test of peekNumber method, of class StackNumber.
     */
    @Test
    void testPeekNumber() {
        System.out.println("Testing peekNumber");
        stackNumber.pushNumber(n);
        assertEquals(n,stackNumber.peekNumber());
    }

    /**
     * Test of dropNumber method, of class StackNumber.
     */
    @Test
    void testDropNumber() {
        System.out.println("Testing dropNumber");
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
        System.out.println("Testing clearNumber");
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
        System.out.println("Testing dupNumber");
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
        System.out.println("Testing swapNumber");
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
        System.out.println("Testing overNumber");
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
        System.out.println("Testing getNumber");
        stackNumber.pushNumber(n);
        assertEquals(n.toString(), stackNumber.getNumber(0));

    }


}