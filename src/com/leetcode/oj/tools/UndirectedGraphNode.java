package com.leetcode.oj.tools;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphNode {
	public int label;
	public List<UndirectedGraphNode> neighbors;

	public UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}

	@Override
	public String toString() {
		String str = "";
		str += "label=" + label+"\n";
		str += "neighbors:\n";
		for (int i = 0; i < neighbors.size(); i++) {
			str += neighbors.get(i).label+"\n";
		}
		return str;
	}
	
}
