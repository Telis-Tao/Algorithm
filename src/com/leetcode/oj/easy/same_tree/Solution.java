package com.leetcode.oj.easy.same_tree;

import com.leetcode.oj.easy.maximum_depth_of_binary_tree.TreeNode;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * 
 * Two binary trees are considered equal if they are structurally identical and
 * the nodes have the same value.
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

	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		boolean a, b;
		if (p == null && q == null)
			return true;
		if ((p != null && q == null) || (p == null && q != null)
				|| p.left != p.left || p.right != p.right)
			return false;
		if (p.val != q.val)
			return false;
		a = isSameTree(p.left, q.left);
		b = isSameTree(p.right, q.right);
		return a & b;
	}
}
