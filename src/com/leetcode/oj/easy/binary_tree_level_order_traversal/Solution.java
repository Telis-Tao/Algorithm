package com.leetcode.oj.easy.binary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.oj.easy.binary_tree_level_order_traversal2.TreeNode;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TreeNode root = new TreeNode(3);
//		root.right = new TreeNode(20);
//		root.right.right = new TreeNode(7);
//		root.right.left = new TreeNode(15);
//		root.left = new TreeNode(9);
		TreeNode root = new TreeNode(3);
		Solution s = new Solution();
		System.out.println(s.levelOrder(root));
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		levelOrder(root, 0, list);
		return list;
	}

	public void levelOrder(TreeNode root, int depth, List<List<Integer>> list) {
		if (root == null)
			return;
		if (list.size() <= depth) {
			list.add(new ArrayList<Integer>());
		}
		list.get(depth).add(root.val);
		levelOrder(root.left, depth + 1, list);
		levelOrder(root.right, depth + 1, list);
	}
}
