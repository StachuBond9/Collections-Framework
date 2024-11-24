package pl.stanislaw.multithread;

public class MyRunnable implements Runnable {

    private final Counter counter;

    public MyRunnable(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 1000) {
            counter.increment();
            i++;
        }
    }
}
