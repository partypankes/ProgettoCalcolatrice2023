package group21.calculator.test;

import group21.calculator.operation.Variables;
import group21.calculator.type.ComplexNumber;
import group21.calculator.type.StackNumber;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VariablesTest {
    Variables variables;
    StackNumber numbers;
    @BeforeEach
    void setUp() {
       variables = new Variables();
       numbers = new StackNumber();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetVariables() {
        System.out.println("Testing getVariables");
        assertNotNull(variables.getVariables());
    }

    @Test
    void testSearchVariable() {
        System.out.println("Testing searchVariable");
        char tempchar = 'A';
        ComplexNumber tempnumber = new ComplexNumber(10,20);
        variables.getVariables().put(tempchar,tempnumber);
        assertEquals(tempnumber,variables.searchVariable(tempchar));

    }

    @Test
    void testPerform1() {
        System.out.println("Testing perform, case 1");
        ComplexNumber tempnumber = new ComplexNumber(10,20);
        numbers.pushNumber(tempnumber);
        variables.perform(">A",numbers);
        assertEquals(tempnumber,variables.searchVariable('A'));
    }

    @Test
    void testPerform2() {
        System.out.println("Testing perform, case 2");
        ComplexNumber tempnumber = new ComplexNumber(10,20);
        numbers.pushNumber(tempnumber);
        variables.getVariables().put('A',tempnumber);
        variables.perform("<A",numbers);
        assertEquals(variables.searchVariable('A'),numbers.peekNumber());
    }
    @Test
    void testPerform3() {
        System.out.println("Testing perform, case 3");
        ComplexNumber tempnumber = new ComplexNumber(10,20);
        numbers.pushNumber(tempnumber);
        variables.perform(">A",numbers);
        variables.perform("+A",numbers);
        assertEquals(variables.searchVariable('A'),tempnumber.add(numbers.peekNumber()));
    }

    @Test
    void testPerform4() {
        System.out.println("Testing perform, case 4");
        ComplexNumber tempnumber = new ComplexNumber(10,20);
        numbers.pushNumber(tempnumber);
        variables.perform(">A",numbers);
        variables.perform("-A",numbers);
        assertEquals(variables.searchVariable('A'),tempnumber.subtract(numbers.peekNumber()));
    }

    @Test
    void testPerform5() {
        System.out.println("Testing perform, case 5");
        ComplexNumber tempnumber = new ComplexNumber(10,20);
        numbers.pushNumber(tempnumber);
        variables.perform(">A",numbers);
        variables.perform("*A",numbers);
        assertEquals(variables.searchVariable('A'),tempnumber.multiply(numbers.peekNumber()));
    }

    @Test
    void testPerform6() {
        System.out.println("Testing perform, case 6");
        ComplexNumber tempnumber = new ComplexNumber(10,20);
        numbers.pushNumber(tempnumber);
        variables.perform(">A",numbers);
        variables.perform("/A",numbers);
        assertEquals(variables.searchVariable('A'),tempnumber.divide(numbers.peekNumber()));
    }

    @Test
    void testPerform7() {
        System.out.println("Testing perform, case 7");
        ComplexNumber tempnumber = new ComplexNumber(10,20);
        numbers.pushNumber(tempnumber);
        variables.perform(">A",numbers);
        variables.perform("√A",numbers);
        assertEquals(variables.searchVariable('A'),numbers.peekNumber().squareRoot());
    }

    @Test
    void testPerform8() {
        System.out.println("Testing perform, case 8");
        ComplexNumber tempnumber = new ComplexNumber(10,20);
        numbers.pushNumber(tempnumber);
        variables.perform(">A",numbers);
        variables.perform("±A",numbers);
        assertEquals(variables.searchVariable('A'),numbers.peekNumber().invertSign());
    }
}
