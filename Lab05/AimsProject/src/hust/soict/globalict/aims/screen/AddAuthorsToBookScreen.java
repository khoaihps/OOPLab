package hust.soict.globalict.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddAuthorsToBookScreen extends JFrame {
    public AddAuthorsToBookScreen(int numberOfAuthors, ArrayList<String> authors) {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(numberOfAuthors + 1, 2));

        JTextField[] tfAuthors = new JTextField[numberOfAuthors];
        for (int i = 0; i < numberOfAuthors; i++) {
            JTextField tfAuthor = new JTextField(10);
            cp.add(new JLabel("Author Name " + i));
            cp.add(tfAuthor);
            tfAuthors[i] = tfAuthor;
        }

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            for (int i = 0; i < numberOfAuthors; i++) {
                authors.add(tfAuthors[i].getText());
            }
            dispose();
        });

        cp.add(new JLabel());
        cp.add(submitButton);

        setTitle("Add Authors");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
