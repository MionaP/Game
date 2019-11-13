package projektni;

import java.awt.Color;
import java.awt.Graphics;

public class Widgets implements Drawable {

	int x1 = 10;
	int y1 = 343;
	int x2 = 445;
	int y2 = 343;

	int x11 = 10;
	int y11 = 415;
	int x21 = 445;
	int y21 = 415;

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.drawLine(x1, y1, x2, y2);
		g.setColor(Color.BLUE);
		g.drawLine(x11, y11, x21, y21);
	}

	public Widgets() {
	};

	public Widgets(int x1, int y1, int x2, int y2, int x11, int y11, int x21, int y21) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x11 = x11;
		this.y11 = y11;
		this.x21 = x21;
		this.y21 = y21;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public int getX11() {
		return x11;
	}

	public void setX11(int x11) {
		this.x11 = x11;
	}

	public int getY11() {
		return y11;
	}

	public void setY11(int y11) {
		this.y11 = y11;
	}

	public int getX21() {
		return x21;
	}

	public void setX21(int x21) {
		this.x21 = x21;
	}

	public int getY21() {
		return y21;
	}

	public void setY21(int y21) {
		this.y21 = y21;
	}

}
// x1 i x11 = m-5;
// y1 =