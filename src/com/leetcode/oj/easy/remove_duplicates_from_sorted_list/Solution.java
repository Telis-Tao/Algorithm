package com.leetcode.oj.easy.remove_duplicates_from_sorted_list;

import com.leetcode.oj.tools.ListNode;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ListNode head = new ListNode(3);
//		head.next = new ListNode(2);
//		head.next.next = new ListNode(2);
//		ListNode tail = new ListNode(0);
//		head.next.next.next = tail;

		 ListNode head = new ListNode(1);
		 head.next = new ListNode(1);

		Solution s = new Solution();
		s.deleteDuplicates(head);
		ListNode temp = head;
		while (temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null||head.next == null) {
			return head;
		}
		ListNode first = head;
		ListNode then = head.next;
		while (then != null) {
			if (first.val == then.val) {
				then = then.next;
				first.next = then;
			} else {
				first = then;
				then = then.next;
			}
		}
		return head;
	}
}
