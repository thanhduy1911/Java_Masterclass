package dev.duyhvt.section_14.MiniLambdaChallenges;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        Consumer<String> printWords = new Consumer<String>() {
            @Override
            public void accept(String s) {
                String[] parts = s.split(" ");
                for (String part : parts) {
                    System.out.println(part);
                }
            }
        };

        Consumer<String> printWordsLambda = s -> {
          String[] parts = s.split(" ");
          for (String part : parts) {
              System.out.println(part);
          }
        };

        printWords.accept("Let's split this up into an array");
        printWordsLambda.accept("Let's split this up into an array");

        Consumer<String> printWordsForEach = s -> {
            String[] parts = s.split(" ");
            Arrays.asList(parts).forEach(sentence -> System.out.println());
        };

        printWordsForEach.accept("Let's split this up into an array");

        Consumer<String> printWordsConcise = s -> {
            Arrays.asList(s.split(" ")).forEach(sentence -> System.out.println());
        };

        printWordsConcise.accept("Let's split this up into an array");

        Function<String, String> everySecondChar = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        UnaryOperator<String> everySecondChar2 = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        System.out.println(everySecondChar2.apply("1234567890"));

        String result = everySecondCharacter(everySecondChar, "1234567890");
        System.out.println(result);

        Supplier<String> iLoveJava = () -> "I love Java!";
        Supplier<String> iLoveJava2 = () -> {return "I love Java!";};
        System.out.println(iLoveJava.get());
        System.out.println(iLoveJava2.get());
    }

    public static String everySecondChar(String source) {
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i % 2 == 1) {
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }

    public static String everySecondCharacter(Function<String, String> func, String source) {
        return func.apply(source);
    }

    public static String everySecondCharacter(UnaryOperator<String> func, String source) {
        return func.apply(source);
    }
}
