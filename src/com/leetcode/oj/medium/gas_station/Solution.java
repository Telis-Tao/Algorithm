package com.leetcode.oj.medium.gas_station;

/**
 * There are N gas stations along a circular route, where the amount of gas at
 * station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from station i to its next station (i+1). You begin the journey with
 * an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit
 * once, otherwise return -1.
 * 
 * Note: The solution is guaranteed to be unique.
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
		int[] gas = { 2,3,1};
		int[] cost = { 3,1,2 };
		Solution s = new Solution();
		int index = s.canCompleteCircuit(gas, cost);
		System.out.println("index :" + index);
	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int totalSum = 0;
		int currentSum = 0;
		int index = 0;
		for (int i = 0; i < cost.length; i++) {
			totalSum += gas[i] - cost[i];
			currentSum += gas[i] - cost[i];
//			System.out.println(currentSum);
			if (currentSum < 0) {
				currentSum = 0;
				index = i+1;
			}
		}
		if(totalSum>=0&&index<=gas.length)
			return index;
		else
			return -1;
		// int currentStation = 0;
		// // Ëã·¨
		// while (currentStation < gas.length) {
		// int sumGas = 0;
		// for (int i = currentStation;; i = i % gas.length) {
		// // currentStation = startStation;
		// sumGas += gas[i];
		// sumGas -= cost[i];
		// i = (++i) % gas.length;
		// if (sumGas < 0) {
		// break;
		// }
		// if (i == currentStation) {
		// return currentStation;
		// }
		// }
		// currentStation++;
		// }
	}
}
