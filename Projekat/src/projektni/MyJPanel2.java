package projektni;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;


public class MyJPanel2 extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private List<Drawable> draw = new ArrayList<>();

    public MyJPanel2(About a) { 
    	draw.add(a);
    	
    	
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Drawable d : draw) {
        	d.draw(g);

        }
    }
}