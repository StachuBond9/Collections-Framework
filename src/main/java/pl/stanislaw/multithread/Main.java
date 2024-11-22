package pl.stanislaw.multithread;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread myRunnable = new Thread(new MyRunnable(counter));
        Thread myRunnable1 = new Thread(new MyRunnable(counter));
        myRunnable.start();
        myRunnable1.start();
        myRunnable1.join();
        myRunnable.join();
        System.out.println(counter.getCount());
    }

}
