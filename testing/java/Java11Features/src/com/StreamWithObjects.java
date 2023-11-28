package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class OnlineUser {
	String name;
	List<OnlineProduct> cart;
	int total;
	
	public OnlineUser() {
	}
	
	public OnlineUser(String name, List<OnlineProduct> cart) {
		this.name = name;
		this.cart = cart;
	}	
	
	void showCart() {
		System.out.println(name + "'s CART");
		System.out.println("TOTAL PRODUCTS: " + cart.size());
		// cart.forEach(OnlineProduct::showProduct);
		
		// USING LAMBDA
//		cart.forEach((product) -> {
//			total += product.price;
//			product.showProduct();
//		});
		
		cart.forEach(OnlineProduct::showProduct);
		
		// USING STREAM
		Optional<OnlineProduct> temp = cart.stream().reduce((p1, p2) -> {
			OnlineProduct p = new OnlineProduct();
			p.price = p1.price + p2.price; 
			return p;
			});
		total = temp.get().price;
		System.out.println("TOTAL: " + total);
	}
}

class OnlineProduct {
	String name;
	String brand;
	int price;

	public OnlineProduct() {
	}

	public OnlineProduct(String name, String brand, int price) {
		this.name = name;
		this.brand = brand;
		this.price = price;
	}

	void showProduct() {
		System.out.println("----------------------------------");
		System.out.println(name + "\t" + brand + "\t" + price);
		System.out.println("----------------------------------");
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", brand=" + brand + ", price=" + price + "]";
	}
}

class OnlineStore {
	ArrayList<OnlineProduct> products;

	public OnlineStore() {
		products = new ArrayList<OnlineProduct>();
		products.add(new OnlineProduct("pomergranate", "fudgi", 3));
		products.add(new OnlineProduct("apple", "fudgi", 2));
		products.add(new OnlineProduct("pear", "bosh", 5));
		products.add(new OnlineProduct("lemon", "large", 9));
		products.add(new OnlineProduct("persimmon", "local", 10));
	}

	void showProductsInStore() {
		products.forEach((product) -> product.showProduct());
	}

	void filterProductsInPriceRange(int fromPrice, int toPrice) {

		// LAMBDA EXPRESSION
//		products.forEach((product) -> {
//			if (product.price >= fromPrice && product.price <= toPrice) {
//				product.showProduct();
//			}
//		});

		// USING STREAM WOW! SO COOL!
		products.stream()
			.filter((product) -> product.price >= fromPrice && product.price <= toPrice)
			.forEach(OnlineProduct::showProduct);
	}
	
	void showProductsToPrimeMember() {
		int flatDiscount = 2;
//		Stream<OnlineProduct> stream = products.stream();
//		Stream<OnlineProduct> mappedProducts = stream.<OnlineProduct>map((product) -> {product.price -= flatDiscount; return product;});	
//		mappedProducts.forEach(OnlineProduct::showProduct);	
		
		// SIMPLIFIED ABOVE CODE
		products.stream()
			.<OnlineProduct>map((product) -> {product.price -= flatDiscount; return product;})
			.forEach(OnlineProduct::showProduct);		
	}
}

public class StreamWithObjects {

	public static void main(String[] args) {

		OnlineStore store = new OnlineStore();
		System.out.println("ALL PRODUCTS");
		store.showProductsInStore();
		
		System.out.println();
		System.out.println("--------------------------------------------------");
		System.out.println();
		
		System.out.println("FILTERED PRODUCTS");
		store.filterProductsInPriceRange(3, 5);
		
		System.out.println();
		System.out.println("--------------------------------------------------");
		System.out.println();
		
		System.out.println("MAPPED PRODUCTS");
		store.showProductsToPrimeMember();
		
		System.out.println();
		System.out.println("--------------------------------------------------");
		System.out.println();
		
		List<OnlineProduct> shoppingCart = store.products.subList(2, 4);
		OnlineUser user = new OnlineUser("John", shoppingCart);
		user.showCart();
	}
}
