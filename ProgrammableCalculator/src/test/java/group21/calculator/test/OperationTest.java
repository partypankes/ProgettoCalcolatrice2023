package group21.calculator.test;

import group21.calculator.operation.Operation;
import group21.calculator.type.ComplexNumber;
import group21.calculator.type.StackNumber;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationTest {
    StackNumber numbers;
    String operators;
    ComplexNumber n1;
    ComplexNumber n2;
    @BeforeEach
    void setUp() {
        numbers = new StackNumber();
        n1 = new ComplexNumber(5,4);
        n2 = new ComplexNumber(9,0);
        numbers.pushNumber(n1);
        numbers.pushNumber(n2);
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * Test of perform method, of class Operation.
     */
    @Test
    void testPerformUnaryCase() {
        System.out.println("Testing perform, unary case");
        operators = "√±";
        ComplexNumber temp = n2.squareRoot().invertSign();
        Operation.perform(operators,numbers);
        assertEquals(temp,numbers.peekNumber());

    }

    @Test
    void testPerformBinaryCase1() {
        System.out.println("Testing perform, binary case 1");
        operators = "+";
        ComplexNumber temp = n1.add(n2);
        Operation.perform(operators,numbers);
        assertEquals(temp,numbers.peekNumber());

    }

    @Test
    void testPerformBinaryCase2() {
        System.out.println("Testing perform, binary case 2");
        operators = "-";
        ComplexNumber temp = n1.subtract(n2);
        Operation.perform(operators,numbers);
        assertEquals(temp,numbers.peekNumber());

    }

    @Test
    void testPerformBinaryCase3() {
        System.out.println("Testing perform, binary case 3");
        operators = "*";
        ComplexNumber temp = n1.multiply(n2);
        Operation.perform(operators,numbers);
        assertEquals(temp,numbers.peekNumber());

    }

    @Test
    void testPerformBinaryCase4() {
        System.out.println("Testing perform, binary case 4");
        operators = "/";
        ComplexNumber temp = n1.divide(n2);
        Operation.perform(operators,numbers);
        assertEquals(temp,numbers.peekNumber());

    }

}