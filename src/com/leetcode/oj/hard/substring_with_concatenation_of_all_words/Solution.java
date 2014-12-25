package com.leetcode.oj.hard.substring_with_concatenation_of_all_words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().findSubstring("a",
				new String[] { "a" }));
		// System.out.println(new Solution().findSubstring("barfoothefoobarman",
		// new String[] { "foo", "bar" }));
		// System.out.println(new Solution().findSubstring("abababab",
		// new String[] { "ab", "ba" }));
	}

	// public List<Integer> findSubstring(String S, String[] L) {
	// List<Integer> list = new ArrayList<Integer>();
	// int lenth = L[0].length();
	// int[] used = new int[L.length];
	// for (int i = 0; i < S.length() - L.length * lenth; i++) {
	// int j = i;
	// while (true) {
	// int index = -1;
	// if (j + lenth <= S.length()
	// && (index = contains(L, S.substring(j, j + lenth), used)) != -1) {
	// used[index] = 1;
	// if (isAllUsed(used)) {
	// // System.out.println(i);
	// list.add(i);
	// break;
	// } else {
	// j += lenth;
	// }
	// } else {
	// used = clearUsed(used);
	// break;
	// }
	// }
	// }
	// return list;
	// }
	/**
	 * 这个竟然过了。。。想着会占用很多的空间，但是查找速度很快
	 * 
	 * @param S
	 * @param L
	 * @return
	 */
	public List<Integer> findSubstring(String S, String[] L) {
		HashMap<String, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < L.length; i++) {
			if (map.containsKey(L[i])) {
				int count = map.get(L[i]);
				map.put(L[i], ++count);
			} else {
				map.put(L[i], 1);
			}
		}
		int lenth = L[0].length();
		for (int i = 0; i <= S.length() - L.length * lenth; i++) {
			HashMap<String, Integer> tempMap = new HashMap<>(map);
			int j = i;
			while (true) {
				if (j + lenth <= S.length()
						&& contains(tempMap, S.substring(j, j + lenth))) {
					if (tempMap.isEmpty()) {
						// System.out.println(i);
						list.add(i);
						break;
					} else {
						j += lenth;
					}
				} else {
					break;
				}
			}
		}
		return list;
	}

	private boolean contains(HashMap<String, Integer> tempMap, String substring) {
		// TODO Auto-generated method stub
		if (tempMap.containsKey(substring)) {
			int count = tempMap.get(substring);
			if (--count == 0) {
				tempMap.remove(substring);
			} else {
				tempMap.put(substring, count);
			}
			return true;
		} else {
			return false;
		}
	}

	// private int contains(String[] l, String substring, int[] used) {
	// // TODO Auto-generated method stub
	// for (int i = 0; i < l.length; i++) {
	// if (used[i] == 0 && l[i].equals(substring)) {
	// return i;
	// }
	// }
	// return -1;
	// }
	//
	// private int[] clearUsed(int[] used) {
	// // TODO Auto-generated method stub
	// return new int[used.length];
	// }
	//
	// private boolean isAllUsed(int[] used) {
	// // TODO Auto-generated method stub
	// for (int i = 0; i < used.length; i++) {
	// if (used[i] == 0) {
	// return false;
	// }
	// }
	// return true;
	// }
}
