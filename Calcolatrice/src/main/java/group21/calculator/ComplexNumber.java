package group21.calculator;

public class ComplexNumber {
    private double real;
    private double imaginary;

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

        if (denominator == 0) {
            throw new ArithmeticException("Division by zero");
        }

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
        return new ComplexNumber(-this.real, -this.imaginary);
    }



    //Dato un numero complesso scritto in stringa viene trasformato in ComplexNumber
    public static ComplexNumber complexParse(String str) {
        if(str.contains("j")) {
            if(str.contains("-")){
                String[] temp = str.split("[-]|[j]");
                return new ComplexNumber(Double.parseDouble(temp[0]),-(Double.parseDouble(temp[1])));
            }
            String[] temp = str.split("[+]|[j]");
           return new ComplexNumber(Double.parseDouble(temp[0]),Double.parseDouble(temp[1]));
        }
        return new ComplexNumber(Double.parseDouble(str),0);
    }


    @Override
    public String toString() {

        if(imaginary == 0) {
            return String.format("%.2f", real);
        }

        return String.format("%.2f%+.2fj", real, imaginary);

    }

}
