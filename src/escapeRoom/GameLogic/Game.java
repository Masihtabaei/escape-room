package escapeRoom.GameLogic;

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

	public Game(String title) {
		this.title = title;
	}

	/**
	 * <p>
	 * This method can be used to initialize the Game.
	 * </p>
	 * 
	 */
	public void init() {
		userInterface = new InOut();
		userInterface.showTheTitle(title);
		begin();
	}

	/**
	 * <p>
	 * 
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
	 * 
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
	 * This method can be used...
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
			startTheEscapeRoom();
			solveTheEcapeRoom();
		} catch (InvalidInputException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <p>
	 * This method can be used...
	 * </p>
	 * 
	 */
	private void solveTheEcapeRoom() {
		String answer = userInterface.promptForAnswer();
		if (answer.equals(currentEscapeRoom.getCurrentRiddle().correctAnswer))
			userInterface.showTheResultOfAnAttempt("Your answer is correct. You solved this riddle!");
		else
			userInterface.showTheResultOfAnAttempt("Your answer is incorrect. Your team has: "
					+ team.getLeftChancesForCurrentEscapeRoom() + " chances left.");
		if (team.getLeftChancesForCurrentEscapeRoom() == 0) { // part of game class or escapeRoom class???
			currentEscapeRoom.getGameOverMessage();
			begin();
		}

	}

	/**
	 * <p>
	 * This method can be used to
	 * </p>
	 * 
	 */
	private void startTheEscapeRoom() {
		userInterface.showTheRiddle(currentEscapeRoom.getCurrentRiddle());
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

	/*
	 * private void showTheResultOfTheEscapeRoom(String message) {
	 * 
	 * }
	 */

}