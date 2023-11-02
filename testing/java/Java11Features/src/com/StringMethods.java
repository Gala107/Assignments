package com;

public class StringMethods {

	public static void main(String[] args) {

		String test = " Hello ";
		
		System.out.println("str repeated :" + test.repeat(5));
		
		System.out.println("removed front white space :" + test.stripLeading());
		System.out.println("removed back white space: " + test.stripTrailing());
		
		test = " hello again   ";
		System.out.println("removed front/back white space :" + test.strip());
		
		test = "";
		System.out.println("is blank? : " + test.isBlank());
		
		test = "      ";
		System.out.println("is blank? : " + test.isBlank());
		
		test = null;
		//System.out.println("is blank? : " + test.isBlank());  throws exception
		
		
	}

}
