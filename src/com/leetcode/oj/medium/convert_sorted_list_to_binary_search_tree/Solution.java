package com.leetcode.oj.medium.convert_sorted_list_to_binary_search_tree;

import com.leetcode.oj.easy.binary_tree_level_order_traversal2.TreeNode;
import com.leetcode.oj.easy.remove_duplicates_from_sorted_list.ListNode;
import com.leetcode.oj.tools.TreeTools;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
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
		int[] vals = { 3, 5, 8 };
//		int[] vals = { 1,2,3,4,5,6,7,8,9 };
		ListNode head = new ListNode(0);
		ListNode temp = head;
		for (int i = 0; i < vals.length; i++) {
			temp.next = new ListNode(vals[i]);
			temp = temp.next;
		}
		head = head.next;
		Solution s = new Solution();
		TreeNode root = s.sortedListToBST(head);
		 TreeTools.firstPrint(root);
	}

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return new TreeNode(head.val);
		TreeNode root;
		ListNode slow, fast;
		slow = head;
		fast = head.next;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		root = new TreeNode(slow.next.val);
		fast = slow.next.next;
		slow.next = null;
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(fast);
		return root;
	}

}
