package escapeRoom.GameLogic;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Vector;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Julius Herpich
 */
public class EscapeRoom {
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
	private int currentRiddleIndex;
	private String riddlesFile;

	public EscapeRoom(
			int id,
			String title,
			String description,
			String winMessage,
			String gameOverMessage,
			int maximumChances,
			int riddlesAmount,
			String riddlesFile) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.winMessage = winMessage;
		this.gameOverMessage = gameOverMessage;
		this.MaximumChances = maximumChances;
		this.riddlesAmount = riddlesAmount;
		this.riddlesFile = riddlesFile;
		this.finalPassword = generatePassword(riddlesAmount);
		this.unlockedPasswordParts = new Character[riddlesAmount];
		this.riddles = generateRiddles(riddlesAmount);
	}
	
	/**
	 * Helper Method, generates a random char array of desired length
	 * @param int
	 */
	private Character[] generatePassword(int length) {
		// allowed characters
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Character[] out = new Character[length];
        
		// replace all empty entries with a random char
		for (int i = 0; i < length; i++) {
        	out[i] = chars.charAt((int) (Math.random()*chars.length()));
        }
        
        return out;
	}
	
	/**
	 * Fills riddles vector with dynamically generated riddles using riddles.json for parameters
	 * @param length int desired amount of riddles
	 */
	private Vector<Riddle> generateRiddles(int length) {
		Vector<Riddle> vec = new Vector<Riddle>();
		// container map for json input
		Map<?, ?> inputMap = null;
		// riddle parameters to fill later
		String description = null;
		String correctAnswer = null;
		Difficulty difficulty = null;
		
		for (int i = 0; i < length; i++) {
    	    // create object mapper instance
    	    ObjectMapper mapper = new ObjectMapper();
    	    
    	    try {
    			// convert JSON file to map
    			inputMap = mapper.readValue(Paths.get("src/escapeRoom/GameLogic/" + this.riddlesFile).toFile(), Map.class);

    		} catch (Exception ex) {
    			ex.printStackTrace();
    		}
    	    
    	    // get Key Array and randomly select one
    		Object[] keyArray = inputMap.keySet().toArray();
    		String randomKey = (String) keyArray[(int) (Math.random()*keyArray.length)];
    		
    		// get entry, in this case riddle data, associated with the random key
    		Map<?, ?> riddleMap = (Map<?, ?>) inputMap.get(randomKey);
    		
    		// entries have to be cast before use
    		description = (String) riddleMap.get("description");
    		correctAnswer = (String) riddleMap.get("correctAnswer");
    		difficulty = Difficulty.valueOf((String) riddleMap.get("difficulty"));

			vec.add(new Riddle(description, correctAnswer, difficulty));
		}
		return vec;
	}
	
	
	/**
	 * Will sort riddles based on their compareTo() implementation
	 */
	public void sortByDifficulty() {
		Collections.sort(this.riddles);
	}
	
	/**
	 * Will sort riddles based comparator
	 * @param comparator Comparator<Riddle> custom comparator
	 */
	public void sortBy(Comparator<Riddle> comparator) {
		this.riddles.sort(comparator);
	}
	
	/**
	 * Checks wether the answer provided matches the riddle's correctAnswer attribute
	 * If correct, will fill one entry in unlockedPasswordParts from final Password
	 * @param comparator Comparator<Riddle> custom comparator
	 * @param r Riddle
	 * @param answer String
	 */
	public boolean tryRiddle(Riddle r, String answer) {
		this.currentRiddleIndex = this.riddles.indexOf(r);
		
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
	
	/**
	 * Helper method, picks an empty index in unlockedPasswordParts
	 */
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
	
	public Character[] getFinalPassword() {
		return finalPassword;
	}
	
	public String getFinalPasswordString() {
		StringBuilder builder = new StringBuilder();
		for (Character c : finalPassword)
			builder.append(c);
		return builder.toString();
	}

	public Character[] getUnlockedPasswordParts() {
		return unlockedPasswordParts;
	}
	
	public String getWinMessage() {
		return winMessage;
	}
	
	public String getGameOverMessage() {
		return gameOverMessage;
	}

	public int getMaximumChances() {
		return MaximumChances;
	}

	public Riddle getCurrentRiddle() {
		return riddles.get(currentRiddleIndex);
	}
	
	public void setCurrentRiddle(int currentRiddle) {
		this.currentRiddleIndex = currentRiddle;
	}

}
