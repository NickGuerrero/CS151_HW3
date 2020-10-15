package guerrero.nicolas.hw3;

/**
 * 
 * Project Specifications
 * 
 * @author Guerr
 *
 */
public class NumbersApplication {
	public static void main(String[] args) {
		NumberView test = new NumberView(3);
		GraphView other = new GraphView();
		test.display();
		other.display();
	}
}
