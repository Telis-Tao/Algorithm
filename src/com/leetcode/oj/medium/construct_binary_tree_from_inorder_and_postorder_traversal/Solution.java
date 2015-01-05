package com.leetcode.oj.medium.construct_binary_tree_from_inorder_and_postorder_traversal;

import java.util.Arrays;
import java.util.List;

import com.bupt.bfs.BreadthFirstSearch;
import com.leetcode.oj.tools.TreeNode;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
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
		TreeNode root = new Solution().buildTree(
				new int[] { 2, 1, 3, 9, 4, 5 }, new int[] { 2, 1, 9, 5, 4, 3 });
		List<TreeNode> list = BreadthFirstSearch.getList(root);
		System.out.println(list);
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (postorder.length <= 0)
			return null;
		if (postorder.length == 1)
			return new TreeNode(postorder[0]);
		int num = postorder[postorder.length - 1];
		TreeNode node = new TreeNode(num);
		int left = 0;
//		System.out.println(num);
		while (inorder[left] != num) {
			left++;
		}
		// System.out.println(inorder[left]);
		// System.out.println(Arrays.toString(Arrays.copyOfRange(inorder, 0,
		// left)));
		node.left = buildTree(Arrays.copyOfRange(inorder, 0, left),
				Arrays.copyOfRange(postorder, 0, left));
		// System.out.println(Arrays.toString(Arrays.copyOfRange(inorder, left +
		// 1, inorder.length)));
		node.right = buildTree(
				Arrays.copyOfRange(inorder, left + 1, inorder.length),
				Arrays.copyOfRange(postorder, left, postorder.length-1));
		return node;
	}
}
