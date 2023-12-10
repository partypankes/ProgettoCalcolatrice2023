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
    void getReal() {
        System.out.println("Testing getReal");
        ComplexNumber n = new ComplexNumber(3,4);
        assertEquals(3, n.getReal());
    }

    @Test
    void getImaginary() {
        System.out.println("Testing getImaginary");
        ComplexNumber n = new ComplexNumber(3,4);
        assertEquals(4, n.getImaginary());
    }

    @Test
    void add() {
        ComplexNumber n = new ComplexNumber(3,4);
        ComplexNumber out = n.add(other);
        assertTrue(out.getReal() == 5 && out.getImaginary() == 7);
    }

    @Test
    void subtract() {
        ComplexNumber n = new ComplexNumber(3,4);
        ComplexNumber out = n.subtract(other);
        assertTrue(out.getReal() == 1 && out.getImaginary() == 1);
    }

    @Test
    void multiply() {
        ComplexNumber n = new ComplexNumber(3,4);
        ComplexNumber out = n.multiply(other);
        assertTrue(out.getReal() == -6 && out.getImaginary() == 17);
    }

    @Test
    void divide() {
        ComplexNumber n = new ComplexNumber(12,3);
        ComplexNumber out = n.divide(new ComplexNumber(3,1));
        assertTrue(out.getReal() == 3.9 && out.getImaginary() == -0.3);
    }

    @Test
    void squareRoot() {
        ComplexNumber n = new ComplexNumber(3,4);
        ComplexNumber out = n.squareRoot();
        assertTrue(out.getReal() == 2 && out.getImaginary() == 1);
    }

    @Test
    void invertSign() {
        ComplexNumber n = new ComplexNumber(3,-4);
        ComplexNumber out = n.invertSign();
        assertTrue(out.getReal() == -3 && out.getImaginary() == 4);
    }

    @Test
    void complexParse() {
        String[] str = {"3+4j", "3-4j", "3", "3+0j"} ; // -3+4j, -3-4j, -3 , 4j, -4j, 0+4j
    }

}
