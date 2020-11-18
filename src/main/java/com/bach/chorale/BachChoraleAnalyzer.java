package com.bach.chorale;

import jm.JMC;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;
import jm.util.Play;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.stream.Stream;

public class BachChoraleAnalyzer implements JMC {

    private final Map<Integer,String> allLines;

    private final int[] pitchSop;
    private final double[] rhythmSop;
    private final int[] pitchAlto;
    private final double[] rhythmAlto;
    private final int[] pitchTenor;
    private final double[] rhythmTenor;
    private final int[] pitchBass;
    private final double[] rhythmBass;

    BachChoraleAnalyzer(String bachChoraleFileName) throws IOException, URISyntaxException {

        allLines = new AllLines(bachChoraleFileName).build();

        pitchSop = getPitch( 1, Tonic.SOP);
        rhythmSop = getRhythm(2);
        pitchAlto = getPitch( 3, Tonic.MID);
        rhythmAlto = getRhythm(4);
        pitchTenor = getPitch( 5, Tonic.MID);
        rhythmTenor = getRhythm(6);
        pitchBass = getPitch( 7, Tonic.BASS);
        rhythmBass = getRhythm(8);

        Stats stats = new Stats(allLines, pitchSop, pitchAlto, pitchTenor, pitchBass);
        stats.printSteps();
        stats.printScaleDegrees();
    }

    private int[] getPitch(int index, Tonic tonic) {
        return Stream.of(allLines.get(index).split(","))
                .mapToInt(scaleDegree -> new ScaleDegree(tonic).map(scaleDegree))
                .toArray();
    }

    private double[] getRhythm(int index) {
        return Stream.of(allLines.get(index).split(",")).mapToDouble(Note::map).toArray();
    }

	public static void main(String[] args) throws Exception {
	    String bachChoraleFileName = ((args != null) && (args.length > 0)) ? args[0] : null;

	    BachChoraleAnalyzer bca = new BachChoraleAnalyzer(bachChoraleFileName);

	    if (bachChoraleFileName != null) {
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
	}
}
