package escapeRoom.GameLogic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RiddleTest {
	public static void main(String[] args) {
		Riddle firstRiddle = new Riddle("Wofür steht BMW?", "Antwort", Difficulty.MEDIUM);
		Riddle secondRiddle = new Riddle("Wann wurde zum ersten Mal Bier getrunken?", "aa", Difficulty.HARD);
		Riddle thirdRiddle = new Riddle("Test", "Test", Difficulty.EASY);

		List<Riddle> listOfRiddles = new ArrayList<Riddle>();
		listOfRiddles.add(firstRiddle);
		listOfRiddles.add(secondRiddle);
		listOfRiddles.add(thirdRiddle);

		for (Riddle riddle : listOfRiddles)
			System.out.println("Riddle: " + riddle.getDescription() + " Difficulty: " + riddle.getDifficulty());

		Collections.sort(listOfRiddles);
		
		System.out.println("---------------------------");
		for (Riddle riddle : listOfRiddles)
			System.out.println("Riddle: " + riddle.getDescription() + " Difficulty: " + riddle.getDifficulty());
	}
}
