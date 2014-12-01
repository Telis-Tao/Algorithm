package com.leetcode.oj.easy.balanced_binary_tree;

import com.leetcode.oj.easy.maximum_depth_of_binary_tree.TreeNode;

/**
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
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
		TreeNode root = new TreeNode('A');
		root.right = new TreeNode('B');
		root.right.right = new TreeNode('D');
		Solution s = new Solution();
		System.out.println(s.isBalanced(root));
	}

	public boolean isBalanced(TreeNode root) {
		if(root==null)
			return true;
		int left = 0;
		int right = 0;
		if (root.left != null)
			left = Depth(root.left, 1);
		if (root.right != null)
			right = Depth(root.right, 1);
		System.out.println("left:"+left);
		System.out.println("right:"+right);
		if (Math.abs(left - right) <= 1)
			return isBalanced(root.left) && isBalanced(root.right);
		return false;
	}

	private int Depth(TreeNode root, int depth) {
		// TODO Auto-generated method stub
		if(root==null)
			return depth;
		int left = depth;
		int right = depth;
		if (root.left != null)
			left = Depth(root.left, depth + 1);
		if (root.right != null)
			right = Depth(root.right, depth + 1);
		return Math.max(left, right);
	}
	// public boolean isBalanced(TreeNode root) {
	// List<Integer> list = new ArrayList<Integer>();
	// if (root == null)
	// return true;
	// minDepth(root, 1, list);
	// int min = list.get(0
	// );
	// int max = list.get(0);
	// for (int i = 0; i < list.size(); i++) {
	// System.out.println(list.get(i));
	// if (min > list.get(i))
	// min = list.get(i);
	// if (max < list.get(i))
	// max = list.get(i);
	// }
	// if (max - min > 1)
	// return false;
	// return true;
	// }
	//
	// public void minDepth(TreeNode root, int depth, List<Integer> list) {
	// if (root == null) {
	// return;
	// }
	// if (!(root.left != null && root.right != null)) {
	// list.add(depth);
	// }
	// minDepth(root.left, depth + 1, list);
	// minDepth(root.right, depth + 1, list);
	// }

}
