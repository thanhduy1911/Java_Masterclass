package dev.duyhvt.section_19.MiniChallenge;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String sentence = "Hello, World!";
        boolean matches = sentence.matches("Hello, World!");
        System.out.println(matches);

        String challenge3 = "[A-Z][\\p{all}]+[.?!]";
        for (String s : List.of("The bik is red, and has flat tires.",
                "I love being a new L.P.A student!",
                "Hello, friends and family: Welcome!",
                "How are you, Mary?")) {
            boolean matched = s.matches(challenge3);
            System.out.println(matched + ": " + s);
        }
    }
}
