package com.leetcode.oj.easy.excel_sheet_column_number;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding
 * column number.
 * 
 * For example:
 * 
 * A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28
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
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 26; j++) {
				System.out.println(new Solution().titleToNumber(String.valueOf((char)('A'+i))+""+String.valueOf((char)('A'+j))));
				
			}
		}
//		System.out.println(new Solution().titleToNumber("AA"));
	}

	public int titleToNumber(String s) {
		int result = 0;
//		System.out.print(s+":");
		for (int i = 0; i < s.length(); i++) {
//			System.out.println((s.charAt(i) - '@'));
			result += (s.charAt(i) - '@') * Math.pow(26, s.length() - i-1);
		}
//		System.out.println(result);
		return result;
	}
}
