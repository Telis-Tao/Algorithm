package com.leetcode.oj.medium.clone_graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import com.leetcode.oj.tools.UndirectedGraphNode;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list
 * of its neighbors.
 * 
 * 
 * OJ's undirected graph serialization: Nodes are labeled uniquely.
 * 
 * We use # as a separator for each node, and , as a separator for node label
 * and each neighbor of the node. As an example, consider the serialized graph
 * {0,1,2#1,2#2,2}.
 * 
 * The graph has a total of three nodes, and therefore contains three parts as
 * separated by #.
 * 
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2. Second node
 * is labeled as 1. Connect node 1 to node 2. Third node is labeled as 2.
 * Connect node 2 to node 2 (itself), thus forming a self-cycle. Visually, the
 * graph looks like the following:
 * 
 * 1 / \ / \ 0 --- 2 / \ \_/
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
		// UndirectedGraphNode node0 = new UndirectedGraphNode(0);
		UndirectedGraphNode node0 = new UndirectedGraphNode(0);
		UndirectedGraphNode node1 = new UndirectedGraphNode(1);
		UndirectedGraphNode node2 = new UndirectedGraphNode(2);
		node0.neighbors.add(node1);
		node0.neighbors.add(node2);
		node1.neighbors.add(node0);
		node1.neighbors.add(node2);
		node2.neighbors.add(node0);
		node2.neighbors.add(node1);
		node2.neighbors.add(node2);
		Solution s = new Solution();
		UndirectedGraphNode result = s.cloneGraph(node0);
		System.out.println(result);
		for (int i = 0; i < result.neighbors.size(); i++) {
			System.out.println(result.neighbors.get(i));
		}
		// System.out.println("result label:\t" + result.label);
		// System.out.println("result list:\t" + result.neighbors);
	}

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
		node = cloneGraph(node, map);
		return node;
	}

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node,
			Map<Integer,UndirectedGraphNode> map) {
		if (node == null)
			return null;
		UndirectedGraphNode nNode = new UndirectedGraphNode(node.label);
		map.put(node.label, nNode);
		for (Iterator<UndirectedGraphNode> it = node.neighbors.iterator(); it
				.hasNext();) {
			UndirectedGraphNode nodeInList = it.next();
			if (!map.containsKey(nodeInList.label)) {
				nNode.neighbors.add(cloneGraph(nodeInList, map));
			}else{
				nNode.neighbors.add(map.get(nodeInList.label));
			}
		}
		return nNode;
	}
}
