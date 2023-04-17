import javax.swing.JOptionPane;

public class SystemLinearEq {
    public static void main(String[] args) {
        double a11 = Double.parseDouble(JOptionPane.showInputDialog("Enter a11: "));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog("Enter a12: "));
        double b1 = Double.parseDouble(JOptionPane.showInputDialog("Enter b1: "));
        double a21 = Double.parseDouble(JOptionPane.showInputDialog("Enter a21: "));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog("Enter a22: "));
        double b2 = Double.parseDouble(JOptionPane.showInputDialog("Enter b2: "));

        double det = a11 * a22 - a21 * a12;

        if (det == 0) {
            if (b1 / a11 == b2 / a21) {
                JOptionPane.showMessageDialog(null, "Infinite solutions.");
            } else {
                JOptionPane.showMessageDialog(null, "No solution.");
            }
        } else {
            double x1 = (b1 * a22 - b2 * a12) / det;
            double x2 = (a11 * b2 - a21 * b1) / det;
            JOptionPane.showMessageDialog(null, "x1 = " + x1 + "\nx2 = " + x2);
        }
    }
}
