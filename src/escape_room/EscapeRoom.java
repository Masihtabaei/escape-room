package escape_room;
import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class EscapeRoom {
	public final String[] riddleClasses = {"Riddle"};
	
	public int id;
	public String title;
	public String description;
	public String winMessage;
	public String gameOverMessage;
	
	//unlocked parts array combines to form final password
	private Character[] finalPassword;
	public Character[] unlockedPasswordParts;
	
	//Amount of chances before room fails
	public int MaximumChances;
	
	//Riddles and index
	public int riddlesAmount;
	private Vector<Riddle> riddles;
	private int currentRiddle;

	public EscapeRoom(int id,
			String title,
			String description,
			String winMessage,
			String gameOverMessage,
			int maximumChances,
			int riddlesAmount) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.winMessage = winMessage;
		this.gameOverMessage = gameOverMessage;
		this.MaximumChances = maximumChances;
		this.riddlesAmount = riddlesAmount;
		this.finalPassword = generatePassword(riddlesAmount);
		this.unlockedPasswordParts = new Character[riddlesAmount];
		this.riddles = generateRiddles(riddlesAmount);
	}
	
	private Character[] generatePassword(int length) {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Character[] out = new Character[length];
        
        for (Character c : out) {
        	c = chars.charAt((int) (Math.random()*length) - 1);
        }
        
        return out;
	}
	
	private Vector<Riddle> generateRiddles(int length) {
		Vector<Riddle> vec = new Vector<Riddle>();
		
		for (int i = 0; i < length; i++) {
			String className = this.riddleClasses[(int) (Math.random()*length) - 1];
			
			Class<?> clazz = Class.forName(className);
			Constructor<?> ctor = clazz.getConstructor(String.class);
			Object object = ctor.newInstance(new Object[] { ctorArgument });
		}
	}
	
	public void sortByDifficulty() {
		Collections.sort(this.riddles);
	}
	
	public void sortBy(Comparator<Riddle> comparator) {
		this.riddles.sort(comparator);
	}
	

	//#TODO: check if implementing this method here even makes sense
	public boolean tryRiddle(Riddle riddle, String answer) {
		Riddle r = this.riddles.get(this.riddles.indexOf(riddle));
		
		if (r.tryAnswer(answer)) {
			int i = pickRandomEmptyPart();
			
			if(i >= 0) {
				this.unlockedPasswordParts[i] = this.finalPassword[i];
			}
			
			 return true;
			 
		} else {
			return false;
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
			return emptyIndices.get((int) (Math.random()*emptyIndices.size()) - 1);
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

	public Character[] getUnlockedPasswordParts() {
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
