package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.cart.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.LimitExceededException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(""+ media.getCost()+" $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addToCartButton = new JButton("Add to cart");
        container.add(addToCartButton);
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cart.addMedia(media);
                } catch (LimitExceededException e1) {
                    e1.printStackTrace();
                }
            }
        });

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            container.add(playButton);
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JDialog dialog = new JDialog();
                    dialog.setTitle("Play Media");
                    dialog.setSize(400, 300);
                    dialog.setVisible(true);
                }
            });
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public MediaStore(Media media, Cart cart) {
        this.media = media;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(String.valueOf(media.getCost()) + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton addBtn = new JButton("Add to Cart");
        addBtn.addActionListener(e -> {
            try {
                cart.addMedia(media);
            } catch (LimitExceededException e1) {
                e1.printStackTrace();
            }
        });
        container.add(addBtn);

        if (media instanceof Playable) {
            JButton playBtn = new JButton("Play");
            playBtn.addActionListener(new PlayListener());
            container.add(playBtn);
        }

        add(Box.createVerticalGlue());
        add(title);
        add(cost);
        add(Box.createVerticalGlue());
        add(container);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private class PlayListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JDialog playDialog = new JDialog();
            playDialog.setTitle("Play");
            playDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

            JLabel label = new JLabel("Playing");
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.PLAIN, 16));

            playDialog.add(label);
            playDialog.setSize(100, 100);
            playDialog.setLocationRelativeTo(null); 
            playDialog.setVisible(true);
        }
    }
}
