import java.util.ArrayList;
import java.util.List;

public class CalculatorLogic {
    private final String expression;

    public CalculatorLogic(String expression) {
        this.expression = expression;
    }

    public float calculate() throws NumberFormatException, ArithmeticException {
        List<Float> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        // extract numbers and operators from the expression
        int startIndex = 0;
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (!Character.isDigit(ch) && ch != '.' && ch != '+' && ch != '-' && ch != '*' && ch != '/') {
                throw new NumberFormatException("Invalid input");
            }
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                // if the number is negative save the two digits
                if(expression.charAt(i)=='-' && i==0){
                    continue;
                }

                String numStr = expression.substring(startIndex, i).trim();
                // check if the string is not empty to add it to the numbers list
                if (!numStr.isEmpty()) {
                    numbers.add(Float.parseFloat(numStr));
                }
                operators.add(ch);
                startIndex = i + 1;
            }
        }
        // add the last number
        String numStr = expression.substring(startIndex).trim();
        if (!numStr.isEmpty()) {
            numbers.add(Float.parseFloat(numStr));
        }

        // punkt-vor-strich
        for (int i = 0; i < operators.size(); i++) {
            char op = operators.get(i);
            if (op == '*' || op == '/') {
                float leftOperand = numbers.get(i);
                float rightOperand = numbers.get(i + 1);
                float result;
                if (op == '*') {
                    result = leftOperand * rightOperand;
                } else {
                    // Check for division by zero
                    if (rightOperand == 0) {
                        throw new ArithmeticException("Division by zero");

                    }
                    result = leftOperand / rightOperand;
                }
                numbers.set(i, (float) result);
                numbers.remove(i + 1);
                operators.remove(i);
                i--;
            }
        }
        // do addition and subtraction after multiplication and division
        float result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            char op = operators.get(i);
            float rightOperand = numbers.get(i + 1);
            if (op == '+') {
                result += rightOperand;
            } else {
                result -= rightOperand;
            }
        }
        return result;
    }
}
