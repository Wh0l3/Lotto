package application;


import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "application")
public class LottoTrans{

	private int validGames;
	private int playedGames;
	private ArrayList plays;
	private String playedDate;
	
	
	
	public String getPlayedDate() {
		return playedDate;
	}
	public void setPlayedDate(String playedDate) {
		this.playedDate = playedDate;
	}
	
	public ArrayList getPlays() {
		return plays;
	}
	public void setPlays(ArrayList plays) {
		this.plays = plays;
	}
	
	
	public int getPlayedGames() {
		return playedGames;
	}
	public void setPlayedGames(int playedGames) {
		this.playedGames = playedGames;
	}
	
	
	public int getValidGames() {
		return validGames;
	}
	public void setValidGames(int validGames) {
		this.validGames = validGames;
	}
	
	
	
}
