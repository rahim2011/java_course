package az.developia.book_project.handlers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import az.developia.book_project.exception.OurRuntimeException;



public class Handlers {
	@RestControllerAdvice
	public class ExceptionHandlers {
	@ExceptionHandler
	@ResponseStatus(code =HttpStatus.BAD_REQUEST )
	public ExceptionResponse handler(OurRuntimeException exc) {
		
		ExceptionResponse response=new ExceptionResponse();
		
		BindingResult br = exc.getBr();
		if(br==null) {
			
		}
		else {
			List<FieldError> fieldErrors = br.getFieldErrors();
		
			}
			response.setValidations(FieldErrors);
		}
	
		response.setMessage(exc.getMessage());
		return response;
	}
}
