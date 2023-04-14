import javax.swing.JOptionPane;

public class FirstDegreeLinearEq {
    public static void main(String[] args) {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Enter a: "));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Enter b: "));

        if (a == 0) {
            JOptionPane.showMessageDialog(null, "Error: a must not be 0");
        } else {
            double x = -b / a;
            JOptionPane.showMessageDialog(null, "x = " + x);
        }
    }
}
