import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.*; //for window, button and panel
import java.awt.BorderLayout; //layout, set the button at the bottom
import java.awt.Color; //for background color


public class Cards {

    private class Card {
        String value;
        String type;


        Card(String value, String type) {
            this.value = value;
            this.type = type;
        }

    }

    int cardWidth = 70;//card size
    int cardHeight = 110;//card size

    ArrayList<Card> deck;

    JPanel gamePanel = new JPanel()
    {
        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            for (int i = 0; i < deck.size(); i++) //loop through all card in the deck
            {

                Card current = deck.get(i);//gets the current card from deck

                String folder = "/Classic/" + current.type + current.value + ".png";//creates file path to a specific(current) card's image

                Image image = new ImageIcon(getClass().getResource(folder)).getImage();//attaches and loads image

                int drawX = 30 + (i % 13) * 80;//card's position
                int drawY = 30 + (i / 13) * 150;//card's position

                g.drawImage(image, drawX,drawY, cardWidth, cardHeight, null);//draws card on gamePanel
            }
        }

    };

    Cards() { 
        SwingUtilities.invokeLater(() -> { //runs GUI code on swing thread

            JFrame window = new JFrame("Card Shuffler"); //create window 
            window.setSize(1100, 750); 
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ends the program when window closed 
            window.getContentPane().setBackground(new Color(0, 100, 0)); //background color of window set to green
            JButton shuffleButton = new JButton("Shuffle Cards"); //button for shuffling cards

            shuffleButton.addActionListener(e -> { 
                //card shuffling code here 
            });

            JPanel bottomPanel = new JPanel(); //panel for holding the button 
            bottomPanel.setBackground(new Color(0, 100, 0)); //background color of panel set to green
            
            bottomPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 10, 25, 10) //empty space around panel
            );
            bottomPanel.add(shuffleButton); //shuffle button added to the panel

            buildDeck();
            
            window.add(gamePanel, BorderLayout.CENTER);
            gamePanel.setBackground(new Color(0, 100, 0));

            window.add(bottomPanel, BorderLayout.SOUTH); //panel palced at the bottom of the window
            window.setLocationRelativeTo(null); //window centered on the screen
            window.setVisible(true); //window displays 

            
        });

         
    }

    public void buildDeck() {
        deck = new ArrayList<Card>();//creates empty list to store cards

        String[] values = {//stores values for each card
            "01", "02", "03", "04", "05", "06", "07",
            "08", "09", "10", "11", "12", "13"
        };

        String[] types = {// stores the four types of cards
            "c", "d", "s", "h"
        };

        for (int i = 0; i < types.length; i++) {//loops through each value of the card type
            for (int j = 0; j < values.length; j++) {//
                Card card = new Card(values[j], types[i]);
                deck.add(card);//adds card to the the deck
            }
        }

    }

    public static void main(String[] args) {
        
        Cards deck = new Cards();//creates card object and opens the window
    }
}