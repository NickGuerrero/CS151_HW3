package guerrero.nicolas.hw3;

import java.awt.Color;

/**
 * Holds information about the application's numeric values
 * Follows the listener pattern: NumberView has inputs and update submits
 * them to NummberController, NumberController listens and formats them, and
 * NumberModel listens to update values. It then call updates to the views. 
 * @author Nicolas Guerrero
 */

public class NumberModel {
	private View[] views;
	protected String[] tags;
	protected Color[] colors;
	protected int[] fields;
	
	// Construct the model for holding values
	public NumberModel(String[] colorTags, Color[] trueColor) {
		if(colorTags.length == trueColor.length) {
			fields = new int[colorTags.length];
			tags = colorTags;
			colors = trueColor;
		} else {
			// If this is ever happens, kill the application immediately
			throw new RuntimeException();
		}
	}
	
	// Allows new views to be added, hard-coded to 2
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
