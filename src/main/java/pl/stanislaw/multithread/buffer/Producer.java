package pl.stanislaw.multithread.buffer;

import java.util.Random;

public class Producer extends Thread {
    private final Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            int value =random.nextInt(100);
            try {
                buffer.produce(value);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("Watek %s stworzyl przedmiot %d %n" , Thread.currentThread().getName(), value );

        }
    }
}
