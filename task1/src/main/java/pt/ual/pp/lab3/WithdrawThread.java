package pt.ual.pp.lab3;

import java.util.Random;

public class WithdrawThread extends Thread {
    private static final int GOAL_WITHDRAWALS = 4;
    private static final double MIN_DEPOSIT_AMOUNT = 1.0;
    private static final double MAX_DEPOSIT_AMOUNT = 10.0;
    private static final int MIN_WAIT_TIME = 1;
    private static final int MAX_WAIT_TIME = 3;
    private final Random random;
    private final BankAccount bankAccount;

    private double numWithdrawals = 0;

    @Override
    public void run() {
        while(numWithdrawals > GOAL_WITHDRAWALS){

        }
    }
}
