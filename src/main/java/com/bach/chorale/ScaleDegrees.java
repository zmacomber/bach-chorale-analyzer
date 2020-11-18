package com.bach.chorale;

import java.util.Map;
import java.util.TreeMap;

public class ScaleDegrees {

    private final Map<String,Integer> map = new TreeMap<>();

    public void add(String[] pitches) {
        for (String s : pitches) {
            String pitch = s.replace("8", "1").replace("9", "2")
                    .replace("10", "3").replace("11", "4")
                    .replace("12", "5");
            if (pitch.startsWith("-")) {
                pitch = pitch.substring(1);
            }
            int occurrences = map.getOrDefault(pitch, 0) + 1;
            map.put(pitch, occurrences);
        }
    }

    public Map<String,Integer> get() {
        return map;
    }
}
