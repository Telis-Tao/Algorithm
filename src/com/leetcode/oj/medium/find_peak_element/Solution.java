package com.leetcode.oj.medium.find_peak_element;

/**
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array where num[i] ¡Ù num[i+1], find a peak element and return
 * its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 * 
 * You may imagine that num[-1] = num[n] = -¡Þ.
 * 
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function
 * should return the index number 2.
 * 
 * click to show spoilers.
 * 
 * Note: Your solution should be in logarithmic complexity.
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
		System.out.println(s.findPeakElement(new int[] { 1, 2, 3, 1 }));
		System.out.println(s.findPeakElement(new int[] { 1, 2, 3, 4, 5, 6 }));
		System.out.println(s.findPeakElement(new int[] { 4, 5, 1, 3, 4, 5, 3,
				2, 1 }));
		System.out.println(s.findPeakElement(new int[] { 3, 4, 3, 4, 3, 4, 3,
				4, 3 }));
		System.out.println(s.findPeakElement(new int[] { 1, 2, 3, 4, 3 }));
		System.out.println(s.findPeakElement(new int[] { 3, 4, 3, 2, 1 }));
	}

	public int findPeakElement(int[] num) {
		if (num.length <= 1 || num[0] > num[1])
			return 0;
		if (num[num.length - 1] > num[num.length - 2])
			return num.length - 1;
		return findPeakElement(num, 1, num.length - 2);
	}

	public int findPeakElement(int[] num, int start, int end) {
		int half = (start + end) / 2;
		if (num[half] > num[half - 1] && num[half] < num[half + 1]) {
			return findPeakElement(num, half + 1, end);
		} else if (num[half] < num[half - 1] && num[half] > num[half + 1]) {
			return findPeakElement(num, start, half - 1);
		} else if (num[half] < num[half - 1] && num[half] < num[half + 1]) {
			int left = findPeakElement(num, start, half - 1);
			int right = findPeakElement(num, half + 1, end);
			if (left != -1)
				return left;
			if (right != -1)
				return right;
		} else {
			return half;
		}
		return -1;
	}
}
