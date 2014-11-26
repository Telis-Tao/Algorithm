package com.leetcode.oj.medium.decode_ways;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given an encoded message containing digits,
 * determine the total number of ways to decode it.
 * 
 * For example, Given encoded message "12", it could be decoded as "AB" (1 2) or
 * "L" (12).
 * 
 * The number of ways decoding "12" is 2.
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
		String str = "1";
		System.out.println(s.numDecodings(str));

	}

	public int numDecodings(String s) {
		if(s.length()<1)
			return 0;
		int[] num = new int[s.length() + 1];
		num[0] = 1;
		if (isValid(s.substring(0, 1))) {
			num[1] = 1;
		} else {
			num[1] = 0;
		}
		for (int i = 2; i <= s.length(); i++) {
			if (isValid(s.substring(i - 1, i))) {
				num[i] += num[i - 1];
			}
			if (isValid(s.substring(i - 2, i))) {
				num[i] += num[i - 2];
			}
		}
		return num[s.length()];
	}

	public boolean isValid(String str) {
		if (str.charAt(0) == '0')
			return false;
		int num = Integer.parseInt(str);
		return num > 0 && num < 27;
	}
}
