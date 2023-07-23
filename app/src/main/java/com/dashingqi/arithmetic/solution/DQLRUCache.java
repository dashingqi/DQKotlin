package com.dashingqi.arithmetic.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : zhangqi
 * @desc : Lru cache
 * @time : 2023/7/23 16:55
 */
public class DQLRUCache {
    int capacity;
    Map<Integer, Integer> maps;

    public DQLRUCache(int capacity) {
        this.capacity = capacity;
        maps = new HashMap<>();
    }

    public Integer get(int key) {
        if (!maps.containsKey(key)) {
            return -1;
        }
        Integer value = maps.remove(key);
        maps.put(key, value);
        return value;

    }

    public void put(int key, int value) {
        if (maps.containsKey(key)) {
            maps.remove(key);
            maps.put(key, value);
            return;
        }
        maps.put(key, value);
        if (capacity < maps.size()) {
            maps.remove(maps.keySet().iterator().next());
        }


    }
}
