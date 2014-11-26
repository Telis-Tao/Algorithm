package com.leetcode.oj.easy.minimum_depth_of_binary_tree;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.oj.maximum_depth_of_binary_tree.TreeNode;

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
		// TreeNode root = new TreeNode('A');
		// root.left = new TreeNode('B');
		// root.right = new TreeNode('C');
		// root.left.left = new TreeNode('D');
		TreeNode root = null;
		Solution s = new Solution();
		System.out.println(s.minDepth(root));
	}

	public int minDepth(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return 0;
		minDepth(root, 1, list);
		int min = list.get(0);
		for (int i = 0; i < list.size(); i++) {
			if (min > list.get(i))
				min = list.get(i);
		}
		return min;
	}

	public void minDepth(TreeNode root, int depth, List<Integer> list) {
		if (root == null) {
			return;
		}
		if (isLeaf(root)) {
			list.add(depth);
		}
		minDepth(root.left, depth + 1, list);
		minDepth(root.right, depth + 1, list);
	}

	public boolean isLeaf(TreeNode root) {
		if (root.left == null && root.right == null)
			return true;
		return false;
	}
}
