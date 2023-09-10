import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import java.awt.*;
import java.awt.event.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class PremiumPanel extends Panels{
	static final String gapList[] = {"20", "15", "10", "0"};
	final static int maxGap = 20;
	JComboBox horGapComboBox;
	JComboBox verGapComboBox;
	JButton applyButton = new JButton("Apply gaps");
	GridLayout experimentLayout = new GridLayout(4,3);
	JTextField jtxt;
	JButton buttonFact;
	JButton buttonPrime;
	JButton buttonFibNum;
	JButton buttonFibSeq;
	JButton ccTextField;
	JButton ccBackGround;
	JButton ccLabel;
	JButton ccMenu;
	JLabel radioLabel;
	JRadioButton yesRadio;
	JRadioButton noRadio;
	String fibSequence = "1";
	GridLayout gridLay;
	int i = 2;
	JPanel activePanel;
	JPanel controls;
	JLabel horGaplb;
	JLabel vertGaplb;
	JLabel blank;
	boolean recordToHist;
	ButtonGroup group;
	public PremiumPanel() {

		jtxt = new JTextField(10);
		buttonFact = new JButton("Factorial");
		buttonPrime = new JButton("Prime Number");
		buttonFibNum = new JButton("Fibonacci Number");
		buttonFibSeq = new JButton("Fibonacci Sequence");

		ccLabel = new JButton("Label Colour");
		ccBackGround = new JButton("Background Colour");
		ccTextField = new JButton("TextField Colour");
		ccMenu = new JButton("MenuBar Colour");
		radioLabel = new JLabel("Record to history?");
		yesRadio = new JRadioButton("Yes");
		noRadio = new JRadioButton("No");

		group = new ButtonGroup();
		group.add(yesRadio);
		group.add(noRadio);
		/*for(int i = 0;i<=1000;i+= 2) {
			set.add(i);
		}*/
		setLayout(new BorderLayout());
		addComponentsToPane();
	}
	public void initGaps() {
		horGapComboBox = new JComboBox(gapList);
		verGapComboBox = new JComboBox(gapList);
	}
	public void addComponentsToPane() {
		initGaps();
		activePanel = new JPanel();
		activePanel.setLayout(experimentLayout);
		controls = new JPanel();
		controls.setLayout(new GridLayout(2,3));
		JPanel title = new JPanel();
		title.setLayout(new FlowLayout());
		activePanel.add(jtxt);
		addButtFact();
		addccLabel();
		activePanel.add(radioLabel);
		addButtPrime();
		addccBackGround();
		addYesRad();
		addFibNum();
		addccTF();
		addNoRad();
		addFibSeq();
		addccMenu();
		horGaplb = new JLabel("Horizontal gap:");
		vertGaplb = new JLabel("Vertical gap:");
		blank = new JLabel(" ");
		//Add controls to set up horizontal and vertical gaps
		controls.add(horGaplb);
		controls.add(vertGaplb);
		controls.add(blank);
		controls.add(horGapComboBox);
		controls.add(verGapComboBox);
		controls.add(applyButton);

		//Process the Apply gaps button press
		applyButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Get the horizontal gap value
				String horGap = (String)horGapComboBox.getSelectedItem();
				//Get the vertical gap value
				String verGap = (String)verGapComboBox.getSelectedItem();
				//Set up the horizontal gap value
				experimentLayout.setHgap(Integer.parseInt(horGap));
				//Set up the vertical gap value
				experimentLayout.setVgap(Integer.parseInt(verGap));
				//Set up the layout of the buttons
				experimentLayout.layoutContainer(activePanel);
			}
		});
		//Set up the horizontal gap value
		experimentLayout.setHgap(20);
		//Set up the vertical gap value
		experimentLayout.setVgap(20);
		//Set up the layout of the buttons
		experimentLayout.layoutContainer(activePanel);
		add(activePanel, BorderLayout.NORTH);
		add(new JSeparator(), BorderLayout.CENTER);
		add(controls, BorderLayout.SOUTH);
	}
	
	public void clearSelect() {
		group.clearSelection();
	}
	public void addNoRad() {
		activePanel.add(noRadio);
		noRadio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				recordToHist = false;
			}
		});
	}
	public void addYesRad() {
		activePanel.add(yesRadio);
		yesRadio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				recordToHist = true;
			}
		});
	}
	public void addccMenu() {
		activePanel.add(ccMenu);
		ccMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JColorChooser colorChooser = new JColorChooser();
				Color color = JColorChooser.showDialog(null, "Pick a color...I guess", Color.black);
				PremiumUI.menuBar.setBackground(color);
			}
		});
	}
	public void addccBackGround() {
		activePanel.add(ccBackGround);
		ccBackGround.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JColorChooser colorChooser = new JColorChooser();
				Color color = JColorChooser.showDialog(null, "Pick a color...I guess", Color.black);
				activePanel.setBackground(color);
				setBackground(color);
				controls.setBackground(color);
				blank.setForeground(color);
			}
		});
	}
	public void addccLabel() {
		activePanel.add(ccLabel);
		ccLabel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JColorChooser colorChooser = new JColorChooser();
				Color color = JColorChooser.showDialog(null, "Pick a color...I guess", Color.black);
				radioLabel.setForeground(color);
				horGaplb.setForeground(color);
				vertGaplb.setForeground(color);
			}
		});
	}
	public void addccTF() {
		activePanel.add(ccTextField);
		ccTextField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JColorChooser colorChooser = new JColorChooser();
				Color color = JColorChooser.showDialog(null, "Pick a color...I guess", Color.black);
				jtxt.setBackground(color);
				
			}
		});
	}
	public void addButtFact() {
		activePanel.add(buttonFact);
		buttonFact.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Algorithms algo = new Algorithms();
				int n1 = 0;
				try {
					n1 = Integer.parseInt(jtxt.getText());
					JOptionPane.showMessageDialog(null, algo.factorial(n1), "Factorial", JOptionPane.INFORMATION_MESSAGE);
					if(recordToHist == true) {
					set.add(Integer.parseInt(jtxt.getText()));
					}
				}
				catch(Exception exc) {
					JOptionPane.showMessageDialog(null, "Please enter an integer in the textfield", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
				jtxt.setText("");
				clearSelect();
			}
		});
	}
	public void addButtPrime() {
		activePanel.add(buttonPrime);
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
					if(recordToHist == true) {
						set.add(Integer.parseInt(jtxt.getText()));
						}
					
				}
				catch(Exception exc) {
					JOptionPane.showMessageDialog(null, "Please enter an integer in the textfield", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
				jtxt.setText("");
				clearSelect();

			}

		});
	}

	public void addFibNum() {
		activePanel.add(buttonFibNum);
		buttonFibNum.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Algorithms algo = new Algorithms();
				int n1 = 0;
				try {
					n1 = Integer.parseInt(jtxt.getText());
					String output = String.valueOf(algo.fibonacciNum(n1));
					JOptionPane.showMessageDialog(null, output, "Fibonacci", JOptionPane.INFORMATION_MESSAGE);
					if(recordToHist == true) {
						set.add(Integer.parseInt(jtxt.getText()));
						}
				}
				catch(Exception exc) {
					JOptionPane.showMessageDialog(null, "Please enter an integer in the textfield", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
				jtxt.setText("");
				clearSelect();
			}
		});
	}

	public void addFibSeq() {
		activePanel.add(buttonFibSeq);
		buttonFibSeq.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Algorithms algo = new Algorithms();
				int num;
				try {
					num = Integer.parseInt(jtxt.getText());
					String output = "";
					//output = String.valueOf();
					//algo.fibonacciSeq(num, fibSequence);
					output = algo.printFibonacci(num-2, fibSequence);
					JOptionPane.showMessageDialog(null, output, "Fibonacci", JOptionPane.INFORMATION_MESSAGE);
					if(recordToHist == true) {
						set.add(Integer.parseInt(jtxt.getText()));
						}
				}
				catch(Exception exc) {
					JOptionPane.showMessageDialog(null, "Please enter an integer in the textfield", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
				fibSequence = "1";
				jtxt.setText("");
				clearSelect();
			}
		});
	}

}