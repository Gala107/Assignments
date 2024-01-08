package com.junit.model;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class PromoCode {

	List<String> promoCodes;
	TreeMap<String, Double> promoCodesWithDiscount;

	public PromoCode() {
		promoCodes = Arrays.asList("JUMBO", "BINGO", "HAPPY50", "TRYNEW90", "SUNDAY");
		promoCodesWithDiscount = new TreeMap<String, Double>();
		promoCodesWithDiscount.put(promoCodes.get(0), 0.40);
		promoCodesWithDiscount.put(promoCodes.get(1), 0.20);
		promoCodesWithDiscount.put(promoCodes.get(2), 0.50);
		promoCodesWithDiscount.put(promoCodes.get(3), 0.40);
		promoCodesWithDiscount.put(promoCodes.get(4), 0.25);
	}

	public Double getDiscount(String promoCode) {
		return promoCodesWithDiscount.containsKey(promoCode) ? promoCodesWithDiscount.get(promoCode) : 0.05;
	}

	public Double getAmountAfterDiscount(String promoCode, double amount) {
		try {
			Thread.sleep(1500);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return promoCodesWithDiscount.containsKey(promoCode) ? (amount - amount * promoCodesWithDiscount.get(promoCode))
				: (amount - amount * 0.05);
	}

	public Double getAmountAfterDiscountWithTtaxes(String promoCode, double amount) {
		double amountAfterDiscount = getAmountAfterDiscount(promoCode, amount);
		return amountAfterDiscount + 0.18 * amountAfterDiscount;
	}
	
	public boolean checkPromoCode(String promoCode) {
		return promoCodes.contains(promoCode.toUpperCase());
	}
	
	public String luckyPromoCode(int luckyNumber) {
		return promoCodes.get(luckyNumber);
	}
}
