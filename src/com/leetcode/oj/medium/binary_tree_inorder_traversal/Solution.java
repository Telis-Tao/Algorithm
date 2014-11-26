package com.leetcode.oj.medium.binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.leetcode.oj.easy.binary_tree_level_order_traversal2.TreeNode;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * For example: Given binary tree {1,#,2,3}, 1 \ 2 / 3 return [1,3,2].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * ÖÐÐò±éÀú
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
		root.left = new TreeNode(2);
//		root.left.left = new TreeNode(11);
//		root.left.left.left = new TreeNode(7);
//		root.left.left.right = new TreeNode(2);
//		root.right = new TreeNode(8);
//		root.right.left = new TreeNode(13);
//		root.right.right = new TreeNode(4);
//		root.right.right.left = new TreeNode(5);
//		root.right.right.right = new TreeNode(1);
		Solution s = new Solution();
		s.inorderTraversal(root);
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node;
		stack.add(root);
		while(!stack.isEmpty()){
			node  = stack.peek();
			if(node.left!=null){
				stack.add(node.left);
				node.left=null;
				continue;
			}else{
				list.add(node.val);
				stack.pop();
			}
			if(node.right!=null){
				stack.add(node.right);
			}
		}
		return list;
	}
}
