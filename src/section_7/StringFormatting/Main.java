package section_7.StringFormatting;

import java.time.Year;

public class Main {
    public static void main(String[] args) {
        String bulletList = "Print a Bulleted List: \n" +
                "\t\u2022 First Point\n" +
                "\t\t\u2022 Sub Point";
        System.out.println(bulletList);

        String textBlock = """
                Print a Bulleted List:
                            \u2022 First Point
                                \u2022 Sub Point""";
        System.out.println(textBlock);

        int age = 35;
        System.out.printf("Your age is %d%n", age);

        int yearOfBirth = Year.now().getValue() - age;
        System.out.printf("Age = %d, Birth year = %d%n", age, yearOfBirth);

        System.out.printf("Your age is %.2f%n",(float) age);

        for (int i = 1; i <= 100000 ; i *= 10)
        {
            System.out.printf("Printing %6d %n", i);
        }
    }
}
