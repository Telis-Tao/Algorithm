package com.leetcode.oj.tools;

public class RandomListNode {
	public int label;
	public RandomListNode next, random;

	public RandomListNode(int x) {
		this.label = x;
	}

	@Override
	public String toString() {
		String s = "label:" + label;
		if (next != null) {
			s += " next: " + next.label;
		}
		if (random != null) {
			s += " random: " + random.label;
		}
		return s;
	}

	public static void printList(RandomListNode root) {
		RandomListNode rootNext;
		rootNext = root;
		while (rootNext != null) {
			System.out.println(rootNext);
			rootNext = rootNext.next;
		}

	}

	public static RandomListNode createRandomListNode(int[] nums) {
		RandomListNode head = new RandomListNode(0);
		RandomListNode node = head;
		for (int i = 0; i < nums.length; i++) {
			node.next = new RandomListNode(nums[i]);
			node = node.next;
		}
		return head.next;
	}
}
