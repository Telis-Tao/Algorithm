package com.leetcode.oj.hard.search_in_rotated_sorted_array;

import junit.framework.TestCase;

public class Test extends TestCase {
	public void testSolution() {
		Solution s = new Solution();
		assertEquals(s.search(new int[] { 3 }, 3), 0);
		assertEquals(s.search(new int[] {  }, 3), -1);
		assertEquals(s.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 2), 6);
		assertEquals(s.search(new int[] { 4, 5, 1, 2, 3 }, 2), 3);
		assertEquals(s.search(new int[] { 1, 3, 5 }, 0), -1);
		assertEquals(s.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3), -1);
		assertEquals(s.search(new int[] { 3, 1, 2 }, 0), -1);
		assertEquals(s.search(new int[] { 3, 5, 1 }, 0), -1);
		assertEquals(s.search(new int[] { 1, 3 }, 3), 1);
		assertEquals(s.search(new int[] { 3, 5, 1 }, 3), 0);
		assertEquals(s.search(new int[] { 3, 1 }, 0), -1);
		assertEquals(s.search(new int[] {5,1,3 }, 5), 0);
	}
}
