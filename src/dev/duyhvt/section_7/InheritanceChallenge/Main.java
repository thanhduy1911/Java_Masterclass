package dev.duyhvt.section_7.InheritanceChallenge;

public class Main {
    public static void main(String[] args) {
        Employee duy = new Employee("Duy", "19/11/1999", "01/01/2020");
        System.out.println(duy);
        System.out.println("Age = " + duy.getAge());
        System.out.println("Pay = " + duy.collectPay());

        SalariedEmployee nhi = new SalariedEmployee("Nhi", "15/02/2001", "03/03/2020", 35000);
        System.out.println(nhi);
        System.out.println("Nhi's Paycheck = $" + nhi.collectPay());

        nhi.retire();
        System.out.println("Nhi's Pension check = $" + nhi.collectPay());

        HourlyEmployee phu = new HourlyEmployee("Phu", "29/04/1997", "02/02/2021", 15);
        System.out.println(phu);
        System.out.println("Phu's Paycheck = $" + phu.collectPay());
        System.out.println("Phu's Holiday Pay = $" + phu.getDoublePay());
    }
}
