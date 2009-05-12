package edu.umich.med.michr.hb2.websvcs;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import edu.umich.med.michr.hb2.core.Message;

@WebService(endpointInterface = "edu.umich.med.michr.hb2.websvcs.ContactUsService")
public final class ContactUsServiceImpl implements ContactUsService {

    public List<Message> getMessages() {
        List<Message> messages = new ArrayList<Message>();
        messages.add(new Message(
                "Willie", "Wheeler", "willie.wheeler@xyz.com", "Great job"));
        messages.add(new Message(
                "Dardy", "Chen", "dardy.chen@xyz.com", "I want my money back"));
        messages.add(new Message(
                "Bob", "Carol", "b.c@xyz.com", "Good Stuff"));
        return messages;
    }

    //This is not from the article, I added it for sanity testing
    public String getMessagesAsString() {
    	StringBuilder messagesString = new StringBuilder();
    	List<Message> messages = getMessages();
    	for (Message message: messages) {
    		messagesString.append(message.getLastNameFirstName() + ": " + message.getText() + "\n");
    	}
    	return messagesString.toString();
    }


    public void postMessage(Message message) {
        System.out.println(message);
    }

}