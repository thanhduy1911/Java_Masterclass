package dev.duyhvt.section_17.StreamingStudents;

import dev.duyhvt.section_17.StreamsChallenge.Course;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class MainMapping {
    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python Masterclass", 50);
        Course jmc = new Course("JMC", "JavaScript Masterclass", 100);
        Course jgames = new Course("JGAME", "Creating games in Java");

        List<Student> students = IntStream
                .rangeClosed(1, 5000)
                .mapToObj(s -> Student.getRandomStudent(jmc, pymc))
                .toList();

        var mappedStudents = students.stream()
                .collect(groupingBy(Student::getCountryCode));

        mappedStudents.forEach((k, v) -> System.out.println("Key = " + k + ", value = " + v.size()));

        System.out.println("-".repeat(50));
        int minAge = 25;
        var youngerSet = students.stream()
                .collect(groupingBy(Student::getCountryCode,
                        filtering(s -> s.getAge() <= minAge, toList())));
        youngerSet.forEach((k, v) -> System.out.println("Key = " + k + ", value = " + v.size()));

        var experienced = students.stream()
                .collect(partitioningBy(Student::hasProgrammingExperience));
        System.out.println("Experienced Students: " + experienced.get(true).size());

        var expCount = students.stream()
                .collect(partitioningBy(Student::hasProgrammingExperience, counting()));
        System.out.println("Experienced Students with counting: " + expCount.get(true));

        var experienceAndActive = students.stream()
                .collect(partitioningBy(
                        s -> s.hasProgrammingExperience()
                        && s.getMonthsSinceActive() == 0, counting()));
        System.out.println("Experienced and Active Students with counting: " + experienceAndActive.get(true));

        var multiLevel = students.stream()
                .collect(groupingBy(Student::getCountryCode,
                        groupingBy(Student::getGender)));

        multiLevel.forEach((key, value) -> {
            System.out.println("Key = " + key);
            value.forEach((key1, value1) ->
                    System.out.println("\tKey = " + key1 + ", value size = " + value1.size()));
        });

        long studentBodyCount = 0;
        studentBodyCount = experienced.values().stream()
                .map(l -> l.stream()
                        .filter(s -> s.getMonthsSinceActive() <= 3)
                        .count())
                .mapToLong(l -> l)
                .sum();
        System.out.println("Student Body Count: " + studentBodyCount);

        long count = experienced.values().stream()
                .flatMap(l -> l.stream())
                .filter(s -> s.getMonthsSinceActive() <= 3)
                .count();
        System.out.println("Active Students = " + count);

        count = multiLevel.values().stream()
                .flatMap(map -> map.values().stream()
                        .flatMap(l -> l.stream()))
                .filter(s -> s.getMonthsSinceActive() <= 3)
                .count();
        System.out.println("Active Students in multiLevel = " + count);
    }
}
