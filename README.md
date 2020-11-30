# bach-chorale-analyzer
Analysis of some aspects of the Bach Chorales (those in a major key in 4/4 time) 
with help from https://explodingart.com/jmusic/.

Run `mvn assembly:assembly` to create an executable jar with dependencies.

```
~/bach-chorale-analyzer$ java -jar target/BachChoraleAnalyzer-1.0-jar-with-dependencies.jar
Processing 1
Processing 3
Processing 8
Processing 10
Processing 11
Step 0 occurs 170 times (18%).
Step 1 occurs 202 times (21%).
Step 2 occurs 354 times (37%).
Step 3 occurs 47 times (5%).
Step 4 occurs 35 times (4%).
Step 5 occurs 77 times (8%).
Step 6 occurs 2 times (0%).
Step 7 occurs 32 times (3%).
Step 8 occurs 3 times (0%).
Step 9 occurs 8 times (1%).
Step 12 occurs 27 times (3%).
Scale degree 1 occurs 193 times (20%).
Scale degree 1+ occurs 5 times (1%).
Scale degree 2 occurs 131 times (14%).
Scale degree 3 occurs 128 times (13%).
Scale degree 4 occurs 76 times (8%).
Scale degree 4+ occurs 19 times (2%).
Scale degree 5 occurs 203 times (21%).
Scale degree 5+ occurs 7 times (1%).
Scale degree 6 occurs 97 times (10%).
Scale degree 7 occurs 94 times (10%).
Scale degree 7- occurs 8 times (1%).
~/bach-chorale-analyzer$ java -jar target/BachChoraleAnalyzer-1.0-jar-with-dependencies.jar 1
Step 0 occurs 30 times (19%).
Step 1 occurs 37 times (23%).
Step 2 occurs 63 times (39%).
Step 3 occurs 4 times (3%).
Step 4 occurs 7 times (4%).
Step 5 occurs 10 times (6%).
Step 7 occurs 5 times (3%).
Step 8 occurs 2 times (1%).
Step 12 occurs 2 times (1%).
Scale degree 1 occurs 41 times (25%).
Scale degree 2 occurs 17 times (10%).
Scale degree 3 occurs 24 times (15%).
Scale degree 4 occurs 15 times (9%).
Scale degree 4+ occurs 2 times (1%).
Scale degree 5 occurs 32 times (20%).
Scale degree 5+ occurs 2 times (1%).
Scale degree 6 occurs 15 times (9%).
Scale degree 7 occurs 14 times (9%).
Scale degree 7- occurs 2 times (1%).
jMusic Play: Playing score 1 using JavaSound General MIDI soundbank.
jMusic Play: Waiting for the end of 1.
jMusic MidiSynth: Stopped JavaSound MIDI playback
~/bach-chorale-analyzer$ 
```
