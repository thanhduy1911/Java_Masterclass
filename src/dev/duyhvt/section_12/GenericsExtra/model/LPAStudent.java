package dev.duyhvt.section_12.GenericsExtra.model;

public class LPAStudent extends Student {
    private double percentComplete;

    public LPAStudent() {
        percentComplete = random.nextDouble(0, 100.001);
    }

    @Override
    public String toString() {
        return "%s %8.1f%%".formatted(super.toString(), percentComplete);
    }

    public LPAStudent(double percentComplete) {
        this.percentComplete = percentComplete;
    }
}
