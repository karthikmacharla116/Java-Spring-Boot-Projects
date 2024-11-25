package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureDemo {

    public void runAsyncDemo() {
        CompletableFuture.runAsync(
                () -> System.out.println(Thread.currentThread().getName() + " " +
                        EmployeeDB.fetchEmployees().size())
        );
    }

    public void runAsyncDemoWithExecutor() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CompletableFuture.runAsync(
                () -> System.out.println(Thread.currentThread().getName() + " " +
                        EmployeeDB.fetchEmployees().size()),
                executorService
        );
    }

    public Integer supplyAsync() {
        CompletableFuture<Integer> sizeCompletableFuture = CompletableFuture.supplyAsync(
                () -> {
                    Thread.currentThread().getName();
                    return EmployeeDB.fetchEmployees().size();
                }
        );
        return sizeCompletableFuture.join();
    }

    public Integer supplyAsyncWithExecutor() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CompletableFuture<Integer> sizeCompletableFuture = CompletableFuture.supplyAsync(
                () -> {
                    Thread.currentThread().getName();
                    return EmployeeDB.fetchEmployees().size();
                },
                executorService
        );
        return sizeCompletableFuture.join();
    }
}
