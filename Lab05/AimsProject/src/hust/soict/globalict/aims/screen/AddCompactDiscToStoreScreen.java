package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.media.*;

import javax.naming.LimitExceededException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class AddCompactDiscToStoreScreen extends JFrame implements AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfDirector;
    private JTextField tfLength;
    private JTextField tfCost;
    private JTextField tfArtist;
    private JTextField tfTracks;

    public AddCompactDiscToStoreScreen(Store store) {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(8, 2));

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

        tfArtist = new JTextField(10);
        cp.add(new JLabel("Artist: "));
        cp.add(tfArtist);

        tfTracks = new JTextField(10);
        cp.add(new JLabel("Enter number of tracks: "));
        cp.add(tfTracks);

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
                String artist = tfArtist.getText();
                ArrayList<Track> tracks = new ArrayList<>();

                AddTracksToCDScreen addTracksToCDScreen = new AddTracksToCDScreen(Integer.parseInt(tfTracks.getText()), tracks);
                addTracksToCDScreen.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        Media media;
                        try {
                            media = new CompactDisc(title, category, cost, director, length, artist, tracks);
                            store.addMedia(media);
                            dispose();
                        } catch (LimitExceededException e1) {
                            e1.printStackTrace();
                        }
                    }
                });
            }
        });

        buttonPanel.setLayout(new GridLayout(1, 2)); // Set the layout to 1 row and 2 columns
        buttonPanel.add(submitButton); // Add the button to the buttonPanel

        cp.add(new JLabel()); // Add an empty label to occupy the first column
        cp.add(buttonPanel); // Add the buttonPanel to the container

        setTitle("Add");
        setSize(350, 225);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
