import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Calcultator implements ActionListener{
    String text = "";
    String value = "";
    double operandA, operandB, result;
    String operator;
    JPanel Calculator;
    private JTextField textDisplay;

    //Special Buttons
    private JButton ACButton, plusButton, minusButton, multiplyButton, divideButton, equalsButton, decimalPointButton;

    //Number buttons
    private JButton a0Button, a1Button, a2Button, a3Button, a4Button, a5Button, a6Button, a7Button, a8Button, a9Button;



    public Calcultator(){
        a0Button.addActionListener(this);
        a1Button.addActionListener(this);
        a2Button.addActionListener(this);
        a3Button.addActionListener(this);
        a4Button.addActionListener(this);
        a5Button.addActionListener(this);
        a6Button.addActionListener(this);
        a7Button.addActionListener(this);
        a8Button.addActionListener(this);
        a9Button.addActionListener(this);

        plusButton.addActionListener(this);
        minusButton.addActionListener(this);
        divideButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        decimalPointButton.addActionListener(this);
        equalsButton.addActionListener(this);
        ACButton.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == minusButton) {
            operandA = Double.parseDouble(value);
            text += "-";
            operator = "-";
            value = "";
        }else if (e.getSource() == plusButton) {
            operandA = Double.parseDouble(value);
            text += "+";
            operator = "+";
            value = "";
        }else if (e.getSource() == multiplyButton) {
            operandA = Double.parseDouble(value);
            text += "*";
            operator = "*";
            value = "";
        }else if (e.getSource() == divideButton) {
            operandA = Double.parseDouble(value);
            text += "/";
            operator = "/";
            value = "";
        }else if (e.getSource() == decimalPointButton){
            if(!value.contains(".")){
                text += ".";
                value += ".";
            }
        } else if (e.getSource() == equalsButton){
            operandB = Double.parseDouble(value);
            switch (operator){
                case "+" -> {
                    result = operandA + operandB;
                }
                case "-" -> {
                    result = operandA - operandB;
                }
                case "*" -> {
                    result = operandA * operandB;
                }
                case "/" -> {
                    result = operandA / operandB;
                }
            }

            int decimalPlaces = 2;
            double multiplier = Math.pow(10, decimalPlaces);
            result = (double) Math.round(result * multiplier) / multiplier;
            text = Double.toString(result);
        } else if(e.getSource() == ACButton){
            text = "";
        }
        else{
            text += e.getActionCommand();
            value += e.getActionCommand();
        }


        textDisplay.setText(text);
    }

}
