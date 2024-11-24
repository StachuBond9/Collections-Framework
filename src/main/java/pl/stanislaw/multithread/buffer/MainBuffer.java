package pl.stanislaw.multithread.buffer;

public class MainBuffer {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);
        consumer.start();
        producer.start();
    }
}
