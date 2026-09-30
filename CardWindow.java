import javax.swing.*; //for window, button and panel
import java.awt.BorderLayout; //layout, set the button at the bottom
import java.awt.Color; //for background color

public class CardWindow {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { //runs GUI code on swing thread
            JFrame window = new JFrame("Card Shuffler"); //create window 
            window.setSize(800, 600); 
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

            window.add(bottomPanel, BorderLayout.SOUTH); //panel palced at the bottom of the window
            window.setLocationRelativeTo(null); //window centered on the screen
            window.setVisible(true); //window displays 
        });
    }
}