package com.leetcode.oj.hard.lru_cache;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

class LRUCache {
    Queue<Integer> list;
    Map<Integer, Integer> data;

    public LRUCache(int capacity) {
        list = new LinkedBlockingDeque<>(capacity);
        data = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (data.containsKey(key)) {
            fresh(key);
        }else{
            Integer removeKey = list.poll();
            data.remove(removeKey);
            list.add(key);
            data.put(key);
        }
    }

    public void put(int key, int value) {
        if (list.contains(key)) {
            list.remove(key);
            list.add(key);
        }
    }


    private void fresh(int key) {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer tmpKey = it.next();
            if (tmpKey == key) {
                it.remove();
                break;
            }
        }
        list.add(key);
    }
}
