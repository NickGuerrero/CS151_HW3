package guerrero.nicolas.hw3;

import java.awt.*;
import javax.swing.*;

/**
 * 
 * Project Specifications
 * 3 rectangles with numbers & different colors next to each to make a bar graph
 * 
 * @author Guerr
 *
 */
public class GraphView implements View {
	private JFrame frame;
	private JPanel barWindow;
	private NumberModel numbers;
	private GridBagLayout layout;
	
	private final int WIDTH = 40;
	private BarGraphComponent[] bars;
	
	public GraphView(NumberModel n) {		
		// Set up the frame
		frame = new JFrame("Graph View");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		// Set up the panel
		barWindow = new JPanel();
		barWindow.setBackground(Color.WHITE);
		layout = new GridBagLayout();
		barWindow.setLayout(layout);
		
		// Retrieve numbers
		numbers = n;
		bars = new BarGraphComponent[numbers.fields.length];
		for(int i = 0; i < numbers.fields.length; i++) {
			bars[i] = new BarGraphComponent(0, 0, WIDTH, numbers.fields[i], numbers.colors[i]);
		}
		
		// Place bars into the GridBag
		for(int i = 0; i < bars.length; i++) {
			JComponent current = (JComponent) bars[i];
			current.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);
			barWindow.add(current, buildConstraint(i, bars[i].height));
		}
		frame.add(barWindow);
	}
	
	public void update(int[] values) {
		for(int i = 0; i < bars.length; i++) {
			bars[i].updateHeight(values[i]);
			layout.setConstraints(bars[i], buildConstraint(i, bars[i].height));
			bars[i].validate();
			bars[i].repaint();
		}
		barWindow.revalidate();
		barWindow.repaint();
	}
	
	// Constraint reference
	private GridBagConstraints buildConstraint(int index, int height) {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = index;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1;
		c.ipady = height;
		c.insets = new Insets(0,30,5,0);
		c.anchor = GridBagConstraints.PAGE_END;
		return c;
	}
	
	// Display GraphView
	public void display() {
		frame.setLocationRelativeTo(null);
		frame.setPreferredSize(new Dimension(FRAMEWIDTH, FRAMEHEIGHT));
		frame.pack();
		frame.setVisible(true);
	}
	
	@SuppressWarnings("serial")
	private class BarGraphComponent extends JComponent {
		private int x;
		private int y;
		private int width;
		protected int height;
		private Color col;
		
		public BarGraphComponent(int x, int y, int width, int height, Color col) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			this.col = col;
		}
		
		public void updateHeight(int h) {
			this.height = h;
		}
		
		public void paint(Graphics g) {
			Graphics2D column = (Graphics2D) g;
			if(col != null) {
				column.setColor(col);
			} else {
				height = 0;
			}
			column.fillRect(x, y, width, height);
		}
	}
}
