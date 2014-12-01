package com.leetcode.oj.easy.best_time_to_buy_and_sell_stock_2;

import java.util.ArrayList;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock
 * multiple times). However, you may not engage in multiple transactions at the
 * same time (ie, you must sell the stock before you buy again).
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
		int[] prices = { 1, 5, 9, 6, 3, 4, 8, 7, 5, 1, 3, 2, 1, 4, 6, 5, 4, 8,
				4 };
		Solution s = new Solution();
		int profit = s.maxProfit(prices);
		System.out.println(profit);
	}

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1)
			return 0;
		int profit = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i] < prices[i + 1])
				profit += prices[i + 1] - prices[i];
		}
		return profit;
	}

	public int maxProfit1(int[] prices) {
		if (prices == null || prices.length <= 1)
			return 0;
		int[] sellBuy = new int[prices.length];
		int profit = 0;
		// ÕÒ²¨·å,²¨¹È
		for (int i = 1; i < sellBuy.length - 1; i++) {
			if (prices[i - 1] < prices[i] && prices[i] > prices[i + 1])
				sellBuy[i] = 1;
			if (prices[i - 1] > prices[i] && prices[i] < prices[i + 1])
				sellBuy[i] = -1;
		}
		if (prices[0] < prices[1])
			sellBuy[0] = -1;
		ArrayList<Integer> top = new ArrayList<>();
		ArrayList<Integer> bottom = new ArrayList<>();
		for (int i = 0; i < sellBuy.length; i++) {
			if (sellBuy[i] == 1) {
				top.add(prices[i]);
			}
			if (sellBuy[i] == -1) {
				bottom.add(prices[i]);
			}
		}
		for (int i = 0; i < top.size(); i++) {
			profit += Math.abs(top.get(i) - bottom.get(i));
		}
		return profit;
	}
}
