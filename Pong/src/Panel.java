//zahi ahmed
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel {
	private Paddle paddle;
	private Ball ball;
	private JLabel topscoreNum;
	private JLabel scoreNum;
	private int score = 0;
	private int topScore = 0;

	public Panel(Pong game) {

		// creates paddle and ball
		paddle = new Paddle(game, game.getHeight() - 50);
		ball = new Ball();

		// shows current score on header
		add(new JLabel("Score: "));
		scoreNum = new JLabel(Integer.toString(score));
		add(scoreNum);

		// shows top score on header
		add(new JLabel("       PONG      Top Score: "));
		topscoreNum = new JLabel(Integer.toString(topScore));
		add(topscoreNum);

		Timer timer = new Timer(5, new TimerHandler());
		timer.start();

		addKeyListener(new KeyHandler());
		setFocusable(true);
	}

	// keeps updating positions of paddle and ball
	private void update() {
		paddle.updatePosition();
		ball.updatePosition();
		checkWallCollision();
		checkPaddleCollision();
		repaint();
	}

	// checks if ball collides with sides of game screen and makes ball bounce
	private void checkWallCollision() {
		if (ball.getX() < 0 || ball.getX() > getWidth() - ball.getWidth() - (getInsets().left + getInsets().right))
			ball.setxSpeed(-ball.getxSpeed());
		else if (ball.getY() < 0)
			ball.setySpeed(-ball.getySpeed());
		else if (ball.getY() > getHeight() - ball.getHeight()) {
			this.resetGame();
		}
	}

	// restarts game once player loses
	private void resetGame() {
		this.ball = new Ball();
		if (score > topScore) {
			topScore = score;
			topscoreNum.setText(Integer.toString(topScore));
		}
		score = 0;
		scoreNum.setText(Integer.toString(score));
	}

	// checks if ball and paddle collide and makes ball bounce
	private void checkPaddleCollision() {
		if (ball.getBounds().y + ball.getHeight() == paddle.getBounds().y
				&& ball.getBounds().x + ball.getWidth() > paddle.getBounds().x
				&& paddle.getBounds().x + paddle.getWidth() > ball.getBounds().x) {
			ball.setySpeed(-ball.getySpeed());
			// updates score count and shows it on header after paddle and ball collide
			score++;
			scoreNum.setText(Integer.toString(score));
		}
	}

	// colors the ball and game
	public void paint(Graphics g) {
		super.paint(g);
		paddle.paint(g);
		ball.paint(g);
	}

	// checks players inputs
	private class KeyHandler implements KeyListener {
		public void keyPressed(KeyEvent e) {
			paddle.pressed(e);
		}

		// stops paddle when key is released
		public void keyReleased(KeyEvent e) {
			paddle.released(e);
		}

		public void keyTyped(KeyEvent e) {
		}
	}

	private class TimerHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			update();
		}
	}
}