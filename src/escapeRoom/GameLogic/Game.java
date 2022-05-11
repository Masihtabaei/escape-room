package escapeRoom.GameLogic;

import java.util.ArrayList;
import java.util.List;

import escapeRoom.UserInterface.UserInterface;
import escapeRoom.UserInterface.Console.InOut;

/**
 * 
 * <p>
 * This class is responsible for the game logic.
 * </p>
 * 
 * @author Anton
 * @since 03.05.2022
 *
 */
public class Game {
	private String title;
	private Team team;
	private UserInterface userInterface;
	private List<EscapeRoom> escapeRooms;
	private EscapeRoom currentEscapeRoom;

	/**
	 * Constructor to initialize the attributes
	 * 
	 * @param title(a String-object)
	 */
	public Game(String title) {
		this.title = title;
		escapeRooms = new ArrayList<EscapeRoom>();
		userInterface = new InOut();

		EscapeRoom firstEscaoeRoom = new EscapeRoom(0, "General", "General questions", "You won!", "Game Over!",
				6, 3, "riddles_1.json");

		EscapeRoom secondEscapeRoom = new EscapeRoom(1, "Computer Science", "CS related questions", "You won!",
				"Game Over!", 6, 3, "riddles_2.json");

		escapeRooms.add(firstEscaoeRoom);
		escapeRooms.add(secondEscapeRoom);

		userInterface.showTheTitle(title);
		begin();
	}

	/**
	 * <p>
	 * This method can be used to begin playing the game or to exit the game.
	 * </p>
	 * 
	 */
	private void begin() {
		String responeOfStartOrExit = userInterface.promptForStartOrExit(); // Asking the user to start or exit the game
		if (responeOfStartOrExit.equalsIgnoreCase("start"))
			startTheGame();
		else
			System.exit(0);
	}

	/**
	 * <p>
	 * This method can be used to re-/start the game.
	 * </p>
	 * 
	 */
	private void startTheGame() {
		createATeam();
		showTheEscapeRooms();
		selectAnEscapeRoom();
		// when to show game win / game over message?
	}

	/**
	 * <p>
	 * This method can be used prompt the user to select an escape-room.
	 * </p>
	 * 
	 */
	private void selectAnEscapeRoom() {
		try {
			int inputId = userInterface.promptForEscapeRoom(); // user chooses an escape room
			for (EscapeRoom escapeRoom : escapeRooms) // searching for the users chosen escape room and saving it as the
														// 'currentEscapeRoom'
				if (escapeRoom.getId() == inputId)
					currentEscapeRoom = escapeRoom;
			playTheGame();
		} catch (InvalidInputException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <p>
	 * This method can get used to check the answer.
	 * </p>
	 * 
	 * @param answer
	 * @return boolean
	 */
	private boolean checkTheAnswer(String answer) {
		if (answer.equalsIgnoreCase(currentEscapeRoom.getCurrentRiddle().getCorrectAnswer()))
			return true;
		else
			return false;
	}

	/**
	 * <p>
	 * This method can be used to prompt the user to solve the escape-room.
	 * </p>
	 * 
	 */
	private void playTheGame() {
		Riddle currentRiddle = currentEscapeRoom.getCurrentRiddle();
		if (currentRiddle != null) {
			userInterface.showTheRiddle(currentRiddle);
			String answer = userInterface.promptForAnswer();
			boolean isCorrect = checkTheAnswer(answer);
			if (isCorrect) {
				userInterface.showTheResultOfAnAttempt("Congrat. Solved!");
				currentEscapeRoom.getCurrentRiddle().setIsSolved(true);
				playTheGame();
			} else {
				userInterface.showTheResultOfAnAttempt("Oops!");
				if (team.getLeftChancesForCurrentEscapeRoom() == 1) {
					userInterface.showTheResultOfTheEscapeRoom(currentEscapeRoom.getGameOverMessage());
					System.exit(0);
				} else {
					team.decrementLeftChancesForCurrentEscapeRoom();
					userInterface.showAnError("Try it again :)");
					playTheGame();
				}
			}
		} else {
			userInterface.showTheResultOfTheEscapeRoom(currentEscapeRoom.getWinMessage());
			userInterface.showTheFinalPassword(currentEscapeRoom.getFinalPasswordString());
			System.exit(0);
		}

	}

	/**
	 * <p>
	 * This method can be used to create a team.
	 * </p>
	 * 
	 */
	private void createATeam() {
		String teamName = userInterface.promptForTeamname();
		team = new Team(teamName, 3);
	}

	/**
	 * <p>
	 * This method can be used to show the available escape-rooms.
	 * </p>
	 * 
	 */
	private void showTheEscapeRooms() {
		userInterface.showTheEscapeRooms(escapeRooms);
	}

}