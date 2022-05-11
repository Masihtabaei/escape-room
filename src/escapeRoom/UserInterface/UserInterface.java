package escapeRoom.UserInterface;

import java.util.List;

import escapeRoom.GameLogic.Riddle;
import escapeRoom.GameLogic.EscapeRoom;
import escapeRoom.GameLogic.InvalidInputException;

public interface UserInterface {

	/**
	 * <p>
	 * This method can be used to show the title of the game. Title should appear on
	 * the home-screen or at the beginning of your game.
	 * </p>
	 * 
	 * @param title (a String-object)
	 */
	void showTheTitle(String title);

	/**
	 * <p>
	 * This method can be used to ask whether the user want to start or exit the
	 * game.
	 * </p>
	 * 
	 * @return an integer-value representing the status of input (0: exit | 1:
	 *         start)
	 */
	String promptForStartOrExit();

	/**
	 * <p>
	 * This method can be used to ask the team-name of the user.
	 * </p>
	 * 
	 * @return a String-object representing the team-name of the user
	 */
	String promptForTeamname();

	/**
	 * <p>
	 * This method can be used to show an error message to the user.
	 * </p>
	 * 
	 * @param message (a String-object)
	 */
	void showAnError(String message);

	/**
	 * <p>
	 * This method can be used to show the escape rooms available in the game.
	 * </p>
	 * 
	 * @param escapeRooms (a List of escape-rooms available in the game)
	 */
	void showTheEscapeRooms(List<EscapeRoom> escapeRooms);

	/**
	 * <p>
	 * This method can be used to prompt the user to select an escape-room.
	 * </p>
	 * 
	 * @return an integer-value representing the ID of the selected escape-room.
	 * @throws InvalidInputException
	 */
	int promptForEscapeRoom() throws InvalidInputException;

	/**
	 * <p>
	 * This method can be used to show the current riddle.
	 * </p>
	 * 
	 * @param riddle (a Riddle object)
	 */
	void showTheRiddle(Riddle riddle);

	/**
	 * <p>
	 * This method can be used to prompt the user to provide an answer for the
	 * current riddle.
	 * </p>
	 * 
	 * @return a String-object representing the answer of the user.
	 */
	String promptForAnswer();

	/**
	 * <p>
	 * This method can be used to show the result of an answer/attempt (to respond
	 * to the input of the user)
	 * </p>
	 * 
	 * @param message(a String object)
	 */
	void showTheResultOfAnAttempt(String message);

	void showTheResultOfTheEscapeRoom(String message);

	void showTheFinalPassword(String finalPassword);
}
