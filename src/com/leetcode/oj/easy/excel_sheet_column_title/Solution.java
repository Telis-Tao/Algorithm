package com.leetcode.oj.easy.excel_sheet_column_title;

/**
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet.
 * 
 * For example:
 * 
 * 1 -> A 2 -> B 3 -> C ... 26 -> Z 27 -> AA 28 -> AB
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
		// new Solution().convertToTitle(256);
//		for (int i = 1; i < 60; i++) {
//			new Solution().convertToTitle(i);
//		}
		// System.out.println(new Solution().convertToTitle(51));
		// System.out.println(new Solution().convertToTitle(52));
		// System.out.println(new Solution().convertToTitle(703));

	}

	public String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		while(n>0){
			n--;
			sb.append((char)('A'+n%26));
			n /= 26;
		}
//		if (n < 1) {
//			return "";
//		}
//		System.out.print(n + ":");
//		StringBuilder sb = new StringBuilder();
//		// 首先转化弄成26进制
//		while (n > 26) {
//			// n--;
//			int count1 = n / 26;
//			int count2 = n % 26;
//			// sb.insert(sb.length(), (char) (count2 + '@'));
//			sb.append((char) (count2 + '@'));
//			// System.out.println((char)(count1+'A')+":"+count1+":"+count2);
//			n = count1;
//		}
//		sb.append((char) (n + '@'));
//		System.out.println(sb.reverse());
		return sb.reverse().toString();
	}
}
