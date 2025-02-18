package dev.duyhvt.section_10.MobilePhone;

public class Main {
    public static void main(String[] args) {
        MobilePhone myPhone = new MobilePhone("5555555");

        Contact bob = new Contact("Bob", "31415926");
        Contact alice = new Contact("Alice", "16180339");
        Contact tom = new Contact("Tom", "11235813");
        Contact jane = new Contact("Jane", "23571113");

        myPhone.addNewContact(bob);
        myPhone.addNewContact(alice);
        myPhone.addNewContact(tom);
        myPhone.addNewContact(jane);

        myPhone.printContact();
        // Contact List:
        // 1. Bob -> 31415926
        // 2. Alice -> 16180339
        // 3. Tom -> 11235813
        // 4. Jane -> 23571113

        Contact bobUpdated = new Contact("Bob", "12345678");
        myPhone.updateContact(bob, bobUpdated);

        myPhone.printContact();
        // Contact List:
        // 1. Bob -> 12345678
        // 2. Alice -> 16180339
        // 3. Tom -> 11235813
        // 4. Jane -> 23571113
    }
}
