package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCodeArray, String> {
	
	private String[] coursePrefixes;
	
	@Override
	public void initialize(CourseCodeArray courseCodeArray) {
		coursePrefixes = courseCodeArray.value();
	}

	@Override
	public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
		

		if (code != null) 
			for (String courseCode : coursePrefixes) {
				if (code.startsWith(courseCode))
					return true;
			}
		else
			return true;
		
		return false;
	}
	
}
