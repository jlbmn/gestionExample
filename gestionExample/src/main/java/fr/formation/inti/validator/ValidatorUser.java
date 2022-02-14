package fr.formation.inti.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.formation.inti.entity.User;

@Component
public class ValidatorUser implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz == User.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "notEmpty.login");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "notEmpty.password");
		
	}
}
