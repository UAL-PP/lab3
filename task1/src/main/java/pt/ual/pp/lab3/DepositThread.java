package pt.ual.pp.lab3;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DepositThread extends Thread {
    private static final double GOAL_AMOUNT = 50.0;
    private static final double MIN_DEPOSIT_AMOUNT = 1.0;
    private static final double MAX_DEPOSIT_AMOUNT = 10.0;
    private static final int MIN_WAIT_TIME = 1;
    private static final int MAX_WAIT_TIME = 3;
    private final Random random;
    private final BankAccount bankAccount;
    private double depositedAmount = 0;

    public DepositThread(final BankAccount bankAccount, final Random random) {
        this.bankAccount = bankAccount;
        this.random = random;
    }

    @Override
    public void run() {
        while(this.depositedAmount < GOAL_AMOUNT) {
            var amount = Math.min(MAX_DEPOSIT_AMOUNT, (random.nextDouble() * MAX_DEPOSIT_AMOUNT) + MIN_DEPOSIT_AMOUNT);
            var waitTime = Math.min(MAX_WAIT_TIME, random.nextInt(MAX_WAIT_TIME) + MIN_WAIT_TIME);
            bankAccount.deposit(amount);
            depositedAmount += amount;
            Thread.currentThread().get
            try {
                TimeUnit.SECONDS.sleep(waitTime);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
