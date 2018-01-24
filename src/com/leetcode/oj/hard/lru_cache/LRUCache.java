package com.leetcode.oj.hard.lru_cache;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private Map<Integer, Node> data;
    private int capacity;

    public LRUCache(int capacity) {
        data = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (data.containsKey(key)) {
            Node node = data.get(key);
            delete(node);
            insert(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (data.containsKey(key)) {
            Node node = data.get(key);
            delete(node);
            insert(node);
            node.value = value;
        } else {
            Node node = new Node();
            node.key = key;
            node.value = value;
            if (data.size() < capacity) {//not full
                insert(node);
                data.put(key, node);
            } else {
                Node oldNode = tail;
                delete(oldNode);
                data.remove(oldNode.key);
                insert(node);
                data.put(key, node);
            }
        }
    }


    private Node head = null;
    private Node tail = null;

    private void insert(Node node) {
        if (head == null) {
            head = tail = node;
        } else {
            clear(node);
            node.next = head;
            head.previous = node;
            head = node;
        }
    }

    private void delete(Node node) {
        if (node == head) {
            head = head.next;
        } else if (node == tail) {
            tail.previous.next = null;
            tail = tail.previous;
        } else {
            node.previous.next = node.next;
            node.next.previous = node.previous;
        }
        clear(node);
    }

    private void clear(Node node) {
        node.next = null;
        node.previous = null;
    }

    class Node {
        int key;
        int value;
        Node previous;
        Node next;
    }
}
