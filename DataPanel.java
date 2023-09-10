import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;   
public class DataPanel extends Panels{

	JButton findButt;
	JTextField searchField;
	JButton ccTextFieldData;
	JButton ccBackGroundData;
	Integer pastNums[]; 
	String[] options = { "Linear Search", "Binary Search"};
	String message="Make a selection to search for your number\n";
	public DataPanel() {
		searchField = new JTextField(5);
		setLayout(new FlowLayout());   
		add(searchField);
		addFindButt();
		addccTF();
		addccBackGround();
	}
	public void addccBackGround() {
		ccBackGroundData = new JButton("background color");
		add(ccBackGroundData);
		ccBackGroundData.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JColorChooser colorChooser = new JColorChooser();
				Color color = JColorChooser.showDialog(null, "Pick a color...I guess", Color.black);
				setBackground(color);
			}
		});
	}
	public void addccTF() {
		ccTextFieldData = new JButton("TextField Color");
		add(ccTextFieldData);
		ccTextFieldData.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JColorChooser colorChooser = new JColorChooser();
				Color color = JColorChooser.showDialog(null, "Pick a color...I guess", Color.black);
				searchField.setBackground(color);
			}
		});
	}
	private void addFindButt() {
		findButt = new JButton("Search");
		findButt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(set.isEmpty()==false) {
					Algorithms algo = new Algorithms();
					pastNums = set.toArray(new Integer[0]);
					int key;
					int[] intArray = Arrays.stream(pastNums).mapToInt(Integer::intValue).toArray();

					String selection = (String)JOptionPane.showInputDialog(null, message, "Search Algo",
							JOptionPane.INFORMATION_MESSAGE, null, options, options[0]); //user's choice
					try{
						//sort the array first
						algo.bubbleSort(intArray, intArray.length);
						for (int i=0; i<intArray.length; i++) {
							System.out.println(intArray[i]);
						}
					}
					catch(Exception except) {
						except.printStackTrace();
					}

					if (selection == "Linear Search") {

						key = algo.RLinearSearch(intArray, intArray.length-1, Integer.parseInt(searchField.getText()));
						if(key == -1) {//if method return -1, means number cannot be found
							JOptionPane.showMessageDialog(null, "Number not found", "Search", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							new PopUp(algo.getValues(), algo);

						}

					}  
					else if (selection == "Binary Search") {
						key = algo.binarySearch(intArray, 0,intArray.length-1, Integer.parseInt(searchField.getText()));
						if(key == -1) {//if method return -1, means number cannot be found
							JOptionPane.showMessageDialog(null, "Number not found", "Search", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							new PopUp(algo.getValues(), algo);

						}
					} 

					algo.setCount(0);
				}
				else {
					JOptionPane.showMessageDialog(null, "No number currently recorded in history!",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		add(findButt);
	}
}