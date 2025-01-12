package section_7.ClassesChallenge;

public class BankAccount {
    private int number = 0;
    private double balance = 0.0;
    private String cusName = null;
    private String email = null;
    private String phoneNumber = null;

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String getCusName() {
        return cusName;
    }
    public void setCusName(String cusName) {
        this.cusName = cusName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void withdraw(double money) {
        if (balance - money < 0) {
            System.out.println("Cannot withdraw with balance: " + balance);
        } else {
            this.balance -= money;
            //System.out.println("The new balance is: " + (balance - money));
            System.out.println("Withdrawal of " + money + " processed, Remaining balance = " + this.balance);
        }
    }
    public void deposit(double money) {
        balance += money;
        //System.out.println("The new balance is: " + (balance + money));
        System.out.println("Deposit of " + money + " made. New balance is " + balance);
    }
}
