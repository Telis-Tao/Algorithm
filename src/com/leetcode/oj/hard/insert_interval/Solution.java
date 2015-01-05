package com.leetcode.oj.hard.insert_interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as
 * [1,5],[6,9].
 * 
 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in
 * as [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
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
		s.insert(intervals,new Interval(2, 5));
	}
	
	/**把merge interval的代码全抄过来，改吧改吧就AC了。。。
	 * @param intervals
	 * @param newInterval
	 * @return
	 */
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		intervals.add(newInterval);
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
		return list;
	}

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
