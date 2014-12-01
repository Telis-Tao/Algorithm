package com.leetcode.oj.easy.maximum_depth_of_binary_tree;

///**
// * Definition for binary tree
// * public class TreeNode {
// *     int val;
// *     TreeNode left;
// *     TreeNode right;
// *     TreeNode(int x) { val = x; }
// * }
// */
/**
 * Given a binary tree, find its maximum depth. The maximum depth is the number
 * of nodes along the longest path from the root node down to the farthest leaf
 * node.
 * 
 * @author Telis
 */
public class Solution {
	public static void main(String args[]) {
		TreeNode root = new TreeNode('A');
		TreeNode BTreeNode = new TreeNode('B');
		BTreeNode.right = new TreeNode('D');
		root.left = BTreeNode;
		TreeNode ETreeNode = new TreeNode('E');
		ETreeNode.left = new TreeNode('G');
		ETreeNode.right = new TreeNode('H');
		TreeNode CTreeNode = new TreeNode('C');
		CTreeNode.left = ETreeNode;
		CTreeNode.right = new TreeNode('F');
		root.right = CTreeNode;
		Solution s = new Solution();

		int depth = s.maxDepth(root);
		System.out.println(depth);
	}

	/**
	 * @param root
	 * @param depth
	 *            附加了一个参数的解法
	 * @return
	 */
	public int maxDepth(TreeNode root, int depth) {
		int left, right;
		left = depth;
		right = depth;
		if (root.left != null)
			left = maxDepth(root.left, ++depth);
		if (root.right != null)
			right = maxDepth(root.right, ++depth);
		return left > right ? left : right;
	}

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int left = 1;
		int right = 1;

		if (root.left != null) {
			left = maxDepth(root.left) + 1;
		}
		if (root.right != null) {
			right = maxDepth(root.right) + 1;
		}
		return left > right ? left : right;
	}

}