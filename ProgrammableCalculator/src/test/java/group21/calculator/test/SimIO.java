package group21.calculator.test;

import java.io.*;

public class SimIO {

    private InputStream originalInput;
    private PrintStream originalOut;
    private ByteArrayOutputStream outputStream;

    public void simulateInput(String in) {
        originalInput = System.in; // Save the current input stream
        System.setIn(new ByteArrayInputStream(in.getBytes())); // Temp input stream
    }

    public void restoreInput() {
        System.setIn(originalInput);
    }

    public void captureOutput() {
        originalOut = System.out; // Save the current output stream
        outputStream = new ByteArrayOutputStream(); // Create a temporary output stream
        System.setOut(new PrintStream(outputStream)); // Change the current output stream
    }

    public String getCapturedOutput() {
        return outputStream.toString();
    }

    public void restoreOutput() {
        System.setOut(originalOut);
    }


}

