package az.developia.book_project.dto;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidEmailValidator implements ConstraintValidator<ValidEmail, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean result;
		if (value != null || !value.isEmpty()) {
			result = value.contains("@") && value.contains(".");
		}else {
			return false;
		}
		
		return result;
	}

}


