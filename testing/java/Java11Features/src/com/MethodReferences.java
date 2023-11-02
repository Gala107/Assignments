package com;

@FunctionalInterface
interface Register1 {
	void register();
}

@FunctionalInterface
interface Login1 {
	void login(String email, String password);
}

@FunctionalInterface
interface Taxes {
	double getAmountToPay(double amount);
}

class Authentication {
	static void registerUser() {
		System.out.println("Registering the User from Authentication class");
	}

	void loginUser(String userName, String pass) {
		if (userName.equals("123") && pass.equals("123")) {
			System.out.println("Log In Successfull...");
		} else {
			System.out.println("Log In Failed");

		}
	}
	
	double getFinalAmount(double amount) {
		return amount + 0.18*amount;
	}
}

class BookMovieTicketTask {
	static void bookTicket() {
		System.out.println("1. Please Pay 200");
		System.out.println("2. Ticket for the Movie Avengers Generated with seat #1 in row B");
		System.out.println("3. Email Sent");
		
	}
}

class Message {
	Message(String text, String phone) {
		System.out.println("Thank you. our text has been sent to " + phone);
	}
}

@FunctionalInterface
interface Notification {
	void notifyUser(String message, String phone);
}

/*
 * 3 ways to reference a method:
 * 1. Static method reference
 * 2. Instance method reference
 * 3. Constructor reference
 */
public class MethodReferences {

	public static void main(String[] args) {
		
		Register1 reg = () -> System.out.println("Registering the User from Lambda Expression");
		reg.register();
		
		// 1. Static Method Referencing
		Register1 reg1 = Authentication::registerUser;
		reg1.register();
		
		// 2. Instance Method Referencing
		Authentication auth = new Authentication();
		Login log = auth::loginUser;
		log.login("123", "123");
		
		// Best Instance Method Referencing
		Taxes tax = new Authentication()::getFinalAmount;
		System.out.println("Final Amount to Pay for 1200: " + tax.getAmountToPay(1200));
		System.out.println();
		
		// Since it is a separate Thread, it does run asynchronously
		Runnable run = BookMovieTicketTask::bookTicket;
		new Thread(run).start();
		System.out.println();
		
		// 3. Refers to Message constructor
		Notification note = Message::new;
		note.notifyUser("A new video has been released", "913 280 1232");
		
	}
}
