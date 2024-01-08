package com.junit.test;

import com.junit.model.PromoCode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static java.time.Duration.ofMillis;

public class MainTest{
	
	PromoCode promoCode = new PromoCode();
	
	@Test
	public void testPromoCode() {
		assertEquals(true, promoCode.checkPromoCode("bingo"));
	}
	
	@Test
	public void testDiscount() {
		String pCode = "JUMBO";
		double expectedPromoCode = 0.4;
		
		assertEquals(expectedPromoCode, promoCode.getDiscount(pCode));				
	}
	
	@Test
	public void testAmountDiscount() {
		String pCode = "TRYNEW";
		double amount = 1000;
		double expectedDiscount = 950.0;
		
		assertEquals(expectedDiscount, promoCode.getAmountAfterDiscount(pCode, amount));
	}
	
	@Test
	public void testAmountDiscountWithTaxes() {
		String pCode = "SUNDAY";
		double amount = 1000;
		double expectedDiscount = 885.0;
		
		assertEquals(expectedDiscount, promoCode.getAmountAfterDiscountWithTtaxes(pCode, amount));
	}
	
	@Test
	public void basicTest() {
		assertEquals(0.4, promoCode.getDiscount("JUMBO"));
		assertEquals(0.4, promoCode.getDiscount("TRYNEW90"), "Sorry! This Promo Code isn't available.");
	}
	
	@Test
	public void groupTest() {
		assertAll("Promo Code Discount is 0.40", ()->assertEquals(0.4, promoCode.getDiscount("JUMBO")), ()->assertEquals(0.4, promoCode.getDiscount("TRYNEW90")));
	}
	
	@Test
	public void testLuckyNumber() {
		Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, ()->promoCode.luckyPromoCode(7));
		//System.out.println("Message: " + exception.getMessage());
		assertEquals("Index 7 out of bounds for length 5", exception.getMessage());
	}
	
	@Test
	public void testWithTimeout() {
		double amount = assertTimeout(ofMillis(1515), ()->{return promoCode.getAmountAfterDiscount("SUNDAY", 1000);});
		assertEquals(750.0, amount);
	}
}
