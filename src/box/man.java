package box;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

//javax.swing.
public class man extends JLabel {

	int num;
	String man;

	public man(int startX, int startY, int n, String picture) {

		num = n;
		man = picture;

		setIcon(new ImageIcon(man));
		setSize(getPreferredSize());
		setLocation(startX, startY);

	}

}
