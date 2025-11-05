package dev.duyhvt.section_16.GameConsole.sealed;

public sealed abstract class SpecialAbstractClass permits FinalKid, NonSealedKid, SealedKid, SpecialAbstractClass.Kid {
    final class Kid extends SpecialAbstractClass {

    }
}
