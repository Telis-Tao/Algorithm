package com.leetcode.oj.easy.majority_element;

/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
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
		new Solution().majorityElement(new int[] { 1, 1, 2 });
		new Solution().majorityElement(new int[] { 1, 1, 2, 2, 2, 2, 3, 2, 3 });
		new Solution().majorityElement(new int[] { 4, 5, 4 });
	}

	/**
	 * 这个是按照bit位做出来的，这个思路确实想不出来。。。
	 * 
	 * @param num
	 * @return
	 */
	public int majorityElement(int[] num) {
		int result = 0;
		int temp = 0;
		for (int i = 31; i >= 0; i--) {
			int one = 0;
			int zero = 0;
			for (int j = 0; j < num.length; j++) {
				// System.out.println(num[j]>>(31-i)&1);
				if ((num[j] >> (31 - i) & 1) == 1) {
					one++;
				} else {
					zero++;
				}
			}
			// System.out.println(one+" "+zero);
			temp = one > zero ? 1 : 0;
			result += temp << (31 - i);
		}
		// System.out.println(result);
		// System.out.println(count);
		// System.out.println(candidate);
		return result;
	}
	// /**
	// * 这个是选举制度的做法，O(1)的空间复杂度，O(n)的时间复杂度，感觉是最好的方法了
	// *
	// * @param num
	// * @return
	// */
	// public int majorityElement(int[] num) {
	// int candidate = num[0];
	// int count = 0;
	// for (int i = 0; i < num.length; i++) {
	// if (candidate == num[i]) {
	// count++;
	// } else {
	// count--;
	// if (count == 0) {
	// count++;
	// candidate = num[i];
	// }
	// }
	// }
	// // System.out.println(count);
	// // System.out.println(candidate);
	// return candidate;
	// }
	// /**这个是最简单的实现方法了。。。但是需要 O(nlongn)的复杂度
	// * @param num
	// * @return
	// */
	// public int majorityElement(int[] num) {
	// Arrays.sort(num);
	// return num[num.length/2];
	// }
}
