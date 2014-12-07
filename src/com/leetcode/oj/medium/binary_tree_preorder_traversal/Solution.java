package com.leetcode.oj.medium.binary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.leetcode.oj.tools.TreeNode;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * For example: Given binary tree {1,#,2,3}, return [1,2,3]. Note: Recursive
 * solution is trivial, could you do it iteratively?
 * 
 * @author Telis
 * 
 */
public class Solution {
	public static void main(String[] args) {
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
		List<Integer> list = s.preorderTraversal(root);
		System.out.println(list);
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root != null) {
			stack.push(root);
			while (!stack.empty()) {
				TreeNode node = stack.pop();
				result.add(node.val);
				if (node.right != null)
					stack.push(node.right);
				if (node.left != null)
					stack.push(node.left);
			}
		}
		return result;
	}

	// public List<Integer> preorderTraversal(TreeNode root) {
	// List<Integer> result = new ArrayList<Integer>();
	// preorderTraversal(root, result);
	// return result;
	// }
	//
	// public void preorderTraversal(TreeNode root, List<Integer> result) {
	// if (root == null)
	// return;
	// result.add(root.val);
	// if (root.left != null)
	// preorderTraversal(root.left, result);
	// if (root.right != null)
	// preorderTraversal(root.right, result);
	// }
}
