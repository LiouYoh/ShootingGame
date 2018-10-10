package box;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class attact extends JLabel {

	int x,y;

	public attact(int startX, int startY) {
		x=startX;
		y=startY;
		setIcon(new ImageIcon("dan.png"));
		setSize(getPreferredSize());
		setLocation(x, y);

	}

	
	Thread thread = new Thread(new Runnable() {
		public void run() {
			for (;;) {
				x=x+50;
				setSize(getPreferredSize());
				setLocation(x,y);
				try {
					Thread.currentThread().sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	});
	
	
	

}
