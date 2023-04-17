// package OOPlab.Lab01;

import javax.swing.JOptionPane;

public class Calculator {
    public static void main(String[] args) {

        double num1 = Double.parseDouble(JOptionPane.showInputDialog("Input the first number: "));
        double num2 = Double.parseDouble(JOptionPane.showInputDialog("Input the second number: "));

        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        double quotient;
        
        if (num2 == 0) {
            JOptionPane.showMessageDialog(null, "Cannot divide by zero");
            quotient = Double.NaN;
        } else {
            quotient = num1 / num2;
        }

        String strNotification = "Sum: " + sum +
                        "\nDifference: " + difference +
                        "\nProduct: " + product +
                        "\nQuotient: " + quotient;

        JOptionPane.showMessageDialog(null, strNotification);

        System.exit(0);
    }
}

