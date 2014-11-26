package com.leetcode.oj.medium.two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
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
//		 int[] numbers = { 2, 7, 11, 15 };
		 int[] numbers = { 0, 4, 3, 0 };
//		int[] numbers = { 5, 75, 25 };
		int target = 0;
		int[] result = s.twoSum(numbers, target);
		System.out.println(Arrays.toString(result));
	}

	public int[] twoSum(int[] numbers, int target) {
		if (numbers == null)
			return null;
		if (numbers.length <= 1)
			return null;
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] result = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i])) {
				result[0] = map.get(target - numbers[i]);
				result[1] = i + 1;
				break;
			} else {
				map.put(numbers[i], i + 1);
			}
		}
		// if (sorted[left] == sorted[right]) {
		// int i = 0;
		// for (int j = 0; j < numbers.length && i < 2; j++) {
		// if (numbers[j] == sorted[left]) {
		// result[i++] = j + 1;
		// }
		// }
		// }else{
		// for (int i = 0; i < numbers.length; i++) {
		// if (numbers[i] == sorted[left]) {
		// result[0] = i + 1;
		// }
		// if (numbers[i] == sorted[right]) {
		// result[1] = i + 1;
		// }
		// }
		// }
		return result;
		// for (int i = 0; i < numbers.length; i++) {
		// for (int j = i + 1; j < numbers.length; j++) {
		// if (numbers[i] + numbers[j] == target) {
		// int[] result = { i + 1, j + 1 };
		// return result;
		// }
		// }
		// }
	}
}
