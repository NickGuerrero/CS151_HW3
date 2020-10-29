package guerrero.nicolas.hw3;

// Used for observer pattern on views
// Got idea from https://www.tutorialspoint.com/design_pattern/observer_pattern.htm
public interface View {
	final int FRAMEHEIGHT = 300;
	final int FRAMEWIDTH = 300;
	abstract public void update(int[] values);
}
