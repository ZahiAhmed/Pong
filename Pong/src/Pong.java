//zahi ahmed
import javax.swing.JFrame;

//creates game and window
public class Pong extends JFrame {
	private static final int HEIGHT = 800;
	private static final int WIDTH = 800;
	private static Panel Game;

	public Pong() {
		super("Pong");
		setSize(WIDTH, HEIGHT);

		Game = new Panel(this);
		add(Game);
		setVisible(true);
	}

	// starts game
	public static void main(String[] args) {
		new Pong();
	}
}