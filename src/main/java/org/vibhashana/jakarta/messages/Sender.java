package org.vibhashana.jakarta.messages;

import java.util.concurrent.atomic.AtomicLong;

import org.vibhashana.jakarta.interceptors.Logging;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class Sender {
	public static AtomicLong counter = new AtomicLong(0);

	@EJB
	private Receiver receiver;

	public void sendMessage(String msg) throws InterruptedException {
		long id = counter.incrementAndGet();
		String strMsg = String.format("Message #%5d! '%s'", id, msg);
		System.out.printf("I will send a message %s", strMsg);

		// receiver.receive(msg);
	}
}
