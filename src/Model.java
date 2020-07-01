import javafx.beans.binding.DoubleExpression;

public class Model {
    /**
     * A calculator which allows to calculate with basic operators
     * Can work with string and int based inputs
     */

    private int MAX_OPERATOR = 5;
    private int MAX_NUMBERS = 10;
    private double[] numbers;
    private char[] operators;
    private int numberCount;


    private static double add(double ... y){
        double solution = 0;
        for (double add: y){
            solution += add;
        }
        return solution;
    }
    private static double substract(double x, double ... y){
        double substractor = add(y);
        return x-substractor;
    }
    private static double multiply(double ...y) {
        double solution = 1;
        for (double factor:y) {
            solution *= factor;
        }
        return solution;
    }

    /**
     *
     * @param x dividend
     * @param y divisor
     * @throws ArithmeticException when dividing by 0
     * @return quotient
     */
    private static double divide(double x,double ...y) {
        double solution = x;
        for (double factor:y) {
            if (factor == 0){
                throw new ArithmeticException("Cannot divide by 0");
            }
            solution /= factor;
        }
        return solution;
    }

    private void translate_string(String input) {

        numbers = new double[MAX_NUMBERS];
        numberCount = 0;
        operators = new char[MAX_OPERATOR];
        int operatorCount = 0;
        //todo
        String result = "xx";
        //temp storage when parsing through int for translation
        int cutoff = 0;

        for(int i = 0; i < input.length(); i++) {



            String current = String.valueOf(input.charAt(i));

            if ("1234567890".contains(current)) {
                continue;
            }

            if ("+-*\\".contains(current)) {

                String number = input.substring(cutoff,i);

                numbers[numberCount] = Double.parseDouble(number);
                operators[operatorCount] = input.charAt(i);

                cutoff = ++i;

                numberCount++;
                operatorCount++;
            }
        }



        //store the last number:
        String lastNumber = input.substring(cutoff);
        numbers[numberCount] = Double.parseDouble(lastNumber);
        numberCount++;

    }

    private double calculate_result(){
        double result;
        int operator_pos = 0;
        double tmp_result = numbers[0];

        for (int i = 1; i < numberCount; i++) {
            double value = numbers[i];

            char operator = operators[operator_pos++];

            switch (operator) {
                case '+':
                    tmp_result = add(tmp_result, value);
                    break;
                case '-':
                    tmp_result = substract(tmp_result, value);
                    break;
                case '\\':

                    tmp_result = divide(tmp_result, value);
                    break;
                case '*':
                    tmp_result = multiply(tmp_result,value);
            }
        }

        result = tmp_result;

        return result;
    }

    /**
     * translates an String input into actionable sequences and calculates the result
     * @param input as String from calculator text field
     */
    public String calc(String input){

        String result;

        translate_string(input);
        double double_result = calculate_result();

        if(double_result % 1 == 0){
            result = Integer.toString((int) double_result);
        }
        else {
            result = Double.toString(double_result);
        }

        return result;
    }

}
