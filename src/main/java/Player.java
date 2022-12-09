import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player extends Sprite implements Commons {

	private final int START_Y = 600;
	private final int START_X = 600;

	private final String player = "/img/craft.png";
	private int width;
	private int height;

	/*
	 * Constructor
	 */
	public Player() {
		ImageIcon ii = new ImageIcon(this.getClass().getResource(player));

		width = ii.getImage().getWidth(null);
		height = ii.getImage().getHeight(null);

		setImage(ii.getImage());
		setX(START_X);
		setY(START_Y);
	}

	public void act() {
		x += dx;
		if (x <= 2)
			x = 2;
		if (x >= BOARD_WIDTH - 2 * width)
			x = BOARD_WIDTH - 2 * width;
		
		y += dy;
		if (y <= 2)
			y = 2;

		if (y >= GROUND +150 - 2 * height)
			y = GROUND +150 - 2 * height;
	}

	//build speed
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			dx = -4;
		}
		if (key == KeyEvent.VK_DOWN) {
			dy = 4;
		}

		if (key == KeyEvent.VK_RIGHT) {
			dx = 4;
		}
		if (key == KeyEvent.VK_UP) {

			dy = -4;
		}
	}


	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			dx = 0;
		}

		if (key == KeyEvent.VK_RIGHT) {
			dx = 0;
		}
		if (key == KeyEvent.VK_UP) {
			dy = 0;
		}

		if (key == KeyEvent.VK_DOWN) {
			dy = 0;
		}
	}
}