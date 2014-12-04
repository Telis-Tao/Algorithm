package com.leetcode.oj.medium.rotate_list;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.leetcode.oj.tools.LinkListTools;
import com.leetcode.oj.tools.ListNode;

/**
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * For example: Given 1->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NULL.
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
		ListNode head = LinkListTools.createLinkedList(new int[] { 1, 2, 3, 4,
				5 });
		// ListNode head = LinkListTools.createLinkedList(new int[] { 1, 2 });
		Solution s = new Solution();
		s.rotateRight(head, 6);
	}

	public ListNode rotateRight(ListNode head, int n) {
		if (head == null || head.next == null || n < 1) {
			return head;
		}
		LinkedList<ListNode> list = new LinkedList<ListNode>();
		ListNode node = head;
		while (node != null) {
			list.add(node);
			if (list.size() > n + 1) {
				list.removeFirst();
			}
			node = node.next;
		}
		if (list.size() == n) {
			return head;
		}
		if (list.size() < n) {
			n = n % list.size();
			return rotateRight(head, n);
		}
		list.getLast().next = head;
		head = list.getFirst().next;
		list.get(0).next = null;
//		LinkListTools.iterList(head);
		return head;
	}
}
