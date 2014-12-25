package com.leetcode.oj.medium.construct_binary_tree_from_preorder_and_inorder_traversal;

import java.util.Arrays;
import java.util.List;

import com.bupt.bfs.BreadthFirstSearch;
import com.leetcode.oj.tools.TreeNode;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] preorder = {};
		// int[] inorder = {};
		int[] preorder = { 3, 1, 4, 5, 2, 7 };
		int[] inorder = { 4, 1, 5, 3, 2, 7 };
		TreeNode root = new Solution().buildTree(preorder, inorder);
		List<TreeNode> list = BreadthFirstSearch.getList(root);
		System.out.println(list);
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || preorder.length < 1)
			return null;
		if (preorder.length == 1)
			return new TreeNode(preorder[0]);
		int val = preorder[0];
		// create new node
		TreeNode node = new TreeNode(val);
		int index = 0;
		while (inorder[index] != val) {
			index++;
		}

		if (index > 0) {
			node.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1),
					Arrays.copyOfRange(inorder, 0, index));
		}
		if (index < preorder.length - 1) {
			// System.out.println(Arrays.toString(preRight));
			// System.out.println(Arrays.toString(inRight));
			node.right = buildTree(
					Arrays.copyOfRange(preorder, index + 1, preorder.length),
					Arrays.copyOfRange(inorder, index + 1, inorder.length));
		}
		// System.out.println(Arrays.toString(preRight));
		// System.out.println(Arrays.toString(inRight));
		// System.out.println(Arrays.toString(preLeft));
		// System.out.println(Arrays.toString(inLeft));
		// System.out.println(Arrays.toString(inRight));
		return node;
	}
}
