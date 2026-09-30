import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JFrame;

public class Cards {

    private class Card {
        String value;
        String type;


        Card(String value, String type) {
            this.value = value;
            this.type = type;
        }

    }

    int cardWidth = 70;
    int cardHeight = 110;

    ArrayList<Card> deck;

   JFrame frame = new JFrame();

    JPanel gamePanel = new JPanel()
    {
        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            for (int i = 0; i < deck.size(); i++) 
            {

                Card current = deck.get(i);

                String folder = "./Classic/" + current.type + current.value + ".png";

                Image image = new ImageIcon(getClass().getResource(folder)).getImage();

                int drawX = 30 + (i % 13) * 80;
                int drawY = 30 + (i / 13) * 150;

                g.drawImage(image, drawX,drawY, cardWidth, cardHeight, null);
            }
        }

    };

    Cards() {
        buildDeck();
        frame.add(gamePanel);
        
        frame.setSize(1100, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    public void buildDeck() {
        deck = new ArrayList<Card>();

        String[] values = {
            "01", "02", "03", "04", "05", "06", "07",
            "08", "09", "10", "11", "12", "13"
        };

        String[] types = {
            "c", "d", "s", "h"
        };

        for (int i = 0; i < types.length; i++) {
            for (int j = 0; j < values.length; j++) {
                Card card = new Card(values[j], types[i]);
                deck.add(card);
            }
        }

    }

    public static void main(String[] args) {
        Cards deck = new Cards();
    }

}