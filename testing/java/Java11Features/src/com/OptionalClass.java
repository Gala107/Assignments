package com;

import java.util.Optional;

class NewUser {
	String name;
	String phone; 
	String email;
	
	NewUser() {
		
	}
	
	public NewUser(String name, String phone, String email) {
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
}

public class OptionalClass {

	public static void main(String[] args) {
		
		NewUser u1 = new NewUser();
		NewUser u2 = new NewUser("John", "234 234 2344", "gala@icloue.dom");
		NewUser u3 = null;
		
		// No compile time error because 
		// reference variable will refer to object at Runtime
		// not Compile time
		//System.out.println("name in u3 is: " + u3.name.toUpperCase());
		//System.out.println("name in u1 is: " + u1.name.toUpperCase());
		//System.out.println("name in u2 is: " + u2.name.toUpperCase());	
		
		Optional<String> check = Optional.ofNullable(u1.name);
		if(check.isPresent()) {
			System.out.println("name in u1 is: " + u1.name.toUpperCase());
		} else {
			System.out.println("Sorry, name in u1 is null");
		}
		
		Optional<NewUser> checkUser = Optional.ofNullable(u3);
		if(checkUser.isPresent()) {
			System.out.println("name in u3 is; " + u3.name);
		} else {
			System.out.println("Sorry! u3 is null");
		}
		
		// Print data if it's not Null
		Optional checkU2 = Optional.ofNullable(u2.name);
		checkU2.ifPresent(System.out::println);
		
		// It will crush if u2.name is Null
		System.out.println("Name is: " + checkU2.get());

	}

}
