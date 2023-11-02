package com;

import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

	public static void main(String[] args) {

		List<Integer> nums = List.of(2, 3, 1, 5, 6, 7, 8, 9, 12);
		
		// Predicate is @FunctionalInterface with 1 method test(T t) to be implemented
		// The method returns true/false based on condition
		Predicate<Integer> even = n -> n % 2 == 0;
		Predicate<Integer> odd = Predicate.not(even);
		nums.stream().filter(even).forEach(System.out::println);
		
		System.out.println();
		nums.stream().filter(odd).forEach(System.out::println);
	}
}
