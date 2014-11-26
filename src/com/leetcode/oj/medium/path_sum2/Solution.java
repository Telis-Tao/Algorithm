package com.leetcode.oj.medium.path_sum2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.leetcode.oj.easy.binary_tree_level_order_traversal2.TreeNode;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * @author Telis
 * 
 */
public class Solution {
	List<Integer> result;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		List<List<Integer>> list = s.pathSum(root, 22);
		System.out.println(list);
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root == null)
			return list;
		result = new ArrayList<Integer>();
		get(root, sum, 0, 0, list);
		return list;
	}

	public void get(TreeNode root, int sum, int layer, int tempSum,
			List<List<Integer>> list) {
		tempSum += root.val;
		if (result.size() < layer + 1) {
			result.add(root.val);
		} else {
			result.set(layer, root.val);
		}
		if (root.left == null && root.right == null) {
			if (tempSum == sum) {
				ArrayList<Integer> tempList = new ArrayList<>();
				for (int i = 0; i < layer + 1; i++) {
					tempList.add(result.get(i));
				}
				list.add(tempList);
			}
		} else {
			if (root.left != null) {
				get(root.left, sum, layer + 1, tempSum, list);
			}
			if (root.right != null) {
				get(root.right, sum, layer + 1, tempSum, list);
			}
		}
	}
}
