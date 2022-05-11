package escapeRoom.GameLogic;

import java.util.ArrayList;

public class EscapeRoomTest {

	public static void main(String[] args) {

		ArrayList<Riddle> firstSetOfRiddles = new ArrayList<Riddle>();

		Riddle firstRiddle = new Riddle("In which year did the corona-crisis beginn?", "2020", Difficulty.EASY);
		Riddle secondRiddle = new Riddle("In which year did Russia attack Ukraeine?", "2022", Difficulty.EASY);
		Riddle thirdRiddle = new Riddle("Which city is the capital of Germany?", "Berlin", Difficulty.EASY);
		Riddle fourthRiddle = new Riddle("What does Bier mean?", "Beer", Difficulty.EASY);
		Riddle fifthRiddle = new Riddle("What is your name?", "Masih", Difficulty.EASY);

		firstSetOfRiddles.add(firstRiddle);
		firstSetOfRiddles.add(secondRiddle);
		firstSetOfRiddles.add(thirdRiddle);
		firstSetOfRiddles.add(fourthRiddle);
		firstSetOfRiddles.add(fifthRiddle);

		EscapeRoom firstEscapeRoom = new EscapeRoom(0, "First Escape Room", "...", "You won!", "Game Over!", "Test", 3,
				firstSetOfRiddles);
		System.out.println(firstEscapeRoom.getId());
		System.out.println(firstEscapeRoom.getTitle());
		System.out.println(firstEscapeRoom.getDescription());
		System.out.println(firstEscapeRoom.getMaximumChances());
		Riddle r = firstEscapeRoom.getCurrentRiddle();
		System.out.println(r.getDescription());

	}

}
