package escapeRoom.UserInterface.Console;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import escapeRoom.GameLogic.Riddle;
import escapeRoom.GameLogic.EscapeRoom;
import escapeRoom.GameLogic.InvalidInputException;
import escapeRoom.UserInterface.UserInterface;

public class InOut implements UserInterface {

	private Scanner scanner;

	@Override
	public void showTheTitle(String title) {
		System.out.println("** Welcome to " + title + " **");
	}

	@Override
	public String promptForStartOrExit() {

		System.out.println("Please enter \"start\" to start the game or \"exit\" to exit the game: ");
		String input = scanner.next();
		return input;
//		boolean inputValid = false;
//		boolean readyToStart = false;
//
//		while (!inputValid) {
//			System.out.println("Please enter \"start\" to start the game or \"exit\" to exit the game: ");
//			String input = scanner.next();
//			if (input == null) {
//				showAnError("Please enter a valid value! You can try again: ");
//				break;
//			}
//			if (input.equalsIgnoreCase("start")) {
//				readyToStart = true;
//				inputValid = true;
//			} else if (input.equalsIgnoreCase("exit")) {
//				readyToStart = false;
//				inputValid = true;
//			} else {
//				showAnError("Please enter a valid value! You can try again: ");
//				break;
//			}
//		}
//		return readyToStart;

	}

	@Override
	public String promptForTeamname() {
		System.out.println("Please enter your team-name: ");
		String input = scanner.next();
		return input;
	}

	@Override
	public void showAnError(String message) {
		System.err.println("Error: " + message);
	}

	@Override
	public void showTheEscapeRooms(List<EscapeRoom> escapeRooms) {
		System.out.println("List of Escape-Rooms available in our Game: \n--------------------------");
		for (EscapeRoom escapeRoom : escapeRooms)
			System.out.println("ID: " + escapeRoom.getId() + "\nTitle: " + escapeRoom.getTitle() + "\nDescription: "
					+ escapeRoom.getDescription() + "\n--------------------------");

	}

	@Override
	public int promptForEscapeRoom() throws InvalidInputException {
		System.out.println("Please enter the ID of the escape-room you prefer to play: ");
		int idOfPreferredEscapeRoom = 0;
		try {
			idOfPreferredEscapeRoom = scanner.nextInt();
		} catch (InputMismatchException e) {
			throw new InvalidInputException();
		}
		return idOfPreferredEscapeRoom;
	}

	@Override
	public void showTheRiddle(Riddle riddle) {
		System.out.println(
				"Riddle Difficulty: " + riddle.getDifficulty() + "\nRiddle-Description: \n" + riddle.getDescription());
	}

	@Override
	public String promptForAnswer() {
		System.out.println("Please enter your answer: ");
		String input = scanner.next();
		return input;
	}

	@Override
	public void showTheResultOfAnAttempt(String message) {
		System.out.println("Result: " + message);
	}

	@Override
	public void showTheResultOfTheEscapeRoom(String message) {
		System.out.println("** " + message + " **");

	}

}
