package com.leetcode.oj.medium.sort_list;

import com.leetcode.oj.tools.LinkListTools;
import com.leetcode.oj.tools.ListNode;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ListNode head = LinkListTools.createLinkedList(new int[] { 1, 3, 5, 7,
//				9 });
//		ListNode half = LinkListTools.createLinkedList(new int[] { 1, 2, 3, 4,
//				5, 6, 7, 8 });
//		head = new Solution().merge(head, half);
//		LinkListTools.iterList(head);

		 ListNode head = LinkListTools.createLinkedList(new
		 int[]{});
		 head = new Solution().sortList(head);
		 LinkListTools.iterList(head);
	}

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode half = head;
		ListNode tail = head;
		while (tail.next != null && tail.next.next != null) {
			half = half.next;
			tail = tail.next.next;
		}
		// LinkListTools.iterList(head);
		ListNode next = half.next;
		half.next = null;
		half = next;
		head = sortList(head);
//		LinkListTools.iterList(head);
		half = sortList(half);
//		LinkListTools.iterList(half);
		return merge(head, half);
	}


	private ListNode merge(ListNode head, ListNode half) {
		// TODO Auto-generated method stub
		ListNode result = new ListNode(0);
		ListNode temp = result;
		while (head != null && half != null) {
			if (head.val <= half.val) {
				temp.next = head;
				head = head.next;
				temp = temp.next;
			} else {
				temp.next = half;
				half = half.next;
				temp = temp.next;
			}
		}
		while (head != null) {
			temp.next = head;
			head = head.next;
			temp = temp.next;
		}
		while (half != null) {
			temp.next = half;
			half = half.next;
			temp = temp.next;
		}
		return result.next;
	}
}
