package application;

import java.util.ArrayList;

public class Play {
	public ArrayList<Integer> numbers;
	public ArrayList<Integer> starNumbers;
	public int superStarNumber;
	
	public ArrayList getNumbers(){
		return this.numbers;
	}
	
	public ArrayList getStarNumbers(){
		return starNumbers;
	}
	
	public int getSuperStarNumber(){
		return superStarNumber;
	}
	
	public void setNumbers(ArrayList numbers){
		this.numbers = numbers;
	}
	
	public void setStarNumbers(ArrayList numbers){
		this.starNumbers = numbers;
	}
	
	
	public void setSuperStarNumber(int number){
		this.superStarNumber = number;
	}
}
