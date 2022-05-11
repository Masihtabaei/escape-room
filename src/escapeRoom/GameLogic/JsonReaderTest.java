package escapeRoom.GameLogic;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReaderTest {
	public static void main(String[] args) throws IOException {
		Map<?, ?> map = null;
		String description = null;
		String answer = null;
		Difficulty difficulty = null;
		
		// create object mapper instance
		ObjectMapper mapper = new ObjectMapper();

		try {

			// convert JSON file to map
			map = mapper.readValue(Paths.get("src/escapeRoom/GameLogic/riddles.json").toFile(), Map.class);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		Object[] keyArray = map.keySet().toArray();
		for (Object o : keyArray) {
			System.out.print(o);
		}
		String randomKey = (String) keyArray[(int) (Math.random()*keyArray.length)];
		System.out.println("\n" + keyArray.length  + "\t" + randomKey);
		Map<?, ?> riddleMap = (Map<?, ?>) map.get(randomKey);
		System.out.println("\n" + map.get(randomKey)  + "\t" + Difficulty.valueOf((String) riddleMap.get("difficulty")));
		System.out.println("\n" + (Difficulty.EASY == Difficulty.valueOf((String) riddleMap.get("difficulty"))));

	}
}