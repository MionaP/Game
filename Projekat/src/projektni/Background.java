package projektni;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Background implements Drawable {
	int x = 415;
	int y = 350;

	public Background(int x, int y) {
		this.x = x;
		this.y = y;
	}

	private Image end = Toolkit.getDefaultToolkit().getImage("/end.PNG");

	@Override
	public void draw(Graphics g) {
		g.drawImage(end, x, y, 35, 35, null);

	}

	public Background() {
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}