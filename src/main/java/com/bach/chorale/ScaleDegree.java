package com.bach.chorale;

import java.util.HashMap;
import java.util.Map;

public class ScaleDegree {
    private final Map<String,Integer> map = new HashMap<>();

    public ScaleDegree(Tonic tonic) {
        map.put("-8", tonic.getBasePitch() + -12);
        map.put("-2-", tonic.getBasePitch() + -11);
        map.put("-1+", tonic.getBasePitch() + -11);
        map.put("-2", tonic.getBasePitch() + -10);
        map.put("-2+", tonic.getBasePitch() + -9);
        map.put("-3-", tonic.getBasePitch() + -9);
        map.put("-3", tonic.getBasePitch() + -8);
        map.put("-4", tonic.getBasePitch() + -7);
        map.put("-4+", tonic.getBasePitch() + -6);
        map.put("-5-", tonic.getBasePitch() + -6);
        map.put("-5", tonic.getBasePitch() + -5);
        map.put("-5+", tonic.getBasePitch() + -4);
        map.put("-6-", tonic.getBasePitch() + -4);
        map.put("-6", tonic.getBasePitch() + -3);
        map.put("-6+", tonic.getBasePitch() + -2);
        map.put("-7-", tonic.getBasePitch() + -2);
        map.put("-7", tonic.getBasePitch() + -1);
        map.put("1", tonic.getBasePitch());
        map.put("1+", tonic.getBasePitch() + 1);
        map.put("2-", tonic.getBasePitch() + 1);
        map.put("2", tonic.getBasePitch() + 2);
        map.put("2+", tonic.getBasePitch() + 3);
        map.put("3-", tonic.getBasePitch() + 3);
        map.put("3", tonic.getBasePitch() + 4);
        map.put("4", tonic.getBasePitch() + 5);
        map.put("4+", tonic.getBasePitch() + 6);
        map.put("5-", tonic.getBasePitch() + 6);
        map.put("5", tonic.getBasePitch() + 7);
        map.put("5+", tonic.getBasePitch() + 8);
        map.put("6-", tonic.getBasePitch() + 8);
        map.put("6", tonic.getBasePitch() + 9);
        map.put("6+", tonic.getBasePitch() + 10);
        map.put("7-", tonic.getBasePitch() + 10);
        map.put("7", tonic.getBasePitch() + 11);
        map.put("8", tonic.getBasePitch() + 12);
        map.put("8+", tonic.getBasePitch() + 13);
        map.put("9-", tonic.getBasePitch() + 13);
        map.put("9", tonic.getBasePitch() + 14);
        map.put("9+", tonic.getBasePitch() + 15);
        map.put("10-", tonic.getBasePitch() + 15);
        map.put("10", tonic.getBasePitch() + 16);
        map.put("11", tonic.getBasePitch() + 17);
        map.put("11+", tonic.getBasePitch() + 18);
        map.put("12-", tonic.getBasePitch() + 18);
        map.put("12", tonic.getBasePitch() + 19);
    }

    public int map(String scaleDegree) {
        Integer val = map.get(scaleDegree);
        if (val == null) {
            throw new IllegalArgumentException("'" + scaleDegree + "' has no mapper");
        }
        return val;
    }
}
