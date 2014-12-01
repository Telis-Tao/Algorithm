package com.leetcode.oj.easy.three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ¡Ü
 * b ¡Ü c) The solution set must not contain duplicate triplets. For example,
 * given array S = {-1 0 1 2 -1 -4},
 * 
 * A solution set is: (-1, 0, 1) (-1, -1, 2)
 * 
 * @author Telis
 * 
 */
public class Solution {
	private int[] used;
	private int[] number;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] input = { -1, 0, 1, 2, -1, -4, 2, 4, 1 };
		int[] input = { 7, 5, -8, -6, -13, 7, 10, 1, 1, -4, -14, 0, -1, -10, 1,
				-13, -4, 6, -11, 8, -6, 0, 0, -5, 0, 11, -9, 8, 2, -6, 4, -14,
				6, 4, -5, 0, -12, 12, -13, 5, -6, 10, -10, 0, 7, -2, -5, -12,
				12, -9, 12, -9, 6, -11, 1, 14, 8, -1, 7, -13, 8, -11, -11, 0,
				0, -1, -15, 3, -11, 9, -7, -10, 4, -2, 5, -4, 12, 7, -8, 9, 14,
				-11, 7, 5, -15, -15, -4, 0, 0, -11, 3, -15, -15, 7, 0, 0, 13,
				-7, -12, 9, 9, -3, 14, -1, 2, 5, 2, -9, -3, 1, 7, -12, -3, -1,
				1, -2, 0, 12, 5, 7, 8, -7, 7, 8, 7, -15 };
		Solution s = new Solution();
		long time = System.currentTimeMillis();
		System.out.println(s.threeSum(input));
		time = System.currentTimeMillis() - time;
		System.out.println(time);
	}

	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>(num.length);
		used = new int[num.length];
		number = new int[3];
		Arrays.sort(num);
		get(0, result, num, 0);
		return result;
	}

	public void get(int count, List<List<Integer>> result, int[] input,
			int start) {
		if (count == 2) {
			for (int i = start; i < input.length; i++) {
				if (used[i] == 0 && number[0] + number[1] == -input[i]) {
					List<Integer> temp = Arrays.asList(number[0], number[1],
							input[i]);
					if (result.isEmpty())
						result.add(temp);
					if (!temp.equals(result.get(result.size()-1))) {
						result.add(temp);
					}
				}
			}
		} else {
			for (int i = start; i < input.length; i++) {
				if (used[i] == 0) {
					number[count] = input[i];
					used[i] = 1;
					get(count + 1, result, input, i);
					used[i] = 0;
				}
			}
		}
	}
}
