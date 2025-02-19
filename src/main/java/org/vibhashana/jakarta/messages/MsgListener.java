package org.vibhashana.jakarta.messages;

import java.util.logging.Logger;

import jakarta.ejb.EJB;
import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSConnectionFactory;
import jakarta.jms.JMSConnectionFactoryDefinition;
import jakarta.jms.JMSDestinationDefinition;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

@MessageDriven(name = "TestQueue", mappedName = "java:app/jms/TestQueue")
// Below config annotations will create the resources
@JMSConnectionFactoryDefinition(name = "java:app/jms/TestFactory")
@JMSDestinationDefinition(name = "java:app/jms/TestQueue", destinationName = "TestQueue", interfaceName = "jakarta.jms.Queue")
public class MsgListener implements MessageListener {
    @EJB
    private Receiver receiver;

    @Override
    public void onMessage(Message message) {
        try {
            receiver.receive(message.getBody(String.class));
        } catch (JMSException | InterruptedException e) {
            Logger.getLogger(MsgListener.class.getName()).severe(e.getMessage());
        }
    }
}
