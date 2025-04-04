package dev.duyhvt.section_17.StreamsTerminal;

public record Seat(char rowMarker, int seatNumber, boolean isReserved) {
    public Seat(char rowMarker, int seatNumber) {
        //this(rowMarker, seatNumber, new Random().nextBoolean());
        this(rowMarker, seatNumber, false);
    }
}
