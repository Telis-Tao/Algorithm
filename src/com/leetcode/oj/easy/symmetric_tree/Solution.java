package com.leetcode.oj.easy.symmetric_tree;

import com.leetcode.oj.easy.maximum_depth_of_binary_tree.TreeNode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 * 
 * For example, this binary tree is symmetric
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
		// TreeNode root = new TreeNode('A');
		// TreeNode BTreeNode = new TreeNode('B');
		// BTreeNode.right = new TreeNode('D');
		// root.left = BTreeNode;
		// TreeNode ETreeNode = new TreeNode('E');
		// ETreeNode.left = new TreeNode('G');
		// ETreeNode.right = new TreeNode('H');
		// TreeNode CTreeNode = new TreeNode('C');
		// CTreeNode.left = ETreeNode;
		// CTreeNode.right = new TreeNode('F');
		// root.right = CTreeNode;

		TreeNode root = new TreeNode('A');
		TreeNode BTreeNode = new TreeNode('B');
		TreeNode BpTreeNode = new TreeNode('B');
		root.left = BTreeNode;
		root.right = BpTreeNode;

		Solution s = new Solution();
		boolean isSymmetric = s.isSymmetric(root);
		System.out.println(isSymmetric);
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return isSymmetric(root.left, root.right);

	}

	private boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if ((left != null && right == null) || (left == null && right != null))
			return false;
		if (left.val != right.val)
			return false;
		boolean lt = isSymmetric(left.left, right.right);
		boolean rt = isSymmetric(left.right, right.left);
		return lt && rt;
	}
}
