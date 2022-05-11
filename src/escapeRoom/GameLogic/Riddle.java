package escapeRoom.GameLogic;

public class Riddle implements Comparable<Riddle> {

	
	protected String description;
	public String correctAnswer;
	protected Difficulty difficulty;

	public Riddle(String description, String correctAnswer, Difficulty difficulty) {
		this.description = description;
		this.correctAnswer = correctAnswer;
		this.difficulty = difficulty;
	}

	public String getDescription() {
		return description;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	@Override
	public int compareTo(Riddle o) {
		// return value = 0 -> this = o
		// return value > 0 -> this > o
		// return value < 0 -> this < o

		int compareResult = 0;
		if (this.difficulty.ordinal() > o.difficulty.ordinal())
			compareResult = +1;
		else if (this.difficulty.ordinal() < o.difficulty.ordinal())
			compareResult = -1;

		return compareResult;

	}
	
	public boolean tryAnswer (String answer) {
		if (answer.equals(this.correctAnswer)) {
			return true;
		} else {
			return false;
		}
	}

//	public String getDescription() {
//		return "Test (Riddle-Desc.)";
//	}
//
//	public Difficulty getDifficulty() {
//		return Difficulty.EASY;
//	}
}
