package com.leetcode.oj.medium.convert_sorted_Array_to_binary_search_tree;

import com.leetcode.oj.easy.binary_tree_level_order_traversal2.TreeNode;
import com.leetcode.oj.tools.TreeTools;

/**
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
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
		// int[] vals = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] vals = { 3, 5, 8 };
		Solution s = new Solution();
		TreeNode root = s.sortedArrayToBST(vals);
		// TreeTools.firstPrint(root);
	}

	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null)
			return null;
		if (num.length == 1)
			return new TreeNode(num[0]);
		TreeNode root = sortedArrayToBST(num, 0, num.length);
		return root;
	}

	public TreeNode sortedArrayToBST(int[] num, int start, int end) {
		if (start >= end) {
			return null;
		}
		int half = (start + end) / 2;
		System.out.println(num[half]);
		TreeNode root = new TreeNode(num[half]);
		root.left = sortedArrayToBST(num, start, half);
		root.right = sortedArrayToBST(num, half + 1, end);
		return root;
	}
}
