package group21.calculator.type;

/**
 * Represents a complex number with real and imaginary parts.
 * This class provides methods to perform arithmetic operations (addition, subtraction,
 * multiplication, division) on complex numbers, as well as methods to calculate the square
 * root and invert the sign of the complex number. It also includes utility methods for parsing
 * complex numbers from strings and representing them as strings.
 */
public class ComplexNumber {
    private final double real;
    private final double imaginary;

    /**
     * Constructor for creating a ComplexNumber object with specified real and imaginary parts.
     *
     * @param real The real part of the complex number.
     * @param imaginary The imaginary part of the complex number.
     */
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    /**
     * Returns the real part of this complex number.
     *
     * @return The real part.
     */
    public double getReal() {
        return real;
    }

    /**
     * Returns the imaginary part of this complex number.
     *
     * @return The imaginary part.
     */
    public double getImaginary() {
        return imaginary;
    }

    /**
     * Adds this complex number to another complex number and returns the result.
     *
     * @param other The complex number to be added to this one.
     * @return The result of adding this complex number to the other complex number.
     */
    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
    }

    /**
     * Subtracts another complex number from this complex number and returns the result.
     *
     * @param other The complex number to be subtracted from this one.
     * @return The result of subtracting the other complex number from this complex number.
     */
    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(this.real - other.real, this.imaginary - other.imaginary);
    }

    /**
     * Multiplies this complex number by another complex number and returns the result.
     *
     * @param other The complex number to multiply this one by.
     * @return The result of multiplying this complex number by the other complex number.
     */
    public ComplexNumber multiply(ComplexNumber other) {
        double newReal = this.real * other.real - this.imaginary * other.imaginary;
        double newImaginary = this.real *  other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(newReal, newImaginary);
    }

    /**
     * Divides this complex number by another complex number and returns the result.
     *
     * @param other The complex number to divide this one by.
     * @return The result of dividing this complex number by the other complex number.
     */
    public ComplexNumber divide(ComplexNumber other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;

        double newReal = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double newImaginary = (this.imaginary * other.real - this.real * other.imaginary) / denominator;

        return new ComplexNumber(newReal, newImaginary);
    }

    /**
     * Calculates the square root of this complex number and returns the result.
     *
     * @return The result of taking the square root of this complex number.
     */
    public ComplexNumber squareRoot() {
        double magnitude = Math.sqrt(this.real * this.real + this.imaginary * this.imaginary);
        double angle = Math.atan2(this.imaginary, this.real) / 2.0;

        double newReal = Math.sqrt(magnitude) * Math.cos(angle);
        double newImaginary = Math.sqrt(magnitude) * Math.sin(angle);

        return new ComplexNumber(newReal, newImaginary);
    }

    /**
     * Inverts the sign of this complex number and returns the result.
     *
     * @return The result of inverting the sign of this complex number.
     */
    public ComplexNumber invertSign() {
        if(this.real == 0) {
            return new ComplexNumber(this.real, -this.imaginary);
        }else if(this.imaginary == 0) {
            return new ComplexNumber(-this.real, this.imaginary);
        }else return new ComplexNumber(-this.real, -this.imaginary);
    }

    /**
     * Parses a string to create a ComplexNumber object.
     *
     * @param str The string representation of a complex number.
     * @return A ComplexNumber object represented by the string.
     */
    public static ComplexNumber complexParse(String str) {

        String regex = "([-+]?(?:\\d*\\.?\\d+)?)?([-+]?(?:\\d*\\.?\\d+j)?)";

        String realPart = str.replaceAll(regex, "$1"); //2j
        String imgPart = str.replaceAll(regex, "$2"); // j
        
        if(realPart.contains("j")){
            if(realPart.matches("[-+]?j")){
                realPart = realPart.replace("j", "1");
            }
            imgPart = realPart;
            realPart = "";
        }

        double real = (realPart.isEmpty()) ? 0 : Double.parseDouble(realPart);
        double img = (imgPart.isEmpty()) ? 0 : Double.parseDouble(imgPart.replace("j", ""));

        return new ComplexNumber(real, img);
    }

    /**
     * Returns a string representation of this complex number in the format "a + bi".
     *
     * @return The string representation of this complex number.
     */
    @Override
    public String toString() {

        if(imaginary == 0) {
            return String.format("%.2f", real);
        }
        return String.format("%.2f%+.2fj", real, imaginary);
    }

    /**
     * Checks if this complex number is equal to another object.
     * Equality is based on the comparison of the real and imaginary parts.
     *
     * @param o The object to compare with.
     * @return True if the objects are the same or if the real and imaginary parts are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumber that = (ComplexNumber) o;
        return Double.compare(real, that.real) == 0 && Double.compare(imaginary, that.imaginary) == 0;
    }


}
