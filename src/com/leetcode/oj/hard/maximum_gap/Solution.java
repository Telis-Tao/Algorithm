package com.leetcode.oj.hard.maximum_gap;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an unsorted array, find the maximum difference between the successive
 * elements in its sorted form.
 * 
 * Try to solve it in linear time/space.
 * 
 * Return 0 if the array contains less than 2 elements.
 * 
 * You may assume all elements in the array are non-negative integers and fit in
 * the 32-bit signed integer range.
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
		System.out.println(new Solution().maximumGap(new int[] { 1, 2, 3, 4, 5,
				7, 8, 9 }));
		System.out.println(new Solution().maximumGap(new int[] { 3, 6, 9, 1 }));
		System.out
				.println(new Solution().maximumGap(new int[] { 1, 10000000 }));
		System.out.println(new Solution().maximumGap(new int[] { 1, 1, 1, 1, 1,
				5, 5, 5, 5, 5 }));
	}

	public int maximumGap(int[] num) {
		if (num.length < 2)
			return 0;
		int min = num[0];
		int max = num[0];
		for (int i = 1; i < num.length; i++) {
			if (num[i] > max) {
				max = num[i];
			} else if (num[i] < min) {
				min = num[i];
			}
		}
		// System.out.println(min+" "+max);
		// System.out.println((max - min) / (num.length - 1));
		int len = (int) Math.ceil((max - min) / (num.length - 1));
		// System.out.println(len);
		if (len == 0)
			len++;
		int count = (int) (Math.ceil((max - min) / len)) + 1;
		// System.out.println(count);
		List<Buc> list = new ArrayList<Buc>();
		for (int i = 0; i < count; i++) {
			list.add(new Buc());
		}
		for (int i = 0; i < num.length; i++) {
			list.get((num[i] - min) / len).add(num[i]);
		}
		// System.out.println(list);
		max = 0;
		for (int i = 0; i < list.size(); i++) {
			if (!list.get(i).isEmpty) {
				int temp = list.get(i).max;
				for (int j = i + 1; j < list.size(); j++) {
					if (!list.get(j).isEmpty) {
						min = list.get(j).min;
						// System.out.println("min:" + min+" temp:"+temp);
						break;
					}
				}
				// System.out.println(max + " " + (min - temp));
				max = Math.max(max, min - temp);
			}
		}
		return max;
	}
}
