package az.developia.book_project.dto;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidEmailValidator implements ConstraintValidator<ValidEmail,String> {
@Override
public boolean isValid(String email, ConstraintValidatorContext context) {
	 boolean result;
	 
	if(email !=null || !email.isEmpty()) {
		result =email.contains("@") && email.contains(".");
	}
	else {
		return false;
	}
	return result;
}





}
