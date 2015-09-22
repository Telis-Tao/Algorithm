package com.leetcode.oj.medium.binary_search_tree_iterator;

import java.util.Stack;

import com.leetcode.oj.tools.TreeNode;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 * 
 * @author Telis
 * 
 */
public class BSTIterator {
	Stack<TreeNode> stack = new Stack<>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(6);
		root.right.right = new TreeNode(9);
		root.right.left = new TreeNode(5);
		BSTIterator it = new BSTIterator(root);
		while (it.hasNext()) {
			// System.out.println(it.stack);
			System.out.println("next:" + it.next());
		}
	}

	/**
	 * �����ʵ������ջ�ķ���ʵ��һ����������������ܼ򵥡�����
	 * 
	 * @param root
	 */
	public BSTIterator(TreeNode root) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode node = stack.pop();
		if (node.right != null) {
			// System.out.println(node.val);
			stack.push(node.right);
			TreeNode temp = node.right;
			while (temp.left != null) {
				stack.push(temp.left);
				temp = temp.left;
			}
		}
		return node.val;
	}
	/**
	 * Your BSTIterator will be called like this: BSTIterator i = new
	 * BSTIterator(root); while (i.hasNext()) v[f()] = i.next();
	 */
}
