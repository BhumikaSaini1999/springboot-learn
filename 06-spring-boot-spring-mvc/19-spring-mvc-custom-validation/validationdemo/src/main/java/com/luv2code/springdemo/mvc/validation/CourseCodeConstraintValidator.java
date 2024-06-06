package com.luv2code.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>{
	
	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();
	}
	
	// theCode here which is passed by user in the form
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		boolean result;
		
		if(theCode!=null) {
			result = theCode.startsWith(coursePrefix);
		}else {
			result = true;
		}
		return result;
	}

}
