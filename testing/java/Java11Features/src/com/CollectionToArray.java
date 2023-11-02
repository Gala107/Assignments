package com;

import java.util.Arrays;
import java.util.List;

public class CollectionToArray {

	public static void main(String[] args) {
		
		// Make sure to specify type of list: <String>, otherwise it is assumed it's list of <Object>
		List<String> list = Arrays.asList("John", "Jenni", "Joe");
		
		// Old way
		String[] names = list.toArray(new String[list.size()]);
	
		// New way
		names = list.toArray(String[]::new);
		
		// :: method reference operator
		list.forEach(System.out::println);
	}

}

