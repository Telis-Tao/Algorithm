package com.leetcode.oj.easy.remove_Nth_node_from_end_of_list;

import java.util.LinkedList;
import com.leetcode.oj.tools.ListNode;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		Solution s = new Solution();
		s.addNext(head, 2);
		// s.addNext(head, 3);
		// s.addNext(head, 4);
		// s.addNext(head, 5);
		ListNode temp = head;
		s.removeNthFromEnd(head, 2);
		temp = head;
		while (temp != null) {
			System.out.print(temp.val + "\t");
			temp = temp.next;
		}
	}

	private void addNext(ListNode head, int val) {
		while (head.next != null) {
			head = head.next;
		}
		head.next = new ListNode(val);
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || head.next == null)
			return null;
		LinkedList<ListNode> nodes = new LinkedList<ListNode>();
		ListNode temp = head;
		while (temp != null) {
			if (nodes.size() == n + 1) {
				nodes.removeFirst();
			}
			nodes.add(temp);
			temp = temp.next;
		}
		if (nodes.size() == n)
			return head.next;
		if (nodes.size() > 2)
			nodes.get(0).next = nodes.get(2);
		else
			nodes.get(0).next = null;
		return head;
	}
}
