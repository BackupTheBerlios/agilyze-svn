
package org.hb2.webservice;

import javax.jws.WebService;

@WebService(endpointInterface = "org.hb2.webservice.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
        return "Hello " + text;
    }
}

