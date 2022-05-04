package escape_room;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

abstract class Riddle implements Comparable<Riddle>{
	public int difficulty;
	
	public int compare(Riddle r1,Riddle r2){
		return r1.difficulty-r2.difficulty;   
	}
	
	abstract boolean tryRiddle(String answer);
}


public class EscapeRoom {

	public int id;
	public String title;
	public String description;
	public String winMessage;
	public String gameOverMessage;
	//unlocked parts array combines to form final password
	private String[] finalPassword;
	public String[] unlockedPasswordParts;
	//Amount of chances before room fails
	public int MaximumChances;
	//Riddles and index
	private Vector<Riddle> riddles;
	private int currentRiddle;

	public EscapeRoom(int id, String title, String description, String winMessage, String gameOverMessage, String[] finalPassword, int maximumChances, Vector<Riddle> riddles) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.winMessage = winMessage;
		this.gameOverMessage = gameOverMessage;
		this.finalPassword = finalPassword;
		this.unlockedPasswordParts = new String[finalPassword.length];
		this.MaximumChances = maximumChances;
		this.riddles = riddles;
	}
	
	public void sortByDifficulty() {
		Collections.sort(this.riddles);
	}
	
	public void sortBy(Comparator<Riddle> comparator) {
		this.riddles.sort(comparator);
	}
	

	//#TODO: check if implementing this method here even makes sense
	public void tryRiddle(Riddle riddle, String answer) {
		Riddle r = this.riddles.get(this.riddles.indexOf(riddle));
		if (r.tryRiddle(answer)) {
			
			int i = pickRandomEmptyPart();
			if(i >= 0) {
				this.unlockedPasswordParts[i] = this.finalPassword[i];
			}
		} else {
		}
		
	}
	
	private int pickRandomEmptyPart() {
		Vector<Integer> emptyIndices = new Vector<Integer>();
		for (int i = 0; i < this.unlockedPasswordParts.length; i++) {
			if (this.unlockedPasswordParts[i] == null) {
				emptyIndices.add(i);
			}
		}
		if (emptyIndices.size() > 0) {
			return emptyIndices.get((int) (Math.random()*emptyIndices.size()));
		} else {
			return -1;
		}
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String[] getUnlockedPasswordParts() {
		return unlockedPasswordParts;
	}

	public int getMaximumChances() {
		return MaximumChances;
	}

	public Riddle getCurrentRiddle() {
		return riddles.get(currentRiddle);
	}
	
	public void setCurrentRiddle(int currentRiddle) {
		this.currentRiddle = currentRiddle;
	}

}
