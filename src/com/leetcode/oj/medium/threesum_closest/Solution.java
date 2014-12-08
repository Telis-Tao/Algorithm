package com.leetcode.oj.medium.threesum_closest;

import java.util.Arrays;
import java.util.Set;

public class Solution {
	int closest;
	int[] result;
	int[] used;
	Set<Integer> set;

	public static void main(String args[]) {
		// int[] num = { -1, 2, 1, -4 };
		int[] num = { 40, -53, 36, 89, -38, -51, 80, 11, -10, 76, -30, 46, -39,
				-15, 4, 72, 83, -25, 33, -69, -73, -100, -23, -37, -13, -62,
				-26, -54, 36, -84, -65, -51, 11, 98, -21, 49, 51, 78, -58, -40,
				95, -81, 41, -17, -70, 83, -88, -14, -75, -10, -44, -21, 6, 68,
				-81, -1, 41, -61, -82, -24, 45, 19, 6, -98, 11, 9, -66, 50,
				-97, -2, 58, 17, 51, -13, 88, -16, -77, 31, 35, 98, -2, 0, -70,
				6, -34, -8, 78, 22, -1, -93, -39, -88, -77, -65, 80, 91, 35,
				-15, 7, -37, -96, 65, 3, 33, -22, 60, 1, 76, -32, 22 };
		Solution s = new Solution();
		System.out.println(s.threeSumClosest(num, 292));
	}

	public int threeSumClosest(int[] num, int target) {
		int ans = 0;
		ans = num[0] + num[1] + num[2];
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			int sum = 0;
			int j = i + 1;
			int k = num.length - 1;
			while (j < k) {
				sum = num[i] + num[j] + num[k];
				if (Math.abs(sum - target) < Math.abs(ans - target)) {
					ans = sum;
					if (ans == target)
						return ans;
				}
				if (sum > target)
					k--;
				else
					j++;
			}
		}
		return ans;
	}
}
