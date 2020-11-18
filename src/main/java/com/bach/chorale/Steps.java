package com.bach.chorale;

import java.util.Map;
import java.util.TreeMap;

public class Steps {

    private final Map<Integer,Integer> map = new TreeMap<>();

    public void add(int[] pitches) {
        for (int x = (pitches.length - 1); x > 0; x--) {
            int step = pitches[x - 1] - pitches[x];
            if (step < 0) {
                step *= -1;
            }
            int occurrences = map.getOrDefault(step,0) + 1;
            map.put(step, occurrences);
        }
    }

    public Map<Integer,Integer> get() {
        return map;
    }
}
