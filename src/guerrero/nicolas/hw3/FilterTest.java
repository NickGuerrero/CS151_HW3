package guerrero.nicolas.hw3;

/**
 * Exercise 1
 * Simple implementation of lambda filters, followed by test cases to
 * prove that the filters work. Similar to the way lambdas were supplied
 * in the examples.
 * @author Nicolas Guerrero
 */
public class FilterTest {
	public static void main(String[] args) {
		// Lambda Filters
		Filter<String> nineMin = (String s) -> s.length() >= 9;
		Filter<Integer> posiOnly = (Integer i) -> i >= 0;
		
		// Short test cases
		String[] testStrings = {"abc", "1234", "alphabet_soup", "exactly_9"};
		int[] testIntegers = {0, -1, 2, -3, 4, -5, 6, -7, -0};
		
		// Performing the tests
		String[] longStrings = filter(testStrings, nineMin);
		int[] positiveOnly = filter(testIntegers, posiOnly);
		
		// Test Results
		System.out.print("Original Integer Array: ");
		for(int i: testIntegers) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println("");
		System.out.print("Filtered Integer Array: ");
		for(int i: positiveOnly) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println("");
		System.out.print("Original String Array: ");
		for(String s: testStrings) {
			System.out.print(s);
			System.out.print(" ");
		}
		System.out.println("");
		System.out.print("Filtered String Array: ");
		for(String s: longStrings) {
			System.out.print(s);
			System.out.print(" ");
		}
		System.out.println("");
	}
	
	public static String[] filter(String[] a, Filter<String> f) {
		// Filter through the string array
		String[] temp = new String[a.length];
		int size = 0;
		for(String s: a) {
			if(f.accept(s)) {
				temp[size] = s;
				size++;
			}
		}
		
		// Copy the shortened array over
		String[] longStrings = new String[size];
		int index = 0;
		while(index < size) {
			longStrings[index] = temp[index];
			index++;
		}
		return longStrings;
	}
	
	public static int[] filter(int[] a, Filter<Integer> f) {
		// Filter through the array
		int[] temp = new int[a.length];
		int size = 0;
		for(int i: a) {
			if(f.accept(i)) {
				temp[size] = i;
				size++;
			}
		}
		
		// Copy the shortened array over
		int[] positiveNumbers = new int[size];
		int index = 0;
		while(index < size) {
			positiveNumbers[index] = temp[index]; 
			index++;
		}
		return positiveNumbers;
	}
}