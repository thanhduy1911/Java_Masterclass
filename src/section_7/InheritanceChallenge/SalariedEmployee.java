package section_7.InheritanceChallenge;

public class SalariedEmployee extends Employee {
    double annualSalary;
    boolean isRetired;

    public SalariedEmployee(String name, String birthDate, String hireDate, double annualSalary) {
        super(name, birthDate, hireDate);
        this.annualSalary = annualSalary;
    }

    @Override
    public double collectPay() {
        double payCheck = annualSalary / 26;
        double adjPayCheck = (isRetired) ? payCheck * 0.9 : payCheck;

        return (int) adjPayCheck;
    }

    public void retire() {
        terminate("12/12/2025");
        isRetired = true;
    }
}
