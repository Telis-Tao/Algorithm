package com.leetcode.oj.medium.restore_ip_addresses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	private int[] results;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		// String str = "25525511135";
		String str = "010010";
		s.restoreIpAddresses(str);
	}

	public List<String> restoreIpAddresses(String s) {
		List<String> list = new ArrayList<String>();
		results = new int[4];
		restoreIpAddresses(s, 0, 0, list);
		System.out.println(list);
		return list;
	}

	public void restoreIpAddresses(String s, int count, int lenth,
			List<String> list) {
		if (count == 4) {
			if (lenth == s.length()) {
				String check = results[0] + "" + results[1] + results[2]
						+ results[3];
				if (check.equals(s)) {
					String str = results[0] + "." + results[1] + "."
							+ results[2] + "." + results[3];
					list.add(str);
				}
			}
		} else {
			for (int i = lenth + 1; i < lenth + 4 && i <= s.length(); i++) {
				results[count] = Integer.parseInt(s.substring(lenth, i));
				if (results[count] <= 255 && results[count] >= 0) {
					restoreIpAddresses(s, count + 1, i, list);
				}
			}
		}
	}
}
