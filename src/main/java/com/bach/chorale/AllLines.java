package com.bach.chorale;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

public class AllLines {

    private final String chorale;

    public AllLines(String chorale) {
        this.chorale = chorale;
    }

    public Map<Integer,String> build() {
        Map<Integer, String> allLines = new TreeMap<>();
        if (chorale != null) {
            addToAllLines(Chorales.get(Integer.valueOf(chorale)), allLines);
        } else {
            Chorales.getAll().forEach((k,v) -> {
                System.out.println("Processing " + k);
                addToAllLines(v, allLines);
            });
        }
        return allLines;
    }

    private void addToAllLines(List<String> fileLines, Map<Integer, String> allLines) {
        int lineNum = 1;
        for (String line : fileLines) {
            if (allLines.containsKey(lineNum)) {
                allLines.put(lineNum, allLines.get(lineNum) + "," + line);
            } else {
                allLines.put(lineNum, line);
            }
            lineNum++;
        }
    }
}
