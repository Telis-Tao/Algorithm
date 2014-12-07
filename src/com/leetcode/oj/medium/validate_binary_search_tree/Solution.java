package com.leetcode.oj.medium.validate_binary_search_tree;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.oj.tools.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's
 * key. The right subtree of a node contains only nodes with keys greater than
 * the node's key. Both the left and right subtrees must also be binary search
 * trees.
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
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
//		root.left.left = new TreeNode(0);
//		root.left.right = new TreeNode(2);
//		root.right = new TreeNode(4);
		Solution s = new Solution();
		boolean b = s.isValidBST(root);
		System.out.println(b);
	}

	public boolean isValidBST(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		isValidBST(root, list);
		for (int i = 0; i < list.size()-1; i++) {
			if(list.get(i)>=list.get(i+1))
				return false;
		}
		return true;
	}

	public void isValidBST(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		isValidBST(root.left, list);
		list.add(root.val);
		isValidBST(root.right, list);
	}
}
