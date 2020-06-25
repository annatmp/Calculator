import com.sun.deploy.util.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class CalcView extends JFrame{

    private JButton[] buttons = new JButton[12];
    private JPanel numberBlockPanel = new JPanel(new GridLayout(4,3));
    private JPanel mathOperatorsPanel = new JPanel(new GridLayout(4,1));
    private JButton[] operators = new JButton[4];
    private JTextField textline = new JTextField();
    private JButton delete = new JButton("DEL");

    CalcView(){

        this.setSize(300,400);

        //number section
        String[] values = {"7","8","9","4","5","6","1","2","3",".","0","="};
        for(int i = 0; i < 12; i++) {
            this.buttons[i] = new JButton(values[i]);
            this.numberBlockPanel.add(buttons[i]);
        }

        //basic operators


        String[] operatorString = {"+","-","*","\\"};
        for (int i=0; i < 4; i++) {
            this.operators[i] = new JButton(operatorString[i]);
            this.mathOperatorsPanel.add(operators[i]);
        }

        //Display area
        this.textline.setEditable(false);

        //add to layout
        this.add(numberBlockPanel, BorderLayout.CENTER);
        this.add(mathOperatorsPanel, BorderLayout.EAST);
        this.add(textline,BorderLayout.NORTH);
        this.add(this.delete,BorderLayout.WEST);
        //terminate program on click
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    public void updateTextline(String character) {
        String current = this.textline.getText();
        String newtext = current + character;
        this.textline.setText(newtext);
    }

    public void deleteFromTextline() {
        String current = this.textline.getText();
        String newtext = current.substring(0, current.length() - 1);
        this.textline.setText(newtext);
    }

    public int getButtonValue(JButton button) {
        int buttonValue = Integer.parseInt(button.getText());

        return buttonValue;
    }

    public String getOperatorType(JButton button) {
        String operatorType = button.getText();
        return operatorType;
    }


    void addNumberListener(ActionListener listenForNumberPress) {
        for(JButton button: buttons) {
            button.addActionListener(listenForNumberPress);
        }
    }

    void addOperatorListener(ActionListener listenForOperatorPress) {
        for (JButton button : operators) {
            button.addActionListener(listenForOperatorPress);
        }
    }

    void addDeleteListener(ActionListener listenForDeletePress){
        delete.addActionListener(listenForDeletePress);
    }
}
