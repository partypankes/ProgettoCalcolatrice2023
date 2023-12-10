package group21.calculator.test;

import group21.calculator.type.ComplexNumber;
import group21.calculator.type.StackNumber;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    @Test
    void testPushNumber() {
        ComplexNumber n = new ComplexNumber(20,21);
        stackNumber.pushNumber(n);
        assertEquals(n,stackNumber.peekNumber());
        assertFalse(stackNumber.isEmpty());
    }

    @Test
    void testGetStackSize() {
        stackNumber.pushNumber(n);
        assertEquals(1,stackNumber.getStackSize());

    }

    @Test
    void testIsEmpty() {
        assertEquals(0,stackNumber.getStackSize());
        assertTrue(stackNumber.isEmpty());
    }


    @Test
    void testPeekNumber() {
        stackNumber.pushNumber(n);
        assertEquals(n,stackNumber.peekNumber());
    }

    @Test
    void testDropNumber() {
        stackNumber.pushNumber(new ComplexNumber(20,32));
        stackNumber.pushNumber(n);
        stackNumber.dropNumber();
        assertNotSame(stackNumber.peekNumber(), n);
    }

    @Test
    void testClearNumber() {
        stackNumber.pushNumber(n);
        stackNumber.pushNumber(new ComplexNumber(20,32));
        stackNumber.pushNumber(new ComplexNumber(24,25.4));
        stackNumber.clearNumber();
        assertTrue(stackNumber.isEmpty());

    }

    @Test
    void testDupNumber() {
        stackNumber.pushNumber(new ComplexNumber(20,32));
        stackNumber.pushNumber(n);
        stackNumber.dupNumber();
        assertEquals(n,stackNumber.dropNumber());
        assertEquals(n,stackNumber.peekNumber());
    }

    @Test
    void testSwapNumber() {
        stackNumber.pushNumber(n);
        stackNumber.pushNumber(new ComplexNumber(20,32));
        stackNumber.swapNumber();
        assertEquals(n,stackNumber.peekNumber());

    }

    @Test
    void testOverNumber() {
        stackNumber.pushNumber(n);
        stackNumber.pushNumber(new ComplexNumber(20,32));
        stackNumber.overNumber();
        assertEquals(n,stackNumber.peekNumber());

    }

    @Test
    void testGetNumber() {
        stackNumber.pushNumber(n);
        ComplexNumber n1 = new ComplexNumber(20,32);
        stackNumber.pushNumber(n1);
        assertEquals(n.toString(), stackNumber.getNumber(0));
        assertEquals(n1.toString(), stackNumber.getNumber(1));
    }
}