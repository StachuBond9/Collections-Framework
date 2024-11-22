package pl.stanislaw.multithread;

public class MyThread extends Thread {
    @Override
    public void run() {
        int i = 0;
        while (i < 100) {
            System.out.println(Thread.currentThread().getName());
            i++;
        }
    }

}
