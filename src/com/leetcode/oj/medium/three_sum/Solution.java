package com.leetcode.oj.medium.three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤
 * b ≤ c) The solution set must not contain duplicate triplets. For example,
 * given array S = {-1 0 1 2 -1 -4},
 * 
 * A solution set is: (-1, 0, 1) (-1, -1, 2)
 * 
 * 这套题如果用常规的思路来做的话基本都会出现TLE，要把重复的提前干掉才能AC
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
		// System.out.println(s.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
		System.out.println(s.threeSum(new int[] { -2, 0, 1, 1, 2 }));
		// System.out.println(s.threeSum(new int[] { -1, 0, 1, 10, -1, -4 }));
		// System.out.println(s.threeSum(new int[] { -7, -10, -1, 3, 0, -7, -9,
		// -1, 10, 8, -6, 4, 14, -8, 9, -15, 0, -4, -5, 9, 11, 3, -5, -8,
		// 2, -6, -14, 7, -14, 10, 5, -6, 7, 11, 4, -7, 11, 11, 7, 7, -4,
		// -14, -12, -13, -14, 4, -13, 1, -15, -2, -12, 11, -14, -2, 10,
		// 3, -1, 11, -5, 1, -2, 7, 2, -10, -5, -8, -10, 14, 10, 13, -2,
		// -9, 6, -7, -7, 7, 12, -5, -14, 4, 0, -11, -8, 2, -6, -13, 12,
		// 0, 5, -15, 8, -12, -1, -4, -15, 2, -5, -9, -7, 12, 11, 6, 10,
		// -6, 14, -12, 9, 3, -10, 10, -8, -2, 6, -9, 7, 7, -7, 4, -8, 5,
		// -4, 8, 0, 3, 11, 0, -10, -9 }));
	}

	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (num.length < 3)
			return list;
		int[] results = new int[3];
		Arrays.sort(num);
		// System.out.println(Arrays.toString(num));
		for (int i = 0; i < num.length; i++) {
			if (i > 0 && num[i] == num[i - 1]) {
				continue;
			}
			results[0] = num[i];
			for (int j = i + 1; j < num.length; j++) {
				// System.out.println(i + ":" + j);
				if (j > i + 1 && num[j] == num[j - 1]) {
					continue;
				}
				results[1] = num[j];
				int sum = num[i] + num[j];
				if (sum > 0) {
					break;
				}
				if (!(-sum > num[num.length - 1])) {
					for (int k = num.length - 1; k > j; k--) {
						// System.out.println(i+" "+j+" "+k);
						if (k < num.length - 1 && num[k] == num[k + 1]) {
							continue;
						}
						if (sum + num[k] == 0) {
							results[2] = num[k];
							List<Integer> temp = Arrays.asList(results[0],
									results[1], results[2]);
							list.add(temp);
						}
					}
				}
			}
		}
		return list;
	}

}
