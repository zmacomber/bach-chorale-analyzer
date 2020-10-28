# bach-chorale-analyzer
Analysis of some aspects of the Bach Chorales (those in a major key in 4/4 time) with help from https://explodingart.com/jmusic/.

Package up into a jar via `mvn clean package assembly:assembly`

Run via `java -jar BachChoraleAnalyzer-1.0-jar-with-dependencies.jar bachChorale1.csv`
(make sure `bachChorale1.csv` is in the directory you're running from) or
`java -jar BachChoraleAnalyzer-1.0-jar-with-dependencies.jar` to see statistics for all `*.csv` files
in your current directory.

Output from `2020-10-27` for `java -jar BachChoraleAnalyzer-1.0-jar-with-dependencies.jar` 
```
Processing bachChorale10.csv
Processing bachChorale11.csv
Processing bachChorale8.csv
Processing bachChorale3.csv
Processing bachChorale1.csv
Step 0 occurs 174 times (18%).
Step 1 occurs 202 times (21%).
Step 2 occurs 354 times (37%).
Step 3 occurs 45 times (5%).
Step 4 occurs 36 times (4%).
Step 5 occurs 76 times (8%).
Step 6 occurs 2 times (0%).
Step 7 occurs 31 times (3%).
Step 8 occurs 4 times (0%).
Step 9 occurs 6 times (1%).
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
```
