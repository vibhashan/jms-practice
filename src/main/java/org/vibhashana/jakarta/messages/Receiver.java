package org.vibhashana.jakarta.messages;

import org.vibhashana.jakarta.interceptors.Logging;

import jakarta.ejb.Stateless;

@Stateless
@Logging
public class Receiver {
    public void receive(String msg) throws InterruptedException {
        System.out.printf("I received a message: %s", msg);
        Thread.sleep(100);
    }
}
