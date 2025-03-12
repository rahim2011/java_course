package az.developia.spring_project_2sentyabr.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import az.developia.spring_project_2sentyabr.exception.OurRuntimeException;

@RestControllerAdvice
public class ExceptionHandlers {
@ExceptionHandler
public String handler(OurRuntimeException exc) {
	return exc.getBr().getFieldErrors().get(0).getDefaultMessage();
}
}
