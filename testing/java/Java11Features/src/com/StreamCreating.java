package com;

import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

public class StreamDemo {
	
	// How to create a stream
	// 1. Empty, not very useful
	Stream<String> stream1 = Stream.empty();
	
	// 2. From List
	Stream<String> stream2 = Arrays.asList("john@me.com", "jenny@me.com", "lenny@me.com", "ino@me.com", "gala@me.com").stream();
	
	// 3. From array
	String[] arr = {"john@me.com", "jenny@me.com", "lenny@me.com", "ino@me.com", "gala@me.com"};
	Stream<String> stream3= Arrays.stream(arr);
	
	String[] arr2 = new String[]{"john@me.com", "jenny@me.com", "lenny@me.com", "ino@me.com", "gala@me.com"};
	Stream<String> stream4= Arrays.stream(arr2);
	
	// 4. By passing values
	Stream<String> stream5 = Stream.of("john@me.com", "jenny@me.com", "lenny@me.com", "ino@me.com", "gala@me.com");
	
	// 5. Using Stream Builder
	Builder<String> builder = Stream.builder();
//	builder.add("john@me.com");
//	builder.add("jenny@me.com");
//	builder.add("jenny@me.com");
//	builder.add("ino@me.com");
//	builder.add("gala@me.com");
	Stream<String> stream6 = builder.build();
	
	// 6. Using generate on Stream to generate 30 integers 101
	Stream<Integer> stream7 = Stream.generate(() -> 101).limit(30);
	
	// 7. Using iterate and passing seed number, how to changed it by +2 and how many numbers: 20
	Stream<Integer> stream8 = Stream.iterate(100, (number) -> number + 2).limit(20);
	
	// Stream Iteration, once stream is processed, you CANNOT re-process it
//	stream2.forEach((element) -> System.out.pintln(element));
//	stream2.forEach(System.out::println);
	
}
