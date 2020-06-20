import javax.swing.*;
import java.awt.*;


public class View {
    public View(){

        //main Frame settings
        JFrame mainFrame = new JFrame();
        mainFrame.setSize(300,400);


        //number section
        JPanel numberBlock1to9 = new JPanel(new GridLayout(4,3));

        JButton[] buttons = new JButton[12];
        String[] values = {"7","8","9","4","5","6","1","2","3",".","0","="};
        for(int i = 0; i < 12; i++) {
            buttons[i] = new JButton(values[i]);
            numberBlock1to9.add(buttons[i]);
        }

        //basic operators

        JPanel mathOperators = new JPanel(new GridLayout(4,1));
        JButton[] operators = new JButton[4];
        String[] operatorString = {"+","-","*","\\"};
        for (int i=0; i < 4; i++) {
            operators[i] = new JButton(operatorString[i]);
            mathOperators.add(operators[i]);
        }

        //Display area
        JTextField textline = new JTextField();
        //textline.setMinimumSize(new Dimension(700,100));
        textline.setEditable(false);

        //add to layout
        mainFrame.add(numberBlock1to9, BorderLayout.CENTER);
        mainFrame.add(mathOperators, BorderLayout.EAST);
        mainFrame.add(textline,BorderLayout.NORTH);
        //terminate program on click
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainFrame.setVisible(true);
    }
}
