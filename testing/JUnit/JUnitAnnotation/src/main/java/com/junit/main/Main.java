package com.junit.main;

import com.junit.model.PromoCode;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("JUnit5");
		
		PromoCode pRef = new PromoCode();
		pRef.getDiscount("JUMBO");
		System.out.println(pRef.getDiscount("JUMBO")); // 0.4
		System.out.println(pRef.getAmountAfterDiscount("TRYNEW", 1000)); // 950.0
		System.out.println(pRef.getAmountAfterDiscountWithTtaxes("SUNDAY", 1000)); // 885.0
		
	}
}
