package com.leetcode.oj.hard.maximum_gap;

public class Buc {
	int max = -1;
	int min = -1;
	boolean isEmpty = true;

	public void add(int num) {
		if (isEmpty){
			max = min = num;
			isEmpty = false;
		}
		if (num > max)
			max = num;
		if (num < min)
			min = num;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	@Override
	public String toString() {
		return "Buc [max=" + max + ", min=" + min + "]";
	}
	
}
