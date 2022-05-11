package escapeRoom.GameLogic;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <p>
 * This class contains the logic related to riddle and the riddles.
 * </p>
 * 
 * 
 *
 */
public class EscapeRoom {
	private int id;
	private String title;
	private String description;
	private String winMessage;
	private String gameOverMessage;
	private String finalPassword;
	private int maximumChances;
	private List<Riddle> riddles;

	/**
	 * <p>
	 * Constructor for initializing the attributes
	 * </p>
	 * 
	 * @param id
	 * @param title
	 * @param description
	 * @param winMessage
	 * @param gameOverMessage
	 * @param finalPassword
	 * @param maximumChances
	 * @param riddles
	 */
	public EscapeRoom(int id, String title, String description, String winMessage, String gameOverMessage,
			String finalPassword, int maximumChances, List<Riddle> riddles) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.winMessage = winMessage;
		this.gameOverMessage = gameOverMessage;
		this.finalPassword = finalPassword;
		this.maximumChances = maximumChances;
		this.riddles = riddles;
	}

	/**
	 * <p>
	 * Getter-method for ID-attribute
	 * </p>
	 * 
	 * @return integer value
	 */
	public int getId() {
		return id;
	}

	/**
	 * <p>
	 * Getter-method for title-attribute
	 * </p>
	 * 
	 * @return String object
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <p>
	 * Getter-method for description-attribute
	 * </p>
	 * 
	 * @return String object
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <p>
	 * Getter-method for winMessage-attribute
	 * </p>
	 * 
	 * @return String object
	 */
	public String getWinMessage() {
		return winMessage;
	}

	/**
	 * <p>
	 * Getter-method for gameOverMessage-attribute
	 * </p>
	 * 
	 * @return String object
	 */
	public String getGameOverMessage() {
		return gameOverMessage;
	}

	/**
	 * <p>
	 * Getter-method for finalPassword-attribute
	 * </p>
	 * 
	 * @return String object
	 */

	public String getFinalPassword() {

		return finalPassword;
	}

	/**
	 * <p>
	 * Getter-method for maximumChances-attribute
	 * </p>
	 * 
	 * @return an integer value
	 */
	public int getMaximumChances() {
		return maximumChances;
	}

	/**
	 * <p>
	 * Getter-method for currentRiddle-attribute
	 * </p>
	 * 
	 * @return a Riddle object
	 */
	public Riddle getCurrentRiddle() {
		Riddle currentRiddle = null;
		for (Riddle riddle : riddles)
			if (!riddle.checkIfSolved())
				currentRiddle = riddle;

		return currentRiddle;
	}

	/**
	 * <p>
	 * This method can get used to sort the riddles in an escape room by their
	 * natural order.
	 * </p>
	 */
	public void sortByDifficulty() {
		Collections.sort(riddles);
	}

	/**
	 * <p>
	 * This method can get used to sort the riddles in an escape room by the
	 * comparator given as parameter.
	 * </p>
	 * 
	 * @param comparator
	 */
	public void sortBy(Comparator<Riddle> comparator) {
		Collections.sort(riddles, comparator);
	}

}
