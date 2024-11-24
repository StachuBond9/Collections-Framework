package pl.stanislaw.multithread.buffer;

public class Consumer extends Thread {
    Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void getItem() throws InterruptedException {

        while (true) {
            System.out.printf("Watek %s pobral %d z kolejki%n", Thread.currentThread().getName(), buffer.consume());
        }
    }

    @Override
    public void run() {
        try {
            getItem();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
