package com;

import java.util.Arrays;
import java.util.List;

/*
 * Rule for @FunctionalInterface: only 1 abstract method
 * Annotation indicates only one abstract method is allowed and 
 * will give a compile error if more than one abstract method is present
 */
@FunctionalInterface
interface Register {
	void register();
}

@FunctionalInterface
interface Login {
	void login(String email, String password);
}

@FunctionalInterface
interface PromoCode {
	double getDiscountWithPromoCode(int input, String promoCode);
}

class User implements Register {

	@Override
	public void register() {
		System.out.println("User Registered Implementing Interface and using Runtime Polymorphism");
	}
}

/*
 * Lambda Expressions can be written as business methods. However if the logic
 * is used in different places, better implement it in a separated class,
 * wouldn't you? So it can be re-used.
 */
public class LambdaAndFunctionalInterface {

	public static void main(String[] args) {

		// Old way : Runtime Polymorphism
		Register ref = new User();
		ref.register();

		// Old Way : Anonymous class
		Register ref1 = new Register() {
			public void register() {
				System.out.println("User Registered with Anonymous Class");
			}
		};
		ref1.register();

		// New Way : Lambda Expression
		Register ref2 = () -> System.out.println("User Registered with Labmda Expression");
		ref2.register();
		System.out.println();

		// Data type for variables is not mandatory
		// since it is defined in interface
		Login login = (email, password) -> {
			System.out.println("Connecting to DB");
			System.out.println("Validating User from DB");
			if (email.equals("gala@icloud.com") && password.equals("123")) {
				System.out.println("Thank you for Logging in with email " + email);
			} else {
				System.out.println("Login Failed. Please try again");
			}

		};
		login.login("gala@icloud.com", "123");
		
		// Lambda Expression
		PromoCode promo0 = (amount, promoCode) -> {
			return promoCode.equals("123") ? (amount -= 0.4 * amount) : (amount -= 0.1 * amount);
		};
		// Simplified Lambda Expression
		PromoCode promo = (amount, promoCode) -> promoCode.equals("123") ? (amount -= 0.4 * amount) : (amount -= 0.1 * amount);
		
		double amountToPay = promo.getDiscountWithPromoCode(2000, "123");
		System.out.println("Amount to pay: " + amountToPay);
		System.out.println();
		
		List<String> list = Arrays.asList("BINGO", "JUMBO", "THANKS");
		
		// 2 ways to print out list: 
		// 1. Lambda Expression 
		// 2. method reference in Lambda Expression
		list.forEach((code -> System.out.println(code)));
		System.err.println();
		list.forEach(System.out::println);
		System.out.println();
		
		// Implementations of Runnable @FunctionalInterface
		Runnable run = new Runnable() {
			public void run() {
				System.out.println("Hello from anynimous class method");
			}
		};
		
		// Lambda Expression
		Runnable run1 = () -> System.out.println("Hello for Lambda Expression method");
		// anonymous thread instance?
		new Thread(run1).start();
				
		
				

	}

}
