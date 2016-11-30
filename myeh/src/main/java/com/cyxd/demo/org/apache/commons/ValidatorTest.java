package com.cyxd.demo.org.apache.commons;

import org.apache.commons.validator.GenericValidator;


public class ValidatorTest {

    public static void main(String[] args) {
	
	System.out.println(GenericValidator.isBlankOrNull(""));
	System.out.println(GenericValidator.isBlankOrNull("ss"));
	System.out.println(GenericValidator.isBlankOrNull(" s s "));
	
	System.out.println(GenericValidator.maxLength(" ss", 3));
	System.out.println(GenericValidator.maxLength(" s我", 3));
	
	
    }
    
    

}
