package com;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// Annotation below indicates that the interface has only 1 method to implement
// and can use lambda for implementation.
@FunctionalInterface
interface Testing {

	void doIt();
}

@interface NonNull {}

public class LambdaVar {
	// var test = "test"; // not allowed here, local

	public static void main(String... args) {
		// var is local but many people say not practical
		var test1 = "test";
		
		// Lambda is writing method in simplified form
		// FunctionalInterface
		Comparator<String> c = (lhs, rhs) -> {
			System.out.println("I am comparing: " + lhs + " to " + rhs);
			return lhs.compareTo(rhs);
		};
		int result = c.compare("Hello", "World");

		System.out.println(result);
		System.out.println();

		///////////////
		Integer i = 5;
		Testing test = () -> System.out.println(i.toString());
		test.doIt();
		System.out.println();

		///////////////
		StringBuilder message = new StringBuilder();
		Runnable r = () -> System.out.println(message);
		message.append("Howdy, ");
		message.append("world!");
		r.run();
		System.out.println();

		//////////////
		List<String> list = Arrays.asList("John", "Jennie", "Joe", "", "Peter");

		String names = list.stream().map((@NonNull var item) -> item.toUpperCase())
				.collect(Collectors.joining(", "));

		System.out.println(names);

	}

}
