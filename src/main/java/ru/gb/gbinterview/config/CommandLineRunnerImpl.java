package ru.gb.gbinterview.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.gb.gbinterview.core.LockCounter;
import ru.gb.gbinterview.core.PingPong;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        // Домашнее задание 3 задача 1
        PingPong pingPong = new PingPong();
        for (int i = 0; i < 10; i++) {
            pingPong.pingPong();
        }

        // Домашнее задание 3 задача 2
        LockCounter lockCounter = new LockCounter();
        lockCounter.start();
    }
}
