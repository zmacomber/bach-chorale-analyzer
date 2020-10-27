import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.sound.midi.MidiSystem;

import jm.JMC;
import jm.music.data.*;
import jm.util.*;

public class BachChoraleAnalyzer implements JMC {

	public static void main(String[] args) throws Exception {
        BachChoraleAnalyzer bca = new BachChoraleAnalyzer(args[0]);

		Phrase soprano = new Phrase();
		Phrase alto = new Phrase();
		Phrase tenor = new Phrase();
		Phrase bass = new Phrase();
		
		soprano.addNoteList(bca.pitchSop, bca.rhythmSop);
		alto.addNoteList(bca.pitchAlto, bca.rhythmAlto);
		tenor.addNoteList(bca.pitchTenor, bca.rhythmTenor);
		bass.addNoteList(bca.pitchBass, bca.rhythmBass);
		
		Part s = new Part("Soprano", OOH, 1);
		Part a = new Part("Alto", AAH, 2);
		Part t = new Part("Tenor", OOH, 3);
		Part b = new Part("Bass", AAH, 4);
		
		s.addPhrase(soprano);
		a.addPhrase(alto);
		t.addPhrase(tenor);
		b.addPhrase(bass);
		
		Score score = new Score(args[0]);
		
		score.addPart(s);
		score.addPart(a);
		score.addPart(t);
		score.addPart(b);
		
		Play.midi(score);
	}

    enum Tonic {
        SOP  (72), // C inside treble clef staff
        MID  (60), // C below treble clef staff
        BASS (48); // C inside bass clef staff

        int basePitch;

        Tonic(int basePitch) {
            this.basePitch = basePitch;
        }

        int getBasePitch() {
            return basePitch;
        }
    }

    private final List<String> allLines;

    private final int[] pitchSop;
    private final double[] rhythmSop;
    private final int[] pitchAlto;
    private final double[] rhythmAlto;
    private final int[] pitchTenor;
    private final double[] rhythmTenor;
    private final int[] pitchBass;
    private final double[] rhythmBass;

    BachChoraleAnalyzer(String satbCsvFileName) throws Exception {
        allLines = Files.readAllLines(Paths.get(satbCsvFileName));

        pitchSop    = Stream.of(allLines.get(0).split(",")).mapToInt(scaleDegree -> mapScaleDegree(scaleDegree, Tonic.SOP)).toArray();
        rhythmSop   = Stream.of(allLines.get(1).split(",")).mapToDouble(this::mapNote).toArray();
        pitchAlto   = Stream.of(allLines.get(2).split(",")).mapToInt(scaleDegree -> mapScaleDegree(scaleDegree, Tonic.MID)).toArray();
        rhythmAlto  = Stream.of(allLines.get(3).split(",")).mapToDouble(this::mapNote).toArray();
        pitchTenor  = Stream.of(allLines.get(4).split(",")).mapToInt(scaleDegree -> mapScaleDegree(scaleDegree, Tonic.MID)).toArray();
        rhythmTenor = Stream.of(allLines.get(5).split(",")).mapToDouble(this::mapNote).toArray();
        pitchBass   = Stream.of(allLines.get(6).split(",")).mapToInt(scaleDegree -> mapScaleDegree(scaleDegree, Tonic.BASS)).toArray();
        rhythmBass  = Stream.of(allLines.get(7).split(",")).mapToDouble(this::mapNote).toArray();

        printStepWiseStats();
        printScaleDegreeStats();
    }

    private int mapScaleDegree(String scaleDegree, Tonic tonic) {
        switch (scaleDegree) {
            case "-8" :
                return tonic.getBasePitch() + -12;
            case "-2-": case "-1+" :
                return tonic.getBasePitch() + -11;
            case "-2":
                return tonic.getBasePitch() + -10;
            case "-2+": case "-3-" :
                return tonic.getBasePitch() + -9;
            case "-3":
                return tonic.getBasePitch() + -8;
            case "-4":
                return tonic.getBasePitch() + -7;
            case "-4+": case "-5-" :
                return tonic.getBasePitch() + -6;
            case "-5":
                return tonic.getBasePitch() + -5;
            case "-5+": case "-6-" :
                return tonic.getBasePitch() + -4;
            case "-6":
                return tonic.getBasePitch() + -3;
            case "-6+": case "-7-" :
                return tonic.getBasePitch() + -2;
            case "-7":
                return tonic.getBasePitch() + -1;
            case "1":
                return tonic.getBasePitch() + 0;
            case "1+": case "2-" :
                return tonic.getBasePitch() + 1;
            case "2":
                return tonic.getBasePitch() + 2;
            case "2+": case "3-" :
                return tonic.getBasePitch() + 3;
            case "3":
                return tonic.getBasePitch() + 4;
            case "4":
                return tonic.getBasePitch() + 5;
            case "4+": case "5-" :
                return tonic.getBasePitch() + 6;
            case "5":
                return tonic.getBasePitch() + 7;
            case "5+": case "6-" :
                return tonic.getBasePitch() + 8;
            case "6":
                return tonic.getBasePitch() + 9;
            case "6+": case "7-" :
                return tonic.getBasePitch() + 10;
            case "7":
                return tonic.getBasePitch() + 11;
            case "8":
                return tonic.getBasePitch() + 12;
            case "8+": case "9-" :
                return tonic.getBasePitch() + 13;
            case "9":
                return tonic.getBasePitch() + 14;
            case "9+": case "10-" :
                return tonic.getBasePitch() + 15;
            case "10":
                return tonic.getBasePitch() + 16;
            case "11":
                return tonic.getBasePitch() + 17;
            case "11+": case "12-" :
                return tonic.getBasePitch() + 18;
            case "12":
                return tonic.getBasePitch() + 19;
        }
        throw new IllegalArgumentException("'" + scaleDegree + "' has no mapper");
    }

    private double mapNote(String note) {
        switch (note) {
            case "1" :
                return 4.0;
            case "2." :
                return 3.0;
            case "2" :
                return 2.0;
            case "4." :
                return 1.5;
            case "4" :
                return 1.0;
            case "8." :
                return 0.75;
            case "8" :
                return 0.5;
            case "16" :
                return 0.25;
        }
        throw new IllegalArgumentException("'" + note + "' has no mapper");
    }

    private void printStepWiseStats() {
        Map<Integer,Integer> steps = new TreeMap<>();
        determineSteps(steps,pitchSop);
        determineSteps(steps,pitchAlto);
        determineSteps(steps,pitchTenor);
        determineSteps(steps,pitchBass);
        int totalOccurrences = steps.values().stream().mapToInt(Integer::valueOf).sum();
        steps.forEach((key, value) -> System.out.println("Step " + key + " occurs " + value + " times (" + (((double)value / (double)totalOccurrences) * 100) + "%)."));
    }

    private void determineSteps(Map<Integer,Integer> steps, int[] pitches) {
       for (int x = (pitches.length - 1); x > 0; x--) {
            int step = pitches[x - 1] - pitches[x];
            if (step < 0) {
                step *= -1;
            }
            int occurences = steps.getOrDefault(step,0) + 1;
            steps.put(step, occurences);
       }
    }

    private void printScaleDegreeStats() {
        Map<String,Integer> scaleDegrees = new TreeMap<>();
        
        determineScaleDegrees(scaleDegrees,allLines.get(0).split(","));
        determineScaleDegrees(scaleDegrees,allLines.get(2).split(","));
        determineScaleDegrees(scaleDegrees,allLines.get(4).split(","));
        determineScaleDegrees(scaleDegrees,allLines.get(6).split(","));
        int totalOccurrences = scaleDegrees.values().stream().mapToInt(Integer::valueOf).sum();
        scaleDegrees.forEach(
            (key, value) -> System.out.println("Scale degree " + key + " occurs " + value + " times (" + (((double)value / (double)totalOccurrences) * 100) + "%).")
        );
    }

    private void determineScaleDegrees(Map<String,Integer> scaleDegrees, String[] pitches) {
        for (int x = 0; x < pitches.length; x++) {
            String pitch = pitches[x].replace("8","1").replace("9","2");
            if (pitch.startsWith("-")) {
                pitch = pitch.substring(1);
            }
            int occurences = scaleDegrees.getOrDefault(pitch, 0) + 1;
            scaleDegrees.put(pitch, occurences);
        }
    }
}
