package dev.duyhvt.section_13.LocalClassChallenge;

import dev.duyhvt.section_13.LocalClassChallenge.domain.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("Minnie", "Mouse", "01/02/2015");
        Employee e2 = new Employee("Mike", "Mouse", "05/08/2000");
        Employee e3 = new Employee("Daffy", "Duck", "11/02/2011");
        Employee e4 = new Employee("Daisy", "Duck", "05/03/2013");
        Employee e5 = new Employee("Goofy", "Dog", "23/07/2020");

        List<Employee> list = new ArrayList<>(Arrays.asList(e1, e2, e3, e4, e5));

        printOrderedList(list, "name");
        System.out.println();
        printOrderedList(list, "year");
    }

    public static void printOrderedList(List<Employee> eList, String sortField) {
        int currentYear = LocalDate.now().getYear();

        class MyEmployee {
            Employee containedEmployee;
            int yearWorked;
            String fullName;

            public MyEmployee(Employee containedEmployee) {
                this.containedEmployee = containedEmployee;
                yearWorked = currentYear - Integer.parseInt(
                        containedEmployee.hireDate().split("/")[2]
                );
                fullName = String.join(" ",
                        containedEmployee.first(), containedEmployee.last());
            }

            @Override
            public String toString() {
                return "%s has been an employee with year %s".formatted(fullName, yearWorked);
            }
        }

        List<MyEmployee> myEmployees = new ArrayList<>();
        for (Employee e : eList) {
            myEmployees.add(new MyEmployee(e));
        }

        var comparator = new Comparator<MyEmployee>() {
            @Override
            public int compare(MyEmployee o1, MyEmployee o2) {
                if (sortField.equals("name")) {
                    return o1.fullName.compareTo(o2.fullName);
                }

                return o1.yearWorked - o2.yearWorked;
            }
        };

        myEmployees.sort(comparator);

        for (MyEmployee e : myEmployees) {
            System.out.println(e);
        }
    }
}
