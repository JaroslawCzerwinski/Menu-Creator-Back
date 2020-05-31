package pl.czerwinski.exception;

public class MissingIdException extends RuntimeException {

	public MissingIdException() {
		super("Missing Id, operation fail");
	}
}
