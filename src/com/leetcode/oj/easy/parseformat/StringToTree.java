package com.leetcode.oj.easy.parseformat;

import com.leetcode.oj.tools.TreeNode;

public class StringToTree {

	public static void main(String[] args) {
		StringToTree s = new StringToTree("{1,2,3,4,5,3,1,2,3,4}");

	}

	public StringToTree(String str) {
		// str = str.replaceAll("[{}]", "");
		// System.out.println(str);
		// String[] strs = str.split(",");
		// ints = new int[strs.length];
		// for (int i = 0; i < ints.length; i++) {
		// ints[i] = Integer.parseInt(strs[i]);
		// }
	}

	public static TreeNode toTree(String str) {
		str = str.replaceAll("[{}]", "");
		System.out.println(str);
		String[] strs = str.split(",");
		// int[] ints = new int[strs.length];
		// for (int i = 0; i < ints.length; i++) {
		// ints[i] = Integer.parseInt(strs[i]);
		// }

		return null;
	}
}
