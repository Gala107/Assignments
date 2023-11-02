package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Product {
	String name;
	int price;
	double rating;

	Product() {

	}

	Product(String name, int price, double rating) {
		this.name = name;
		this.price = price;
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", rating=" + rating + "]";
	}
}

class EStore {

	ArrayList<Product> getProductsFromStore() {
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product("apple", 200, 2.3));
		products.add(new Product("pear", 100, 5.5));
		products.add(new Product("lemon", 150, 9.9));
		products.add(new Product("persimmon", 500, 10.5));

		return products;
	}
}

public class ComparatorAndLambda {

	public static void main(String[] args) {

		EStore estore = new EStore();
		List<Product> products = estore.getProductsFromStore();
		
		System.out.println("EStore Products");
		System.out.println("- - - - - - - - - - - - -");
		products.forEach(System.out::println);
		
		//  Collections.sort(products); --Compile ERROR
		Comparator<Product> com1 = new Comparator<Product>() {
			public int compare(Product o1, Product o2) {
				return o1.name.compareTo(o2.name);			}
		};
		Collections.sort(products, com1);
		System.out.println();
		System.out.println("EStore Products After Sort by Name");
		System.out.println("- - - - - - - - - - - - -");
		products.forEach(System.out::println);
		
		// Using Lambda Expressions
		Comparator<Product> lamCom = (o1, o2) -> o1.name.compareTo(o2.name);
		Collections.sort(products, lamCom);
		
		// Simplified Lambda Expressions
		Collections.sort(products, (o1, o2) -> o2.price - o1.price);
		System.out.println();
		System.out.println("EStore Products After Sorting by Price by Simplified Lambda Expression");
		System.out.println("- - - - - - - - - - - - -");
		products.forEach(System.out::println);
		
		Collections.sort(products, (o1, o2) ->(int)(o1.rating - o2.rating));
		System.out.println();
		System.out.println("EStore Products After Sorting by Rating by Simplified Lambda Expression");
		System.out.println("- - - - - - - - - - - - -");
		products.forEach(System.out::println);

	}

}
