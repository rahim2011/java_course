package az.developia.spring_project_2sentyabr.handler;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import az.developia.spring_project_2sentyabr.exception.OurRuntimeException;
import az.developia.spring_project_2sentyabr.response.ExceptionResponse;
import az.developia.spring_project_2sentyabr.response.ValidationResponse;

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
	//	List<ValidationResponse> validations=new ArrayList<ValidationResponse>();
	//	for(FieldError error:fieldErrors) {
		//	ValidationResponse validation=new ValidationResponse();
		//	validation.setField(error.getField());
		//	validation.setErorMessage(error.getDefaultMessage());
		//	validation.add(validation);
		}
		response.setValidations(FieldErrors);
	}
	//return exc.getBr().getFieldErrors().get(0).getDefaultMessage();
	response.setMessage(exc.getMessage());
	return response;
}
}
