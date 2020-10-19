package guerrero.nicolas.hw3;

import java.awt.Color;

/**
 * 
 * Project Specifications
 * 
 * @author Guerr
 *
 */
public class NumberApplication {
	public static void main(String[] args) {
		String[] tags = {"Red", "Green", "Blue"};
		Color[] colors = {Color.RED, Color.GREEN, Color.BLUE};
		NumberController app = new NumberController(tags, colors);
		app.run();
		
		/**
		NumberView test = new NumberView(3);
		GraphView other = new GraphView();
		test.display();
		other.display();
		**/
	}
}
