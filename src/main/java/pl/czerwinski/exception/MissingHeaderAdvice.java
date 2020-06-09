package pl.czerwinski.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MissingHeaderAdvice {

	@ResponseBody
	@ExceptionHandler(MissingHeaderException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String missingHeaderHandler(MissingHeaderException ex) {
		return ex.getMessage();
	}
}
