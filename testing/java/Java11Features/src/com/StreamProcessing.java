package com;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

/*
 * Stream was introduced in Java 8
 */
public class StreamProcessing {
	
	public static void main(String[] args) {
			
		Stream<Integer> stream1 = Arrays.asList(10, 11, 12, 13, 14, 15, 16, 17, 18, 20).stream();
		System.out.println("stream1 is " + stream1);
		
		// ALLMATCH METHOD
		// All numbers are equals or greater than 10, result is true
		// boolean result = stream1.allMatch((number) -> number >= 10);
		boolean result1 = stream1.allMatch((number) -> (number % 2 == 0));
		System.out.println("Result is " + result1);
		
		// REDUCE METHOD -  USING OPTIONAL TO SUM UP ALL ELEMENTS
		Stream<Integer> stream2 = Arrays.asList(10, 20, 30, 40).stream();
		Optional<Integer> optResult = stream2.reduce((num1, num2) -> num1 + num2);
		System.out.println(optResult);
		System.out.println(optResult.get());
		System.out.println();
		
		// FILTER METHOD - RETURNS STREAM
		Stream<Integer> stream3 = Arrays.asList(10, 20, 30, 40).stream();
		stream3 = stream3.filter((element) -> element >= 30);
		stream3.forEach(System.out::println);
		System.out.println();
		
		// MAP METHOD
		Stream<Integer> stream4 = Arrays.asList(10, 20, 30, 40).stream();
		stream4 = stream4.map((price) -> price - 200);
		stream4.forEach(System.out::println);		
	} 
}
