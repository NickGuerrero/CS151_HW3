package guerrero.nicolas.hw3;

import java.awt.Color;

public class NumberController {
	private NumberModel model;
	private NumberView numView;
	private GraphView barView;
	
	
	// GraphView listens to model, no controller involved
	public NumberController(String[] colorTags, Color[] trueColor) {
		model = new NumberModel(colorTags, trueColor);
		numView = new NumberView(colorTags, this);
		barView = new GraphView(model);
		View[] v = {numView, barView};
		model.addViews(v);
	}
	
	public void run() {
		barView.display();
		numView.display();
	}
	
	public void updateModel(String[] input) {
		Double carry;
		int[] fields = new int[input.length];
		for(int i = 0; i < input.length; i++) {
			try {
				carry = Double.valueOf(input[i]);
				fields[i] = carry.intValue();
			} catch(NumberFormatException e) {
				fields[i] = 0;
			}
		}
		model.update(fields);
	}
}
