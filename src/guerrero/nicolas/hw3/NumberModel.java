package guerrero.nicolas.hw3;

import java.awt.Color;

public class NumberModel {
	private View[] views;
	protected String[] tags;
	protected Color[] colors;
	protected int[] fields;
	
	// bars is the number of bars we're building
	public NumberModel(String[] colorTags, Color[] trueColor) {
		fields = new int[colorTags.length];
		tags = colorTags;
		colors = trueColor;
	}
	
	public void addViews(View[] v) {
		views = v;
	}
	
	// TODO: Observer pattern with views
	public void update(String[] values) {
		// Parse through the input
		for(int i = 0; i < values.length; i++) {
			try {
				fields[i] = Integer.parseInt(values[i]);
			} catch(NumberFormatException e) {
				fields[i] = 0;
			}
		}
		// Update the views
		for(View v: views) {
			v.update(fields);
		}
	}
	
	// We only care about updating values, so we have a quick function for it
	public void update(int[] values){
		// Parse through the strings here instead of NumberView
		fields = values;
		
		// Update both views
		for(View v: views) {
			v.update(fields);
		}
	}
}
