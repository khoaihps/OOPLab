package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.media.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddTracksToCDScreen extends JFrame {
    public AddTracksToCDScreen(int numberOfTracks, ArrayList<Track> tracks) {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(numberOfTracks * 2 + 1, 2));

        JTextField[] tfTitles = new JTextField[numberOfTracks];
        JTextField[] tfLengths = new JTextField[numberOfTracks];
        for (int i = 1; i <= numberOfTracks; i++) {
            JTextField tfTitle = new JTextField(10);
            cp.add(new JLabel("Title Track " + i));
            cp.add(tfTitle);
            tfTitles[i - 1] = tfTitle;

            JTextField tfLength = new JTextField(10);
            cp.add(new JLabel("Length Track " + i));
            cp.add(tfLength);
            tfLengths[i - 1] = tfLength;
        }

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            for (int i = 0; i < numberOfTracks; i++) {
                tracks.add(new Track(tfTitles[i].getText(), Integer.parseInt(tfLengths[i].getText())));
            }
            dispose();
        });

        cp.add(new JLabel());
        cp.add(submitButton);

        setTitle("Add Track");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
