package io.thread;

public class EvenAndProblem {

    static Thread evenThread = null;
    static Thread oddThread = null;

    public static void main(String[] args) {
        evenThread = new Thread(() -> {
            for (int i = 0; i < 10; i++){
                if (i % 2 == 0) {
                    synchronized ("this") {
                        System.out.println(Thread.currentThread().getName() + " " + i);
                    }
                }
            }
        }, "EVEN_THREAD");
        oddThread = new Thread(() -> {
            for (int i = 0; i < 10; i++){
                if (i % 2 != 0) {
                    try {
                        evenThread.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + i);
                    evenThread.notify();
                } else {
                    evenThread.notify();
                }
            }
        },"ODD_THREAD");
        evenThread.start();
        oddThread.start();
    }

}
