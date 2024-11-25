package org.example;

import java.util.List;
import java.util.concurrent.*;

public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Future.class introduced in Java 1.5v
        ExecutorService executor = Executors.newCachedThreadPool();

        Future<List<Integer>> listFuture = executor.submit(() -> List.of(10));

        listFuture.get();
        //Limitations of Future are covered by CompletableFuture
    }
}
