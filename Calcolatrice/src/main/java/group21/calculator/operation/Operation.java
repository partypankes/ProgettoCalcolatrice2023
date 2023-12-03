package group21.calculator.operation;


import group21.calculator.type.StackNumber;

public class Operation implements PerformOperation {

    private StackNumber number;

    public Operation(StackNumber number) {
        this.number = number;
    }

    //altro modo:  char sqrt -> 's', char ± -> 'm'
    @Override
    public void perform(String operation) {
        for (int i = 0; i < operation.length(); i++) {
            switch (operation.charAt(i)) {
                case '+':
                    number.pushNumber(number.dropNumber().add(number.dropNumber()));
                    break;
                case '-':
                    number.swapNumber();
                    number.pushNumber(number.dropNumber().subtract(number.dropNumber()));
                    break;
                case '*':
                    number.pushNumber(number.dropNumber().multiply(number.dropNumber()));
                    break;
                case '/':
                    number.swapNumber();
                    number.pushNumber(number.dropNumber().divide(number.dropNumber()));
                    break;
                case '√':
                    number.pushNumber(number.dropNumber().squareRoot());
                    break;
                case '±':
                    number.pushNumber(number.dropNumber().invertSign());
                    break;
            }

        }
    }
}
