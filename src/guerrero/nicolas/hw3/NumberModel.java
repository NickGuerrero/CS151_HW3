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
