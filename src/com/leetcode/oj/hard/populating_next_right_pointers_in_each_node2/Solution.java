package com.leetcode.oj.hard.populating_next_right_pointers_in_each_node2;

import com.leetcode.oj.tools.TreeLinkNode;

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * 
 * What if the given tree could be any binary tree? Would your previous solution
 * still work?
 * 
 * Note:
 * 
 * You may only use constant extra space. For example, Given the following
 * binary tree, 1 / \ 2 3 / \ \ 4 5 7 After calling your function, the tree
 * should look like: 1 -> NULL / \ 2 -> 3 -> NULL / \ \ 4-> 5 -> 7 -> NULL
 * 
 * @author Telis
 * 
 */
public class Solution {
	TreeLinkNode next;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		root.left.left = new TreeLinkNode(4);
		// root.left.right = new TreeLinkNode(5);
		// root.right.left = new TreeLinkNode(6);
		root.right.right = new TreeLinkNode(7);
		s.connect(root);
		System.out.println(root.val);
		// s.iter(root);
	}

	// private void iter(TreeLinkNode root) {
	// // TODO Auto-generated method stub
	// if (root == null)
	// return;
	// TreeLinkNode upper = root;
	// next = upper;
	// upper = findNext(node);
	// }

	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		TreeLinkNode upper = root;
		while (upper != null) {
			next = upper;
			TreeLinkNode left = null;
			TreeLinkNode right = null;
			upper = left = findNext(null);
			// System.out.println(left+":"+next);
			right = findNext(left);
			// System.out.println(left+":"+right);
			while (right != null) {
				left.next = right;
				// System.out.println(left + ":" + right);
				left = right;
				right = findNext(left);
			}
		}
	}

	/**
	 * @param node
	 *            父节点
	 * @param isLeft
	 *            0:寻找LEFT（最开始不为NULL的） 1:上一个寻找到的在左边 2 上一个寻找到的在右边
	 * @return
	 */
	public TreeLinkNode findNext(TreeLinkNode node) {
		if (node == null) {
			while (next != null) {
				if (next.left != null)
					return next.left;
				if (next.right != null)
					return next.right;
				next = next.next;
			}
			return null;
		} else {
			if (next.left == node) {
				if (next.right != null)
					return next.right;
				else {
					next = next.next;
					while (next != null) {
						if (next.left != null)
							return next.left;
						if (next.right != null)
							return next.right;
						next = next.next;
					}
				}
			} else if (next.right == node) {
				next = next.next;
				while (next != null) {
					if (next.left != null)
						return next.left;
					if (next.right != null)
						return next.right;
					next = next.next;
				}
				return null;
			}
		}
		return null;
	}
}
