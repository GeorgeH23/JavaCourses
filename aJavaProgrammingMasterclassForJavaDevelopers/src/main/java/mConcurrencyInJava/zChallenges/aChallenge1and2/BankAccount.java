package mConcurrencyInJava.zChallenges.aChallenge1and2;

public class BankAccount {

    private double balance;
    private String accountNumber;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    /*public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(getColor() + "Deposited: " + amount + "$. New balance = " + this.getBalance() + ".");
    }

    public synchronized void withdraw(double amount) {
        balance -= amount;
        System.out.println(getColor() + "Withdrawn: " + amount + "$. New balance = " + this.getBalance() + ".");
    }*/

    public void deposit(double amount) {
        synchronized (this) {
            balance += amount;
            System.out.println(getColor() + "Deposited: " + amount + "$. New balance = " + this.getBalance() + ".");
        }
    }

    public void withdraw(double amount) {
        synchronized (this) {
            balance -= amount;
            System.out.println(getColor() + "Withdrawn: " + amount + "$. New balance = " + this.getBalance() + ".");
        }
    }

    public String getColor() {
        String color;

        switch (Thread.currentThread().getName()) {
            case "Thread 1" :
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2" :
                color = ThreadColor.ANSI_PURPLE;
                break;
            default :
                color = ThreadColor.ANSI_GREEN;
        }
        return color;
    }

    public double getBalance() {
        return balance;
    }
}
