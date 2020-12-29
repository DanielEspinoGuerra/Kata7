
package kata7;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import kata7.view.BlockDisplay;
import static kata7.view.BlockDisplay.size;

class BlockPanel extends JPanel implements BlockDisplay{
    private final MouseHandler handler;
    private final int max;
    private int x;
    private int y;
    private Moved moved;
    
    public BlockPanel(int max) {
        this.handler = new MouseHandler();
        this.max = max;
        this.addMouseListener(handler);
        this.addMouseMotionListener(handler);
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getWidth());
        
        int d = max * size;
        g.setColor(Color.black);
        for(int i = 0; i <= max; i++) {
            int c = i * size;
            g.drawLine(0, c, d, c);
            g.drawLine(c, 0, c, d);
        }
        
        g.setColor(Color.blue);
        g.fillRect(x, y, size, size);
    }

    @Override
    public void paintBlock(int x, int y) {
        this.x = x;
        this.y = y;
        repaint();
    }

    @Override
    public void on(Moved moved) {
        this.moved = moved;
    }
    
    private class MouseHandler implements MouseListener, MouseMotionListener {

        private boolean grabbed;

        @Override
        public void mouseClicked(MouseEvent event) {
        }

        @Override
        public void mousePressed(MouseEvent event) {
            if(event.getX() < x || event.getX() > x + size) return;
            if(event.getY() < y || event.getY() > y + size) return;
            grabbed = true;
        }

        @Override
        public void mouseReleased(MouseEvent event) {
            grabbed = false;
        }

        @Override
        public void mouseEntered(MouseEvent event) {
        }

        @Override
        public void mouseExited(MouseEvent event) {
        }

        @Override
        public void mouseDragged(MouseEvent event) {
            moved.to(event.getX(), event.getY());
        }

        @Override
        public void mouseMoved(MouseEvent event) {
        }
        
    }
    
}
