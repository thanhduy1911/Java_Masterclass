package dev.duyhvt.section_15.EnumCollections;

import java.util.*;

public class Main {
    enum WeekDay {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY}
    public static void main(String[] args) {
        List<WeekDay> annsWorkDay = new ArrayList<>(List.of(
           WeekDay.MONDAY, WeekDay.TUESDAY, WeekDay.THURSDAY, WeekDay.FRIDAY
        ));

        var annsDaysSet = EnumSet.copyOf(annsWorkDay);
        System.out.println(annsDaysSet.getClass().getSimpleName());
        annsDaysSet.forEach(System.out::println);
        var allDaysSet = EnumSet.allOf(WeekDay.class);
        System.out.println("-".repeat(50));
        allDaysSet.forEach(System.out::println);

        Set<WeekDay> newPersonDays = EnumSet.complementOf(annsDaysSet);
        System.out.println("-".repeat(50));
        newPersonDays.forEach(System.out::println);

        Set<WeekDay> anotherWay = EnumSet.copyOf(allDaysSet);
        anotherWay.removeAll(annsDaysSet);
        System.out.println("-".repeat(50));
        anotherWay.forEach(System.out::println);

        Set<WeekDay> businessDay = EnumSet.range(WeekDay.MONDAY, WeekDay.FRIDAY);
        System.out.println("-".repeat(50));
        businessDay.forEach(System.out::println);

        Map<WeekDay, String[]> employeeMap = new EnumMap<>(WeekDay.class);
        employeeMap.put(WeekDay.FRIDAY, new String[] {"Ann", "Mary", "Bob"});
        employeeMap.put(WeekDay.MONDAY, new String[] {"Mary", "Bob"});
        employeeMap.forEach((k, v) -> System.out.println("Key = " + k + " , value = " + Arrays.toString(v)));
    }
}
