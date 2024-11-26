package Bamking;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
public class test {
	
	    public static void main(String[] args) {
	        JFrame frame = new JFrame("Swing Example");
	        JPanel panel = new JPanel();
	        JButton button = new JButton("Click Me!");

	        panel.add(button);
	        frame.add(panel);

	        frame.setSize(300, 200);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	    }
	}


