import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Chart extends JFrame { 
    public Chart() 
    { 
        setTitle("Random Line Grid"); setSize(600, 500);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
         GridPanel gridPanel = new GridPanel(); 
         add(gridPanel); 
         setVisible(true);
    } 
public static void main(String[] args)
    { 
        Chart myChart = new Chart(); 
        
    } 

    class GridPanel extends JPanel 
    {
        @Override
        protected void paintComponent(Graphics g) 
        { 
            super.paintComponent(g); 
            g.drawString("", 250, 30);
            int gridX = 140;
            int gridY = 80;

            int gridWidth = 300;
            int gridHeight = 300;

            int cellWidth = gridWidth / 10;
            int cellHeight = gridHeight / 10;

            g.drawRect(gridX, gridY, gridWidth, gridHeight);


            for (int i = 1; i < 10; i++) 
            {
                int x = gridX + i * cellWidth;
                g.drawLine(x, gridY, x, gridY + gridHeight);
            }
            for (int i = 1; i < 10; i++) {
                int y = gridY + i * cellHeight;
                g.drawLine(gridX, y, gridX + gridWidth, y); 
                
            } 
        }
    }
}
