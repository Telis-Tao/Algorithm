package com.leetcode.oj.medium.letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number
 * could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf",
 * "cd", "ce", "cf"]. Note: Although the above answer is in lexicographical
 * order, your answer could be in any order you want.
 * 
 * @author Telis
 * 
 */
public class Solution {
	private static char[][] datas = { {}, {}, { 'a', 'b', 'c' },
			{ 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
			{ 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' },
			{ 'w', 'x', 'y', 'z' } };
	private char[] results;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String digits = "23";
		s.letterCombinations(digits);
	}

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		if(digits==null){
			return result;
		}
		results = new char[digits.length()];
		letterCombinations(digits, result, 0);
		return result;
	}

	public void letterCombinations(String digits, List<String> result, int start) {
		if (start == digits.length()) {
			result.add(String.valueOf(results));
		} else {
			for (int i = 0; i < datas[digits.charAt(start) - '0'].length; i++) {
				results[start] = datas[digits.charAt(start) - '0'][i];
				letterCombinations(digits, result, start + 1);
			}
		}
	}
}
