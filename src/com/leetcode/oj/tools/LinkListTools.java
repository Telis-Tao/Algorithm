package com.leetcode.oj.tools;


public class LinkListTools {
	public static void iterList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "\t");
			head = head.next;
		}
		System.out.println();
	}

	public static ListNode createLinkedList(int[] vals) {
		ListNode head = new ListNode(0);
		ListNode temp = head;
		for (int i = 0; i < vals.length; i++) {
			temp.next = new ListNode(vals[i]);
			temp = temp.next;
		}
		return head.next;
	}
}
