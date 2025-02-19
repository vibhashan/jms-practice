package org.vibhashana.jakarta.messages;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

import jakarta.annotation.Resource;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.Destination;
import jakarta.jms.JMSContext;

@Stateless
public class Sender {
	public static AtomicLong counter = new AtomicLong(0);

	@EJB
	private Receiver receiver;

	@Resource(lookup = "java:app/jms/TestFactory")
	private ConnectionFactory factory;

	@Resource(lookup = "java:app/jms/TestQueue")
	private Destination queue;

	public void sendMessage(String msg) throws InterruptedException {
		long id = counter.incrementAndGet();
		String strMsg = String.format("Message #%5d! '%s'", id, msg);
		System.out.printf("I will send a message %s", strMsg);

		// receiver.receive(msg);

		try (JMSContext context = factory.createContext();) {
			context.createProducer().send(queue, strMsg);
		}
	}
}
