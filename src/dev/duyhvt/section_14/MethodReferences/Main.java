package dev.duyhvt.section_14.MethodReferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

class PlainOld {
    private static int last_id = 1;
    private int id;

    public PlainOld() {
        id = PlainOld.last_id++;
        System.out.println("Creating a PlainOld Object: id = " + id);
    }
}

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of(
                "Anna", "Bob", "Chuck", "Dave"
        ));
        list.forEach(System.out::println);
        calculator(Integer::sum, 10, 25);
        calculator(Double::sum, 2.5, 7.5);

        Supplier<PlainOld> reference1 = PlainOld::new;
        PlainOld pojo = reference1.get();

        System.out.println("Getting Array");
        PlainOld[] pojo1 = seedArray(PlainOld::new, 10);

        calculator((s1,s2) -> s1.concat(s2), "Hello ", "World");
        calculator(String::concat, "Hello ", "World");

        BinaryOperator<String> b1 = (s1,s2) -> s1.concat(s2);
        b1.apply("Hello", "World");
        System.out.println("Test: " + b1);
    }

    private static <T> void calculator(BinaryOperator<T> function, T value1, T value2) {
        T result = function.apply(value1, value2);
        System.out.println("Result of Operation: " + result);
    }

    private static PlainOld[] seedArray(Supplier<PlainOld> reference, int count) {
        PlainOld[] array = new PlainOld[count];
        Arrays.setAll(array, i -> reference.get());
        return array;
    }
}
