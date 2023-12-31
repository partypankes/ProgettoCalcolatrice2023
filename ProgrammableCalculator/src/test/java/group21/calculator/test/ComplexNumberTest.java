package group21.calculator.test;

import group21.calculator.type.ComplexNumber;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


class ComplexNumberTest {


    private ComplexNumber other;

    @BeforeAll
    static void setUpAll() {
    }
    @BeforeEach
    void setUp() {
        this.other = new ComplexNumber(2,3);
    }
    @AfterAll
    static void tearDownAll() {
    }
    @AfterEach
    void tearDown() {
    }

    /**
     * Test of getReal method, of class ComplexNumber.
     */
    @Test
    void testGetReal() {
        System.out.println("Testing getReal");
        ComplexNumber n = new ComplexNumber(3,4);
        assertEquals(3, n.getReal());
    }

    /**
     * Test of getImaginary method, of class ComplexNumber.
     */
    @Test
    void testGetImaginary() {
        System.out.println("Testing getImaginary");
        ComplexNumber n = new ComplexNumber(3,4);
        assertEquals(4, n.getImaginary());
    }

    /**
     * Test of add method, of class ComplexNumber.
     */
    @Test
    void testAdd() {
        System.out.println("Testing add");
        ComplexNumber n = new ComplexNumber(3,4);
        ComplexNumber out = n.add(other);
        assertTrue(out.getReal() == 5 && out.getImaginary() == 7);
    }

    /**
     * Test of subtract method, of class ComplexNumber.
     */
    @Test
    void testSubtract() {
        System.out.println("Testing subtract");
        ComplexNumber n = new ComplexNumber(3,4);
        ComplexNumber out = n.subtract(other);
        assertTrue(out.getReal() == 1 && out.getImaginary() == 1);
    }

    /**
     * Test of multiply method, of class ComplexNumber.
     */
    @Test
    void testMultiply() {
        System.out.println("Testing multiply");
        ComplexNumber n = new ComplexNumber(3,4);
        ComplexNumber out = n.multiply(other);
        assertTrue(out.getReal() == -6 && out.getImaginary() == 17);
    }
    /**
     * Test of divide method, of class ComplexNumber.
     */
    @Test
    void testDivide() {
        System.out.println("Testing divide");
        ComplexNumber n = new ComplexNumber(12,3);
        ComplexNumber out = n.divide(new ComplexNumber(3,1));
        assertTrue(out.getReal() == 3.9 && out.getImaginary() == -0.3);
    }

    /**
     * Test of squareRoot method, of class ComplexNumber.
     */
    @Test
    void testSquareRoot() {
        System.out.println("Testing squareRoot");
        ComplexNumber n = new ComplexNumber(3,4);
        ComplexNumber out = n.squareRoot();
        assertTrue(out.getReal() == 2 && out.getImaginary() == 1);
    }

    /**
     * Test of invertSign method, of class ComplexNumber.
     */
    @Test
    void testInvertSign() {
        System.out.println("Testing invertSign");
        ComplexNumber n = new ComplexNumber(3,-4);
        ComplexNumber out = n.invertSign();
        assertTrue(out.getReal() == -3 && out.getImaginary() == 4);
    }

    /**
     * Test of complexParse method, of class ComplexNumber.
     */
    @Test
    void testComplexParse1() {
        System.out.println("Testing complexParse, case 1");
        ComplexNumber n = ComplexNumber.complexParse("3+4j");
        assertTrue(n.getReal() == 3 && n.getImaginary() == 4);
    }

    @Test
    void testComplexParse2() {
        System.out.println("Testing complexParse, case 2");
        ComplexNumber n = ComplexNumber.complexParse("-3+4j");
        assertTrue(n.getReal() == -3 && n.getImaginary() == 4);
    }

    @Test
    void testComplexParse3() {
        System.out.println("Testing complexParse, case 3");
        ComplexNumber n = ComplexNumber.complexParse("3-4j");
        assertTrue(n.getReal() == 3 && n.getImaginary() == -4);
    }

    @Test
    void testComplexParse4() {
        System.out.println("Testing complexParse, case 4");
        ComplexNumber n = ComplexNumber.complexParse("0+4j");
        assertTrue(n.getReal() == 0 && n.getImaginary() == 4);
    }

    @Test
    void testComplexParse5() {
        System.out.println("Testing complexParse, case 5");
        ComplexNumber n = ComplexNumber.complexParse("3");
        assertTrue(n.getReal() == 3 && n.getImaginary() == 0);
    }

    @Test
    void testComplexParse6() {
        System.out.println("Testing complexParse, case 6");
        ComplexNumber n = ComplexNumber.complexParse("+j");
        assertTrue(n.getReal() == 0 && n.getImaginary() == 1);
    }

    @Test
    void testComplexParse7() {
        System.out.println("Testing complexParse, case 7");
        ComplexNumber n = ComplexNumber.complexParse("3+0j");// -3+4j, -3-4j, -3 , 4j, -4j, 0+4j
        assertTrue(n.getReal() == 3 && n.getImaginary() == 0);
    }

    /**
     * Test of toString method, of class ComplexNumber.
     */
    @Test
    void testToString() {
        System.out.println("Testing toString");
        SimIO simIO = new SimIO();
        simIO.captureOutput();
        System.out.println(other);
        assertEquals("2,00+3,00j",simIO.getCapturedOutput().trim());
        simIO.restoreOutput();
    }
}


