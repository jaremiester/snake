import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Main extends JPanel {

    // Common Variables
    int xP = 1000000; // Mouse Click X coordinate
    int yP;           // Mouse Click Y coordinate
    int screen_w;     // Screen Width
    int screen_h;     // Screen Height

    // Constructor
    public Main(int width, int height) {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                xP = evt.getX();
                yP = evt.getY();
                repaint();
            }
        });

        this.screen_w = width;
        this.screen_h = height;
    }

    public void paint(Graphics g) {
        super.paint(g);
        
        g.setColor(new Color(22, 22, 120));
        g.fill3DRect(200, 300, 100, 100, false);
    }


    public static void main(String[] args) {
        final int WIDTH  = 640;
        final int HEIGHT = 480;
    
        JFrame frame = new JFrame("Snake 2D [Forsman]");
        Main mainPanel = new Main(WIDTH, HEIGHT);
        frame.add(mainPanel);
        frame.setSize(WIDTH, HEIGHT);
        frame.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);     
    
        while (true) {
    
            mainPanel.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
