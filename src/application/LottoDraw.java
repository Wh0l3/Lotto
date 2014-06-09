package application;

import java.util.ArrayList;

public class LottoDraw {
	
	public LottoDraw(){}

	ArrayList<Integer> numbers = new ArrayList<Integer>();
	ArrayList<Integer> starNumbers = new ArrayList<Integer>();
	int superStarNumber = -1;

	// Adds a number to the <numbers> List
	public boolean setNumber(int number) {
		if (numbers.contains(number)) {
			deleteNumber(number);
			System.out.print("Nummer gelöscht");
			return false;
		}
		if(numbers.size() < 5){
			numbers.add(number);
			System.out.print("Nummer hinzugefügt");
			return true;
		}
		return false;
	}

	// Adds a number to the <starNumbers> List
	public boolean setStarNumber(int number) {
		if (starNumbers.contains(number)) {
			deleteStarNumber(number);
			System.out.print("StarNummer gelöscht");
			return false;
		}
		if(starNumbers.size() < 2){
			starNumbers.add(number);
			System.out.print("StarNummer hinzugefügt");
			return true;
		}
		return false;
	}

	// Adds a number to the <superStarNumber> List
	public boolean setSuperStarNumber(int number) {
		if (superStarNumber == number) {
			deleteSuperStarNumber(number);
			System.out.print("SuperStarNummer gelöscht");
			return false;
		}
		if(superStarNumber == -1){
			superStarNumber = number;
			System.out.print("SuperStarNummer hinzugefügt");
			return true;
		}
		return false;
	}

	// Deletes a number from the <number> List
	public void deleteNumber(int number) {
		if (numbers.contains(number)) {
			numbers.remove(numbers.indexOf(number));
		}
	}

	// Deletes a number from the <starNumber> List
	public void deleteStarNumber(int number) {
		if (starNumbers.contains(number)) {
			starNumbers.remove(starNumbers.indexOf(number));
		}
	}

	// Deletes a number from the <StarNumber> List
	public void deleteSuperStarNumber(int number) {
		if (superStarNumber == number) {
			superStarNumber = -1;
		}	
	}
	
	public ArrayList<Integer> getNumbers(){
		return numbers;
	}
	
	public ArrayList<Integer> getStarNumbers(){
		return starNumbers;
	}
	
	public int getSuperStar(){
		return superStarNumber;
	}
}
