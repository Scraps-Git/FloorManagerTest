package Main;
import javax.swing.JFrame;

public class Initialize {

	public static void main(String[] args) {
		JFrame window = new JFrame("Mall Navigator");
		window.setContentPane(new FloorPanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
	}
}