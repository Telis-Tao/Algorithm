package com.leetcode.oj.medium.populating_next_right_pointers_in_each_node;

import com.leetcode.oj.tools.TreeLinkNode;

/**
 * Populate each next pointer to point to its next right node. If there is no
 * next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * Note:
 * 
 * You may only use constant extra space. You may assume that it is a perfect
 * binary tree (ie, all leaves are at the same level, and every parent has two
 * children).
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
		Solution s = new Solution();
		TreeLinkNode root = new TreeLinkNode(1);
		 root.left = new TreeLinkNode(2);
		 root.right = new TreeLinkNode(3);
		 root.left.left = new TreeLinkNode(4);
		 root.left.right = new TreeLinkNode(5);
		 root.right.left = new TreeLinkNode(6);
		 root.right.right = new TreeLinkNode(7);
		s.connect(null);
	}

	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		TreeLinkNode upper = root;
		while (upper.left != null) {
			TreeLinkNode next = upper;
			while (next != null) {
				next.left.next = next.right;
				if (next.next != null) {
					next.right.next = next.next.left;
				}
				next = next.next;
			}
			upper = upper.left;
		}
	}

	// if (root == null)
	// return;
	// TreeLinkNode pre = root;
	// TreeLinkNode cur;
	// while (pre.left != null) {
	// cur = pre;
	// while (cur != null) {
	// cur.left.next = cur.right;
	// if (cur.next != null) {
	// cur.right.next = cur.next.left;
	// }
	// cur = cur.next;
	// }
	// pre = pre.left;
	// }
}
