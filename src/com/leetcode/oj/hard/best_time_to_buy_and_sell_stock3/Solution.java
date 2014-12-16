package com.leetcode.oj.hard.best_time_to_buy_and_sell_stock3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.leetcode.oj.tools.ArrayTools;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two
 * transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (ie, you
 * must sell the stock before you buy again).
 * 
 * 这个题没想到是用DP做出来的，最后需要用点心。。。推出来点公式才能做出来。。。挺难的。
 * 
 * @author Telis
 * 
 */
public class Solution {

	// int result;

	public static void main(String[] args) {
		// new Solution().maxProfit(new int[] { 1, 2, 1, 3, 4, 1, 1, 2, 3, 4 });
		// new Solution().maxProfit(new int[] { 1, 2, 3, 4, 5, 6 });
		// new Solution().maxProfit(new int[] { 1, 1, 1, 1, 1, 1, 1 });
		// new Solution().maxProfit(new int[] { 2, 1 });
		// new Solution().maxProfit(new int[] { 1, 2 });
		// new Solution().maxProfit(new int[] { 3, 2, 6, 5, 0, 3 });
		new Solution().maxProfit(new int[] { 1, 2, 4, 2, 5, 7, 2, 4, 9 });
	}

	// f[k, ii] represents the max profit up until prices[ii] (Note: NOT ending
	// with prices[ii]) using at most k transactions.
	// f[k, ii] = max(f[k, ii-1], prices[ii] - prices[jj] + f[k-1, jj]) { jj in
	// range of [0, ii-1] }
	// = max(f[k, ii-1], prices[ii] + max(f[k-1, jj] - prices[jj]))
	// f[0, ii] = 0; 0 times transation makes 0 profit
	// f[k, 0] = 0; if there is only one price data point you can't make any
	// money no matter how many times you can trade
	// if (prices.size() <= 1) return 0;
	/**
	 * @param prices
	 * 
	 * @return
	 */
	public int maxProfit(int[] prices) {
		if (prices.length < 2)
			return 0;
		int[][] results = new int[3][prices.length];
		for (int i = 1; i < results.length; i++) {
			int max = results[i - 1][0] - prices[0];
			for (int j = 1; j < results[i].length; j++) {
				results[i][j] = Math.max(results[i][j - 1], max + prices[j]);
				max = Math.max(max, results[i - 1][j] - prices[j]);
			}
		}
		ArrayTools.iter(results);
		return results[2][prices.length - 1];
	}
}
