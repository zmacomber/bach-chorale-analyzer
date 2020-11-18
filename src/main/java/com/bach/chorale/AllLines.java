package com.bach.chorale;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

public class AllLines {

    private final String bachChoraleFileName;

    public AllLines(String bachChoraleFileName) {
        this.bachChoraleFileName = bachChoraleFileName;
    }

    public Map<Integer,String> build() throws IOException, URISyntaxException {
        Map<Integer, String> allLines = new TreeMap<>();
        if (bachChoraleFileName != null) {
            addToAllLines(
                    Files.readAllLines(
                            Paths.get(
                                    ClassLoader.getSystemResource(bachChoraleFileName).toURI()
                            )
                    ),
                    allLines
            );
        } else {
            try (Stream<Path> paths = Files.walk(Paths.get(""))) {
                paths.filter(Files::isRegularFile)
                        .filter(path -> path.toString().contains(".csv") && ( ! path.toString().contains("src")))
                        .forEach(path -> {
                            try {
                                System.out.println("Processing " + path.getFileName());
                                addToAllLines(Files.readAllLines(path), allLines);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
            }
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
