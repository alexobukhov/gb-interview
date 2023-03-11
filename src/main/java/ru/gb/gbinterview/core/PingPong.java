package ru.gb.gbinterview.core;

import static java.lang.Thread.sleep;

public class PingPong {

    public void pingPong() {
        Thread ping = new Thread(new Ping(), "ping");
        ping.start();
        Thread pong = new Thread(new Ping(), "pong");
        pong.start();
    }

    protected class Ping implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    showMessage();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    protected synchronized void showMessage() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        sleep(100);
        wait();
        notify();
    }
}
