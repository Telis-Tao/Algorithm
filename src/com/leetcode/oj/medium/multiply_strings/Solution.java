package com.leetcode.oj.medium.multiply_strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two numbers represented as strings, return multiplication of the
 * numbers as a string.
 * 
 * Note: The numbers can be arbitrarily large and are non-negative.
 * 这个题我一开始用的String 作为result的格式，最后TLE了，然后是换成的StringBuilder格式的，竟然就AC了！！！太厉害了！！！
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
		// System.out.println(s.multiply("9133", "0"));
		System.out.println(s.multiply("9133", "12"));
		System.out.println(s.multiply("408", "5"));
	}

	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		char[] c1 = num1.toCharArray();
		char[] c2 = num2.toCharArray();
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (int i = 0; i < c2.length; i++) {
			if (!map.containsKey(c2[i] - '0')) {
				map.put(c2[i] - '0', getOnemulti(num1, c1, c2[i]));
			}
		}
		// System.out.println(map);
		String[] results = new String[c2.length];
		for (int i = 0; i < c2.length; i++) {
			String temp = map.get(c2[i] - '0');
			for (int j = 1; j < c2.length - i; j++) {
				temp += "0";
			}
			results[i] = temp;
		}
		// System.out.println(Arrays.toString(results));
		String result = "0";
		for (int i = 0; i < results.length; i++) {
			result = getPlus(results[i], result);
		}
		// System.out.println(result);
		return result;
	}

	private String getOnemulti(String num1, char[] c1, char c2) {
		int[] results = new int[num1.length()];
		for (int i = 0; i < c1.length; i++) {
			results[i] = (c1[i] - '0') * (c2 - '0');
		}
		// System.out.println(Arrays.toString(results));
		int temp = 0;
		for (int i = results.length - 1; i > 0; i--) {
			temp = 0;
			while (results[i] > 9) {
				temp++;
				results[i] -= 10;
			}
			results[i - 1] += temp;
		}
		// System.out.println(Arrays.toString(results));
		StringBuilder result = new StringBuilder();
		temp = 0;
		if (results[0] > 9) {
			while (results[0] > 9) {
				temp++;
				results[0] -= 10;
			}
			result.append(temp);
		}
		for (int i = 0; i < results.length; i++) {
			result.append(results[i]);
		}
		return result.toString();
	}

	private String getPlus(String num1, String num2) {
		int maxLength = num1.length() > num2.length() ? num1.length() : num2
				.length();
		while (maxLength > num1.length()) {
			num1 = "0" + num1;
		}
		while (maxLength > num2.length()) {
			num2 = "0" + num2;
		}
		StringBuilder result = new StringBuilder();
		int temp = 0;
		int count = 0;
		for (int i = maxLength - 1; i >= 0; i--) {
			temp = (num1.charAt(i) - '0') + (num2.charAt(i) - '0');
			if (count != 0) {
				temp += count;
				count = 0;
			}
			while (temp > 9) {
				temp -= 10;
				count++;
			}
			result.insert(0, temp);
		}
		if (count != 0) {
			result.insert(0, count);
		}
		return result.toString();
	}
}
