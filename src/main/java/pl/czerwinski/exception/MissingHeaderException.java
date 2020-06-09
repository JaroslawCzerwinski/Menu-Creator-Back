package pl.czerwinski.exception;

public class MissingHeaderException extends RuntimeException {

	public MissingHeaderException() {
		super("Missing request header, operation fail");
	}
}
