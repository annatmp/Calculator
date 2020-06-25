public class Calculator {

    public static void main(String[] argv) {
        //this will later launch my application

        CalcView view = new CalcView();
        Model model = new Model();

        Controller controller = new Controller(view, model);
        //int x =4;
        //System.out.println(String.valueOf(x++));
        //System.out.println(String.valueOf(x));
    }
}
