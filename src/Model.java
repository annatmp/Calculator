

public class Model {

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

}
