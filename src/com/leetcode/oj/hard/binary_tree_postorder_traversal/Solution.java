package com.leetcode.oj.hard.binary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.leetcode.oj.tools.TreeNode;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * For example: Given binary tree {1,#,2,3}, 1 \ 2 / 3 return [3,2,1].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
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
		root.left = new TreeNode(1);
		root.left.right = new TreeNode(2);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(6);
		Solution s = new Solution();
		System.out.println(s.postorderTraversal(root));
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.peek();
			if (node.left == null && node.right == null) {
				list.add(node.val);
				stack.pop();
			} else {
				if (node.right != null) {
					stack.push(node.right);
					node.right = null;
				}
				if (node.left != null) {
					stack.push(node.left);
					node.left = null;
				}
			}
		}
		return list;
	}
}
