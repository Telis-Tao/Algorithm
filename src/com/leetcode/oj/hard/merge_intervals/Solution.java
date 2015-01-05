package com.leetcode.oj.hard.merge_intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
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
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(0, 2));
		intervals.add(new Interval(-1, 1));
		intervals.add(new Interval(7, 8));
		intervals.add(new Interval(1, 4));
		intervals.add(new Interval(2, 3));
		s.merge(intervals);
	}

	/**
	 * 耗时竟然排名靠前。。。实在没想到，代码写的太LOW了，正在改进中
	 * 
	 * @param intervals
	 * @return
	 */
	public List<Interval> merge(List<Interval> intervals) {
		// System.out.println(intervals);
		sort(intervals, 0, intervals.size() - 1, new Interval[intervals.size()]);
		// System.out.println(intervals);
		List<Interval> list = new ArrayList<Interval>();
		for (int i = 0; i < intervals.size(); i++) {
			int left = intervals.get(i).start;
			int right = intervals.get(i).end;
			for (int j = i + 1; j < intervals.size(); j++) {
				if (intervals.get(j).start <= right) {
					if (right < intervals.get(j).end)
						right = intervals.get(j).end;
					i++;
				} else {
					break;
				}
			}
			list.add(new Interval(left, right));
		}
		System.out.println(list);
		return list;
	}

	// 排序
	// public void sort(List<Interval> intervals){
	//
	//
	// }

	public void sort(List<Interval> intervals, int start, int end,
			Interval[] temp) {
		if (start < end) {
			int half = (start + end) / 2;
			sort(intervals, start, half, temp);
			sort(intervals, half + 1, end, temp);
			// Interval[] temp = new Interval[end - start + 1];
			int left = start, right = half + 1, count = start;
			while (left <= half && right <= end) {
				int flag = compare(intervals.get(left), intervals.get(right));
				if (flag == 1) {
					temp[count++] = intervals.get(right++);
				} else {
					temp[count++] = intervals.get(left++);
				}
			}
			while (left <= half) {
				temp[count++] = intervals.get(left++);
			}
			while (right <= end) {
				temp[count++] = intervals.get(right++);
			}
			for (int i = start; i <= end; i++) {
				// Interval inter = intervals.get(start+i);
				// inter = temp[i];
				intervals.set(i, temp[i]);
			}
		}
	}

	private int compare(Interval interval, Interval interval2) {
		// TODO Auto-generated method stub
		if (interval.start < interval2.start) {
			return -1;
		} else if (interval.start > interval2.start) {
			return 1;
		} else {
			if (interval.end < interval2.end) {
				return -1;
			} else if (interval.end > interval2.end) {
				return 1;
			} else {
				return 0;
			}
		}
	}
}
