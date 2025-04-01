package dev.duyhvt.section_16.CopyingClasses;

import java.util.Arrays;

record Person(String name, String dob, Person[] kids) {
    public Person(Person person) {
        this(person.name, person.dob,
                person.kids == null ? new Person[0] : Arrays.copyOf(person.kids, person.kids.length));
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", kids=" + Arrays.toString(kids) +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Person joe = new Person("Joe", "01/01/1961", null);
        Person jim = new Person("Jim", "02/02/1962", null);
        Person jack = new Person("Jack", "03/03/1963",
                new Person[] {joe, jim});
        Person jane = new Person("Jane", "04/04/1964", null);
        Person jill = new Person("Jill", "05/05/1965",
                new Person[] {joe, jim});

        Person[] persons = {joe, jim, jack, jane, jill};
//        Person[] personsShallow = Arrays.copyOf(persons, persons.length);
//        Person[] personsDeepCopy = new Person[persons.length];
//        Arrays.setAll(personsDeepCopy,i -> new Person(persons[i]));
        Person[] personsDeepCopy = persons.clone();
//        for (int i = 0; i < persons.length; i++) {
//
//            personsDeepCopy[i] = new Person(persons[i]);
//        }

        var jillsKids = personsDeepCopy[4].kids();
        jillsKids[1] = jane;

        for (int i = 0; i < persons.length; i++) {
            if (persons[i] == personsDeepCopy[i]) {
                System.out.println("Equal References " + persons[i]);
            }
        }

        System.out.println(persons[4]);
        System.out.println(personsDeepCopy[4]);
    }
}
