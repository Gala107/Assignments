package com.junit.test;

import com.junit.model.PromoCode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

import static java.time.Duration.ofMinutes;

public class MainTest {

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
		System.out.println("[MainTest] testDiscount");
	}

	@Test
	public void testAmountDiscount() {
		String pCode = "TRYNEW";
		double amount = 1000;
		double expectedDiscount = 950.0;

		assertEquals(expectedDiscount, promoCode.getAmountAfterDiscount(pCode, amount));
		System.out.println("[MainTest] testAmountDiscount");
	}

	@Test
	public void testAmountDiscountWithTaxes() {
		String pCode = "SUNDAY";
		double amount = 1000;
		double expectedDiscount = 885.0;

		assertEquals(expectedDiscount, promoCode.getAmountAfterDiscountWithTtaxes(pCode, amount));
		System.out.println("[MainTest] testAmountDiscountWithTaxes");
	}

	@Test
	public void basicTest() {
		assertEquals(0.4, promoCode.getDiscount("JUMBO"));
		assertEquals(0.4, promoCode.getDiscount("TRYNEW90"), "Sorry! This Promo Code isn't available.");
		System.out.println("[MainTest] basicTest");
	}

	@Test
	public void groupTest() {
		assertAll("Promo Code Discount is 0.40", () -> assertEquals(0.4, promoCode.getDiscount("JUMBO")),
				() -> assertEquals(0.4, promoCode.getDiscount("TRYNEW90")));
		System.out.println("[MainTest] groupTest");
	}

	@Test public void testLuckyNumber() { 
		Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, ()->promoCode.luckyPromoCode(7)); 
		//System.out.println("Message: " + exception.getMessage()); 
		assertEquals("Index 7 out of bounds for length 5", exception.getMessage()); 
		System.out.println("[MainTest] testLuckyNumber");
	}

	@Test
	public void testWithTimeout() {
		double amount = assertTimeout(ofMinutes(1), () -> { return promoCode.getAmountAfterDiscount("SUNDAY", 1000); });
		assertEquals(750.0, amount);
		System.out.println("[MainTest] testWithTimeout");
	}

	@BeforeAll
	static void initAll() {
		System.out.println("[MainTest] Before All - initAll");

	}

	@BeforeEach
	void init() {
		System.out.println("[MainTest] Before Each - init");
	}

	@Test
	void myTest1() {
		System.out.println("[MainTest] Test Case1- myTest1");
		// fail("Test Case Failed");
	}
	
	@Test
	@Disabled
	void myTest3() {
		System.out.println("[MainTest] Test Case3 - myTest3");
	}

	@AfterEach
	void destroy() {
		System.out.println("[MainTest] After Each - destroy");
	}

	@AfterAll
	static void destroyAll() {
		System.out.println("[MainTest] After All - destroyAll");
	}
}
