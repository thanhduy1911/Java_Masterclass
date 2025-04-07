package dev.duyhvt.section_18.LocaleProject;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.out.println("Default Locale = " + Locale.getDefault());

        Locale vn = new Locale.Builder().setLanguage("vi").setRegion("VN").build();
        Locale enAU = new Locale("en", "AU");
        Locale enCA = new Locale("en", "CA");

        Locale enIN = new Locale.Builder().setLanguage("en").setRegion("IN").build();
        Locale enNZ = new Locale.Builder().setLanguage("en").setRegion("NZ").build();

        var dtf =
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);

        for (var locale : List.of(
                Locale.getDefault(), Locale.US, vn, enAU, enCA, enIN, enNZ, Locale.UK
        )) {
            System.out.println(locale.getDisplayName() + "= "
                    + LocalDateTime.now().format(dtf.withLocale(locale)));
        }

        DateTimeFormatter wdayMonth = DateTimeFormatter.ofPattern(
                "EEEE, MMMM d, yyyy");
        DateTimeFormatter vietnameseFormatter = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_WEEK, TextStyle.FULL)
                .appendLiteral(", tháng ")
                .appendValue(ChronoField.MONTH_OF_YEAR, 2)
                .appendLiteral(" ngày ")
                .appendValue(ChronoField.DAY_OF_MONTH, 2)
                .appendLiteral(" năm ")
                .appendValue(ChronoField.YEAR)
                .toFormatter(vn);

        LocalDate May5 = LocalDate.of(2020, 5, 5);
        System.out.println("-".repeat(60));
        for (var locale : List.of(Locale.CANADA, Locale.CANADA_FRENCH,
                Locale.FRANCE, Locale.GERMANY, Locale.TAIWAN, Locale.JAPAN, Locale.ITALY, vn)) {
            DateTimeFormatter formatter = locale.equals(vn)
                    ? vietnameseFormatter
                    : wdayMonth.withLocale(locale);

            System.out.println(locale.getDisplayName() + " : " +
                    locale.getDisplayName(locale) + " =\n\t" +
                    May5.format(formatter));

            NumberFormat currency = NumberFormat.getCurrencyInstance(locale);
            Currency localCurrency = Currency.getInstance(locale);
            System.out.println(currency.format(555.555) + " [" +
                    localCurrency.getCurrencyCode() + "]" +
                    localCurrency.getDisplayName(locale) + "/" +
                    localCurrency.getDisplayName()
            );
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the loan amount: ");
        scanner.useLocale(Locale.ITALY);
        BigDecimal myLoan = scanner.nextBigDecimal();
        NumberFormat decimalInfo = NumberFormat.getCurrencyInstance(Locale.ITALY);
        System.out.println("My Loan " + decimalInfo.format(myLoan));
    }
}
