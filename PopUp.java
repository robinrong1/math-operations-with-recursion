import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
public class PopUp {
	JLabel jLabel;
	JDialog jd;
	public PopUp(ArrayList<Integer> values, Algorithms algo) {
		JFrame jFrame = new JFrame();

		jd = new JDialog(jFrame);
		jd.setLayout(new FlowLayout());
		jd.setTitle("progress bar");
		jLabel = new JLabel("Press close button to close the dialog.");


		JProgressBar bar = new JProgressBar();
		bar.setValue(0);

		jd.add(jLabel);
		jd.add(bar);
		jd.pack();
		jd.setVisible(true);
		jd.setLocationRelativeTo(null);
		jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		ProgressWorker pw = new ProgressWorker(values, algo);
		pw.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				String name = evt.getPropertyName();
				if (name.equals("progress")) {
					int progress = (int) evt.getNewValue();
					bar.setValue(progress);
					bar.repaint();
				} else if (name.equals("state")) {
					SwingWorker.StateValue state = (SwingWorker.StateValue) evt.getNewValue();
					switch (state) {
					case DONE:
						break;
					}
				}
			}
		});
		pw.execute();
	}


	public class ProgressWorker extends SwingWorker<Object, Object> {

		int interval;
		int count;
		ArrayList<Integer> values = new ArrayList<>();
		Algorithms algo;
		public ProgressWorker(ArrayList<Integer> values, Algorithms algo){
			this.interval = 100/values.size();
			this.values = values;
			this.algo = algo;
		}
		@Override
		protected Object doInBackground() throws Exception {
			for (int i = 0; i <= 100; i+=interval) {        

				jLabel.setText("number " + String.valueOf(values.get(count) + " tried"));
				setProgress(i);
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				count++;
				if(count == values.size()) {
					setProgress(100);
					i = 100;
				}
			}
			JOptionPane.showMessageDialog(null, String.valueOf(values.get(values.size()-1)) + " is found after " + String.valueOf(values.size()) + " iterations", "progress", JOptionPane.INFORMATION_MESSAGE);
			jd.dispose();
			algo.getValues().removeAll(algo.getValues());
			return null;
		}
	}
}