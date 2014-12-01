package com.leetcode.oj.medium.add_two_numbers;

import com.leetcode.oj.tools.ListNode;

/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
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
		Solution s = new Solution();
		ListNode root1 = new ListNode(2);
		root1.next = new ListNode(4);
		root1.next.next = new ListNode(3);

		ListNode root2 = new ListNode(5);
		root2.next = new ListNode(6);
		root2.next.next = new ListNode(8);
		// root2.next.next.next = new ListNode(4);

		ListNode result = s.addTwoNumbers(root1, root2);
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result, r1;
		result = r1 = new ListNode(0);
		boolean isAdd = false;
		while (l1 != null && l2 != null) {
			r1.next = new ListNode(l1.val + l2.val);
			r1 = r1.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		while (l1 != null) {
			r1.next = new ListNode(l1.val);
			r1 = r1.next;
			l1 = l1.next;
		}
		while (l2 != null) {
			r1.next = new ListNode(l2.val);
			r1 = r1.next;
			l2 = l2.next;
		}
		r1 = result;
		while (r1.next != null) {
			if (isAdd) {
				r1.next.val++;
				isAdd = false;
			}
			if (r1.next.val >= 10) {
				r1.next.val -= 10;
				isAdd = true;
			}
			r1 = r1.next;
		}
		if(isAdd){
			r1.next = new ListNode(1);
		}
//		if (isAdd) {
//			r1 = result.next;
//			while (r1.next != null)
//				r1 = r1.next;
//			r1.next = new ListNode(1);
//		}
		return result.next;
		// while (l1 != null && l2 != null) {
		// temp = l1.val + l2.val;
		// // System.out.println(temp);
		// if (isAdd) {
		// temp++;
		// isAdd = false;
		// }
		// if (temp >= 10) {
		// isAdd = true;
		// temp -= 10;
		// }
		// r1.next = new ListNode(temp);
		// r1 = r1.next;
		// l1 = l1.next;
		// l2 = l2.next;
		// }
		// if (isAdd) {
		// if (l1 != null)
		// l1.val++;
		// if (l2 != null)
		// l2.val++;
		// if (l1 == null && l2 == null)
		// r1.next = new ListNode(1);
		// }
		// if (l1 != null) {
		// r1.next = new ListNode(l1.val);
		// r1 = r1.next;
		// l1 = l1.next;
		// }
		// if (l2 != null) {
		// r1.next = new ListNode(l2.val);
		// r1 = r1.next;
		// l2 = l2.next;
		// }
		// return result.next;
	}
}
