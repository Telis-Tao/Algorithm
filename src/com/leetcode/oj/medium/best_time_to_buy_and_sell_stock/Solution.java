package com.leetcode.oj.medium.best_time_to_buy_and_sell_stock;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 * @author Telis
 * 
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] i = { 2, 4, 1 };
		System.out.println(s.maxProfit(i));
	}

	public int maxProfit(int[] prices) {
		int current = 0;
		int max = 0;
		for (int i = 1; i < prices.length; i++) {
			current += prices[i] - prices[i - 1];
			if (current < 0)
				current = 0;
			else if (current > max)
				max = current;
		}
		return max;
	}
}
