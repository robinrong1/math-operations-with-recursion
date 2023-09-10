import java.awt.GridLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuListener;
public class FreeUI extends JFrame{
	JMenuBar menuBar;
	JMenu menu;
	JMenu menu2;
	JMenu menu3;
	CardLayout cl;
	public JTextField jtxt;
	JPanel cardPanel;

	public FreeUI() {
		super("recursion");
		FreePanel freePanel = new FreePanel();
		add(freePanel);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pack();
		setVisible(true);
	}

	public void showFrame() {
		setVisible(true);
	}

}