import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FreePanel extends Panels{
	
	JTextField jtxt;
	JButton buttonFact;
	JButton buttonPrime;
	JButton buttonFibNum;
	JButton buttonFibSeq;
	String fibSequence = "1";
	int i = 2;
	public FreePanel() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		jtxt = new JTextField(10);
		buttonFact = new JButton("Factorial");
		buttonPrime = new JButton("Prime Number");
		buttonFibNum = new JButton("Fibonacci Number");
		buttonFibSeq = new JButton("Fibonacci Sequence");

		add(jtxt);
		addButtFact();
		addButtPrime();
		addFibNum();
		addFibSeq();
		
	}
	public void addButtFact() {
		add(buttonFact);
		buttonFact.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Algorithms algo = new Algorithms();
				int n1 = 0;
				try {
					n1 = Integer.parseInt(jtxt.getText());
					JOptionPane.showMessageDialog(null, algo.factorial(n1), "Factorial", JOptionPane.INFORMATION_MESSAGE);
					
				}
				catch(Exception exc) {
					JOptionPane.showMessageDialog(null, "Please enter an integer in the textfield", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
				jtxt.setText("");
			}
		});
	}
	public void addButtPrime() {
		add(buttonPrime);
		buttonPrime.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					Algorithms algo = new Algorithms();
					int n1 = 0;
					try {
						n1 = Integer.parseInt(jtxt.getText());
						boolean isPrime = algo.isPrime(n1, i);
						if(isPrime == true) {
							JOptionPane.showMessageDialog(null, "The number is prime", "Prime", JOptionPane.INFORMATION_MESSAGE);
						}
						else if(isPrime == false) {
							JOptionPane.showMessageDialog(null, "The number is not prime", "Prime", JOptionPane.INFORMATION_MESSAGE);
						}
						
					}
					catch(Exception exc) {
						JOptionPane.showMessageDialog(null, "Please enter an integer in the textfield", "Error", JOptionPane.INFORMATION_MESSAGE);
					}
					jtxt.setText("");
				

			}

		});
	}

	public void addFibNum() {
		add(buttonFibNum);
		buttonFibNum.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Algorithms algo = new Algorithms();
				int n1 = 0;
				try {
					n1 = Integer.parseInt(jtxt.getText());
					String output = String.valueOf(algo.fibonacciNum(n1));
					JOptionPane.showMessageDialog(null, output, "Fibonacci", JOptionPane.INFORMATION_MESSAGE);
					
				}
				catch(Exception exc) {
					JOptionPane.showMessageDialog(null, "Please enter an integer in the textfield", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
				jtxt.setText("");
			}
		});
	}

	public void addFibSeq() {
		add(buttonFibSeq);
		buttonFibSeq.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Algorithms algo = new Algorithms();


				int num;
				try {
					num = Integer.parseInt(jtxt.getText());
					String output = "";
					output = algo.printFibonacci(num-2, fibSequence);
					JOptionPane.showMessageDialog(null, output, "Fibonacci", JOptionPane.INFORMATION_MESSAGE);
					
				}
				catch(Exception exc) {
					JOptionPane.showMessageDialog(null, "Please enter an integer in the textfield", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
				fibSequence = "1";
				jtxt.setText("");
			}
		});
	}

}