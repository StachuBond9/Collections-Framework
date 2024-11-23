package pl.stanislaw.multithread.es;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main3 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Callable<Integer>> tasks = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Future<Integer>> futureList = new ArrayList<>();


        for (int i = 0; i < 10 ; i++) {
            Callable<Integer> task = () -> {
                int delay = ThreadLocalRandom.current().nextInt(1, 10);
                Thread.sleep(Duration.ofSeconds(delay));
                System.out.println(delay);
                System.out.println(Thread.currentThread().getName());

                return ThreadLocalRandom.current().nextInt(0, 100);
            };

            tasks.add(task);
            futureList.add(executorService.submit(task));
        }




        for (Future<Integer> future : futureList) {
            try{
                System.out.println(future.get(2, TimeUnit.SECONDS));
            } catch (TimeoutException e) {
                e.printStackTrace();
                future.cancel(true);
            }


        }
        executorService.shutdown();


    }
}
