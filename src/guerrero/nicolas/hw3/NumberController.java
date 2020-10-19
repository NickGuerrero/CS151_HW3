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
		numView.display();
		barView.display();
	}
	
	public void updateModel(String[] input) {
		int[] fields = new int[input.length];
		for(int i = 0; i < input.length; i++) {
			try {
				fields[i] = Integer.parseInt(input[i]);
			} catch(NumberFormatException e) {
				fields[i] = 0;
			}
		}
		numView.update(fields);
		barView.update(fields);
	}
}
