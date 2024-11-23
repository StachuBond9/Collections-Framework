package pl.stanislaw.multithread.es;

import pl.stanislaw.multithread.MyRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Runnable task1 = () -> System.out.println(Thread.currentThread().getName());
        Runnable task2 = () -> System.out.println(Thread.currentThread().getName());
        Runnable task3 = () -> System.out.println(Thread.currentThread().getName());
        Runnable task4 = () -> System.out.println(Thread.currentThread().getName());
        Runnable task5 = () -> System.out.println(Thread.currentThread().getName());
        Runnable task6 = () -> System.out.println(Thread.currentThread().getName());
        Runnable task7 = () -> System.out.println(Thread.currentThread().getName());
        Runnable task8 = () -> System.out.println(Thread.currentThread().getName());

        executorService.execute(task1);
        executorService.execute(task2);
        executorService.execute(task3);
        executorService.execute(task4);
        executorService.execute(task5);
        executorService.execute(task6);
        executorService.execute(task7);
        executorService.execute(task8);

        executorService.shutdown();
    }
}
