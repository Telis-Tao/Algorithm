package com.bupt.dynamic_programming;

import com.leetcode.oj.tools.ArrayTools;

public class BinPacking {
	private static int[] values = { 3, 4, 5, 7, 8, 2 };
	private static int[] weights = { 5, 4, 6, 4, 7, 2 };

	public static void main(String[] args) {
		BinPacking b = new BinPacking();
		b.packing(12);
	}

	public void packing(int maxWeight) {
		int[][] results = new int[values.length][maxWeight + 1];
		for (int i = 0; i <= maxWeight; i++) {
			if (weights[0] < i) {
				results[0][i] = values[0];
			}
		}

		for (int i = 1; i < values.length; i++) {// 前i个石头
			int max = values[0];
			for (int j = 0; j <= maxWeight; j++) {// 最大重量为j
				if (weights[i] <= j) {
					max = Math.max(results[i - 1][j - weights[i]] + values[i],
							results[i - 1][j]);
					results[i][j] = max;
				}else{
					results[i][j] = results[i-1][j];
				}
			}
		}
		ArrayTools.iter(results);
	}
}
