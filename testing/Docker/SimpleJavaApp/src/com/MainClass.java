package com;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {

		System.out.println("Welcome to Lucky Number CashBack");
		int[] cashBack = {120, 200, 320, 500, 50, 80, 90, 1000};
		int luckyNumber = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Your Lucky Number");
		
		try {
			luckyNumber = scanner.nextInt();
		} catch (Exception e) {
			System.out.println("Sorry!! Input Mismatches");
		}
		
		System.out.println("For Your Lucky Number " + luckyNumber + " CashBack Earned is: " + cashBack[luckyNumber]);
		
		scanner.close();
		System.out.println("Thank you For Playing Lucky Number CashBack");

	}

}
