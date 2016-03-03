package blackjack;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Draws background image on the board.
 */
public class BoardPanel extends JPanel {

    private Image feltImage;
    private Image backgroundImage;

    public BoardPanel(String feltImage, String backgroundImage) {
        this.feltImage = new ImageIcon(feltImage).getImage();
        this.backgroundImage = new ImageIcon(backgroundImage).getImage();
    }

    public BoardPanel(String feltImage) {
        this.feltImage = new ImageIcon(feltImage).getImage();
    }

    public void paintComponent(Graphics g) {
        g.drawImage(feltImage, 0, 0, null);
    }
}
