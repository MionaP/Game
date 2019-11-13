package projektni;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Motor implements Drawable {

	private int x = 15;
	private int brzina;
	private int y = 385;
	private String path = "";


	public Motor(int x, int y, String path) {
		this.x = x;
		this.y = y;
		this.path = path;
	}

	@Override
	public void draw(Graphics g) {
		Image motor1 = Toolkit.getDefaultToolkit().getImage(path);
		g.drawImage(motor1, x, y, null);

	}

	public void kreni() {

		x++;

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

	public int getBrzina() {
		return brzina;
	}

	public void setBrzina(int brzina) {
		this.brzina = brzina;
	}

}
