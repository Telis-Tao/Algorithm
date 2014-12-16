package com.leetcode.oj.hard.edit_distance;

/**
 * Given two words word1 and word2, find the minimum number of steps required to
 * convert word1 to word2. (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character b) Delete a character c) Replace a character
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
		s.minDistance("Telis", "eli");
	}

	public int minDistance(String word1, String word2) {
		int start = 0;
		int end = 0;
		boolean isFound = false;
		// 寻找最长相同子串
		for (int i = word1.length(); i > 0; i--) {
			if (!isFound) {
				for (int j = 0; j < word1.length() + 1 - i; j++) {
					String match = word1.substring(j, j + i);
					// System.out.println(match);
					if (word2.indexOf(match) != -1) {
						start = j;
						end = j + i;
						isFound = true;
						break;
					}
				}
			}
		}
		System.out.println(word1.substring(start, end));
		return 0;
	}
}
