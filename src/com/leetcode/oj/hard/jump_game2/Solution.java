package com.leetcode.oj.hard.jump_game2;

import java.util.Arrays;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example: Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from
 * index 0 to 1, then 3 steps to the last index.)
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
		System.out.println(new Solution().jump(new int[] { 2, 3, 1, 1, 4, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1 }));
	}

	public int jump(int[] A) {
		if (A.length < 2) {
			return 0;
		}
		int[] r = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			for (int j = A[i] + i; j > i; j--) {
				if (j >= A.length - 1) {
					return r[i] + 1;
				} else {
					if (r[j] == 0) {
						r[j] = r[i] + 1;
					} else {
						break;
					}
				}
			}
			// System.out.println(Arrays.toString(r));
		}
		// 下面是我的写的DP的算法，可以TLE了，因为有O(n^2)的算法，上面的也是我自己想出来的，计算量理论上虽然没怎么变，但是实际上会少很多
		// for (int i = 1; i < results.length; i++) {
		// results[i] = results[i - 1] + 1;
		// for (int j = 0; j < i; j++) {
		// if (A[j] + j >= i) {
		// results[i] = Math.min(results[i], results[j] + 1);
		// }
		// }
		// }
		// System.out.println(Arrays.toString(r));
		return r[r.length - 1];
	}
}
