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

    /**
     * Test of getVar method, of class Execute.
     */
    @Test
    void testGetVar() {
        System.out.println("Testing getVar");
        assertNotNull(exe.getVar());
    }

    /**
     * Test of getStack method, of class Execute.
     */
    @Test
    void testGetStack() {
        System.out.println("Testing getStack");
        assertNotNull(exe.getStack());
    }

    /**
     * Test of elaborateTextArea method, of class Execute.
     */
    @Test
    void testElaborateTextArea1() {
        System.out.println("Testing elaborateTextArea, case 1");
        String str = "14+22j";
        exe.elaborateTextArea(str);
        ComplexNumber out = exe.getStack().peekNumber();
        assertEquals(out,n2);
    }

    @Test
    void testElaborateTextArea2() {
        System.out.println("Testing elaborateTextArea, case 2");
        String str = "+";
        exe.elaborateTextArea(str);
        ComplexNumber sum = n1.add(n2);
        ComplexNumber out = exe.getStack().peekNumber();
        assertEquals(out,sum);

    }

    @Test
    void testElaborateTextArea3() {
        System.out.println("Testing elaborateTextArea, case 3");
        String str = ">A";
        exe.elaborateTextArea(str);
        ComplexNumber out = exe.getVar().searchVariable(str.charAt(1));
        assertEquals(out, n2);

    }
}