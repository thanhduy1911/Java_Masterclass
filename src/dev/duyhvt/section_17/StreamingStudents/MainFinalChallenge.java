package dev.duyhvt.section_17.StreamingStudents;

import dev.duyhvt.section_17.StreamsChallenge.Course;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

public class MainFinalChallenge {
    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python Masterclass", 50);
        Course jmc = new Course("JMC", "JavaScript Masterclass", 100);
        Course jgames = new Course("JGAME", "Creating games in Java");

        int currentYear = LocalDate.now().getYear();
        List<Student> students = Stream
                .generate(() -> Student.getRandomStudent(jmc, pymc, jgames))
                .filter(s -> s.getYearEnrolled() >= (currentYear - 4))
                .limit(10000)
                .toList();

        System.out.println(students
                .stream()
                .mapToInt(Student::getYearEnrolled)
                .summaryStatistics());

        students.subList(0, 10).forEach(System.out::println);

        System.out.println(students
                .stream()
                .mapToInt(s -> s.getEngagementMap().size())
                .summaryStatistics());

        var mappedActivity = students.stream()
                .flatMap(s -> s.getEngagementMap().values().stream())
                .collect(groupingBy(CourseEngagement::getCourseCode,
                        counting()));
        mappedActivity.forEach((key, value) -> System.out.println(key + ": " + value));

        var classCount = students.stream()
                .collect(groupingBy(s -> s.getEngagementMap().size(),
                        counting()));
        classCount.forEach((key, value) -> System.out.println(key + ": " + value));

        var percentages = students.stream()
                .flatMap(s -> s.getEngagementMap().values().stream())
                .collect(groupingBy(CourseEngagement::getCourseCode,
                        summarizingDouble(CourseEngagement::getPercentComplete)));
        percentages.forEach((key, value) -> System.out.println(key + ": " + value));

        var yearMap = students.stream()
                .flatMap(s -> s.getEngagementMap().values().stream())
                .collect(groupingBy(CourseEngagement::getCourseCode,
                        groupingBy(CourseEngagement::getLastActivityYear,
                                counting())));
        yearMap.forEach((key, value) -> System.out.println(key + ": " + value));

        students.stream()
                .flatMap(s -> s.getEngagementMap().values().stream())
                .collect(groupingBy(CourseEngagement::getEnrollmentYear,
                        groupingBy(CourseEngagement::getCourseCode,
                        counting())))
                .forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
