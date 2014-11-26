package com.leetcode.oj.easy.count_and_say;

public class Solution {

	// 1. 1
	// 2. 11
	// 3. 21
	// 4. 1211
	// 5. 111221
	// 6. 312211
	// 7. 13112221
	// 8. 1113213211
	// 9. 31131211131221
	// 10. 13211311123113112211
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.countAndSay(2));
	}

	public String countAndSay(int n) {
		int i = 1;
		char[] seq = { '1' };
		while (i != n) {
			seq = proceed(seq).toCharArray();
			i++;
		}
		return String.valueOf(seq);
	}

	private String proceed(char[] c) {
		StringBuffer sb = new StringBuffer();
		int count = 0;
		for (int i = 0; i < c.length - 1; i++) {
			if (c[i] == c[i + 1]) {
				count++;
			} else {
				sb.append(++count);
				sb.append(c[i]);
				count = 0;
			}
		}
		if (count == 0) {
			sb.append(1);
		} else {
			sb.append(++count);
		}
		sb.append(c[c.length - 1]);
		return sb.toString();
	}
}
