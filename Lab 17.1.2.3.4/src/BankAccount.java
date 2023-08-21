import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private double balance;
    private String accountNumber;
    private Lock lock;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock = new ReentrantLock();
    }

    /* Lab 17.1 */
//    public void deposit(double amount) {
//        balance += amount;
//    }

    /* Lab 17.2 */
//    public void deposit(double amount){
//        synchronized (this) {
//            balance += amount;
//        }
//    }
    /* Lab 17.3 */
//    public void deposit(double amount){
//        lock.lock();
//        try{
//            balance += amount;
//        } finally {
//            lock.unlock();
//        }
//    }

    /* Lab 17.4 */
    public void deposit(double amount) {
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance += amount;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }
        } catch (InterruptedException e) {
            System.out.println("Producer has Interrupted Exception");
        }
    }



    /* Lab 17.1 */
//    public void withdraw(double amount) {
//        balance -= amount;
//    }

    /* Lab 17.2 */
//    public void withdraw(double amount){
//        synchronized (this) {
//            balance -= amount;
//        }
//    }

    /* Lab 17.3 */
//    public void withdraw(double amount) {
//      lock.lock();
//          try{
//              balance -= amount;
//          } finally {
//              lock.unlock();
//          }
//    }

    /* Lab 17.4 */
    public void withdraw(double amount) {
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance -= amount;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }
        } catch (InterruptedException e) {
            System.out.println("Producer has Interrupted Exception");
        }
    }
}
