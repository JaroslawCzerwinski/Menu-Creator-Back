package pl.czerwinski.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserMissingAdvice {

	@ResponseBody
	@ExceptionHandler(UserMissingException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public String userMissingHandler(UserMissingException ex) {
		return ex.getMessage();
	}
}
