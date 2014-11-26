package com.bupt.dynamic_programming;

/**
 * @author Telis
 * 
 */
public class MaxContinueSubstrSum {

	/**
	 * 给定K个整数的序列{ N1, N2, ..., NK }，其任意连续子序列可表示为{ Ni, Ni+1, ..., Nj }，其中 1 <= i
	 * <= j <= K。最大连续子序列是所有连续子序中元素和最大的一个， 例如给定序列{ -2, 11, -4, 13, -5, -2
	 * }，其最大连续子序列为{ 11, -4, 13 }，最大和为20
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = { -2, 11, -4, 13, -5, -2 };
		MaxContinueSubstrSum m = new MaxContinueSubstrSum();
		System.out.println(m.getSum(num));
	}

	public int getSum(int[] num) {
		int max = 0;
		int temp = num[0];
		for (int i = 1; i < num.length; i++) {
			if (temp < 0) {
				temp = num[i];
			} else {
				temp += num[i];
			}
			max = max > temp ? max : temp;
		}
		return max;
	}
}
