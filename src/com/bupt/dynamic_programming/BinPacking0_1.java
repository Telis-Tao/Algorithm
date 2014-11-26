package com.bupt.dynamic_programming;

import java.util.Arrays;

public class BinPacking0_1 {
	private static int[] values = { 20, 10, 12 };
	private static int[] weights = { 5, 4, 3 };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinPacking0_1 b = new BinPacking0_1();
		b.findMax(values, weights, 10);
	}

	public void findMax(int[] values, int[] weights, int maxValue) {
		int[] results = new int[values.length];
		int[][] max = new int[values.length][maxValue + 1];
		// max[i][j]:有i块石头的情况下拥有j容量背包时所获得的最大价值
		for (int j = 0; j <= maxValue; j++) {
			if (j >= weights[0]) {
				max[0][j] = values[0];
			}
		}
		for (int i = 1; i < values.length; i++) {
			for (int j = 0; j <= maxValue; j++) {
				max[i][j] = max[i - 1][j];
				if (j >= weights[i]) {
					max[i][j] = Math.max(max[i - 1][j], max[i - 1][j
							- weights[i]]
							+ values[i]);
				}
			}
		}
		iter(max);
		// 寻找放入的宝石序号
		int j = maxValue;
		for (int i = values.length - 1; i >= 0; i--) {
			if (i > 0) {
				if (max[i][j] > max[i - 1][j]) {
					results[i] = 1;
					j = j - weights[i];
				}
			} else {
				if (max[i][j] > 0) {
					results[i] = 1;
				}
			}
		}
		System.out.println(Arrays.toString(results));
	}

	public void iter(int[][] results) {
		for (int i = 0; i < results[0].length; i++) {
			System.out.print(i + "\t");
		}
		System.out.println();
		for (int i = 0; i < results.length; i++) {
			for (int j = 0; j < results[i].length; j++) {
				System.out.print(results[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
