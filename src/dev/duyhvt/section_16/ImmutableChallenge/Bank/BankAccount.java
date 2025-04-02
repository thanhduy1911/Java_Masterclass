package dev.duyhvt.section_16.ImmutableChallenge.Bank;

import dev.duyhvt.section_16.ImmutableChallenge.dto.Transaction;

import java.util.LinkedHashMap;
import java.util.Map;

public class BankAccount {
    public enum AccountType {CHECKING, SAVINGS}

    private final AccountType accountType;
    private double balance;
    private final Map<Long, Transaction> transactions = new LinkedHashMap<>();

    BankAccount(AccountType accountType, double balance) {
        this.accountType = accountType;
        this.balance = balance;
    }

    public Map<Long, String> getTransactions() {
        Map<Long, String> txMap = new LinkedHashMap<>();
        for (var tx : transactions.entrySet()) {
            txMap.put(tx.getKey(), tx.getValue().toString());
        }

        return txMap;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "%s $%.2f".formatted(accountType, balance);
    }

    void commitTransaction(int routingNumber, long transactionId,
                           String customerId, double amount) {
        balance += amount;
        transactions.put(transactionId,
                new Transaction(routingNumber, transactionId,
                        Integer.parseInt(customerId), amount));
    }
}
