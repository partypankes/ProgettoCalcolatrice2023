package group21.calculator.type;

import group21.calculator.exceptions.DivisionByZeroException;

import java.util.Objects;

public class ComplexNumber {
    private final double real;
    private final double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    //effettua l'addizione tra due numeri complessi CORRETTO
    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
    }

    //effettua la sottrazione tra due numeri complessi CORRETTO
    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(this.real - other.real, this.imaginary - other.imaginary);
    }

    //effettua la moltiplicazione tra due numeri complessi CORRETTO
    public ComplexNumber multiply(ComplexNumber other) {
        double newReal = this.real * other.real - this.imaginary * other.imaginary;
        double newImaginary = this.real *  other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(newReal, newImaginary);
    }

    //effettua la divisione tra due numeri complessi CORRETTO
    public ComplexNumber divide(ComplexNumber other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;

        double newReal = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double newImaginary = (this.imaginary * other.real - this.real * other.imaginary) / denominator;

        return new ComplexNumber(newReal, newImaginary);
    }

    //effettua la radice quadrata del numero complesso CORRETTO
    public ComplexNumber squareRoot() {
        double magnitude = Math.sqrt(this.real * this.real + this.imaginary * this.imaginary);
        double angle = Math.atan2(this.imaginary, this.real) / 2.0;

        double newReal = Math.sqrt(magnitude) * Math.cos(angle);
        double newImaginary = Math.sqrt(magnitude) * Math.sin(angle);

        return new ComplexNumber(newReal, newImaginary);
    }
    //effettua l'inversione di segno CORRETTO
    public ComplexNumber invertSign() {
        if(this.real == 0) {
            return new ComplexNumber(this.real, -this.imaginary);
        }else if(this.imaginary == 0) {
            return new ComplexNumber(-this.real, this.imaginary);
        }else return new ComplexNumber(-this.real, -this.imaginary);
    }


    public static ComplexNumber complexParse(String str) {

        //String regex = "([-+]?(?:\\d*\\.?(\\d+)??)?([-+]?(?:\\d*\\.?(\\d+)?j)?))"; //2j
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

    @Override
    public String toString() {

        if(imaginary == 0) {
            return String.format("%.2f", real);
        }
        return String.format("%.2f%+.2fj", real, imaginary);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumber that = (ComplexNumber) o;
        return Double.compare(real, that.real) == 0 && Double.compare(imaginary, that.imaginary) == 0;
    }


}
