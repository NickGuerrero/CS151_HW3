package guerrero.nicolas.hw3;

import java.awt.*;
import javax.swing.*;

/**
 * Creates the input window for the NumberApplication
 * This input window is used to update the sibling GraphView on what numbers to show.
 * Only integer values are accepted, just to keep the problem simple.
 * 
 * Sources: JavaDoc
 * https://stackoverflow.com/questions/17884843/change-jlabel-font-size/17884919
 * 
 * @author Nicolas Guerrero
 */
public class NumberView implements View {
	private JFrame frame;
	private NumberEntry[] fields;
	private JButton updateButton;
	private NumberController controller;
	
	// Construct NumberView
	public NumberView(String[] colors, NumberController c) {
		// Set controller
		controller = c;
		
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
		fields = new NumberEntry[colors.length];
		for(int i = 0; i < colors.length; i++) {
			fields[i] = new NumberEntry(colors[i]);
			frame.add(fields[i].entry);
		}
		
		// Add the update button
		updateButton = new JButton("Update");
		updateButton.addActionListener(event -> updateController());
		center = new JPanel(new FlowLayout());
		center.add(updateButton);
		frame.add(center);
	}
	
	// Update NumberView, called by NumberModel after update
	public void update(int[] values) {
		for(int i = 0; i < values.length; i++) {
			fields[i].numInput.setText(Integer.toString(values[i]));
		}
	}
	
	// Update NumberModel, called by NumberView to update
	public void updateController() {
		String[] input = new String[fields.length];
		for(int i = 0; i < fields.length; i++) {
			input[i] = fields[i].numInput.getText();
		}
		controller.updateModel(input);
	}
	
	// Display NumberView, called by NumberApplication
	public void display() {
		frame.setLocationRelativeTo(null);
		frame.setPreferredSize(new Dimension(FRAMEWIDTH, FRAMEHEIGHT));
		frame.pack();
		frame.setVisible(true);
	}
	
	/**
	 * Internal class for setting up number input templates
	 * Each NumberEntry builds and contains JPanel objects with the
	 * text field and label. Also contains the update function for
	 * manipulating the object. Allows for quick templates.
	 */
	protected class NumberEntry {
		JPanel entry;
		JLabel numLabel;
		JTextField numInput;
		
		// Older constructor: Label the fields by number
		public NumberEntry(int i) {
			numInput = new JTextField("0", 20);
			numLabel = new JLabel("Field " + Integer.toString(i) + ": ");
			numLabel.setLabelFor(numInput);
			
			entry = new JPanel(new FlowLayout());
			entry.add(numLabel);
			entry.add(numInput);
		}
		
		// Current constructor: Label the fields by the given string
		public NumberEntry(String c) {
			numInput = new JTextField("0", 20);
			numLabel = new JLabel(c + ": ");
			numLabel.setLabelFor(numInput);
			
			entry = new JPanel(new FlowLayout());
			entry.add(numLabel);
			entry.add(numInput);
		}
		
		// Update text, called when the model updates the view
		public void updateText(int i) {
			numInput.setText(Integer.toString(i));
		}
	}

}
