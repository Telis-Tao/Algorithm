package com.leetcode.oj.hard.merge_k_sorted_lists;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.oj.tools.LinkListTools;
import com.leetcode.oj.tools.ListNode;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity. 经过粗略计算，应该有O(n^2)的时间复杂度吧
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
		List<ListNode> lists = new ArrayList<ListNode>();
		lists.add(LinkListTools.createLinkedList(new int[] { 2 }));
		lists.add(LinkListTools.createLinkedList(new int[] {}));
		lists.add(LinkListTools.createLinkedList(new int[] { -1 }));
		LinkListTools.iterList(new Solution().mergeKLists(lists));
	}

	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists.size() < 1)
			return null;
		if (lists.size() == 1)
			return lists.get(0);
		ListNode node = null;
		node = mergeKLists(lists, 0, lists.size() - 1);
		return node;
	}

	public ListNode mergeKLists(List<ListNode> lists, int start, int end) {
		if (start + 1 == end) {
			return mergeTwoLists(lists.get(start), lists.get(end));
		} else if (start < end) {
			int half = (start + end) / 2;
			ListNode left = mergeKLists(lists, start, half);
			ListNode right = mergeKLists(lists, half + 1, end);
			return mergeTwoLists(left, right);
		} else if (start == end) {
			return lists.get(start);
		}
		return null;
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode temp1 = l1;
		ListNode temp2 = l2;
		// L2的小于头节点的情况：
		if (temp2.val < l1.val) {
			while (temp2.next != null && temp2.next.val < l1.val) {
				temp2 = temp2.next;
			}
			ListNode temp = temp2.next;
			temp2.next = l1;
			l1 = l2;
			temp1 = l1;
			temp2 = temp;
		}
		// 处理常规的情况
		while (temp1.next != null && temp2 != null) {
			if (temp1.next.val > temp2.val) {
				ListNode temp = temp2;
				temp2 = temp2.next;
				temp.next = temp1.next;
				temp1.next = temp;
			} else {
				temp1 = temp1.next;
			}
		}
		if (temp1.next == null) {
			temp1.next = temp2;
		}
		return l1;
	}
}
