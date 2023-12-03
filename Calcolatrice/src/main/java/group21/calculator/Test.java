package group21.calculator;

//POSSIBILE IDEA -> stack su GUI non visibile fino alla fine della stringa delle operazioni
// array di operazioni da swappare prima di eseguirle
public class Test {
    public static void main(String[] args) {

        // (3 + 6 / 2) -> 3 6 2 + /
        //             -> 3 3 2 * + -> swap -> 3 2 3 * +  ->  3 3 +  ->  6

        //

        //In TextArea viene inserito un valore da GUI:
        String textArea = "30+5j";
        StackNumber  number = new StackNumber();
        //stack.pushNumber(ComplexNumber.complexParse("6+5j"));
        //stack.pushNumber(ComplexNumber.complexParse("2+5j"));
        Operation performOp = new Operation(number);
        number.pushNumber(ComplexNumber.complexParse("-4"));
        performOp.performOperation("sqrt");
        //exe.performOperation("+");






        System.out.println(performOp.peekNumber());
    }
}
