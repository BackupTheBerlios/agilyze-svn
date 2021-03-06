package it.edu.umich.med.michr.hb2.websvcs;

import java.util.List;

import junit.framework.TestCase;

import org.apache.cxf.frontend.ClientProxyFactoryBean;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.umich.med.michr.hb2.core.Message;
import edu.umich.med.michr.hb2.websvcs.ContactUsService;

public class ContactUsServiceIntegrationTest extends TestCase {

	@Test
	public void testGetMessageAsString() throws Exception {
		ClientProxyFactoryBean factory = new ClientProxyFactoryBean();
		factory.setServiceClass(ContactUsService.class);
		factory.setAddress("http://localhost:8080/hb2/ws/ContactUs/");
//		factory.setAddress("http://localhost:8080/hb2-webservice-0.0.1-SNAPSHOT/ws/ContactUs/");
		ContactUsService client = (ContactUsService) factory.create();

		String response = client.getMessagesAsString();
		System.out.println("Received response from webservice: " + response);

		assertTrue(response.contains("Wheeler"));
	}

	public void testGetMessage() {
//		lookup client
	    ClassPathXmlApplicationContext context
        = new ClassPathXmlApplicationContext(new String[] {"spring-test.xml"});

	    ContactUsService client = (ContactUsService)context.getBean("contactUsServiceClient");
	    List<Message> messages = client.getMessages();
	    assertEquals(3, messages.size());
	    assertEquals("Willie", messages.get(0).getFirstName());

	}

}