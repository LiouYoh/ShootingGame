package box;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Scream extends JFrame implements KeyListener {

	man m1;
	man boss;
	attact at = null;

	int x = 50, y = 200;
	int bossx = 600, bossy = 200;

	static int x1, y1;
	JPanel panel;

	public Scream() {

		panel = new JPanel(null) {
			Image image = new ImageIcon("background.jpg").getImage();

			protected void paintComponent(Graphics g) {
				g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
				super.paintComponent(g);
			}
		};
		panel.setOpaque(false);
		m1 = new man(x, y, 1, "man.png");
		boss = new man(bossx, bossy, 2, "chen.png");

		thread.start();
		panel.add(m1);
		panel.add(boss);

		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		setContentPane(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			x += 100;
			m1.setLocation(x, y);
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			x -= 100;
			m1.setLocation(x, y);
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			y -= 100;
			m1.setLocation(x, y);
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			y += 100;
			m1.setLocation(x, y);
		}
		if (e.getKeyCode() == KeyEvent.VK_Q) {
			x1 = x + 150;
			y1 = y;
			at = new attact(x1, y1);
			panel.add(at);
			panel.repaint();
			at.thread.start();

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	Thread thread = new Thread(new Runnable() {

		@Override
		public void run() {
			for (;;) {

				if (((int) (Math.random() * 100)) % 4 == 0) {
					bossy = bossy + (int) (Math.random() * 10);
				}
				if (((int) (Math.random() * 100)) % 4 == 1) {
					bossy = bossy - (int) (Math.random() * 10);
				}
				if (((int) (Math.random() * 100)) % 4 == 0) {
					bossx = bossx + (int) (Math.random() * 10);
				}
				if (((int) (Math.random() * 100)) % 4 == 0) {
					bossx = bossx - (int) (Math.random() * 10);
				}

				boss.setLocation(bossx, bossy);
				try {
					Thread.currentThread().sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}

	});

}
