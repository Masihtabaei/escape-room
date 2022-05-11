package escapeRoom.GameLogic;

/**
 * 
 * <p>
 * Objects of this class represent the riddles in our escape rooms.
 * </p>
 * 
 * @author Marcel
 * 
 */
public class Riddle implements Comparable<Riddle> {

	protected String description;
	protected String correctAnswer;
	protected Difficulty difficulty;

	/**
	 * <p>
	 * This constructor can get used to instantiate this class and initialize the
	 * attributes.
	 * </p>
	 * 
	 * @param description   (a String object)
	 * @param correctAnswer (a String object)
	 * @param difficulty    (an enumeration of type Difficulty )
	 */
	public Riddle(String description, String correctAnswer, Difficulty difficulty) {
		this.description = description;
		this.correctAnswer = correctAnswer;
		this.difficulty = difficulty;
	}

	/**
	 * <p>
	 * Getter-method for the description-attribute
	 * </p>
	 * 
	 * @return a String-object representing the description of our riddle
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <p>
	 * Getter-method for the correctAnswer-attribute.
	 * </p>
	 * 
	 * @return a String-object representing the correct answer of the riddle
	 */
	public String getCorrectAnswer() {
		return correctAnswer;
	}

	/**
	 * <p>
	 * Getter-method for the difficulty-attribute.
	 * </p>
	 * 
	 * @return an enumeration of type Difficulty
	 */
	public Difficulty getDifficulty() {
		return difficulty;
	}

	@Override
	public int compareTo(Riddle o) {

		int compareResult = 0;
		if (this.difficulty.ordinal() > o.difficulty.ordinal())
			compareResult = +1;
		else if (this.difficulty.ordinal() < o.difficulty.ordinal())
			compareResult = -1;

		return compareResult;

	}

}
