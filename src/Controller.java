import javax.script.ScriptEngine;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    private CalcView view;
    private Model model;
    private int OperatorCount;
    private int numberCount;



    Controller(CalcView view, Model model) {

        this.view = view;
        this.model = model;

        this.view.addNumberListener(new NumberListener());
        this.view.addOperatorListener(new OperatorListener());
        this.view.addDeleteListener(new DeleteListener());
        this.view.addbottomRowListener(new BottomRowListener());

        OperatorCount = 0;
        OperatorCount = 0;
    }


    class NumberListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int value = view.getButtonValue((JButton) e.getSource());
            view.updateTextline(Integer.toString(value));
        }
    }

    class OperatorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String operator = view.getOperatorType((JButton) e.getSource());
            view.updateTextline(operator);

        }
    }

    class BottomRowListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String operator = view.getBottomRowValue((JButton) e.getSource());

            switch(operator){
                case "=" :
                    // TODO: char
                    char[] values = view.getInput();
                    for (char c : values){
                        System.out.print(c);
                    }

                    break;
                case ".":
                    char lastChar = view.getLastInputChar();
                    if (lastChar == '.') {
                        //error message?
                        view.deleteFromTextline();
                    }


                case "0":
                    break;
            }


            view.updateTextline(operator);

        }
    }

    class DeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.deleteFromTextline();
        }
    }
//    private float TranslateToInt(String numberString){
//
//
//        while(numberString)
//
//        return number;
//    }

    private String Calc(String input) {

        //get all the values from the String
        //todo
        String result = "none";

        return result;

    }
}
