package pl.czerwinski.exception;

public class UserMissingException extends RuntimeException {

	public UserMissingException() {
		super("No user in the database ");
	}
}