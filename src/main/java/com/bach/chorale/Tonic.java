package com.bach.chorale;

enum Tonic {
    SOP(72), // C inside treble clef staff
    MID(60), // C below treble clef staff
    BASS(48); // C inside bass clef staff

    int basePitch;

    Tonic(int basePitch) {
        this.basePitch = basePitch;
    }

    int getBasePitch() {
        return basePitch;
    }
}
