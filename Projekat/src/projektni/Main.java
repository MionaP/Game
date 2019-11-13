package projektni;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {
	final static JFrame j = new JFrame("Trka Motora");

	final private static About a = new About();

	final private static MyJPanel2 mp2 = new MyJPanel2(a);

	public static void main(String[] args) {

		JFrame o = new JFrame("Opcije");
		o.setSize(300, 300);
		o.setLocationRelativeTo(null);
		o.setResizable(true);
		o.setVisible(false);

		j.setSize(500, 500);
		j.setLocationRelativeTo(null);
		j.setResizable(true);
		j.setLayout(new BorderLayout());
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Widgets widgets = new Widgets();
		Background background = new Background();
		Judge judge = new Judge(j.getWidth() / 2, j.getHeight() / 2);
		Motor m1 = new Motor(15, j.getWidth() - 125, "/motor1.gif");
		Motor m2 = new Motor(15, j.getWidth() - 195, "/motor2.GIF");
		MyJPanel p1 = new MyJPanel(m1, m2, background, widgets, judge);

		JFrame a = new JFrame("About");
		a.setSize(300, 300);
		a.setLocationRelativeTo(null);
		a.setResizable(false);
		a.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		a.add(mp2);

		final JButton start = new JButton("Start");
		final JButton exit = new JButton("Exit");
		final JButton newGame = new JButton("New Game");
		final JButton setSpeed = new JButton("Set Speed");
		final JButton about = new JButton("About");

		final JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		p2.add(setSpeed);
		p2.add(start);
		p2.add(newGame);
		p2.add(about);
		p2.add(exit);

		setSpeed.addActionListener(e -> {
			JFrame jf = new JFrame("Set Speed");
			jf.setSize(300, 300);
			jf.setLocationRelativeTo(null);
			jf.setResizable(true);

			GridLayout gl = new GridLayout(4, 2);
			JPanel jp = new JPanel();
			jp.setLayout(gl);

			JLabel jL1 = new JLabel("Motor1");
			JLabel jL2 = new JLabel("Motor2");

			JTextField motor1brzina = new JTextField();
			JTextField motor2brzina = new JTextField();

			jp.add(jL1);
			jp.add(motor1brzina);
			jp.add(jL2);
			jp.add(motor2brzina);

			jf.add(jp);

			jf.setVisible(true);
			jf.addWindowListener(new WindowListener() {

				@Override
				public void windowOpened(WindowEvent e) {

				}

				@Override
				public void windowIconified(WindowEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void windowDeiconified(WindowEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void windowDeactivated(WindowEvent e) {
					try {
						m1.setBrzina(Integer.parseInt(motor1brzina.getText().toString()));
						m2.setBrzina(Integer.parseInt(motor2brzina.getText().toString()));
						if (motor1brzina.getText().length() == 0) {
							System.out.println("Morate da unesete brojcanu vrednost za brzinu");
						}

					} catch (Exception e2) {
						System.out.println("Morate da unesete brojcanu vrednost za brzinu");

					}

				}

				@Override
				public void windowClosing(WindowEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void windowClosed(WindowEvent e) {

				}

				@Override
				public void windowActivated(WindowEvent e) {
					// TODO Auto-generated method stub

				}
			});

		});

		j.add(p2, BorderLayout.NORTH);
		j.add(p1, BorderLayout.CENTER);

		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (m1.getBrzina() < 1 || m2.getBrzina() < 1) {
					m1.setBrzina(m1.getBrzina() + ((int) (5 + Math.random() * 15)));
					m2.setBrzina(m2.getBrzina() + ((int) (5 + Math.random() * 15)));
				}
				newGame.setEnabled(false);
				start.setEnabled(false);
				Thread motor1 = new Thread() {

					public void run() {

						try {
							for (int i = 0; i < j.getWidth()-j.getWidth()*15/100; i++) {
								m1.kreni();
								Thread.sleep(m1.getBrzina());
								p1.repaint();
								if (m1.getX() == j.getWidth()*85/100 && m2.getX() == j.getWidth()*85/100) {
									newGame.setEnabled(true);
								}
								if (m1.getX() > j.getWidth()*85/100 && m2.getX() < j.getWidth()*85/100) {
									judge.setWinner("BLUE WON !!!");
								}
								if (m2.getX() > j.getWidth()*85/100 && m1.getX() < j.getWidth()*85/100) {
									judge.setWinner("RED WON !!!");
								}
								if (m1.getX() > j.getWidth()*80/100 && m2.getX() > j.getWidth()*80/100) {
									newGame.setEnabled(true);
								}
							}

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				};
				motor1.start();

				Thread motor2 = new Thread() {

					public void run() {

						try {
							for (int i = 0; i < j.getWidth()-j.getWidth()*15/100; i++) {
								m2.kreni();
								Thread.sleep(m2.getBrzina());
								p1.repaint();
								if (m1.getX() > j.getWidth()*80/100 && m2.getX() > j.getWidth()*80/100) {
									newGame.setEnabled(true);
								}
							}

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				};
				motor2.start();
			}
		});

		j.addComponentListener(new ComponentListener() {

			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void componentResized(ComponentEvent e) {
				
				
				m1.setY(j.getHeight() - 125);
				m2.setY(j.getHeight() - 195);
				
				judge.setX(j.getWidth() * 50 / 100 - 50);
				judge.setY(j.getHeight() * 50 / 100 - 50);
				
				widgets.setX1(10);
				widgets.setX11(10);
				
				widgets.setY1(j.getHeight()-167);
				widgets.setY2(j.getHeight()-167);
				
				widgets.setY11(j.getHeight()-85);
				widgets.setY21(j.getHeight()-85);
				
				widgets.setX2(j.getWidth()*95/100);
				widgets.setX21(j.getWidth()*95/100);

				background.setY(j.getHeight() - 150);
				background.setX(j.getWidth() - 100);
				
				
				
				j.repaint();
			}

			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub

			}
		});

		newGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				judge.setWinner("");
				start.setEnabled(true);
				m1.setX(15);
				m2.setX(15);
				p1.repaint();

			}
		});

		about.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				a.setVisible(true);
			}
		});

		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

		j.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				j.repaint();

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});

		j.setVisible(true);

	}

}
