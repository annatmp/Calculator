import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class CalcView extends JFrame{

    private JButton[] buttons = new JButton[9];
    private JButton[] bottomRow = new JButton[3];
    private JPanel numberBlockPanel = new JPanel(new GridLayout(4,3));
    private JPanel mathOperatorsPanel = new JPanel(new GridLayout(4,1));
    private JButton[] operators = new JButton[4];
    private JTextField textline = new JTextField();
    private JButton delete = new JButton("DEL");

    CalcView(){

        this.setSize(300,400);

        //number section
        String[] values = {"7","8","9","4","5","6","1","2","3"};
        for(int i = 0; i < 9; i++) {
            this.buttons[i] = new JButton(values[i]);
            this.numberBlockPanel.add(buttons[i]);
        }
        //bottom row
        String[] bottom_values = {".","0","="};
        for (int i = 0; i < 3; i++) {
            this.bottomRow[i] = new JButton(bottom_values[i]);
            this.numberBlockPanel.add(bottomRow[i]);

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

    public char getLastInputChar() {
        String input = this.textline.getText();
        char lastChar = input.charAt(input.length()-1);
        return lastChar;
    }

    public char[] getInput() {
        String input_line = this.textline.getText();
        char[] input = new char[input_line.length()];

        for (int i = 0; i < input_line.length(); i++) {
            input[i] = input_line.charAt(i);
        }

        return input;
    }

    public int getButtonValue(JButton button) {
        int buttonValue = Integer.parseInt(button.getText());

        return buttonValue;
    }

    public String getBottomRowValue(JButton button) {
        String buttonValue = button.getText();

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

    void addbottomRowListener(ActionListener listenForBottomRow) {
        for (JButton button: bottomRow) {
            button.addActionListener(listenForBottomRow);
        }
    }
}
