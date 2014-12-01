package com.leetcode.oj.medium.reorder_list;

import com.leetcode.oj.tools.ListNode;

/**
 * Given a singly linked list L: L0¡úL1¡ú¡­¡úLn-1¡úLn, reorder it to:
 * L0¡úLn¡úL1¡úLn-1¡úL2¡úLn-2¡ú¡­
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * @author Telis
 * 
 */
public class Solution {
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		int[] vals = { 1, 2, 3, 4, 5, 6 };
		ListNode temp = head;
		for (int i = 0; i < vals.length; i++) {
			temp.next = new ListNode(vals[i]);
			temp = temp.next;
		}
		head = head.next;
		// Solution.reverse(head);
		Solution s = new Solution();
		s.reorderList(head);
		while (head != null) {
			System.out.print(head.val);
			head = head.next;
		}

	}

	public void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null)
			return;
		ListNode slower, reverse;
		slower = head;
		reverse = head;
		while (reverse.next != null && reverse.next.next != null) {
			slower = slower.next;
			reverse = reverse.next.next;
		}
		reverse = slower.next;
		slower.next = reverseLinkList(reverse);
		ListNode first = head;
		reverse = slower.next;
		slower.next = null;
		while (reverse != null) {
			ListNode temp = reverse;
			reverse = reverse.next;
			temp.next = first.next;
			first.next = temp;
			first = temp.next;
		}

	}

	public static ListNode reverseLinkList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode p = head;
		ListNode q = null;
		while (p.next != null) {
			q = p.next;
			p.next = q.next;
			q.next = head;
			head = q;
		}
		return head;
	}
}
