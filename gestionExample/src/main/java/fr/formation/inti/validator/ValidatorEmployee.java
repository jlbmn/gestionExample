package fr.formation.inti.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.formation.inti.entity.Employee;

@Component
public class ValidatorEmployee implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz == Employee.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		Employee employee = (Employee) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "notEmpty.firstName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "notEmpty.lastName");
		
	}

}
