# bach-chorale-analyzer
Analysis of some aspects of the Bach Chorales (those in a major key in 4/4 time) with help from https://explodingart.com/jmusic/.

Package up into a jar via `mvn clean package assembly:assembly`

Run via `java -jar BachChoraleAnalyzer-1.0-jar-with-dependencies.jar bachChorale1.csv`
(make sure `bachChorale1.csv` is in the directory you're running from) or
`java -jar BachChoraleAnalyzer-1.0-jar-with-dependencies.jar` to see statistics for all `*.csv` files
in your current directory.
