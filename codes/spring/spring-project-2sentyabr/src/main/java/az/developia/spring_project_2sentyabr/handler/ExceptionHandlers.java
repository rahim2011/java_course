package az.developia.spring_project_2sentyabr.handler;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import az.developia.spring_project_2sentyabr.exception.OurRuntimeException;

@RestControllerAdvice
public class ExceptionHandlers {
@ExceptionHandler
@ResponseStatus(code =HttpStatus.BAD_REQUEST )
public String handler(OurRuntimeException exc) {
	
	BindingResult br = exc.getBr();
	if(br==null) {
		
	}
	else {
		
	}
	return exc.getBr().getFieldErrors().get(0).getDefaultMessage();
}
}
