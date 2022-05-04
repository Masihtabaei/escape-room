package escapeRoom.GameLogic;

public class Team {
	private String teamName;
	private int leftChancesForCurrentEscapeRoom;

	public Team(String teamName, int chances) {
		this.teamName = teamName;
		leftChancesForCurrentEscapeRoom = chances;
	}

	public String getTeamName() {
		return teamName;
	}

	public int getLeftChancesForCurrentEscapeRoom() {
		return leftChancesForCurrentEscapeRoom;
	}

	public void decrementLeftChancesForCurrentEscapeRoom() {
		leftChancesForCurrentEscapeRoom--;
	}
}