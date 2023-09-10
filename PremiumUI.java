import java.awt.GridLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuListener;
public class PremiumUI extends JFrame implements MenuListener{
	static JMenuBar menuBar;
	JMenu menu;
	JMenu menu2;
	JMenu menu3;
	CardLayout cl;
	public JTextField jtxt;
	JPanel cardPanel;

	public PremiumUI() {
		super("recursion");


		cardPanel = new JPanel();
		cl = new CardLayout();
		cardPanel.setLayout(cl);
		PremiumPanel actPanel = new PremiumPanel();
		DataPanel dataPanel = new DataPanel();

		cardPanel.add(actPanel,"1");
		cardPanel.add(dataPanel,"2");
		menu = new JMenu("Calculate");
		menu.addMenuListener(this);

		menu2 = new JMenu("History");
		menu2.addMenuListener(this);

		menu3 = new JMenu("Help");
		menu3.addMenuListener(this);

		menuBar = new JMenuBar();
		menuBar.add(menu);
		menuBar.add(menu2);
		menuBar.add(menu3);
		setJMenuBar(menuBar);
		//create a menu bar in the jframe
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(cardPanel);
		pack();
		setVisible(true);

	}

	@Override
	public void menuSelected(MenuEvent e) {
		if(e.getSource() == menu2) {
			cl.show(cardPanel,"2");
		}

		if(e.getSource() == menu) {
			cl.show(cardPanel,"1");
		}

		if(e.getSource() == menu3) {
			JOptionPane.showMessageDialog(null, "The calculate page allows the user to enter a number and a variety of actions can be performed\n"
					+ "For example:\n"
					+ "Click the Prime button to determine whether the number is prime or not\n"
					+ "The History page contains all the numbers you have previously entered and allows you to use different searching algorithms\n"
					+ "to see how many searches is required to find your number with different algorithms", "Help", JOptionPane.INFORMATION_MESSAGE);
		}

	}
	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub

	}


	public void showFrame() {
		setVisible(true);
	}

}