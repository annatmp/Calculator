import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller {

    private CalcView view;
    private Model model;
    private int OperatorCount;
    private int numberCount;
    private boolean requiresOperatorInput;

    private int count;


    Controller(CalcView view, Model model) {

        this.view = view;
        this.model = model;

        this.view.addNumberListener(new NumberListener());
        this.view.addOperatorListener(new OperatorListener());
        this.view.addDeleteListener(new DeleteListener());
        this.view.addbottomRowListener(new BottomRowListener());
        this.view.addKeyBoardListener(new KeyboardInput());

        OperatorCount = 0;
        OperatorCount = 0;
        count = 1;

        requiresOperatorInput = false;


    }

    private void showErrorMessage(String errorMessage) {
        view.errorPopup(errorMessage);
    }

    private boolean lastWasOperator() {

        char operator = view.getLastInputChar();

        switch (operator) {
            case '+':
                return true;
            case '-':
                return true;
            case '*':
                return true;
            case '\\':
                return true;
            default:
                return false;
        }
    }

    private void updateNumber(int value) {
        if (!requiresOperatorInput) {
            view.updateTextline(Integer.toString(value));
        }
    }

    private void updateOperator(String operator) {

        if (lastWasOperator()) {
            return;
        }

        if (count == 1) {
            count++;

            //requiresOperatorInput = true;

        } else {
            String input = view.getInputAsString();

            try {
                String tmp_result = model.calc(input);
                view.replaceTextLine(tmp_result);
                count++;
            } catch (ArithmeticException divisionError) {
                showErrorMessage("Cannot divide through 0");
                return;
            }
        }

        view.updateTextline(operator);

        requiresOperatorInput = false;
    }

    private void updateBottomRowInput(String operator) {
        switch (operator) {
            case "=":
                //check if the last value is not an operator
                if (lastWasOperator()) {
                    return;
                }

                String input = view.getInputAsString();

                try {
                    String result = model.calc(input);
                    view.replaceTextLine(result);

                } catch (ArithmeticException divisionError) {
                    showErrorMessage("Cannot divide through 0");
                    return;
                }


                requiresOperatorInput = true;

                return;

            case ".":
                char lastChar = view.getLastInputChar();
                if (lastChar == '.') {
                    showErrorMessage("Invalid, only one period per number");
                    view.deleteFromTextline();
                }

            case "0":
                break;
        }

        view.updateTextline(operator);

    }


    class NumberListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int value = view.getButtonValue((JButton) e.getSource());
            updateNumber(value);
        }
    }

    class OperatorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String operator = view.getOperatorType((JButton) e.getSource());
            updateOperator(operator);

        }
    }

    class BottomRowListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String operator = view.getBottomRowValue((JButton) e.getSource());
            updateBottomRowInput(operator);

        }
    }

    class KeyboardInput implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            char input = e.getKeyChar();

            String numbers = view.getNumbersAsString();
            String operators = view.getOperatorsAsString();
            String bottomRow = view.getBottomRowAsString();


            if (numbers.indexOf(input) > -1) {
                int value = Character.getNumericValue(input);
                updateNumber(value);
            } else if (operators.indexOf(input) > -1) {
                updateOperator(Character.toString(input));
            } else if (bottomRow.indexOf(input) > -1) {
                updateBottomRowInput(Character.toString(input));
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }

    class DeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                view.deleteFromTextline();
            } catch (IllegalStateException emptyTextline){
                System.out.println("Trying to delete from empty text field");
            }
        }
    }
}
