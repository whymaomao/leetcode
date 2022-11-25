package com.yue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadGroupPoolTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for(int i = 0; i < 2; i ++) {
            executor.execute(() -> System.out.println("hello"));
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try{
            executor.shutdown();
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test done");
        for(int i = 0; i < 2; i ++) {
            executor.execute(() -> System.out.println("hello"));
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try{
            executor.shutdown();
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test 2 done");
        System.exit(0);

    }
}
