package escapeRoom.GameLogic;

public class EscapeRoomTest {

	public static void main(String[] args) {
		EscapeRoom e = new EscapeRoom(1, "Room", "This is Room 1", "fetter W", "fettes L", 5, 2);

		System.out.println(e.getId());
		System.out.println(e.getTitle());
		System.out.println(e.getDescription());
		System.out.println(e.getMaximumChances());
		Riddle r = e.getCurrentRiddle();
		System.out.println(r.getDescription());
		for (Character c : e.getUnlockedPasswordParts()) {
			System.out.print(c + "\t");
		}
		System.out.println();
		System.out.println(r.getCorrectAnswer());
		System.out.println(e.tryRiddle(r, "darum"));
		for (Character c : e.getUnlockedPasswordParts()) {
			System.out.print(c + "\t");
		}
		
	}

}
