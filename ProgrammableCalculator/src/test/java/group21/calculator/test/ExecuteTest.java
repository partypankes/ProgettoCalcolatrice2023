package group21.calculator.test;

import group21.calculator.operation.Execute;
import group21.calculator.type.ComplexNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExecuteTest {
    Execute exe;
    ComplexNumber n1;
    ComplexNumber n2;

    @BeforeEach
    void setUp() {
        exe = new Execute();
        n1 = new ComplexNumber(10,32);
        n2 = new ComplexNumber(14,22);
        exe.getStack().pushNumber(n1);
        exe.getStack().pushNumber(n2);
    }

    @Test
    void testGetVar() {
        assertNotNull(exe.getVar());
    }

    @Test
    void testGetStack() {
        assertNotNull(exe.getStack());
    }

    @Test
    void testElaborateTextArea0() {
        String tempstring = "10+20j";
        exe.elaborateTextArea(tempstring);
        ComplexNumber tempnumber = ComplexNumber.complexParse(tempstring);
        assertNotNull(exe.getStack().peekNumber());
        assertEquals(tempnumber,exe.getStack().peekNumber());

    }

    @Test
    void testElaborateTextArea1() {
        String tempstring = "+";
        exe.elaborateTextArea(tempstring);
        ComplexNumber tempnumber = n1.add(n2);
        assertNotNull(exe.getStack().peekNumber());
        assertEquals(tempnumber,exe.getStack().peekNumber());

    }

    @Test
    void testElaborateTextArea2() {
        String tempstring = ">A";
        exe.elaborateTextArea(tempstring);
        assertEquals(exe.getVar().searchVariable(tempstring.charAt(1)), exe.getStack().peekNumber());

    }
}