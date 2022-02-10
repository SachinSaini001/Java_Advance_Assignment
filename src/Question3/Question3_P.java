package Question3;

import java.util.concurrent.locks.ReentrantLock;

class Question3_P {
    public static void main(String[] args) throws InterruptedException {
        Question3_P reentrantLockExample = new Question3_P();
        Account account1 = new Account("12345", 10000);
        Account account2 = new Account("123456", 20000);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                reentrantLockExample.lock(account1, account2);
                reentrantLockExample.transfer(account1, account2);
                reentrantLockExample.unLock(account1, account2);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                reentrantLockExample.lock(account2, account1);
                reentrantLockExample.transfer(account2, account1);
                reentrantLockExample.unLock(account2, account1);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Total balance for both account: " + (account1.getAmount() + account2.getAmount()));
    }

    private void transfer(Account fromAccount, Account toAccount) {
        System.out.println("Transferring amount: " + 100 + " from account: " + fromAccount.getAccountNumber() + " to account: " + toAccount.getAccountNumber());
        toAccount.setAmount(toAccount.getAmount() - (Integer) 100);
        fromAccount.setAmount(fromAccount.getAmount() + (Integer) 100);
    }

    private void lock(Account fromAccount, Account toAccount) {
        while (true) {
            Boolean fromAccountLocked = fromAccount.getLock().tryLock();
            Boolean toAccountLocked = toAccount.getLock().tryLock();
            if (fromAccountLocked && toAccountLocked) {
                return;
            }
            if (fromAccountLocked) {
                fromAccount.getLock().unlock();
            }
            if (toAccountLocked) {
                toAccount.getLock().unlock();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void unLock(Account fromAccount, Account toAccount) {
        fromAccount.getLock().unlock();
        toAccount.getLock().unlock();
    }
}

class Account {
    private final String accountNumber;
    private Integer amount;
    private final ReentrantLock lock;

    public Account(String accountNumber, Integer amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.lock = new ReentrantLock();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public ReentrantLock getLock() {
        return lock;
    }
}