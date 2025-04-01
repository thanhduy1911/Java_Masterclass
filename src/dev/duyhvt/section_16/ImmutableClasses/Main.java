package dev.duyhvt.section_16.ImmutableClasses;

public class Main {
    public static void main(String[] args) {
//        Person jane = new Person();
//        jane.setName("Jane");
//        Person jim = new Person();
//        jim.setName("Jim");
//        Person joe = new Person();
//        joe.setName("Joe");
//        Person john = new Person();
//        john.setName("John");
//        john.setDob("19/11/1999");
//        john.setKids(new Person[] {jane, jim, joe});
//
//        System.out.println(john);

        Person nhi = new Person("Nhi", "15/02/2001");
        Person duy = new Person("Duy", "19/11/1999");
        Person nhi2 = new Person("Nhi 2", "05/02/1996");

        Person[] giangKids = {nhi, duy, nhi2};
        Person giang = new Person("Giang", "17/01/1971", giangKids);

        System.out.println(giang);
    }
}
