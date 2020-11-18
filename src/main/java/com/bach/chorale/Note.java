package com.bach.chorale;

public class Note {

    private Note() {
        throw new IllegalStateException("Utility class");
    }

    public static double map(String note) {
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
            default:
                throw new IllegalArgumentException("'" + note + "' has no mapper");
        }
    }
}
