package com;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MovieTicket{
	
	static int ticketNumber = 1;
	
	String movieName;
	String seatNumber;
	boolean isTicketBooked;
	String emailUser;
	public MovieTicket() {
	}
	
	public MovieTicket(String movieName, String seatNumber, boolean isTicketBooked, String emailUser) {
		this.movieName = movieName;
		this.seatNumber = seatNumber;
		this.isTicketBooked = isTicketBooked;
		this.emailUser = emailUser;
	}

	@Override
	public String toString() {
		return "MovieTicket [movieName=" + movieName + ", seatNumber=" + seatNumber + ", isTicketBooked="
				+ isTicketBooked + ", emailUser=" + emailUser + "]";
	}	
}

class MovieTicketBookingTask implements Callable<String> {
	
	MovieTicket ticket;
	
	public MovieTicketBookingTask(MovieTicket ticket) {
		this.ticket = ticket;
	}

	@Override
	public String call() throws Exception {	
		ticket.seatNumber = "A" + MovieTicket.ticketNumber;
		MovieTicket.ticketNumber++;
		ticket.isTicketBooked = true;
		System.out.println("Paying for the Ticket Seat " + ticket.seatNumber + " for user: " + ticket.emailUser);	
		//Thread.sleep(2000);
		System.out.println("Ticket Booked for " + ticket.emailUser + " with seat number: " + ticket.seatNumber);
		System.out.println();
		
		return "[Future] Ticket Booked for " + ticket.emailUser + " with seat number: " + ticket.seatNumber;
	}
	
}

public class CallableFuture {

	public static void main(String[] args) {
		
		System.out.println("Movie Ticket Booking App Started");
		
		MovieTicket ticket1 = new MovieTicket("Avengers", "", false, "gala@me.com");
		MovieTicket ticket2 = new MovieTicket("Avengers", "", false, "joe@me.com");
		MovieTicket ticket3 = new MovieTicket("Avengers", "", false, "jennie@me.com");
		MovieTicket ticket4 = new MovieTicket("Avengers", "", false, "jackson@me.com");
		MovieTicket ticket5 = new MovieTicket("Avengers", "", false, "justin@me.com");
		
		System.out.println("ticket1: " + ticket1);
		System.out.println("ticket2: " + ticket2);
		System.out.println("ticket3: " + ticket3);
		System.out.println("ticket4: " + ticket4);
		System.out.println("ticket5: " + ticket5);
		
		System.out.println("Processors: " + Runtime.getRuntime().availableProcessors());
		
		Callable<String> task1 = new MovieTicketBookingTask(ticket1);
		Callable<String> task2 = new MovieTicketBookingTask(ticket2);
		Callable<String> task3 = new MovieTicketBookingTask(ticket3);
		Callable<String> task4 = new MovieTicketBookingTask(ticket4);
		Callable<String> task5 = new MovieTicketBookingTask(ticket5);
		
		// Maintains thread pool of 2 threads
		ExecutorService service = Executors.newFixedThreadPool(2);
		// This is blocking execution. the code will not continue till .submit is done
		Future<String> future1 = service.submit(task1);
		Future<String> future2 = service.submit(task2);
		Future<String> future3 = service.submit(task3);
		Future<String> future4 = service.submit(task4);
		Future<String> future5 = service.submit(task5);
		
		try {
			System.out.println("Task 1 Result: " + future1.get());
			System.out.println("Task 2 Result: " + future2.get());
			System.out.println("Task 3 Result: " + future3.get());
			System.out.println("Task 4 Result: " + future4.get());
			System.out.println("Task 5 Result: " + future5.get());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		System.out.println("Movie Ticket Booking App Finished");
	}
}
