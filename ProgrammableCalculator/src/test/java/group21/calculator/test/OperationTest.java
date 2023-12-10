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
    @BeforeEach
    void setUp() {
        numbers = new StackNumber();
        numbers.pushNumber(new ComplexNumber(5,4));
        numbers.pushNumber(new ComplexNumber(9,0));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testPerformUnaryCase() {
        operators = "√±";
        Operation.perform(operators,numbers);
        assertEquals(-3,numbers.peekNumber().getReal());

    }

}