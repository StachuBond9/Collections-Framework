package pl.stanislaw.multithread;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int count;
    private ReentrantLock reentrantLock = new ReentrantLock();

    public void increment() {
        /*/
        synchronized (this) {
            count++;
        }
         */
        reentrantLock.lock();
        count++;
        reentrantLock.unlock();
    }

    public int getCount() {
        return count;
    }
}
