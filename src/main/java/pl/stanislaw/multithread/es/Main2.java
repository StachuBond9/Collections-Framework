package pl.stanislaw.multithread.es;

import java.util.Scanner;
import java.util.concurrent.*;

public class Main2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Callable<Integer> callable =  () -> {
            int a = n;
            int wynik =1;
            for(int i = 1; i<= a; i++){
                 wynik*=i;
            }
                return wynik;
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(callable);
        System.out.println(future.get());

        executorService.shutdown();
    }
}
