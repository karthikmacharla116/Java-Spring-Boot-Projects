package org.example;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        CompletableFutureDemo futureDemo = new CompletableFutureDemo();

        futureDemo.runAsyncDemo();
        futureDemo.runAsyncDemoWithExecutor();
        futureDemo.supplyAsync();
        futureDemo.supplyAsyncWithExecutor();
    }
}
