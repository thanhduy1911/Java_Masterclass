package dev.duyhvt.section_16.GameConsole.sealed;

import java.util.function.Predicate;

public sealed interface SealedInterface permits BetterInterface, StringChecker {
    boolean testData(Predicate<String> p, String... strings);
}
