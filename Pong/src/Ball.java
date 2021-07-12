//zahi ahmed
import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Player {
	// sets ball start position and dimensions
	public Ball() {
		super(0, 0, 5, 10, 30, 30);
	}

	// sets ball speed and position
	public void updatePosition() {
		setY(getY() + getySpeed());
		setX(getX() + getxSpeed());
	}

	public void paint(Graphics g) {
		g.fillOval(getX(), getY(), getWidth(), getHeight());

	}
}