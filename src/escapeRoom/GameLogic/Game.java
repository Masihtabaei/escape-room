package escapeRoom.GameLogic;

import java.util.List;

import escapeRoom.UserInterface.UserInterface;
import escapeRoom.UserInterface.Console.InOut;

public class Game {
	private String title;
	private Team team;
	private UserInterface userInterface;
	private List<EscapeRoom> escapeRooms;

	public Game(String title) {
		this.title = title;
	}

	public void init() {
		userInterface = new InOut();
		userInterface.showTheTitle(title);
		String responeOfStartOrExit = userInterface.promptForStartOrExit();
		if (responeOfStartOrExit.equalsIgnoreCase("start"))
			createATeam();
		else
			System.exit(0);
	}

	private void createATeam() {
		String teamName = userInterface.promptForTeamname();
		team = new Team(teamName, 3);
	}

	private void showTheEscapeRoons() {
		// TODO Auto-generated method stub

	}

}
