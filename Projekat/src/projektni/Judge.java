package projektni;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Judge implements Drawable {

	private String winner = "";
	int x = 235;
	int y = 170;

	private Image judge = Toolkit.getDefaultToolkit().getImage("/sudija.PNG");

	@Override
	public void draw(Graphics g) {
		g.drawImage(judge, x + 15, y + 10, null);
		if (winner.equals("RED WON !!!")) {
			g.setColor(Color.RED);
			g.drawString(winner, x, y);
		}
		if (winner.equals("BLUE WON !!!")) {
			g.setColor(Color.BLUE);
			g.drawString(winner, x, y);
		}
	}

	public Judge(int x, int y) {
		this.x = x;
		this.y = y;
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

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

}
