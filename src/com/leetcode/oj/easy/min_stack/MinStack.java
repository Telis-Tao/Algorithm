package com.leetcode.oj.easy.min_stack;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * push(x) -- Push element x onto stack. pop() -- Removes the element on top of
 * the stack. top() -- Get the top element. getMin() -- Retrieve the minimum
 * element in the stack.
 * 
 * @author Telis
 * 
 */
class MinStack {
	long min;
	Stack<Long> stack = new Stack<>();

	public void push(int x) {
		if (stack.isEmpty()) {
			min = x;
			stack.push((long) 0);
		} else {
			stack.push(x - min);
			if (x < min) {
				min = x;
			}
		}
	}

	public void pop() {
		if (stack.isEmpty()) {
			return;
		}
		long x = stack.pop();
		if (x <= 0) {
			min = min - x;
		}
	}

	public int top() {
		long top = stack.peek();
		if (top > 0) {
			return (int) (top + min);
		} else {
			return (int) min;
		}
	}

	public int getMin() {
		return (int) min;
	}

}
