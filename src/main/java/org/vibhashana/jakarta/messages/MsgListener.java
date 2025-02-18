// package org.vibhashana.jakarta.messages;

// import java.util.logging.Logger;

// import jakarta.ejb.EJB;
// import jakarta.ejb.MessageDriven;
// import jakarta.jms.JMSException;
// import jakarta.jms.Message;
// import jakarta.jms.MessageListener;

// @MessageDriven(name = "TestQueue", mappedName = "jms/TestQueue"
// // Not mandatory
// // activationConfig = {
// // @ActivationConfigProperty(name = "acknowledgeMode", value =
// // "Auto-acknowledge"),
// // @ActivationConfigProperty(name = "destinationType", value =
// // "jakarta.jms.Queue") }
// )
// public class MsgListener implements MessageListener {
// @EJB
// private Receiver receiver;

// @Override
// public void onMessage(Message message) {
// try {
// receiver.receive(message.getBody(String.class));
// } catch (JMSException | InterruptedException e) {
// Logger.getLogger(MsgListener.class.getName()).severe(e.getMessage());
// }
// }
// }
