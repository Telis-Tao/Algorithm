package com.leetcode.oj.medium.linked_list_cycle2;

import com.leetcode.oj.tools.ListNode;

/**
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 * 
 * Follow up: Can you solve it without using extra space?
 * 
 * @author Telis
 * 
 */
public class Solution {
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		// int[] vals = { 1, 2, 3, 4, 5, 6 };
		int[] vals = { 1, 2 };
		ListNode temp = head;
		for (int i = 0; i < vals.length; i++) {
			temp.next = new ListNode(vals[i]);
			temp = temp.next;
		}
		head = head.next;
		temp.next = head;
		Solution s = new Solution();
		temp = head;
		ListNode cycleNode = s.detectCycle(head);
		System.out.println("cycleNode:" + cycleNode.val);
	}

	public ListNode detectCycle(ListNode head) {
		if (head == null)
			return null;
		ListNode slow, fast;
		slow = head;
		fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				ListNode cycleNode = head;
				while (true) {
					fast = fast.next;
					if (cycleNode == fast)
						return cycleNode;
					while (fast != slow) {
						fast = fast.next;
						if (cycleNode == fast)
							return cycleNode;
					}
					cycleNode = cycleNode.next;
				}
			}
		}
		return null;
	}
}
