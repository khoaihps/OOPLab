package OOPlab.Lab01;

import javax.swing.JOptionPane;
// import javax.xml.stream.util.StrecdamReaderDelegate;

public class Calculator {
    public static void main(String[] args) {

        double num1 = Double.parseDouble(JOptionPane.showInputDialog("Input the first number: "));
        double num2 = Double.parseDouble(JOptionPane.showInputDialog("Input the second number: "));

        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        double quotient = num1 / num2;

        strNotification += "Sum: " + sum +
                        "\nDifference: " + difference +
                        "\nProduct: " + product +
                        "\nQuotient: " + quotient;
                        JOptionPane.showMessageDialog(null, strNotification,
                        "Show two numbers", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
}
