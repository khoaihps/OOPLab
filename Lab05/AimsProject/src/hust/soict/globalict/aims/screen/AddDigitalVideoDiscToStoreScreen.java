package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.media.*;

import javax.naming.LimitExceededException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDigitalVideoDiscToStoreScreen extends JFrame implements AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfDirector;
    private JTextField tfLength;
    private JTextField tfCost;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(6, 2));

        tfTitle = new JTextField(10);
        cp.add(new JLabel("Title: "));
        cp.add(tfTitle);

        tfCategory = new JTextField(10);
        cp.add(new JLabel("Category: "));
        cp.add(tfCategory);

        tfDirector = new JTextField(10);
        cp.add(new JLabel("Director: "));
        cp.add(tfDirector);

        tfLength = new JTextField(10);
        cp.add(new JLabel("Length: "));
        cp.add(tfLength);

        tfCost = new JTextField(10);
        cp.add(new JLabel("Cost: "));
        cp.add(tfCost);

        JPanel buttonPanel = new JPanel(); // Use a JPanel for the button

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                String director = tfDirector.getText();
                int length = Integer.parseInt(tfLength.getText());
                float cost = Float.parseFloat(tfCost.getText());

                Media media;
                try {
                    media = new DigitalVideoDisc(title, category, director, length, cost);
                    store.addMedia(media);
                    dispose();
                } catch (LimitExceededException e1) {
                    e1.printStackTrace();
                }                
            }
        });

        buttonPanel.setLayout(new GridLayout(1, 2)); 
        buttonPanel.add(submitButton);

        cp.add(new JLabel()); 
        cp.add(buttonPanel); 

        setTitle("Add");
        setSize(350, 225);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
