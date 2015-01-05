package com.leetcode.oj.medium.reverse_linked_list2;

import com.leetcode.oj.tools.LinkListTools;
import com.leetcode.oj.tools.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
 * 
 * Note: Given m, n satisfy the following condition: 1 ¡Ü m ¡Ü n ¡Ü length of list.
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
		ListNode head = new ListNode(0);
		int[] vals = { 1, 2, 3, 4, 5, 6 };
		// int[] vals = { 1, 2 };
		ListNode temp = head;
		for (int i = 0; i < vals.length; i++) {
			temp.next = new ListNode(vals[i]);
			temp = temp.next;
		}
		head = head.next;
		LinkListTools.iterList(head);
		Solution s = new Solution();
		head = s.reverseBetween(head, 2, 4);
		// head = s.inverse(head, 1);
		LinkListTools.iterList(head);
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n)
			return head;
		if (m == 1) {
			return inverse(head, n - m);
		} else {
			ListNode root = head;
			for (int i = 0; i < m - 2; i++) {
				root = root.next;
			}
			// System.out.println(root.val);
			root.next = inverse(root.next, n - m);
			return head;
		}
	}

	private ListNode inverse(ListNode head, int count) {
		ListNode former = head;
		while (former.next != null && count > 0) {
			ListNode node = former.next;
			former.next = node.next;
			node.next = head;
			head = node;
			count--;
		}
		return head;
	}
}
