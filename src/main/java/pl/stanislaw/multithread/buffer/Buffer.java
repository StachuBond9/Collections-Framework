package pl.stanislaw.multithread.buffer;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {

    private final Queue<Integer> queue = new LinkedList<>();

    public synchronized void produce(int value) throws InterruptedException {
        if (queue.size() > 100) {
            wait();
        }
        queue.add(value);
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        if(queue.isEmpty()){
            wait();
        }
        int value = queue.poll();
        notifyAll();
        return value;
    }

}

