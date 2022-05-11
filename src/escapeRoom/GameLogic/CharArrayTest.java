package escapeRoom.GameLogic;

public class CharArrayTest {

	public static void main(String[] args) {
		int length = 5;
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Character[] out = new Character[length];
        
        for (int i = 0; i < length; i++) {
        	out[i] = chars.charAt((int) (Math.random()*length));
        }
        
		System.out.println();

		for (Character c : out) {
			System.out.print(c + "\t");
		}
	}

}
