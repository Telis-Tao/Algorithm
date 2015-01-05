package com.leetcode.oj.hard.distinct_subsequences;

import junit.framework.TestCase;

public class Test extends TestCase {
	public void testSolution() {
		Solution s = new Solution();
		// assertEquals(10,s.numDistinct1("rabbitrabbit", "rabbit"));
		// assertEquals(,s.numDistinct("rabbitrabbit", "rabbit"));
		assertEquals(0, s.numDistinct("", "a"));
		assertEquals(0, s.numDistinct("fff", "ffff"));
		assertEquals(2, s.numDistinct("aabb", "abb"));
		// assertEquals(,s.numDistinct("raatrat", "rat"));
		// assertEquals(,s.numDistinct("raara", "ra"));
		assertEquals(3, s.numDistinct("rabbbit", "rabbit"));
	}
}
