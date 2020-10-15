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
public class GraphView {
	private JFrame frame;
	//private int width;
	//private int height;
	
	public GraphView() {
		frame = new JFrame("Graph View");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		//frame.getContentPane().setLayout(new FlowLayout());
		//frame.getContentPane().getLayout().setAlignmentX(Component.BOTTOM_ALIGNMENT);

		//frame.setLayout(new FlowLayout());
		
		JPanel barWindow = new JPanel();
		barWindow.setBackground(Color.WHITE);
		//BoxLayout layout = new BoxLayout(barWindow, BoxLayout.X_AXIS);
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		barWindow.setLayout(layout);
		
		// Second argument must be dynamic on max
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
			
			barWindow.add(current, con);;
			//barWindow.add(current, BorderLayout.SOUTH);
		}
		
		frame.add(barWindow); //, BorderLayout.SOUTH);
		
		/**
		JPanel temp;
		for(BarGraphComponent sus: sample) {
			temp = new JPanel();
			temp.setLayout(new BoxLayout(temp, BoxLayout.Y_AXIS));
			//temp.setLayout(new BorderLayout());
			temp.setAlignmentY(Component.BOTTOM_ALIGNMENT);
			sus.setAlignmentY(Component.BOTTOM_ALIGNMENT);
			temp.add(sus);
			frame.add(temp);
		}
		**/
		
		//frame.add(barWindow);
		
		//frame.add(sample[0]);
		//frame.add(sample[1]);
		//frame.add(sample[2]);
		//frame.add(sample[3]);
		//frame.add(barWindow);
		
		/**
		JLabel sep = new JLabel(new BarIcon(40, 120, 1));
		sep.setVerticalAlignment(SwingConstants.BOTTOM);
		JLabel ses = new JLabel(new BarIcon(40, 30, 1));
		ses.setVerticalAlignment(SwingConstants.BOTTOM);
		JLabel set = new JLabel(new BarIcon(40, 40, 1));
		set.setVerticalAlignment(SwingConstants.BOTTOM);
		
		JPanel bep = new JPanel();
		bep.setAlignmentY(Component.TOP_ALIGNMENT);
		JPanel bes = new JPanel();
		bes.setAlignmentY(Component.TOP_ALIGNMENT);
		JPanel bet = new JPanel();
		bet.setAlignmentY(Component.TOP_ALIGNMENT);
		
		bep.add(sep);
		bes.add(ses);
		bet.add(set);
		
		frame.add(new JLabel(new BarIcon()));
		frame.add(bep);
		frame.add(bes);
		frame.add(bet);
		//frame.add(quick);
		 * **/
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
