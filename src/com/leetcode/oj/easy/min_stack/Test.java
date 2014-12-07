package com.leetcode.oj.easy.min_stack;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack m = new MinStack();
		// m.push(2147483646);
		// m.push(2147483646);
		// m.push(2147483647);
		// m.top();
		// m.pop();
		// m.getMin();
		// m.pop();
		// m.getMin();
		// m.pop();
		// m.push(2147483647);
		// m.top();m.getMin();
		// m.push(-2147483648);
		// m.top();
		// m.getMin();
		// m.pop();
		// m.getMin();
		m.push(2);
		m.push(0);
		m.push(3);
		m.push(0);
		m.getMin();
		System.out.println(m);
		m.pop();
		System.out.println(m);
		m.getMin();
		m.pop();
		System.out.println(m);
		m.getMin();
		m.pop();
		System.out.println(m);
		m.getMin();
	}
}
