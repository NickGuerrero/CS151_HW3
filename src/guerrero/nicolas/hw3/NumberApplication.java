package guerrero.nicolas.hw3;

import java.awt.Color;

/**
 * Exercise 2
 * Launch the bar graph application, which works over two windows. It creates the controller,
 * which then creates the two windows. The input window updates the output graph when the
 * submit button is clicked. This number is scaled by a factor available in GraphView.
 * @author Nicolas Guerrero
 */

public class NumberApplication {
	public static void main(String[] args) {
		String[] tags = {"Red", "Green", "Blue"};
		Color[] colors = {Color.RED, Color.GREEN, Color.BLUE};
		NumberController app = new NumberController(tags, colors);
		app.run();
	}
}
