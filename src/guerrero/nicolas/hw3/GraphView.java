package guerrero.nicolas.hw3;

import java.awt.*;
import java.awt.geom.Rectangle2D;

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
	private BarGraphComponent[] bars;
	private GridBagLayout layout;
	//private int width;
	//private int height;
	
	public GraphView() {
		// Set up the frame
		frame = new JFrame("Graph View");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		// Set up the panel
		barWindow = new JPanel();
		barWindow.setBackground(Color.WHITE);
		layout = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		barWindow.setLayout(layout);
		
		// Retrieve numbers
		
		// Example Components
		BarGraphComponent[] sample = {
				new BarGraphComponent(0, 0, 40, 100, Color.BLUE),
				new BarGraphComponent(0, 0, 40, 50, Color.RED),
				new BarGraphComponent(0, 0, 40, 150, Color.GREEN)
		};
		
		for(int i = 0; i < sample.length; i++) {
			JComponent current = (JComponent) sample[i];
			current.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);
			
			con.fill = GridBagConstraints.HORIZONTAL;
			con.gridx = i;
			con.gridy = 0;
			con.weightx = 1;
			con.weighty = 1;
			con.ipady = sample[i].height;
			con.insets = new Insets(0,30,5,0);
			con.anchor = GridBagConstraints.PAGE_END;
			
			barWindow.add(current, con);
		}
		frame.add(barWindow); //, BorderLayout.SOUTH);
	}
	
	public GraphView(NumberModel n) {
		// Set up the frame
		frame = new JFrame("Graph View");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		// Set up the panel
		barWindow = new JPanel();
		barWindow.setBackground(Color.WHITE);
		layout = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		barWindow.setLayout(layout);
		
		// Retrieve numbers
		numbers = n;
		bars = new BarGraphComponent[numbers.fields.length];
		for(int i = 0; i < numbers.fields.length; i++) {
			bars[i] = new BarGraphComponent(0, 0, 40, numbers.fields[i], numbers.colors[i]);
		}
		
		// Place bars into the gridbag
		for(int i = 0; i < bars.length; i++) {
			JComponent current = (JComponent) bars[i];
			current.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);
			
			con.fill = GridBagConstraints.HORIZONTAL;
			con.gridx = i;
			con.gridy = 0;
			con.weightx = 1;
			con.weighty = 1;
			con.ipady = bars[i].height;
			con.insets = new Insets(0,30,5,0);
			con.anchor = GridBagConstraints.PAGE_END;
			
			barWindow.add(current, con);
		}
		frame.add(barWindow);
	}
	
	public void update(int[] values) {
		for(int i = 0; i < bars.length; i++) {
			bars[i].updateHeight(values[i]);
			updateConstraint(i, bars[i]);
			bars[i].validate();
			bars[i].repaint();
		}
		barWindow.revalidate();
		barWindow.repaint();
	}
	
	// Redesign constraints
	public void updateConstraint(int index, BarGraphComponent c) {
		GridBagConstraints con = new GridBagConstraints();
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridx = index;
		con.gridy = 0;
		con.weightx = 1;
		con.weighty = 1;
		con.ipady = c.height;
		con.insets = new Insets(0,30,5,0);
		con.anchor = GridBagConstraints.PAGE_END;
		layout.setConstraints(c, con);
	}
	
	// Display GraphView
	public void display() {
		frame.setLocationRelativeTo(null);
		frame.setPreferredSize(new Dimension(300, 300));
		frame.pack();
		frame.setVisible(true);
	}
	
	@SuppressWarnings("serial")
	protected class BarGraphComponent extends JComponent {
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

	protected class BarIcon implements Icon {
		protected int width;
		protected int height;
		protected int spacing;
		protected Color color;
		
		public BarIcon() {
			width = 60;
			height = 100;
			spacing = 20;
			color = Color.blue;
		}
		
		public BarIcon(int width, int height, int separator) {
			this.width = width;
			this.height = height;
			this.spacing = separator;
			color = Color.red;
		}
		
		public int getIconWidth() {
			return width;
		}
		
		public int getIconHeight() {
			return height;
		}
		
		public void paintIcon(Component c, Graphics g, int x, int y) {
			Graphics2D g2 = (Graphics2D) g;
			Rectangle2D.Double rect = new Rectangle.Double(x + spacing, y, width, height);
			g2.setColor(color);
			g2.fill(rect);
		}
	}
}
