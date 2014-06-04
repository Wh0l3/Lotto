package application;

import java.util.ArrayList;

public class LottoDraw {
	
	public LottoDraw(){}

	ArrayList<Integer> numbers = new ArrayList<Integer>();
	ArrayList<Integer> starNumbers = new ArrayList<Integer>();
	ArrayList<Integer> superStarNumber = new ArrayList<Integer>();

	// Adds a number to the <numbers> List
	public void setNumber(int number) {
		if (numbers.contains(number)) {
			return;
		}
		numbers.add(number);
	}

	// Adds a number to the <starNumbers> List
	public void setStarNumber(int number) {
		if (starNumbers.contains(number)) {
			return;
		}
		starNumbers.add(number);
	}

	// Adds a number to the <superStarNumber> List
	public void setSuperStarNumber(int number) {
		if (superStarNumber.contains(number)) {
			return;
		}
		superStarNumber.add(number);
	}

	// Deletes a number from the <number> List
	public void deleteNumber(int number) {
		if (numbers.contains(number)) {
			numbers.remove(number);
		}
	}

	// Deletes a number from the <starNumber> List
	public void deleteStarNumber(int number) {
		if (starNumbers.contains(number)) {
			starNumbers.remove(number);
		}
	}

	// Deletes a number from the <StarNumber> List
	public void deleteSuperStarNumber(int number) {
		if (superStarNumber.contains(number)) {
			superStarNumber.remove(number);
		}	
	}
}
