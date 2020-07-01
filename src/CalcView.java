import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;


public class CalcView extends JFrame {

    private JButton[] buttons = new JButton[9];
    private JButton[] bottomRow = new JButton[3];
    private JPanel numberBlockPanel = new JPanel(new GridLayout(4, 3));
    private JPanel mathOperatorsPanel = new JPanel(new GridLayout(4, 1));
    private JButton[] operators = new JButton[4];
    private JTextField textline = new JTextField();
    private JButton delete = new JButton("DEL");

    private String[] values = {"7", "8", "9", "4", "5", "6", "1", "2", "3"};
    private String[] operatorStrings = {"+", "-", "*", "\\"};
    private String[] bottomRowStrings = {".", "0", "="};

    CalcView() {

        this.setSize(300, 400);

        //number section

        for (int i = 0; i < 9; i++) {
            this.buttons[i] = new JButton(values[i]);
            this.numberBlockPanel.add(buttons[i]);
        }
        //bottom row
        for (int i = 0; i < 3; i++) {
            this.bottomRow[i] = new JButton(bottomRowStrings[i]);
            this.numberBlockPanel.add(bottomRow[i]);

        }
        //basic operators

        for (int i = 0; i < 4; i++) {
            this.operators[i] = new JButton(operatorStrings[i]);
            this.mathOperatorsPanel.add(operators[i]);
        }

        //Display area
        this.textline.setEditable(false);

        //add to layout
        this.add(numberBlockPanel, BorderLayout.CENTER);
        this.add(mathOperatorsPanel, BorderLayout.EAST);
        this.add(textline, BorderLayout.NORTH);
        this.add(this.delete, BorderLayout.WEST);
        //terminate program on click
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    public void updateTextline(String character) {
        String current = this.textline.getText();
        String newtext = current + character;
        this.textline.setText(newtext);
    }

    public void replaceTextLine(String newtext) {
        this.textline.setText(newtext);
    }


    /**
     * @throws IllegalStateException if input field empty
     */
    public void deleteFromTextline() throws IllegalStateException {
        String current = this.textline.getText();
        if (current.length() > 0) {
            String newtext = current.substring(0, current.length() - 1);
            this.textline.setText(newtext);
        } else {
            throw new IllegalStateException("Input field empty");
        }
    }

    public char getLastInputChar() {
        String input = this.textline.getText();
        return input.charAt(input.length() - 1);
    }

    public char[] getInput() {
        String input_line = this.textline.getText();
        char[] input = new char[input_line.length()];

        for (int i = 0; i < input_line.length(); i++) {
            input[i] = input_line.charAt(i);
        }

        return input;
    }

    public String getInputAsString() {
        return this.textline.getText();
    }

    public int getButtonValue(JButton button) {
        return Integer.parseInt(button.getText());
    }

    public String getBottomRowValue(JButton button) {

        return button.getText();
    }

    public String getOperatorType(JButton button) {

        return button.getText();
    }

    public String[] getNumbers() {
        return values;
    }

    public String getNumbersAsString() {

        StringBuilder numberString = new StringBuilder();
        for(String number : values) {
            numberString.append(number);

        }
        return numberString.toString();
    }

    public String getOperatorsAsString() {

        StringBuilder operatorString = new StringBuilder();
        for(String operator : operatorStrings) {
            operatorString.append(operator);

        }
        return operatorString.toString();
    }
    public String getBottomRowAsString() {

        StringBuilder bottomRow = new StringBuilder();
        for(String bottom : bottomRowStrings) {
            bottomRow.append(bottom);

        }
        return bottomRow.toString();
    }


    public String[] getOperators(){
        return operatorStrings;
    }

    public void errorPopup(String errorMessage){
        
        JOptionPane.showMessageDialog(this, errorMessage);
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

    void addKeyBoardListener(KeyListener KeyboardInput){
        this.addKeyListener(KeyboardInput);
        this.setFocusable(true);
        System.out.println("Keylistener added");
    }
}
