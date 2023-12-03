package com.example.calcolatrice;


import java.util.Stack;

public class Calculator {
    private Stack<ComplexNumber> stack;


    public Calculator() {
        this.stack= new Stack<>();

    }

    public Stack<ComplexNumber> getStack() {
        return stack;
    }

    public void performOperation(String operation){
        switch(operation){
            case "+":
                performBinaryOperation(ComplexNumber::add);
                break;
            case "-":
                performBinaryOperation(ComplexNumber::subtract);
                break;
            case "*":
                performBinaryOperation(ComplexNumber::multiply);
                break;
            case "/":
                performBinaryOperation(ComplexNumber::divide);
                break;
            case "sqrt":
                performUnaryOperation(ComplexNumber::squareRoot);
                break;
            case "+-":
                performUnaryOperation(ComplexNumber::invertSign);
                break;
            default:
                try {
                    double realPart = Double.parseDouble(operation);
                    stack.push(new ComplexNumber(realPart, 0));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input: " + operation);
                }
        }
    }

    private void performUnaryOperation(UnaryOperation operation) {
        if(!stack.isEmpty()){
            ComplexNumber a= (ComplexNumber) stack.pop();
            stack.push(operation.apply(a));
        }else{
            System.out.println("Not enough operands for unary operation");
        }

    }

    private void performBinaryOperation(BinaryOperation operation) {
        if(stack.size()>=2){
            ComplexNumber b = (ComplexNumber) stack.pop();
            ComplexNumber a = (ComplexNumber) stack.pop();
            stack.push(operation.apply(a,b));
        }else{
            System.out.println("Not enough operands for binary operation");
        }
    }
}
