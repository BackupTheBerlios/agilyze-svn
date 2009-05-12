package edu.umich.med.michr.hb2.websvcs;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import edu.umich.med.michr.hb2.core.Message;

@WebService(name="ContactUs")
public interface ContactUsService {

	@WebResult (name = "messages")
	List<Message> getMessages();

    String getMessagesAsString();

    void postMessage(@WebParam(name = "message") Message message);
}