package com.leetcode.oj.easy.binary_tree_level_order_traversal2;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.oj.tools.TreeNode;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes'
 * values. (ie, from left to right, level by level from leaf to root).
 * 
 * For example: Given binary tree {3,9,20,#,#,15,7}, 3 / \ 9 20 / \ 15 7 return
 * its bottom-up level order traversal as: [ [15,7], [9,20], [3] ]
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
		TreeNode root = new TreeNode(3);
		root.right = new TreeNode(20);
		root.right.right = new TreeNode(7);
		root.right.left = new TreeNode(15);
		root.left = new TreeNode(9);
		Solution s = new Solution();
		System.out.println(s.levelOrderBottom(root));
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root == null)
			return list;
		list = levelOrderBottom(root, 0, list);
		for (int i = 0; i < list.size() / 2; i++) {
			List<Integer> temp = new ArrayList<Integer>();
			temp = list.get(i);
			list.set(i, list.get(list.size() - 1 - i));
			list.set(list.size() - 1 - i, temp);
		}
		return list;
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root, int depth,
			List<List<Integer>> list) {
		if (root == null)
			return list;
		if (list.size() <= depth)
			list.add(new ArrayList<Integer>());
		list.get(depth).add(root.val);
		list = levelOrderBottom(root.left, depth + 1, list);
		list = levelOrderBottom(root.right, depth + 1, list);
		return list;
	}
}
