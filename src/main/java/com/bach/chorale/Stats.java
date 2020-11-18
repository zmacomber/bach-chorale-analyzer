package com.bach.chorale;

import java.util.Map;

public class Stats {

    private final Map<Integer, String> allLines;

    private final int[] pitchSop;
    private final int[] pitchAlto;
    private final int[] pitchTenor;
    private final int[] pitchBass;

    public Stats(Map<Integer, String> allLines, int[] pitchSop, int[] pitchAlto, int[] pitchTenor, int[] pitchBass) {
        this.allLines = allLines;
        this.pitchSop = pitchSop;
        this.pitchAlto = pitchAlto;
        this.pitchTenor = pitchTenor;
        this.pitchBass = pitchBass;
    }

    public void printSteps() {
        Steps steps = new Steps();
        steps.add(pitchSop);
        steps.add(pitchAlto);
        steps.add(pitchTenor);
        steps.add(pitchBass);

        int totalOccurrences = steps.get().values().stream().mapToInt(Integer::valueOf).sum();

        steps.get().forEach((key, value) ->
                System.out.println(
                        "Step " + key + " occurs " + value + " times (" + getPercentage(value, totalOccurrences) + "%)."
                )
        );
    }

    public void printScaleDegrees() {
        ScaleDegrees scaleDegrees = new ScaleDegrees();
        scaleDegrees.add(allLines.get(1).split(","));
        scaleDegrees.add(allLines.get(3).split(","));
        scaleDegrees.add(allLines.get(5).split(","));
        scaleDegrees.add(allLines.get(7).split(","));

        int totalOccurrences = scaleDegrees.get().values().stream().mapToInt(Integer::valueOf).sum();

        scaleDegrees.get().forEach((key, value) ->
                System.out.println(
                        "Scale degree " + key + " occurs " + value + " times (" + getPercentage(value, totalOccurrences) + "%)."
                )
        );
    }

    private long getPercentage(int value, int totalOccurrences) {
        return Math.round(((double)value / (double)totalOccurrences) * 100);
    }
}
