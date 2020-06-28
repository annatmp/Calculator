import javafx.beans.binding.DoubleExpression;

public class Model {
    /**
     * A calculator which allows to calculate with basic operators
     * Can work with string and int based inputs
     * @param y
     * @return
     */

    private int MAX_OPERATOR = 5;
    private int MAX_NUMBERS = 10;


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
    private static double divide(double x,double ...y) {
        double solution = x;
        for (double factor:y) {
            solution /= factor;
        }
        return solution;
    }

    /**
     * translates an String input into actionable sequences and calculates the result
     * @param input
     * @throws IndexOutOfBoundsException
     */
    public String eval(String input){

        double[] numbers = new double[MAX_NUMBERS];
        int numberCount = 0;
        char[] operators = new char[MAX_OPERATOR];
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

            if ("+-*/".contains(current)) {

                String number = input.substring(cutoff,i);

                numbers[numberCount] = Double.parseDouble(number);
                operators[operatorCount] = input.charAt(i);

                cutoff = ++i;

                numberCount++;
                operatorCount++;
            }
        }



        //store the last number:
        String lastNumber = input.substring(cutoff,input.length()-1);
        numbers[numberCount] = Double.parseDouble(lastNumber);
        numberCount++;

        return result;
    }

}
