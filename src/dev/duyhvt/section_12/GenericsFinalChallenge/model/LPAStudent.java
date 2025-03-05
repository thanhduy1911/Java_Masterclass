package dev.duyhvt.section_12.GenericsFinalChallenge.model;

public class LPAStudent extends Student {
    private double percentComplete;

    public double getPercentComplete() {
        return percentComplete;
    }

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

    @Override
    public boolean matchFieldValue(String fieldName, String value) {

        if (fieldName.equalsIgnoreCase("percentComplete")) {
            return percentComplete <= Integer.parseInt(value);
        }
        return super.matchFieldValue(fieldName, value);
    }
}
