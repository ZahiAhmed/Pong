//zahi ahmed
import java.awt.Rectangle;

public class Player {
	private int x;
	private int y;
	private int xSpeed;
	private int ySpeed;
	private int width;
	private int height;

	// sets variables for dimensions, coordinates and speed of ball and paddle
	public Player(int x, int y, int xSpeed, int ySpeed, int width, int height) {
		this.x = x; // horizontal coordinate
		this.y = y; // vertical coordinate
		this.xSpeed = xSpeed; // horizontal speed value
		this.ySpeed = ySpeed; // vertical speed value
		this.width = width;
		this.height = height;
	}

	// getters and setter for dimensions, coordinates and speed values of ball and
	// paddle
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

	public int getxSpeed() {
		return xSpeed;
	}

	public void setxSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}

	public int getySpeed() {
		return ySpeed;
	}

	public void setySpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);

	}

}