import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.*;

public class RandomBarChart extends JFrame {

    public RandomBarChart() {
        setTitle("Random Line Grid"); setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        BarChartPanel chartPanel = new BarChartPanel();

        JButton redrawButton = new JButton("Regenerate");

        redrawButton.addActionListener(event -> {
            chartPanel.redrawBars();
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(redrawButton);

        add(chartPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RandomBarChart window = new RandomBarChart();
            window.setVisible(true);
        });
    }
}

class BarChartPanel extends JPanel {

    private static final int ROWS = 10;
    private static final int COLUMNS = 10;

    private static final int CELL_SIZE = 30;

    private static final int GRID_X = 30;
    private static final int GRID_Y = 30;

    private static final int GRID_WIDTH =COLUMNS * CELL_SIZE;

    private static final int GRID_HEIGHT =ROWS * CELL_SIZE;

    private static final int NUMBER_OF_BARS = 12;

    private final Random random = new Random();
    private final List<Bar> bars = new ArrayList<>();

    public BarChartPanel() {
        setBackground(new Color(205, 205, 205));
        setPreferredSize(new Dimension(360, 350));

        generateBars();
    }

    public void redrawBars() {
        generateBars();
        repaint();
    }

    private void generateBars() {
        bars.clear();
        List<Integer> positions = new ArrayList<>();

        for (
                int x = GRID_X + 15;
                x < GRID_X + GRID_WIDTH - 5;
                x += 20
        ) {
            positions.add(x);
        }

        Collections.shuffle(positions, random);

        for (int i = 0; i < NUMBER_OF_BARS; i++) {

            int x = positions.get(i);
            int height =
                    (random.nextInt(6) + 1) * CELL_SIZE;

            Color randomColor = Color.getHSBColor(
                    random.nextFloat(),
                    0.65f + random.nextFloat() * 0.35f,
                    0.75f + random.nextFloat() * 0.25f
            );

            bars.add(
                    new Bar(
                            x,
                            height,
                            randomColor
                    )
            );
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D g2 =(Graphics2D) graphics.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        drawGrid(g2);
        drawBars(g2);

        g2.dispose();
    }

    private void drawGrid(Graphics2D g2) {
        g2.setColor(new Color(70, 70, 70));
        g2.setStroke(new BasicStroke(1));

        for (
                int column = 0;
                column <= COLUMNS;
                column++
        ) 
        {
            int x =
                    GRID_X + column * CELL_SIZE;

            g2.drawLine(
                    x,
                    GRID_Y,
                    x,
                    GRID_Y + GRID_HEIGHT
            );
        }

        for (
                int row = 0;
                row <= ROWS;
                row++
        ) 
        {
            int y =
                    GRID_Y + row * CELL_SIZE;

            g2.drawLine(
                    GRID_X,
                    y,
                    GRID_X + GRID_WIDTH,
                    y
            );
        }
    }

    private void drawBars(Graphics2D g2) {
        int bottomOfGrid =
                GRID_Y + GRID_HEIGHT;
        g2.setStroke(
                new BasicStroke(
                        10,
                        BasicStroke.CAP_BUTT,
                        BasicStroke.JOIN_MITER
                )
        );

        for (Bar bar : bars) {
            g2.setColor(bar.color);
            g2.drawLine(
                    bar.x,
                    bottomOfGrid,
                    bar.x,
                    bottomOfGrid - bar.height
            );
        }
    }

    private static class Bar {

        private final int x;
        private final int height;
        private final Color color;

        private Bar(
                int x,
                int height,
                Color color
        ) {
            this.x = x;
            this.height = height;
            this.color = color;
        }
    }
}