package hust.soict.lab01.FirstPrograms;

import javax.swing.JOptionPane;

public class SecondDegreeEq {
    public static void main(String[] args) {
        double a = 0;
        while (a == 0) {
            a = Double.parseDouble(JOptionPane.showInputDialog("Enter a: "));
            if (a == 0) {
                JOptionPane.showMessageDialog(null, "a cannot be zero");
            }
        }
        double b = Double.parseDouble(JOptionPane.showInputDialog("Enter b: "));
        double c = Double.parseDouble(JOptionPane.showInputDialog("Enter c: "));

        double delta = b*b - 4*a*c;
        if (delta == 0)
        {
            double root = -b / (2 * a);
            JOptionPane.showMessageDialog(null, "One double root \nx1 = x2 = " + root);
        } else if (delta < 0)
        {
            JOptionPane.showMessageDialog(null, "No real root");
        } else
        {
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            JOptionPane.showMessageDialog(null, "Two distinct roots \nx1 = " + root1 + "\nx2 = " + root2);
        }
    }
}
