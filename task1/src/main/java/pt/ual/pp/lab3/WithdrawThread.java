package pt.ual.pp.lab3;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class WithdrawThread extends Thread {
    private static final int GOAL_WITHDRAWALS = 4;
    private static final double MIN_DEPOSIT_AMOUNT = 5.0;
    private static final double MAX_DEPOSIT_AMOUNT = 20.0;
    private static final int MIN_WAIT_TIME = 2;
    private static final int MAX_WAIT_TIME = 5;
    private final Random random;
    private final BankAccount bankAccount;

    private double numWithdrawals = 0;

    public WithdrawThread(final Random random, final BankAccount bankAccount) {
        this.random = random;
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        while(numWithdrawals < GOAL_WITHDRAWALS){
            var amount = Math.min(MAX_DEPOSIT_AMOUNT, (random.nextDouble() * MAX_DEPOSIT_AMOUNT) + MIN_DEPOSIT_AMOUNT);
            var waitTime = Math.min(MAX_WAIT_TIME, random.nextInt(MAX_WAIT_TIME) + MIN_WAIT_TIME);

            bankAccount.withdraw(amount);
            numWithdrawals++;
            System.out.println(Thread.currentThread().getId() + " [W] " + bankAccount.getBalance() + " " + numWithdrawals);

            if(numWithdrawals < GOAL_WITHDRAWALS) {
                try {
                    TimeUnit.SECONDS.sleep(waitTime);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
