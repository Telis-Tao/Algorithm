package com.leetcode.oj.medium.flatten_binary_tree_to_linked_list;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.oj.tools.TreeNode;

public class Solution {
	List<Integer> list;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution s = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		s.flatten(root);
		while (root != null) {
			System.out.println(root.val);
			root = root.right;
		}
	}

	public void flatten(TreeNode root) {
		if (root == null)
			return;
		if (root.left == null && root.right == null)
			return;
		list = new ArrayList<>();
		get(root);
		for (int i = 1; i < list.size(); i++) {
			if (root.right != null) {
				root.right.val = list.get(i);
			} else {
				root.right = new TreeNode(list.get(i));
			}
			root.left = null;
			root = root.right;
		}
	}

	public void get(TreeNode root) {
		if (root == null)
			return;
		list.add(root.val);
		if (root.left != null)
			get(root.left);
		if (root.right != null)
			get(root.right);
	}


	private void printTree(TreeNode root) {
		if (root == null)
			return;
		// TreeNode result = new TreeNode(root.val);
		System.out.println(root.val);
		if (root.left != null)
			printTree(root.left);
		if (root.right != null)
			printTree(root.right);
	}

}
