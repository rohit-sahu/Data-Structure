package io.thread;

public class ThreadExample {

    private static int number;
    private volatile static boolean ready;

    private static class Reader extends Thread {

        public Reader(String threadName) {
            this.setName(threadName);
            this.start();
        }

        @Override
        public void run() {
            if (Thread.currentThread().getName().equals("Reader Thread1")) {
                ready = false;
            }
            System.out.println("Thread " + Thread.currentThread().getName() + " - " + ready);
            while (!ready) {
                Thread.yield();
            }

            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new Reader("Reader Thread1");
        new Reader("Reader Thread2");
        number = 42;
        ready = true;
        System.out.println(ready);
    }
}
