package escapeRoom.GameLogic;

public class InvalidInputException extends Exception {

	private static final long serialVersionUID = 203393814636969656L;

	public InvalidInputException() {
		super();
	}

	public InvalidInputException(String message) {
		super(message);
	}
}
