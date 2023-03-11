package ru.gb.gbinterview.core;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCounter {

    private static final int CYCLES = 13;

    public void start() throws InterruptedException {
        Lock lock = new ReentrantLock();
        Counter c1 = new Counter(lock);
        Counter c2 = new Counter(lock);
        Counter c3 = new Counter(lock);

        Thread t1 = new Thread(new ThreadCounter(c1, c3, CYCLES));
        Thread t2 = new Thread(new ThreadCounter(c2, c3, CYCLES));
        Thread t3= new Thread(new ThreadCounter(c3, c3, CYCLES));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Counter 1: " + c1.getValue());
        System.out.println("Counter 2: " + c2.getValue());
        System.out.println("Counter 3: " + c3.getValue());
    }

    private class ThreadCounter implements Runnable {

        private final Counter c1;
        private final Counter c2;
        private int cycles;

        public ThreadCounter(Counter c1, Counter c2, int cycles) {
            this.c1 = c1;
            this.c2 = c2;
            this.cycles = cycles;
        }

        @Override
        public void run() {
            for (int i = 0; i < cycles; i++) {
                c1.changeValue();
                c2.changeValue();
            }
        }
    }

    private class Counter {
        private int value;
        private Lock lock;

        public Counter(Lock lock) {
            this.lock = lock;
        }

        public int getValue() {
            return value;
        }

        public int changeValue() {
            try {
                lock.lock();
                this.value += 1;
            } finally {
                lock.unlock();
            }
            return value;
        }
    }
}
