package com.leetcode.oj.easy.linked_list_cycle;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(0);
		ListNode tail = new ListNode(-4);
		head.next.next.next = tail;
		tail.next = tail;
		// tail.next = head.next.next;
		Solution s = new Solution();
		System.out.println(s.hasCycle(head));
	}

	// /**
	// * Definition for singly-linked list.
	// * class ListNode {
	// * int val;
	// * ListNode next;
	// * ListNode(int x) {
	// * val = x;
	// * next = null;
	// * }
	// * }
	// */
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode slow, fast;
		slow = head;
		fast = head;
		while (slow != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == null || fast == null)
				return false;
			if (slow.hashCode() == fast.hashCode())
				return true;
		}
		return false;
	}
}
