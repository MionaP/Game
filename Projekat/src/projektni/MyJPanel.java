package projektni;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class MyJPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private List<Drawable> draw = new ArrayList<>();

    public MyJPanel(Motor m1, Motor m2, Background b, Widgets w, Judge j) { 
    	draw.add(m1);
    	draw.add(m2);
    	draw.add(b);
    	draw.add(w);
    	draw.add(j);
    	
    	
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Drawable d : draw) {
        	d.draw(g);

        }
    }
}