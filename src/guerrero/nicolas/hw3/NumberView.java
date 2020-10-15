package guerrero.nicolas.hw3;

import java.awt.*;
import javax.swing.*;

/**
 * 
 * Project Specifications
 * 3 labels
 * 3 text fields with numbers
 * Update button
 * 
 * Sources:
 * https://stackoverflow.com/questions/17884843/change-jlabel-font-size/17884919
 * 
 * @author Guerr
 *
 */
public class NumberView {
	private JFrame frame;
	private NumberEntry[] fields;
	private JButton updateButton;
	
	// Construct NumberView
	public NumberView(int size) {
		// Frame operations
		frame = new JFrame("Number View");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		// Set title
		JLabel title = new JLabel("Change numbers to edit the graph");
		title.setFont(title.getFont().deriveFont(16.0f));
		JPanel center = new JPanel(new FlowLayout());
		center.add(title);
		frame.add(center);
		
		// Add the text fields
		fields = new NumberEntry[size];
		for(int i = 0; i < size; i++) {
			fields[i] = new NumberEntry(i + 1);
			frame.add(fields[i].entry);
		}
		
		// Add the update button
		updateButton = new JButton("Update");
		center = new JPanel(new FlowLayout());
		center.add(updateButton);
		frame.add(center);
	}
	
	// Display NumberView
	public void display() {
		frame.setLocationRelativeTo(null);
		frame.setPreferredSize(new Dimension(300, 300));
		frame.pack();
		frame.setVisible(true);
	}
	
	protected class NumberEntry {
		JPanel entry;
		JLabel numLabel;
		JTextField numInput;
		
		public NumberEntry(int i) {
			numInput = new JTextField("0", 20);
			numLabel = new JLabel("Field " + Integer.toString(i) + ": ");
			numLabel.setLabelFor(numInput);
			
			entry = new JPanel(new FlowLayout());
			entry.add(numLabel);
			entry.add(numInput);
		}
	}

}
