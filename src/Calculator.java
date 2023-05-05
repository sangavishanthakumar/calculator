import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Calculator {
    // create a calculator with a gui
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(new BorderLayout());

        // create the text area to display the numbers
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setRows(3);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frame.add(scrollPane, BorderLayout.NORTH);

        // create the buttons
        JPanel buttonPanel = new JPanel(new GridLayout(5, 4));

        JButton buttonC = new JButton("C");
        buttonPanel.add(buttonC);
        JButton buttonSign = new JButton("+/-");
        buttonPanel.add(buttonSign);
        JButton buttonPercent = new JButton("%");
        buttonPanel.add(buttonPercent);
        JButton buttonDivide = new JButton("/");
        buttonPanel.add(buttonDivide);

        // create an array for button 0-9
        JButton[] buttons = new JButton[10];
        // add numbers 1-9 and the symbols in the rightest column
        JButton buttonMultiply = null;
        JButton buttonSubtract = null;
        for (int i = 1; i < 10; i++) {
            if (i == 4) {
                buttonMultiply = new JButton("*");
                buttonPanel.add(buttonMultiply);
                JButton button4 = new JButton(Integer.toString(i));
                buttonPanel.add(button4);
                buttons[i] = button4;
            } else if (i == 7) {
                buttonSubtract = new JButton("-");
                buttonPanel.add(buttonSubtract);
                JButton button7 = new JButton(Integer.toString(i));
                buttonPanel.add(button7);
                buttons[i] = button7;
            } else {
                JButton button = new JButton(Integer.toString(i));
                buttonPanel.add(button);
                buttons[i] = button;
            }
        }

        JButton buttonPlus = new JButton("+");
        buttonPanel.add(buttonPlus);
        JButton button0 = new JButton("0");
        buttons[0] = button0;


        buttonPanel.add(button0);
        JButton buttonDecimal = new JButton(".");
        buttonPanel.add(buttonDecimal);
        JButton buttonEquals = new JButton("=");
        buttonPanel.add(buttonEquals);
        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.setVisible(true);



        ActionListener buttonListener = new ActionListener() {
            final String operators = "";
            final String numbers = String.valueOf(0.0);

            public void actionPerformed(ActionEvent e) {
                // get button that was pressed
                JButton buttonPressed = (JButton) e.getSource();
                // get the text of the button
                String buttonText = buttonPressed.getText();
                switch (buttonText){
                    case "C":
                        textArea.setText("");
                        break;
                    case "+/-":
                        textArea.append("-");
                        break;
                    case "%":
                        // divide the number by 100
                        double number = Double.parseDouble(textArea.getText());
                        number = number / 100;
                        textArea.setText(Double.toString(number));
                        break;
                    case "/":
                        textArea.append("/");
                        break;
                    case "1":
                        textArea.append("1");
                        break;
                    case "2":
                        textArea.append("2");
                        break;
                    case "3":
                        textArea.append("3");
                        break;

                    case "*":
                        textArea.append("*");
                        break;
                    case "4":
                        textArea.append("4");
                        break;
                    case "5":
                        textArea.append("5");
                        break;
                    case "6":
                        textArea.append("6");
                        break;
                    case "-":
                        textArea.append("-");
                        break;
                    case "7":
                        textArea.append("7");
                        break;
                    case "8":
                        textArea.append("8");
                        break;
                    case "9":
                        textArea.append("9");
                        break;
                    case "+":
                        textArea.append("+");
                        break;
                    case "0":
                        textArea.append("0");
                        break;
                    case ".":
                        textArea.append(".");
                        break;

                }

            }
        };


        button0.addActionListener(buttonListener);
        buttonC.addActionListener(buttonListener);
        buttonSign.addActionListener(buttonListener);
        buttonPercent.addActionListener(buttonListener);
        buttonDivide.addActionListener(buttonListener);
        buttonMultiply.addActionListener(buttonListener);
        buttonSubtract.addActionListener(buttonListener);
        buttonPlus.addActionListener(buttonListener);
        buttonDecimal.addActionListener(buttonListener);
        buttonEquals.addActionListener(buttonListener);
        for (int i = 1; i < 10; i++) {
            buttons[i].addActionListener(buttonListener);
        }





    }

}
