package section_7.ClassesChallenge;

public class Main {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount();
//        myAccount.setNumber(1029347326);
//        myAccount.setBalance(0);
//        myAccount.setCusName("Huynh Vo Thanh Duy");
//        myAccount.setEmail("duythanh19111999@gmail.com");
//        myAccount.setPhoneNumber("+84 54 876 5472");

        myAccount.withdraw(100.0);
        myAccount.deposit(250);
        myAccount.withdraw(50);
        myAccount.withdraw(150);

        //myAccount.deposit(100);
        myAccount.withdraw(45.55);
        myAccount.withdraw(54.46);

        myAccount.withdraw(4.45);
    }
}
