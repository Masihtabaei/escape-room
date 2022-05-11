package escapeRoom.GameLogic;

/**
 * <p>
 * The objects of this class represents the teams in our game.
 * </p>
 * 
 * @author Noah
 * @since 03.05.2022
 *
 */
public class Team {
	private String teamName;
	private int leftChancesForCurrentEscapeRoom;

	/**
	 * <p>
	 * This constructor can get used to instantiate this class and initialize the
	 * attributes.
	 * </p>
	 * 
	 * @param teamName (a String object)
	 * @param chances  (an integer value)
	 */
	public Team(String teamName, int chances) {
		this.teamName = teamName;
		leftChancesForCurrentEscapeRoom = chances;
	}

	/**
	 * <p>
	 * Getter-method for teamName-attribute
	 * </p>
	 * 
	 * @return a String object representing the team name
	 */
	public String getTeamName() {
		return teamName;
	}

	/**
	 * <p>
	 * Getter-method for leftChancesForCurrentEscapeRoom-attribute
	 * </p>
	 * 
	 * @return an integer value representing the left chances
	 */
	public int getLeftChancesForCurrentEscapeRoom() {
		return leftChancesForCurrentEscapeRoom;
	}

	/**
	 * <p>
	 * This method can get used to decrement the left chances.
	 * </p>
	 */
	public void decrementLeftChancesForCurrentEscapeRoom() {
		leftChancesForCurrentEscapeRoom--;
	}
}