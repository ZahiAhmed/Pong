//zahi ahmed
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class Paddle extends Player {
	private final Pong game;

	// sets paddle dimensions and start position
	public Paddle(Pong game, int y) {
		super((game.getWidth() - 50) / 3, y, 0, 0, 100, 25);
		this.game = game;
	}

	// sets player controls reads players inputs for paddle to move
	public void pressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT)
			setxSpeed(-5);
		else if (key == KeyEvent.VK_RIGHT)
			setxSpeed(5);
	}

	// stops paddle when keys are released
	public void released(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT)
			setxSpeed(0);
	}

	// updates paddle position when keys are pressed
	public void updatePosition() {
		if (getX() + getxSpeed() >= 0 && getX() + getxSpeed() < game.getWidth() - getWidth())
			setX(getX() + getxSpeed());
	}

	// colors game
	public void paint(Graphics g) {
		g.fillRect(getX(), getY(), getWidth(), getHeight());
		g.setColor(Color.RED);

	}
}
