import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    private CalcView view;
    private Model model;

    Controller(CalcView view, Model model) {

        this.view = view;
        this.model = model;

        this.view.addNumberListener(new NumberListener());
        this.view.addOperatorListener(new OperatorListener());
        this.view.addDeleteListener(new DeleteListener());
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

    class DeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.deleteFromTextline();
        }
    }
}
