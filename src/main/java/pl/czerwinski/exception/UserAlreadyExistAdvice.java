package pl.czerwinski.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserAlreadyExistAdvice {

	@ResponseBody
	@ExceptionHandler(UserAlreadyExistException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public String userAlreadyExistHandler(UserAlreadyExistException ex) {
		return ex.getMessage();
	}
}
