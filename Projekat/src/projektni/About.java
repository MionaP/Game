package projektni;

import java.awt.Graphics;

public class About implements Drawable {

	private int x = 15;
	@Override
	public void draw(Graphics g) {
		g.drawString("Projektni zadatak iz predmeta CS101", x, 15);
		g.drawString("Autor: Miona Pavlovic", x, 35);
		g.drawString("Broj indeksa: 2541", x, 55);
		g.drawString("O igrici: ", x, 100);
		g.drawString("Motori dobijaju random brzine svakim novin klikom", x, 115);
		g.drawString("na dugme Start", x, 130);

	}

}
