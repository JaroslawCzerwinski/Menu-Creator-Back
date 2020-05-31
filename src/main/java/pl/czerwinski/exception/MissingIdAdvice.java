package pl.czerwinski.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MissingIdAdvice {

	@ResponseBody
	@ExceptionHandler(MissingIdException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public String missingIdHandler(MissingIdException ex) {
		return ex.getMessage();
	}
}
