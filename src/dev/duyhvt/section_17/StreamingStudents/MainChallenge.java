package dev.duyhvt.section_17.StreamingStudents;

import dev.duyhvt.section_17.StreamsChallenge.Course;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class MainChallenge {
    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python Masterclass", 50);
        Course jmc = new Course("JMC", "JavaScript Masterclass", 100);
        Course jgames = new Course("JGAME", "Creating games in Java");

        List<Student> students = IntStream
                .rangeClosed(1, 5000)
                .mapToObj(s -> Student.getRandomStudent(jmc, pymc))
                .toList();

        double totalPercent = students.stream()
                .mapToDouble(s -> s.getPercentComplete("JMC"))
                .reduce(0, Double::sum);
        double avePercent = totalPercent / students.size();
        System.out.printf("Average Percentage Complete = %.2f%% %n", avePercent);

        int topPercent = (int) (1.25 * avePercent);
        System.out.printf("Best Percentage Complete = %d%% %n", topPercent);

        Comparator<Student> longTermStudent = Comparator.comparingDouble(Student::getYearEnrolled);
        List<Student> hardWorkers = students.stream()
                .filter(s -> s.getMonthsSinceActive("JMC") == 0)
                .filter(s -> s.getPercentComplete("JMC") >= topPercent)
                .sorted(longTermStudent)
                .limit(10)
                .toList();
        hardWorkers.forEach(s -> {
            s.addCourse(jgames);
            System.out.print(s.getStudentId() + " ");
        });

        Comparator<Student> uniqueSorted = longTermStudent.thenComparing(Student::getStudentId);
        students.stream()
                .filter(s -> s.getMonthsSinceActive("JMC") == 0)
                .filter(s -> s.getPercentComplete("JMC") >= topPercent)
                .sorted(longTermStudent)
                .limit(10)
                //.toList()
                //.collect(Collectors.toList()
                //.collect(Collectors.toSet())
                //.collect(() -> new TreeSet<>(uniqueSorted), TreeSet::add, TreeSet::addAll)
                .forEach(s -> {
                    s.addCourse(jgames);
                    System.out.print(s.getStudentId() + " ");
                });
    }
}
