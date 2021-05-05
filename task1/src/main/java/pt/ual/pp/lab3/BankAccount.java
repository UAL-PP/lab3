package pt.ual.pp.lab3;

public class BankAccount {
    private double balance = 0.0;

    public BankAccount(final double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(final double amount) {
        this.balance += amount;
        notify();
    }

    public synchronized void withdraw(final double amount) {
        while(amount > this.balance){
            try {
                wait();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.balance -= amount;
        notify();
    }
}
